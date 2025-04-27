package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetailsmaintabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsMainTabs.jsp", 1742982517886L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\t\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\'../js/AddModifyPatFinClassDetails.js\'></script> \n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\n\t</head>\n<script>\nfunction tab_change(obj,cald_for)\n{\n\tvar params = document.forms[0].params.value;\n\n\tvar obj_id=obj.id;\n\tcellref = document.getElementById(\'tab\').rows[0].cells;\n\tfor(i=0; i<cellref.length; i++)\n\t{\n\t\tif(cellref[i].id == \'FinancialClass\' || cellref[i].id == \'FinancialDetails\')\n\t\t{\n\t\t\tif(cellref[i].id == obj_id)\n\t\t\t{\n\t\t\t\tcellref[i].className=\'TDCLICKED\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tcellref[i].className=\'TDNORMAL\';\n\t\t\t}\n\t\t}\n\t}\n/*\n\tif(cald_for == \'FC\')\n\t{\n\t\tparent.frames[1].location.href = \"../../eBL/jsp/AddModifyPatFinClassDetailsMain.jsp?\"+params;\n\t}\n\telse if (cald_for == \'FD\')\n\t{\n\t\tparams = params+\"&fin_class_flag_YN=N\";\n\t\tparent.frames[1].location.href = \"../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?\"+params;\n\t}\n*/\n}\nfunction load_fin_dtls()\n{\n/*\n\tvar params = document.forms[0].params.value;\n\tparams = params+\"&fin_class_flag_YN=N\";\n\tparent.frames[1].location.href = \"../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?\"+params;\n\tdocument.getElementById(\'fin_class_tab\').className = \"tabA\";\n\tdocument.getElementById(\'FinancialClass\').className = \"tabAspan\";\n\n\tdocument.getElementById(\'fin_dtl_tab\').className = \"tabClicked\";\n\tdocument.getElementById(\'FinancialDetails\').className = \"tabSpanclicked\";\n*/\n}\n\n</script>\n\n<BODY onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" onLoad=\"load_fin_dtls();refreshAuthValue()\">\n\t<FORM name=\'\' action=\"\" method=\'post\'>\n\t  <TABLE border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\' id=\'tab\'>\n\t  <tr>\n\t  <!--\n\t\t<td id=\'FinancialDetails\' class=\"tabSpanclicked\" border=\'3\' width=\"25%\" align=\'left\' onclick=\"tab_change(this,\'FD\');\" ><a style=\'color:white;cursor:pointer\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</a></td>\n\n\t\t<td id=\'FinancialClass\' class=\"TDCLICKED\" border=\'3\' width=\"25%\" align=\'left\' onclick=\"tab_change(this,\'FC\');\"><a style=\'color:white;cursor:pointer\' >Financial Classification</a></td>\n-->\n\t\t<td width= \"100%\" class=\"white\">\n\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t\t\t<a onclick=\"tab_click(\'fin_class_tab\')\" class=\"tabClicked\" id=\"fin_class_tab\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"FinancialClass\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t<a onclick=\"tab_click(\'fin_dtl_tab\')\" class=\"tabA\" id=\"fin_dtl_tab\">\n\t\t\t\t\t<span class=\"tabAspan\" id=\"FinancialDetails\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t</ul>\n\t\t</tr>\n<!--\n\t\t<td class=\"label\" width=\"25%\">&nbsp;</td>\n\t  </tr>\n-->\n</TABLE>\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'  />\n<input type=\'hidden\' name=\'calling_module_id\' id=\'calling_module_id\' id=\'calling_module_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'> \n<input type=\'hidden\' name=\'calling_function_id\' id=\'calling_function_id\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'modify_flag\' id=\'modify_flag\' value=\'N\' >\n<input type=\'hidden\' name=\'slmt_ind\' id=\'slmt_ind\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\t\n<input type=\'hidden\' name=\'cash_pay_pat_YN\' id=\'cash_pay_pat_YN\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\t\n\n<input type=\'hidden\' name=\'class_type\' id=\'class_type\' id=\'class_type\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >\n<input type=\'hidden\' name=\'class_code\' id=\'class_code\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >\t\n<input type=\'hidden\' name=\'class_desc\' id=\'class_desc\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n<input type=\'hidden\' name=\'fam_mem_incl_YN\' id=\'fam_mem_incl_YN\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' >\n<input type=\'hidden\' name=\'SiteSpecific\' id=\'SiteSpecific\' id=\'SiteSpecific\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" /> \n<input type=\'hidden\' name=\'boolean_security\' id=\'boolean_security\' id=\'boolean_security\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" /> \n<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' >\t\t\t\n<input type=\'hidden\' name=\'social_pensioner_id\' id=\'social_pensioner_id\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' >\t\t\t\t\n<input type=\'hidden\' name=\'inc_asset_ind\' id=\'inc_asset_ind\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' >\t\t\t\n<input type=\'hidden\' name=\'ind_inc\' id=\'ind_inc\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' >\t\t\t\t\n<input type=\'hidden\' name=\'ind_inc_freq\' id=\'ind_inc_freq\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' >\t\t\n<input type=\'hidden\' name=\'spouse_inc\' id=\'spouse_inc\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' >\t\t\t\n<input type=\'hidden\' name=\'spouse_inc_freq\' id=\'spouse_inc_freq\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' >\t\n<input type=\'hidden\' name=\'dependent_inc\' id=\'dependent_inc\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' >\t\n<input type=\'hidden\' name=\'dependent_inc_freq\' id=\'dependent_inc_freq\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' >\n\n<input type=\'hidden\' name=\'tot_inc_asset\' id=\'tot_inc_asset\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' >\t\n<input type=\'hidden\' name=\'no_of_dependants\' id=\'no_of_dependants\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' >\n\n<input type=\'hidden\' name=\'blng_grp_id\' id=\'blng_grp_id\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' >\n<input type=\'hidden\' name=\'blng_grp_desc\' id=\'blng_grp_desc\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' >\n<input type=\'hidden\' name=\'valid_from\' id=\'valid_from\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >\n<input type=\'hidden\' name=\'valid_to\' id=\'valid_to\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' >\n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' >\n<input type=\'hidden\' name=\'sex\' id=\'sex\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >\t\n<input type=\'hidden\' name=\'last_date\' id=\'last_date\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'  />\n<input type=\'hidden\' name=\'soc_pensr_id_mand_yn\' id=\'soc_pensr_id_mand_yn\' value=\"\" >\n<input type=\'hidden\' name=\'inc_asset_mand_YN\' id=\'inc_asset_mand_YN\' value=\"\" >\t\n<input type=\'hidden\' name=\'remarks_mand_YN\' id=\'remarks_mand_YN\' value=\"\"  />\n\n<input type=\'hidden\' name=\'encounter_date_aft_trunc\' id=\'encounter_date_aft_trunc\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'  />\n<input type=\'hidden\' name=\'blng_grp_changed_YN\' id=\'blng_grp_changed_YN\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'  />\t\t\n<input type=\'hidden\' name =\'siteSpec\' id =\'siteSpec\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'/>\n<input type=\'hidden\' name =\'blng_grp_id_temp\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'/>\n\n<input type=\'hidden\' name =\'change_flag\' id =\'change_flag\' value=\'N\' />\n<input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'  />\n<input type=\'hidden\' name=\'prevPatId\' id=\'prevPatId\' id=\'prevPatId\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<input type=\'hidden\' name=\'classTypChangeAuthYN\' id=\'classTypChangeAuthYN\' id=\'classTypChangeAuthYN\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=\'hidden\' name=\'changePatAuthYN\' id=\'changePatAuthYN\' id=\'changePatAuthYN\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\n\t<input type=\'hidden\' name=\'class_type_prev\' id=\'class_type_prev\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' />\t\n\t<input type=\'hidden\' name=\'class_code_prev\' id=\'class_code_prev\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' />\t\n\t<input type=\'hidden\' name=\'class_desc_prev\' id=\'class_desc_prev\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' />\n\t<input type=\'hidden\' name=\'social_pensioner_id_prev\' id=\'social_pensioner_id_prev\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' />\t\n\t<input type=\'hidden\' name=\'inc_asset_ind_prev\' id=\'inc_asset_ind_prev\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' />\t\n\t<input type=\'hidden\' name=\'ind_inc_prev\' id=\'ind_inc_prev\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' />\t\n\t<input type=\'hidden\' name=\'ind_inc_freq_prev\' id=\'ind_inc_freq_prev\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' />\t\n\t<input type=\'hidden\' name=\'spouse_inc_prev\' id=\'spouse_inc_prev\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' />\t\n\t<input type=\'hidden\' name=\'spouse_inc_freq_prev\' id=\'spouse_inc_freq_prev\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'/>\t\n\t<input type=\'hidden\' name=\'dependent_inc_prev\' id=\'dependent_inc_prev\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' />\t\t\n\t<input type=\'hidden\' name=\'dependent_inc_freq_prev\' id=\'dependent_inc_freq_prev\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' />\t\t\t\t\n\t<input type=\'hidden\' name=\'tot_inc_asset_prev\' id=\'tot_inc_asset_prev\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' />\t\n\t<input type=\'hidden\' name=\'no_of_dependants_prev\' id=\'no_of_dependants_prev\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' />\t\n\t<input type=\'hidden\' name=\'blng_grp_desc_prev\' id=\'blng_grp_desc_prev\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' />\n\t<input type=\'hidden\' name=\'blng_grp_id_prev\' id=\'blng_grp_id_prev\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' />\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n\n</FORM>\n<script>\n\tvar params = document.forms[0].params.value;\n\tvar SiteSpecific = document.forms[0].SiteSpecific.value;\n\tparent.frames[1].location.href = \"../../eBL/jsp/AddModifyPatFinClassDetailsMain.jsp?\"+params+\"&SiteSpecific=\"+SiteSpecific;\n</script>\n</BODY>\t\n</HTML>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" \n\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

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

	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	ResultSet rs = null;
	PreparedStatement pstmt=null;
	Statement stmt				= null;
	String strAllParam = "";
	try
	{
		String locale			= (String)session.getAttribute("LOCALE");
		con = ConnectionManager.getConnection();	
		strAllParam = request.getQueryString();
		if(strAllParam == null) strAllParam="";
		String strModuleId =  request.getParameter("calling_module_id") ==null ? "" : request.getParameter("calling_module_id");	
		String patient_id =  request.getParameter("patient_id") ==null ? "" : request.getParameter("patient_id");	
		String billing_mode =  request.getParameter("billing_mode") == null? "" :request.getParameter("billing_mode");
		String operation =  request.getParameter("operation") == null? "" :request.getParameter("operation");

		String functionId =  request.getParameter("calling_function_id") == null? "" :request.getParameter("calling_function_id");

		String facilityId =  request.getParameter("facilityId") == null? "" :request.getParameter("facilityId");

		String sex = request.getParameter("sex") == null? "" :request.getParameter("sex");

		String slmt_ind = "", cash_pay_pat_YN="N", class_type = "", class_code = "", class_desc = "", remarks = "", social_pensioner_id = "";
		String inc_asset_ind = "", ind_inc = "", ind_inc_freq = "", spouse_inc = "", spouse_inc_freq = "", dependent_inc = "", dependent_inc_freq = "";
		String tot_inc_asset = "";
		String no_of_dependants = "", blng_grp_id = "", blng_grp_desc = "", valid_from = "", valid_to = "", last_date = "";

		String blng_grp_changed_YN="N", fam_mem_incl_YN="N";
		String classStartDate="",classEndDate="";String sql = "";
		String blng_grp_id_temp="";
		
		String delimiter="::";
		String prevPatId="";
		String classTypChangeAuthYN="";
		String changePatAuthYN="";
		
		String classTypChangeAuthYnPatId			= (String)session.getAttribute("classTypChangeAuthYnPatId");
		System.err.println("classTypChangeAuthYnPatId maintabs"+classTypChangeAuthYnPatId);
		//System.err.println(" bef loop prevPatId "+prevPatId);
		// System.err.println("bef loop classTypChangeAuthYN :: "+classTypChangeAuthYN);
		 
		if(classTypChangeAuthYnPatId != null){
			
			System.err.println("In loop classTypChangeAuthYnPatId maintabs"+classTypChangeAuthYnPatId);
			 String[] classTypChangeTokens=classTypChangeAuthYnPatId.split(delimiter);
			 //System.out.println("classTypChangeTokens "+classTypChangeTokens);
			 prevPatId=classTypChangeTokens[0];
			 //System.err.println("prevPatId "+prevPatId);
			 classTypChangeAuthYN=classTypChangeTokens[1];
			 //System.err.println("classTypChangeAuthYN :: "+classTypChangeAuthYN);
		}

		if((!strModuleId.equals("IP") || billing_mode.equals("Add")) && (!functionId.equals("CHG_PAT_DTLS")))
		{
/*
			slmt_ind = request.getParameter("slmt_ind") == null? "" :request.getParameter("slmt_ind");

			class_type = request.getParameter("class_type") == null? "" :request.getParameter("class_type");
			
			class_code = request.getParameter("class_code") == null? "" :request.getParameter("class_code");
			
			class_desc = request.getParameter("class_desc") == null? "" :request.getParameter("class_desc");
			
			remarks = request.getParameter("remarks") == null? "" :request.getParameter("remarks");
			
			social_pensioner_id = request.getParameter("social_pensioner_id") == null? "" : request.getParameter("social_pensioner_id");
			
			inc_asset_ind = request.getParameter("inc_asset_ind") == null? "" : request.getParameter("inc_asset_ind");
			
			ind_inc = request.getParameter("ind_inc") == null? "" :request.getParameter("ind_inc");
			
			ind_inc_freq = request.getParameter("ind_inc_freq") == null? "" :request.getParameter("ind_inc_freq");
			
			spouse_inc = request.getParameter("spouse_inc") == null? "" :request.getParameter("spouse_inc");
			
			spouse_inc_freq = request.getParameter("spouse_inc_freq") == null? "" :request.getParameter("spouse_inc_freq");
			
			dependent_inc = request.getParameter("dependent_inc") == null? "" :request.getParameter("dependent_inc");
			
			dependent_inc_freq = request.getParameter("dependent_inc_freq") == null? "" :request.getParameter("dependent_inc_freq");
			
			tot_inc_asset = request.getParameter("tot_inc_asset") == null? "" :request.getParameter("tot_inc_asset");
			
			no_of_dependants = request.getParameter("no_of_dependants") == null? "" :request.getParameter("no_of_dependants");
			
			blng_grp_id = request.getParameter("blng_grp_id") == null? "" :request.getParameter("blng_grp_id");
			
			blng_grp_desc = request.getParameter("blng_grp_desc") == null? "" :request.getParameter("blng_grp_desc");
			
			valid_from = request.getParameter("valid_from") == null? "" :request.getParameter("valid_from");
			
			valid_to = request.getParameter("valid_to") == null? "" :request.getParameter("valid_to");
			
			last_date = request.getParameter("last_date")== null ? "" : request.getParameter("last_date");
*/			
		}
		
		String encounter_date_aft_trunc="",encounter_date_time="",sys_date_wht_sec="",sysDate = "";
		int noofdecimal=2;
		
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI'),to_char(sysdate,'dd/mm/yyyy') from  sm_acc_entity_param where acc_entity_id='ZZ'");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				noofdecimal  =  rs.getInt(1);
				sys_date_wht_sec = rs.getString(2);
				sysDate = rs.getString(3);
			}	
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}
		
		
		encounter_date_time = request.getParameter("encounter_date_time");
		System.err.println("encounter_date_time :"+encounter_date_time);
		if(encounter_date_time == null) encounter_date_time="";

		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

		try
		{
			String sql_trunc_time="select to_char( (to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

		//	stmt = con.createStatement();
			pstmt = con.prepareStatement(sql_trunc_time);
			pstmt.setString(1,encounter_date_time);
		
			rs = pstmt.executeQuery() ;

			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}
		

Boolean siteSpec=false;
		
		try
		{
			
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_FIN_CLASS_DTLS_BLANK");
			
	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in site specific "+e);
		}
		String finDetClose="";
//		if((functionId.equals("CHG_PAT_DTLS") || functionId.equals("PAT_REG")) && (billing_mode.equals("Modify")))
		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
//			System.err.println("Financial Session value in Tabs.jsp:"+bl_data);
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				finDetClose = ((String)bl_data.get("fin_det_close")).trim();
				if(finDetClose == null) finDetClose="";
				
				System.out.println("finDetClose BEF:::AddModifyPatFinDetailsMainTabs.jsp :"+finDetClose);
				if(siteSpec)
				{
				if(strModuleId.equals("IP") || strModuleId.equals("DC")) {
					 
					if(finDetClose.equals("Y")){
						System.err.println("AddModifyPatFinDetailsMainTabs.jsp ::finDetClose "+ind_inc_freq);
						blng_grp_id=((String)bl_data.get("blng_grp")).trim();
						if(blng_grp_id == null) blng_grp_id="";
						slmt_ind=((String)bl_data.get("slmt_ind")).trim();
						if(slmt_ind == null) slmt_ind="";
						class_type=((String)bl_data.get("class_type")).trim();
						if(class_type == null) class_type="";
						class_code=((String)bl_data.get("class_code")).trim();
						if(class_code == null) class_code="";
						remarks=((String)bl_data.get("fin_remarks")).trim();
						if(remarks == null) remarks="";
						inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
						if(inc_asset_ind == null) inc_asset_ind="";
						ind_inc=((String)bl_data.get("ind_inc")).trim();
						if(ind_inc == null) ind_inc="";
						ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
						if(ind_inc_freq == null) ind_inc_freq="";
						spouse_inc=((String)bl_data.get("spouse_inc")).trim();
						if(spouse_inc == null) spouse_inc="";
						spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
						if(spouse_inc_freq == null) spouse_inc_freq="";
						dependent_inc=((String)bl_data.get("dependent_inc")).trim();
						if(dependent_inc == null) dependent_inc="";
						dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
						if(dependent_inc_freq == null) dependent_inc_freq="";
						no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
						if(no_of_dependants == null) no_of_dependants="";
						valid_from=((String)bl_data.get("valid_from")).trim();
						if(valid_from == null) valid_from="";
						valid_to=((String)bl_data.get("valid_to")).trim();
						if(valid_to == null) valid_to="";
						last_date=((String)bl_data.get("last_date")).trim();
						if(last_date == null) last_date="";
						if(inc_asset_ind.equals("I"))
						{
							tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
							if(tot_inc_asset == null) tot_inc_asset=""; 
						}
						else if(inc_asset_ind.equals("A"))
						{
							tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
							if(tot_inc_asset == null) tot_inc_asset=""; 
						}
						social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
						if(social_pensioner_id == null) social_pensioner_id="";
					}else{
						System.err.println("AddModifyPatFinDetailsMainTabs.jsp ::else "+ind_inc_freq);
						valid_from=((String)bl_data.get("valid_from")).trim();
						if(valid_from == null) valid_from="";	

						valid_to=((String)bl_data.get("valid_to")).trim();
						if(valid_to == null) valid_to="";
						
						last_date=((String)bl_data.get("last_date")).trim();
						if(last_date == null) last_date="";
						
						blng_grp_id_temp=((String)bl_data.get("blng_grp")).trim();
						if(blng_grp_id_temp == null) blng_grp_id_temp="";
					
					}
				}else{
					System.err.println("AddModifyPatFinDetailsMainTabs.jsp ::2nd else "+ind_inc_freq);
					blng_grp_id=((String)bl_data.get("blng_grp")).trim();
					if(blng_grp_id == null) blng_grp_id="";
					slmt_ind=((String)bl_data.get("slmt_ind")).trim();
					if(slmt_ind == null) slmt_ind="";
					class_type=((String)bl_data.get("class_type")).trim();
					if(class_type == null) class_type="";
					class_code=((String)bl_data.get("class_code")).trim();
					if(class_code == null) class_code="";
					remarks=((String)bl_data.get("fin_remarks")).trim();
					if(remarks == null) remarks="";
					inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
					if(inc_asset_ind == null) inc_asset_ind="";
					ind_inc=((String)bl_data.get("ind_inc")).trim();
					if(ind_inc == null) ind_inc="";
					ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
					if(ind_inc_freq == null) ind_inc_freq="";
					spouse_inc=((String)bl_data.get("spouse_inc")).trim();
					if(spouse_inc == null) spouse_inc="";
					spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
					if(spouse_inc_freq == null) spouse_inc_freq="";
					dependent_inc=((String)bl_data.get("dependent_inc")).trim();
					if(dependent_inc == null) dependent_inc="";
					dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
					if(dependent_inc_freq == null) dependent_inc_freq="";
					no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
					if(no_of_dependants == null) no_of_dependants="";
					valid_from=((String)bl_data.get("valid_from")).trim();
					if(valid_from == null) valid_from="";
					valid_to=((String)bl_data.get("valid_to")).trim();
					if(valid_to == null) valid_to="";
					last_date=((String)bl_data.get("last_date")).trim();
					if(last_date == null) last_date="";
					if(inc_asset_ind.equals("I"))
					{
						tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
						if(tot_inc_asset == null) tot_inc_asset=""; 
					}
					else if(inc_asset_ind.equals("A"))
					{
						tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
						if(tot_inc_asset == null) tot_inc_asset=""; 
					}
					social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
					if(social_pensioner_id == null) social_pensioner_id="";
				}

			}
				else{
					System.err.println("AddModifyPatFinDetailsMainTabs.jsp ::3rd else "+ind_inc_freq);
					blng_grp_id=((String)bl_data.get("blng_grp")).trim();
					if(blng_grp_id == null) blng_grp_id="";
					slmt_ind=((String)bl_data.get("slmt_ind")).trim();
					if(slmt_ind == null) slmt_ind="";
					class_type=((String)bl_data.get("class_type")).trim();
					if(class_type == null) class_type="";
					class_code=((String)bl_data.get("class_code")).trim();
					if(class_code == null) class_code="";
					remarks=((String)bl_data.get("fin_remarks")).trim();
					if(remarks == null) remarks="";
					inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
					if(inc_asset_ind == null) inc_asset_ind="";
					ind_inc=((String)bl_data.get("ind_inc")).trim();
					if(ind_inc == null) ind_inc="";
					ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
					if(ind_inc_freq == null) ind_inc_freq="";
					spouse_inc=((String)bl_data.get("spouse_inc")).trim();
					if(spouse_inc == null) spouse_inc="";
					spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
					if(spouse_inc_freq == null) spouse_inc_freq="";
					dependent_inc=((String)bl_data.get("dependent_inc")).trim();
					if(dependent_inc == null) dependent_inc="";
					dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
					if(dependent_inc_freq == null) dependent_inc_freq="";
					no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
					if(no_of_dependants == null) no_of_dependants="";
					valid_from=((String)bl_data.get("valid_from")).trim();
					if(valid_from == null) valid_from="";
					valid_to=((String)bl_data.get("valid_to")).trim();
					if(valid_to == null) valid_to="";
					last_date=((String)bl_data.get("last_date")).trim();
					if(last_date == null) last_date="";
					if(inc_asset_ind.equals("I"))
					{
						tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
						if(tot_inc_asset == null) tot_inc_asset=""; 
					}
					else if(inc_asset_ind.equals("A"))
					{
						tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
						if(tot_inc_asset == null) tot_inc_asset=""; 
					}
					social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
					if(social_pensioner_id == null) social_pensioner_id="";
				}
			}
		}

		if(siteSpec){
		sql = "SELECT to_char(CLASSIFICATION_START_DATE,'dd/mm/yyyy') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'dd/mm/yyyy') CLASSIFICATION_END_DATE FROM BL_PATIENT_FIN_DTLS WHERE PATIENT_ID=?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				classStartDate = rs.getString(1);		
		    	classEndDate = rs.getString(2);
		    	System.out.println("classStartDate::classEndDate :: "+classStartDate+"::"+classEndDate);
		    	
			}
		}
		catch(Exception e)
		{
			System.err.println("Exception from ASSESSMENT_MONTHS:"+e );
		}
		finally
		{
			if (pstmt!=null) pstmt.close();
			if (rs!=null) rs.close();
		}

		if(classStartDate==null) classStartDate="";
		if(classEndDate==null) classEndDate="";
		valid_from=classStartDate;
		valid_to=classEndDate;
		}
		
		Boolean SiteSpec=false;
		Boolean boolPatientFoundMP=false;
		boolean boolSecurity = false;
			String SiteSpecific ="";
			try
			{				
				SiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISABLE_FIN_DETAILS_IN_MP");				
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in site specific "+e);
			}
			if(SiteSpec){
				SiteSpecific="Y";
			}
			else{
				SiteSpecific="N";
			}
	if(!patient_id.equals("")){	
		try
			{
				String sqlCiti = "select a.citizen_yn,to_char(a.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, b.gl_holder_name gl_holder_name, b.pat_reln_with_gl_holder pat_reln_with_gl_holder from mp_patient a, bl_patient_fin_dtls b where a.patient_id = ? and a.patient_id=b.patient_id";
				
				pstmt = con.prepareStatement(sqlCiti);
				pstmt.setString(1,patient_id);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{	
					while( rs.next() )
					{  
						boolPatientFoundMP = true;
					}
				}
				if (rs != null) rs.close();
				if(pstmt!=null) pstmt.close();	
			}
			catch(Exception e)
			{
			}
		}
		if (((strModuleId.equals("MP")) && (boolPatientFoundMP == true)) || ((strModuleId.equals("IP") || strModuleId.equals("DC") ||           strModuleId.equals("OP")||strModuleId.equals("AE")) && (boolPatientFoundMP == true)))
		{
			boolSecurity = true;
		}

            _bw.write(_wl_block5Bytes, _wl_block5);
	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cash_pay_pat_YN));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(class_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fam_mem_incl_YN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(SiteSpecific));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(boolSecurity));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(social_pensioner_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ind_inc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(spouse_inc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dependent_inc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tot_inc_asset));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(no_of_dependants));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(valid_from));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(valid_to));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(encounter_date_aft_trunc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(blng_grp_changed_YN));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(siteSpec));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(blng_grp_id_temp));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(prevPatId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classTypChangeAuthYN));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(changePatAuthYN));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(class_type));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(class_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(social_pensioner_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(ind_inc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(spouse_inc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dependent_inc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(tot_inc_asset));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(no_of_dependants));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            _bw.write(_wl_block67Bytes, _wl_block67);

	}
	catch(Exception e )
	{ 
		out.println(e);
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block68Bytes, _wl_block68);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FIN_CLASS.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FIN_CLASS.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
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
}
