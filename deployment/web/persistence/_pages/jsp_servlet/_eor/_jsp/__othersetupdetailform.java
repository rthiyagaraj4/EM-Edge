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
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __othersetupdetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OtherSetUpDetailForm.jsp", 1742362490000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<style>\n\t\ttextarea {\n\t\t  \tresize: none;\n\t\t}\n\t</style>\n\t<link rel=\'StyleSheet\' href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" type=\'text/css\'></link>\n\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n\t<script language=\"javascript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n\n\t<script>\n\t\tvar testvar=\"test\";\n\n\t\tfunction assignDummys(objFrom,objTo,type){\n\n\t\t\tif(type == \"CheckBox\"){\n\t\t\t\tif(objFrom.checked == true )\n\t\t\t\t\tobjTo.checked == true ;\n\t\t\t\telse\n\t\t\t\t\tobjTo.checked == true ;\n\t\t\t}\n\n\t\t}\n\n\t\tfunction checkBoxValidate()\n\t\t{\t\n\t\t\t//if(document.detailLowerForm.routine_chk_for_dupl_yn)\t{\n\t\t\tif(document.detailLowerForm.routine_chk_for_dupl_yn !=null && document.detailLowerForm.urgent_chk_for_dupl_yn.checked !=null && document.detailLowerForm.stat_chk_for_dupl_yn.checked !=null) {\n\t\t\t\tif(document.detailLowerForm.routine_chk_for_dupl_yn.checked\t == false && document.detailLowerForm.urgent_chk_for_dupl_yn.checked == false && document.detailLowerForm.stat_chk_for_dupl_yn.checked == false){\n\t\t\t\t//alert(\"deselect\");\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_yn.checked = false ;\n\t\t\t\t\tdocument.detailLowerForm.routine_chk_for_dupl_yn.disabled = true ;\n\t\t\t\t\tdocument.detailLowerForm.urgent_chk_for_dupl_yn.disabled = true ;\n\t\t\t\t\tdocument.detailLowerForm.stat_chk_for_dupl_yn.disabled = true ;\n\t\t\t\t\t/*444444444444444444444444444*/\n\t\t\t\t\tdocument.detailLowerForm.dup_reason_reqd_yn.checked = false ;\t// // IN047644\n\t\t\t\t    document.detailLowerForm.chk_for_dupl_status.selectedIndex = 0;\n\t\t\t\t    document.detailLowerForm.check_for_dupl_level.selectedIndex    = 0;\n\t\t\t\t    //document.detailLowerForm.activity_type.value\t         = \"\";\n\t\t\t\t    //parent.parent.parent.chkActionType(detailLowerForm.activity_type);\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_behind_action.selectedIndex\t = 0;\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_behind_period.value\t     = \"\";\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_behind_unit.selectedIndex    = 0;\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_ahead_action.selectedIndex\t = 0\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_ahead_period.value\t     = \"\";\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_ahead_unit.selectedIndex     = 0;\n\t\t\t\t\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_status.disabled\t\t    = true;\n\t\t\t\t\tdocument.detailLowerForm.check_for_dupl_level.disabled\t\t= true;\n\t\t\t\t\t//document.detailLowerForm.activity_type.disabled\t\t\t\t= true;\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_behind_action.disabled\t= true;\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_behind_period.disabled\t= true;\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_behind_unit.disabled    = true;\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_ahead_action.disabled\t= true;\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_ahead_period.disabled\t= true;\n\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_ahead_unit.disabled     = true;\n\t\t\t\n\t\t\t\t\t\t/*4444444444444444444444*/\n\t\t\t\n\t\t\t\t}else if(document.detailLowerForm.routine_chk_for_dupl_yn.checked == true || document.detailLowerForm.urgent_chk_for_dupl_yn.checked == true || document.detailLowerForm.stat_chk_for_dupl_yn.checked == true){\n\t\t\t\t\t\t//alert(\"select\");\n\t\t\t\t\t\tdocument.detailLowerForm.chk_for_dupl_yn.checked = true ;\n\t\t\t\t}\n\t\t\t}\n\t\t\t//}\n\t\t\n\t\t}\n\t\n\tfunction changeValue()\n\t{\n\t\tvar consent_req_bo = document.detailLowerForm.num_of_consent_req_bo.value;\n\t\tvar consent_req_br = document.detailLowerForm.num_of_consent_req_br.value;\n\t\tif(parseInt(consent_req_bo) > 0 || parseInt(consent_req_br) == 0)\n\t\t{\n\t\t\tdocument.detailLowerForm.consent_stage.selectedIndex=0;\n\t\t}\n\t\telse if(parseInt(consent_req_br) > 0)\n\t\t{\n\t\t\tdocument.detailLowerForm.consent_stage.selectedIndex=1;\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t}\n\tfunction setValues(obj)\n\t{\n\t\tif(obj.value==\"A\")\n\t\t{\n\t\t\tdocument.detailLowerForm.num_of_consent_req_bo.value = 1;\n\t\t\tdocument.detailLowerForm.num_of_consent_req_br.value = 0;\n\t\t}\n\t\telse if(obj.value==\"R\")\n\t\t{\n\t\t\tdocument.detailLowerForm.num_of_consent_req_bo.value = 0;\n\t\t\tdocument.detailLowerForm.num_of_consent_req_br.value = 1;\n\t\t}\n\t}\n\tfunction changeConsentNoteText(obj)\n\t{\n\t\tvar multi_consent = document.detailLowerForm.multiple_consent_yn.checked;\n\t\tif(obj.value==\"V\" && multi_consent==false)\n\t\t{\n\t\t\tdocument.detailLowerForm.consent_form_id.disabled = true;\n\t\t\tdocument.detailLowerForm.consent_form_id.value = \"\";\n\t\t}\n\t\telse if(obj.value==\"F\" && multi_consent==false)\n\t\t{\n\t\t\tdocument.detailLowerForm.consent_form_id.disabled = false;\n\t\t}\n\t}\n\t//IN024984 - Start\n\tfunction displayDuplicateReq(obj)\n\t{\n\t\tif (obj.value != \'\' && obj.value == \'W\')\n\t\t{\n\t\t\tif((document.detailLowerForm.chk_for_dupl_behind_action.selectedIndex == \'2\') || (document.detailLowerForm.chk_for_dupl_ahead_action.selectedIndex == \'2\'))\n\t\t\t\tdocument.getElementById(\'dup_reason_chk\').style.display =\'inline\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif((document.detailLowerForm.chk_for_dupl_behind_action.selectedIndex == \'2\') || (document.detailLowerForm.chk_for_dupl_ahead_action.selectedIndex == \'2\'))\t\n\t\t\t\tdocument.getElementById(\'dup_reason_chk\').style.display =\'inline\';\n\t\t\telse\n\t\t\t\tdocument.getElementById(\'dup_reason_chk\').style.display =\'none\';\n\t\t}\n\t}\n\t//IN024984 - End\n//IN068314 Starts\n\tfunction loadfppCategory(obj){\n\t\tif(\'Y\'==obj.value){\n\t\t\tfppCategoryApplicable_lbl_td.style.visibility =\'visible\';\n\t\t\tfppCategoryApplicable_td.style.visibility =\'visible\';\n\t\t\tfppCategoryApplicable_lbl_td.innerHTML \t= getLabel(\"eOR.FPPCATEGORYS.label\",\"OR\");\n\t\t\tfppCategoryApplicable_td.innerHTML \t= \"<TD><select name=\\\"fpp_category\\\" id=\\\"fpp_category\\\"><option  value=\\\"S\\\" selected>\"+getLabel(\'eOR.Simple.label\',\'Common\')+\"</option><option  value=\\\"M\\\">\"+getLabel(\'eOR.Medium.label\',\'OR\')+\"</option><option  value=\\\"C\\\">\"+getLabel(\'eOR.Complex.label\',\'OR\')+\"</option></select></TD>\";\n\t\t}\n\t\telse\t\n\t\t{\n\t\t\tfppCategoryApplicable_lbl_td.style.visibility =\'hidden\';\n\t\t\tfppCategoryApplicable_td.style.visibility =\'hidden\';\n\t\t\tfppCategoryApplicable_lbl_td.innerHTML \t= \"\";\n\t\t\tfppCategoryApplicable_td.innerHTML=\"\";\n\t\t}\t\n\t}\n//IN068314 Ends\n\t</script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n  <body onLoad=\"parent.parent.parent.defaultIntLowerFrame(),checkBoxValidate();\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n <!--ONLOAD OF BODY= parent.parent.parent.chkDuplicateReq(document.getElementById(\"chk_for_dupl_yn\")) -->\n<form name=\'detailLowerForm\' id=\'detailLowerForm\' target=\'messageFrame\' scrolling=\'auto\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<!-- ------------------Synonyms------------------------- -->\n\n<table name=\"synonyms\"  id=\"synonyms\" width=\"100%\" class=\'grid\' style=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n <tr>\n\t   <td class=\"COLUMNHEADER\" id=\"\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t   <td class=\"COLUMNHEADER\" id=\"\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t  <td class=\"COLUMNHEADER\" id=\"\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n </tr>\n <tr style=\"bottom-margin:0;display:none\">\n\t\t<td class=\"gridData\" style=\"bottom-margin:0;display:none\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td  class=\"gridData\"><input type=text size=\'40\' maxlength=\"40\"\n\t\tonBlur=\"makeValidString(this);\"\n\t\tname=\'catalog_synonym_primary\' id=\'catalog_synonym_primary\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" readonly></td>\n\t\t<td class=\"gridData\"><input type=\'checkbox\' value=\'Y\'  name=\'effective_status_primary\' id=\'effective_status_primary\'  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" disabled ></td>\n </tr>\n <tr>\n ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<td class=\"gridData\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td class=\"gridData\"><input type=text size=\'40\' maxlength=\"40\"\n\tonBlur=\"makeValidString(this);\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\tname=\'catalog_synonym_directCare\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></td>\n\t<td class=\"gridData\"><input type=\'checkbox\' value=\'Y\'\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\tname=\'effective_status_directCare\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="  ></td>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n </tr>\n <tr>\n\t\t<td class=\"gridData\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t<td class=\"gridData\"><input type=text size=\'40\' name=\'catalog_synonym_ancillaryDept\' id=\'catalog_synonym_ancillaryDept\' maxlength=\"40\"\n\t\tonBlur=\"makeValidString(this);\"\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"></td>\n\t\t<td class=\"gridData\"><input type=\'checkbox\'name=\'effective_status_ancillaryDept\'  value=\'Y\'\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ></td>\n </tr>\n</table>\n<!-- ----------------------Timing------------------------------------ -->\n<table border=\"0\" name=\"timing\"  id=\"timing\" cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" style=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n <tr>\n\t <td >\n\t\t <table name=\"timing_dose\"  id=\"timing_dose\" cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t <tr>\n\t\t\t<!--Changes Qty/dose -->\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t  <td class=\"fields\" width=\"15%\" ><input type=\'checkbox\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" name=\'qty_reqd_yn\' value=\'Y\'  onClick=\'parent.parent.parent.showUOM(this,\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\",\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\");\'></td>\n\n\n              <!-- UOM -->\n  \t\t\t ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t  <td  id=\'uom_lbl_td\' class=\"label\" >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t  <td class=\"fields\" id=\'uom_td\' >\n\t\t\t  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\t\t ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \n\t\t\t  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t  <INPUT TYPE=\"hidden\" name=\"qty_uom\" id=\"qty_uom\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t <INPUT TYPE=\"text\" name=\"qty_uom_desc\" id=\"qty_uom_desc\"\n\t\t\t  size=\'10\' onBlur=\'parent.parent.parent.before_show_qty_uom_window(this,qty_uom);\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" >\n\t\t\t  <INPUT type=\"hidden\" name=\"qty_uom_desc_temp\" id=\"qty_uom_desc_temp\" value=\"\">\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t  \n\t\t\t<input type=\'button\' name=\'qty_uom_button\' id=\'qty_uom_button\' class=\'button\' ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" value=\'?\' onclick=\"parent.parent.parent.show_qty_uom_window(qty_uom_desc,qty_uom);\" >\n\t\t\t\t ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</td>\n \t\t\t<!-- SPLIT -->\n\t\t\t ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\t\t\t\n\t\t\t  <td class=\"label\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t  <td class=\"fields\"><input type=\'checkbox\' value=\'Y\'\n\t\t\t ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t  name=\'split_dose_yn\' ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="></td>\n\t\t\t<!-- TAPER -->\n\t\t\t  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t  <td class=\"label\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t  <td class=\"label\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<input type=\'radio\' name=\'taper_up\' id=\'taper_up\' value=\'Y\'\n\t\t\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" onClick=\'parent.parent.parent.chkTaperRadio(this);\'> \t\t\t\t \n\t\t\t  ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="<input type=\'radio\' name=\'taper_dose_yn\' id=\'taper_dose_yn\' value=\'Y\'\n\t\t\t ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" onClick=\'parent.parent.parent.chkTaperRadio(this);\'>\n\t\t\t  ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="<input type=\'radio\' name=\'none_yn\' id=\'none_yn\'  value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="    \t\t\t\t\t\n\t\t\tonClick=\'parent.parent.parent.chkTaperRadio(this);\'>            \n             </td>\n              <td class=\"label\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t  name=\'appl_sliding_scale_yn\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="></td>\n\n\t\t\t ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t  <td width=\'\' ></td>\n\t\t\t  ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n  \t\t <tr>\n\t\t  </table>\n\t  </td>\n </tr>\n <tr><td colspan></td></tr>\n  <tr>\n\t <td>\n\t\t <table name=\"timing_orderRepeat\"  id=\"timing_orderRepeat\" border=\'0\' cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" >\n\t\t <tr>\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<!-- THIS LINE ADDED BY CHANNAVEER B on 14/05/2010-->             \n\t\t\t <td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t <td class=\"fields\" width=\"15%\"><input type=\'checkbox\' name=\'freq_applicable_yn\' id=\'freq_applicable_yn\' value=\'Y\' onClick=\"parent.parent.parent.chkFreq(this)\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="></td>\n\n\n\t\t\t <!-- Soft Stop  -->\n\t\t\t <td  Width=\"14.9%\" class=\"label\">";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t <td class=\"fields\" ><input type=\'checkbox\' name=\'soft_stop_yn\' id=\'soft_stop_yn\'\n\t\t\t value=\'Y\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =">\n\t\t\t </td>\n\t\t\t \n\t\t\t  <td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t  <td class=\"fields\" ><input type=\'checkbox\' name=\'cont_order_yn\' id=\'cont_order_yn\'  value=\'Y\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t  onclick=\"parent.parent.parent.chkCont_order_yn(this)\"\n\t\t\t  ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">\n\t\t\t  </td>\n\t\t\t  ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" <!-- THIS LINE ADDED BY CHANNAVEER B -->\n\t\t  </tr>\n\t\t  <!--7540 Starts  -->\n\t\t  <tr>\n\t\t  \t <td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t <td class=\"fields\" width=\"15%\"><input type=\'checkbox\' name=\'freq_order_split_indvi_yn\' id=\'freq_order_split_indvi_yn\' value=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" onClick=\"parent.parent.parent.chkFreqSplitIndivialOrd(this)\" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="></td>\n\t\t  </tr>\n\t\t  <!-- 7540 Ends -->\n\t \t </table>\n\t  </td>\n  </tr>\n\n <tr><td colspan></td></tr>\n\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n  <tr>\n\t  <td>\n\t\t  <table name=\"refills\"  id=\"refills\" border=\'0\' cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" >\n\t       <tr>\n\t\t  ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="<!-- THIS LINE  ADDED BY CHANNAVEER B on 14/05/2010 -->\n\t\t\t  <td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\t\t \n\t\t\t  <td id=\"contineous_freq_order_td\"><SELECT   ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" NAME=\"contineous_freq_order\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t  </SELECT></td>\n\t\t\t   ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" <!-- THIS LINE ADDED BY CHANNAVEER B -->\t\t\t\n\t\t\t  <!--Refill-->\n\t\t\t  ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t  <td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t\t  <td  class=\"fields\"><input type=\'checkbox\'  value=\'Y\'\n\t\t\t  ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="  name=\'refill_cont_order_yn\' ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="></td>\n\t\t\t  ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t<td  colspan=2>&nbsp;</td>\t  \n\t\t\t  ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t       </tr>\n\t\t </table>\n\t   </td>\n </tr>\n\n <tr><td colspan></td></tr>\n\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n<tr>\n\t <td>\n\t<table name=\"timing_orderConsent\"  id=\"timing_orderConsent\" border=\'0\' cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" >\n\t<tr>\n\t<td  class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t <td class=\"fields\" width=\"15%\" ><SELECT ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" NAME=\"priority_appl\">\t<option value=\'\' ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</option><option value=\'2\' ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</option><option value=\'1\' ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</option><option value=\'3\' ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</option></SELECT></td>\n\t\n\t<td></td>\n</tr>\n</table>\n\n <!-------ADD -Comment Ends ----------->\n\t</td>\n</tr>\n\n<tr><td colspan></td></tr>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n<tr>\n\t<td>\n\t <table name=\"timing_orderConsent\"  id=\"timing_orderConsent\" cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" border=\'0\' >\n\t    <tr>\n\t\t <td class=\"label\" width=\'23%\'>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n         <td  width=\'25%\' class=\"fields\"><input type=\'checkbox\' name=\'result_auth_reqd_yn_ph\' id=\'result_auth_reqd_yn_ph\' value=\'Y\'  onClick=\'assignDummys(this,result_auth_reqd_yn,\"CheckBox\");\'\n\t\t ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="></td>\n\t\t<td colspan></td>\n\t\t <td colspan></td>\n        </tr>\n     </table>\n\t </td>\n</tr>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\n</table>\n<!-- ---------------------Duplicate Check-------------------------------- -->\n<table border=\"0\" name=\"duplicate\"  id=\"duplicate\" cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" style=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\n<tr>\n <td colspan=\'4\'></td>\n\t</tr>\n\n <tr>\n\t <td colspan=\'4\' >\n\t    <table name=\"dup_req\"  id=\"dup_req\" border=\'0\' cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" >\n         <tr>\n\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t<td  class=\"label\" width=\"20%\" >";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t\t\t<td class=\"fields\" width=\"20%\"><input type=\'checkbox\' value=\'Y\' onClick=\"parent.parent.parent.chkDuplicateReq(this)\" name=\'chk_for_dupl_yn\' id=\'chk_for_dupl_yn\'\n\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="></td>\n\t\t\t\n\t\t\t<td  class=\"label\"  onClick=\'checkBoxValidate();\' nowrap>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t\t\t\t<td class=\"label\" >\n\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="<input type=\'checkbox\' value=\'Y\' name=\'routine_chk_for_dupl_yn\' id=\'routine_chk_for_dupl_yn\' ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="<input type=\'checkbox\' value=\'Y\' name=\'urgent_chk_for_dupl_yn\' id=\'urgent_chk_for_dupl_yn\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" >";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="<input type=\'checkbox\' value=\'Y\' name=\'stat_chk_for_dupl_yn\' id=\'stat_chk_for_dupl_yn\' ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" ></td>\n\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t\t</tr>\t\t\t\t \n\t\t\t<tr>\n\t\t\t<td colspan=\'4\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td >\n\t\t\t<table name=\"dup_req\"  id=\"dup_req\" border=\'0\' cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" >\n\t\t\t<tr>\n\t\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t\t<td   class=\"fields\"><SELECT ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="   NAME=\"chk_for_dupl_status\">";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</SELECT></td>\n\t\t\t<td  class=\"label\"  >";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\t\t\t<td class=\"fields\"><SELECT \t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="   NAME=\"check_for_dupl_level\" >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</SELECT></td>\n\t\t\t\t<!-- <td align=\'left\'><SELECT \t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="   NAME=\"check_for_dupl_level\" onChange=\'parent.parent.parent.chkActionType(this)\'>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</SELECT></td> -->\n\t\t\t<!-- <td align=\'right\' class=\"label\" id=\'chk_for_dupl_activity_type_lbl_td\' >";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t\t<td align=\'left\' id=\'chk_for_dupl_activity_type_td\'>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t    </td> -->\n\t\t </tr>\n\t\t<tr>\n\t\t<td colspan=\'5\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\' columnheader\' colspan=\'2\' width=\'40%\' >";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n\t\t\t<td class=\' columnheader\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</td>\n\t\t\t<td class=\' columnheader\' colspan=\'2\'>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t     </tr>\n\t\t<!--Behind Action IN024984 included onchange event -->\n\t\t<tr>\n\t\t   <td  class=\"label\" width=\"20%\" >";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\t\t\t<td class=\"fields\" width=\"22%\"><SELECT \t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =" NAME=\"chk_for_dupl_behind_action\" onchange=\"displayDuplicateReq(this)\">";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</SELECT></td>\n\t\t   ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t   <td ><input type=text size=\'3\' maxlength=\'3\'\n\t\t   ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =" name=\'chk_for_dupl_behind_period\'  class=\"NUMBER\" onblur=\'checkDecimal(this)\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"></td>\n\t\t   <td  colspan=\'2\'><SELECT ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =" NAME=\"chk_for_dupl_behind_unit\">\n\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</option>\n\t\t\t<option value=\'M\'  ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</option>\n\t\t\t<option value=\'W\'  ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</option>\n\t\t\t<option value=\'D\'  ";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</option>\n\t\t\t<option value=\'H\'  ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</option>\n\t\t\t<option value=\'I\'  ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</option>\n\t\t   </SELECT></td>\n\t\t  </tr>\n\t\t\t<!-- Ahead Action IN024984 included onchange event-->\n\t\t  <tr>\n\t\t   <td class=\"label\" width=\"20%\" >";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</td>\n\t\t\t<td class=\"fields\" width=\"22%\"><SELECT  ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\tNAME=\"chk_for_dupl_ahead_action\" onchange=\"displayDuplicateReq(this)\">";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</SELECT></td>\n\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\n\t\t   <td class=\"fields\" width=\"12%\"><input type=text size=\'3\' maxlength=\'3\'\n\t\t\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="   name=\'chk_for_dupl_ahead_period\' class=\"NUMBER\" onblur=\'checkDecimal(this)\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"></td>\n\n\t\t   <td class=\"fields\" colspan=\'2\'><SELECT \t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =" NAME=\"chk_for_dupl_ahead_unit\">\n\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</option>\n\t\t\t<option value=\'M\' ";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</option>\n\t\t\t<option value=\'W\' ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</option>\n\t\t\t<option value=\'H\' ";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</option>\n\t\t\t<option value=\'I\' ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</option>\n\t\t   </SELECT></td>\n\t\t </tr>\n\t\t ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t <!-- Duplicate Reason IN024984-->\n\t\t<tr id=\"dup_reason_chk\" style=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t <td  class=\"label\" width=\"20%\"  >";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</td>\n\t\t\t<td class=\"fields\" width=\"20%\" ><input type=\'checkbox\' value=\'Y\' name=\'dup_reason_reqd_yn\' id=\'dup_reason_reqd_yn\' ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="></td> <!-- modified for IN047644 -->\n\t\t</tr>\n\t\t</table>\n     </td>\n </tr>\n<tr>\n <td colspan=\'4\'></td>\n</tr>\n\n</table>\n\n<!-- ---------------------Consent/Refusal-------------------------------- -->\n\t<table name=\"consent_refusal\"  id=\"consent_refusal\" border=\'0\' cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" style=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\n <td colspan=\'6\'></td>\n\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t<tr>\n\t<td  class=\"label\" >";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</td>\n\t<td class=\"fields\"><input type=\'checkbox\' value=\'Y\' onClick=\"parent.parent.parent.chkConsentReq(this)\"\tname=\'consent_reqd_yn\' id=\'consent_reqd_yn\' \t ";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="></td>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</td><td class=\"fields\"><select ";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="  name=\'consent_form_list\' onChange=\"changeConsentNoteText(this);\">\n\t\t<option value=\'F\' ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</option>\n\t\t<option value=\'V\' ";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</option>\n\t</select>\n\t </td>\n\t <!-- Code for Maximum Duration Type Options-->\n";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t<td  class=\"label\" width=\'16%\' >";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</td>\n\t<td class=\"fields\" ><select ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="  name=\'consent_stage\' onChange=\"setValues(this);\">\n\t<option value=\'A\' ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</option>\n\t<option value=\'R\' ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</option>\n\t</select></td>\n</tr>\n<tr>\n\t<td colspan=\"2\" class=\"label\">\n\t</td>\n\t<td colspan=\"3\" class=\"LABELCENTER\"><B>";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</B></td>\n\t<td class=\"label\">\n\t</td>\n</tr>\n<tr>\n\t<td colspan=\"6\" class=\"label\">\n\t</td>\n</tr>\n<tr>\n\t<td width=\'\' class=\"label\"  nowrap>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</td>\n\t<td class=\"fields\"><input type=\'checkbox\' value=\'Y\' onClick=\"parent.parent.parent.enableMultiConsent(this)\"\tname=\'multiple_consent_yn\' id=\'multiple_consent_yn\' ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</td>\n\t<td class=\"fields\" width=\'6%\'> \n\t\t<input type=text size=\'3\' maxlength=\'2\'\n\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="  name=\'num_of_consent_req_bo\' class=\"NUMBER\" onblur=\'OrCheckNumber(this);changeValue();parent.parent.parent.linkedConsent(this,\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\",consent_form_list);\' value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t</td>\n\t<td class=\"label\" width=\'18%\'>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="</td>\n\t<td class=\"fields\">\n\t\t<input type=text size=\'3\' maxlength=\'2\' ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" \n\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="   name=\'num_of_consent_req_br\' class=\"NUMBER\" onblur=\'OrCheckNumber(this);changeValue();parent.parent.parent.linkedConsent(this,\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t</td>\n</tr>\n<tr>\n\t<td colspan=\"6\" class=\"label\">\n\t</td>\n</tr>\n<tr>\n\t <td class=\"label\" width=\'15%\' >";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n\t <td class=\"fields\" width=\'21%\'><SELECT ";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =" NAME=\"consent_form_id\">\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" ---</option>";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</SELECT></td>\n\t<td class=\"label\" width=\'15%\'>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\t\t\n\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t<td width=\"15%\" class=\"fields\" colspan=\"3\"><select name=\"refusal_form_id\" id=\"refusal_form_id\" ";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 =">\n\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t</select></td>\n\t\t\n\t</tr>\n\t\t<td colspan=\'6\'></td>\n\t</table>";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\n<!-- ---------------------Explanatory Text-------------------------------- -->\n<table border=\"0\" name=\"explanatoryText\" id=\"explanatoryText\" cellpadding=3 cellspacing=0 width=\"100%\"  align=\"center\" style=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\n";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n<tr >\n<td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</td>\n\t<td class=\"fields\" ><textarea name=\"explanatory_text\" value=\"\" onBlur=\"makeValidString(this);SPCheckMaxLen(\'Explanatory Text\',this,255);\" size=\"255\" maxlength=\"255\" rows=\'6\' cols=\'60\' ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</textarea></td></tr>\n</tr>\n</table>\n\n<!-- --------------------- CHARTING----------------------------- -->\n\n<table border=\"0\" name=\"others\"  id=\"others\" cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\"  style=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n <tr>\n\t <td>\n\t\t <table name=\"dep_com_chr_img\"  id=\"dep_com_chr_img\" cellpadding=3 border=\'0\' cellspacing=0 width=\"100%\" align=\"center\" >\n\n\t\t\t<tr>\n\t\t\t  <!-- Department -->\n\t\t\t  <td   class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</td>\n\t\t\t  <td class=\"fields\" width=\'25%\' ><input type=\'checkbox\' name=\'dept_only_yn\' id=\'dept_only_yn\' value=\'Y\' ";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="></td>\n\t\t\t  <!-- Complete on Order -->\n\t\t\t  <td   class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="</td>\n\t\t\t  <td class=\"fields\" width=\'25%\' ><input type=\'checkbox\' onClick=\"parent.parent.parent.chkCompleteOnOrder(this)\"\n\t\t\t  ";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t name=\'complete_on_order_yn\' id=\'complete_on_order_yn\' value=\'Y\' >";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="<img align=center src=\"../../eCommon/images/mandatory.gif\"></img>";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="</td></tr><tr>\n\t          <!-- Billable -->\n\t\t\t  ";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t  <td width=\'25%\' style=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" class=\"label\" >";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="</td>\n\t\t\t  <td  width=\'25%\'  style=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\"><input type=\'checkbox\' onClick=\'parent.parent.parent.showChargeTypeApplicable(this)\'\n\t\t\t  ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t\t  name=\'bill_yn\' value=\'Y\' ></td>\n\t\t\t \n\t\t\t ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t  <td width=\'25%\' id=\'ChargeTypeApplicable_lbl_td\'  style=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</td>\n\t\t  <td width=\'25%\' id=\'ChargeTypeApplicable_td\' style=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" width=\'8%\'>\n\t\t  ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\t\t\t\t\n\t\t   <select name=\"charge_type_applicable\" id=\"charge_type_applicable\"><option  value=\"S\" ";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</option><option  value=\"M\" ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="</option></select></td> ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t  <td colspan=\'4\'  class=\"label\"></td>\n\t\t\t  ";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t  \n</tr>\n<!--IN063816 -->\n\n";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t<tr>\n\t\t\t  <td   class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</td>\n\t\t\t  <td class=\"fields\" width=\'25%\' ><input type=\'checkbox\' onClick=\"parent.parent.parent.chkBarcode(this)\"\n\t\t\t  name=\'barcode_reqd_yn\' id=\'barcode_reqd_yn\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 =" ></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n<!--IN063816 -->\n\t</table>\n\t <table name=\"dep_com_chr_img\"  id=\"dep_com_chr_img\" cellpadding=3 border=\'0\' cellspacing=0 width=\"100%\" align=\"center\" >\n\n\t\t<!-- <tr><td colspan=\'8\'></td></tr>\n\t\t<tr><td colspan=\'8\'></td></tr>\n\t\t<tr><td colspan=\'8\'></td></tr>-->\n\t<tr>\n\n\t\t\t  <!-- chart -->\n\t\t\t ";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t  <td  width=\'25%\'  style=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\" class=\"label\">";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</td>\n\t\t\t  <td class=\"fields\" width=\'25%\' style=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\"><input type=\'checkbox\'  onClick=\"parent.parent.parent.chkChart(this)\" ";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="  ";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="  name=\'result_applicable_yn\' id=\'result_applicable_yn\' value=\'Y\' ></td>\n\t\t\t  ";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\t  <td  width=\'25%\' class=\"label\"  name=\"auto_report_yn_lbl\" id=\"auto_report_yn_lbl\" >";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</td>\t\t\t \n\t\t\t  <td   width=\'25%\' name=\"auto_report_yn_id\" id=\"auto_report_yn_id\" ><input type=\"checkbox\" name=\"auto_report_yn\" id=\"auto_report_yn\" value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" ";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="  onclick=\"parent.parent.parent.chkAutoReport(this);\"></td>\n\n\t\t\t  ";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t\t   <td  width=\'50%\' class=\"label\" ></td>\n\t\t\t  ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n    </tr>\n\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n            <td   style=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\"class=\"label\">";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</td>\n\n\t\t\t  <td    style=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\"><input type=\'checkbox\'  onClick=\"\"\n\t\t\t  ";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t\t  name=\'confidential_yn\' value=\'Y\' ></td>\n\t\t\t\t \n\t\t\t  ";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t   <td   class=\"label\"></td>\n\t\t\t  ";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t\t<!-- External Requisition form 68801-->\n\t\t\t  <td style=\"width:25%\" class=\"label\">";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="</td>\n\t\t\t  <td style=\"width:25%\"><input type=\'checkbox\'  onClick=\"\" ";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\t\t\t  name=\'external_requisition_yn\' value=\'Y\' ></td>\n\t\t\t  </td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t<tr>\n\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="</td>\n\t\t\t<td><input type=\'checkbox\' ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 =" name=\'prn_regd_ord\' onClick=\"parent.parent.parent.chkPrnRegStatus(this)\" value=\'Y\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\n\t\t  </table>\n\t  </td>\n </tr>\n  <tr>\n\t <td>\n\t\t <table name=\"resulting_despensing\"  id=\"resulting_despensing\" border=\'0\' cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" >\n\t\t<tr><td class=\'columnheader\' colspan=\'6\' align=\"left\">";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</td></tr>\t\t\n\t\t<tr>\n\t\t    <td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</td>\n\t\t\t<td  class=\"fields\" width=\'25%\'><input type=\'checkbox\' name=\'result_auth_reqd_yn\' id=\'result_auth_reqd_yn\'  value=\'Y\'\n\t\t\t";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="></td>\n\t\t\t\t\t\t <!-- Nature -->\n\t\t\t <td class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="</td>\n\t\t\t <td class=\"fields\" width=\'25%\'\n\t\t\t id=\"order_catalog_nature_id\"><SELECT\n\t\t\t ";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t Onchange=\"parent.parent.parent.chkNature(this)\" NAME=\"order_catalog_nature\">\n\t\t\t <option value=\'A\' ";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n\t\t\t </option>\n\t\t\t <option value=\'P\' ";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\t\t\t </option>\n\t\t\t </SELECT>\n\t\t\t </td>\n\n\t  \t    \n\t\t  </tr>\n\n\t\t </table>\n\t  </td>\n  </tr>\n<tr>\n\t <td>\n\t\t <table name=\"resulting_despensing\"  id=\"resulting_despensing\" border=\'0\' cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" >\n\t\t <!-- <tr><td colspan=\'6\'></td></tr>\n\t\t  <tr><td colspan=\'6\'></td></tr>\n\t\t  <tr><td colspan=\'6\'></td></tr>-->\t\t\t\n\t\t  <tr >\n\t\t\t  \n\t\t\t  <td class=\"label\"  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="</td>\n\t\t\t  <td  id=\'chart_result_type_td\'  width=\'5%\' class=\"fields\"><SELECT name=\"chart_result_type\" id=\"chart_result_type\" ";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n \t\t\t   onChange=\'parent.parent.parent.chkResultType(this);\'>\n\t\t\t\t";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n\t\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\n\t\t\t\t <option value=\'D\' ";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n\t\t\t\t\t <option value=\'M\' ";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="</option>\n\t\t\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n\t\t\t\t\t\t<option value=\'C\' ";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\t\t\t\t\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t\t\t  <!-- <option value=\'N\' ";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 =">Note Type</option> -->\n\t\t\t  ";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n\t\t\t  <!-- <option value=\'C\' ";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="</option> -->\n\t\t\t  ";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t\t  <!-- <option value=\'I\' ";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n\t\t\t  <!-- <option value=\'T\' ";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 =">Culture Test</option> -->\n\t\t\t  ";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n\t\t\t\t   \n\t\t\t  </SELECT>\n\t\t\t  </td>\n\n\t\t\t  <td align=\"left\"  id=\'chrtMandatory1\' name=\'chrtMandatory1\' width=\'15%\'  nowrap >";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="</td>\n\t\t\t  ";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\n\n\t\t  \t  <td width=\"25%\"  name=\'discr_msr_panel_id_lbl\' id=\'discr_msr_panel_id_lbl\'  nowrap class=\"label\" >";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="</td>\n\n\t\t  \t  ";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\n\t\t\t<td  style=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\" id=\"proc_coding_scheme_td\"  ><select name=\"proc_coding_scheme\" id=\"proc_coding_scheme\" noresize ><option value=\"\" onChange=\"parent.parent.parent.onChangeProcCodingScheme();\">--- ";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 =" ---</option>\n\t\t\t";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\t\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="</option>  \n\t\t\t\t";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td id=\'discr_msr_panel_id_td\' class=\'label\' width=\"20%\"><input type=\'text\'  name=\'discr_msr_panel_id_desc\' id=\'discr_msr_panel_id_desc\' onfocus=\"javascript:blur();\"  value=\'";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\' size=23 maxlength=30 >\n\t\t\t\t<input type=\'hidden\'  name=\'discr_msr_panel_id\' id=\'discr_msr_panel_id\' value=\'";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\n\t\t\t\t\t<input type=\'button\' name=\'appl_button\' id=\'appl_button\' class=\'button\'";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 =" value=\'?\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="></td>\t\t\n\t\t\t\t\t<td name=\'chrtMandatory2\' id=\'chrtMandatory2\'  width=\"15%\">";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\n\t\t\t\t\t<Input name=\'appl_button\' id=\'appl_button\' type=\'hidden\' value=\'\'>  </td>\t\t\t\t\t \n\t\t\t\t\t<td  id=\'chrtMandatory2\'>";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\t\t\t \n\t\t  </tr>  \t\t  \n\t\t </table>\n\t  </td>\n  </tr>\n\t";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n  <tr>\n\t  <td>\n\t\t  <table name=\"mod_drug\"  id=\"mod_drug\" border=\'0\' cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\"  style=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" >\n\t       <tr>\n\t\t\t  <td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="</td>\n\t\t\t  <td width=\'25%\'><input type=\"text\"  size=2\n\t\t\t\tmaxlength=2 name=\"contr_mod_id\" id=\"contr_mod_id\" value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="> </td>\n\n\t\t\t  <td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="</td>\n\t\t\t  <td  width=\"25%\" class=\"fields\"><input type=\'text\'  name=\'contr_msr_panel_desc\' id=\'contr_msr_panel_desc\' value=\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\' size=20 maxlength=30  disabled></td>\n\t\t\t  <input type=\"hidden\" name=\"contr_msr_panel_id\" id=\"contr_msr_panel_id\" value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\"></tr>\n\t\t </table>\n\t   </td>\n </tr>\n\t\n\t\t\t  <tr><td colspan=\'6\'></td></tr>\n  <tr>\n\t <td>\n\t  <table name=\"resulting_despensing\"  id=\"resulting_despensing\" border=\'0\'  cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" >\n\n\t  <tr><td class=\'columnheader\' colspan=\'6\' align=\"left\">";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="</th><tr>\n\t\t<tr><td colspan=\'6\'></td></tr>\n\t\t<tr >\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="</td>\n\t\t <input type=\"hidden\" name=\"ChartProceApplicable\" id=\"ChartProceApplicable\" value=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\">\n\t\t<td width=\'25%\' name=\"proc_link_applicable_td\" id=\"proc_link_applicable_td\" >\n\t\t<select name=\"proc_link_applicable\" id=\"proc_link_applicable\" ";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 =" onChange=\"parent.parent.parent.showProc_link_resulting_option(this);\">\n\t\t\t\n\t\t  <option value=\'X\' ";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="</option>\n<!-- \t\t  <option value=\'C\' >AutoLink to Catalog Code</option>\n -->\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="</option>\n\t\t  <option value=\'R\' ";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="</option>\n\t\t\t  \n\t\t  </select>\n\t\t </td>\n\t      ";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\t \n\t\t<td  class=\'label\' width=\'25%\' name=\"proc_link_resulting_option_lbl\" id=\"proc_link_resulting_option_lbl\"  style=\'";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\'>";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="</td>\n\t\t  <td align=\'left\' style=\'";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\' width=\'30%\'>\n\t\t  <select name=\"proc_link_resulting_option\" id=\"proc_link_resulting_option\">\n\t\t  <option value=\'M\' ";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="</option>\n\t\t  <option value=\'O\' ";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="</option>\n<!-- \t\t  <option value=\'\' ";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 =">Not Applicable</option>\n -->\t\t  </select>\n\t\t  </td> \n\t\t</tr>\n \t\t<tr ><td colspan=\'6\' ></td></tr>\n\t\t\n\t\t<tr  >\t\t\t\n\t\t<td width=\'25%\' class=\'label\' name=\'term_set_id_lbl\' id=\'term_set_id_lbl\' style=\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\'  width=\'20%\' >";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="</td>\n\t\t<td width=\'25%\' name=\"term_set_id_td\" id=\"term_set_id_td\"  style=\'";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\' class=\"fields\"><select name=\"term_set_id\" id=\"term_set_id\" onChange=\"parent.parent.parent.onChangeTermSetID();\" >\n\t\t<option value=\"\">";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="</option>\n\t\t";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\t\n\t\t\t<option value=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="</option>  \n";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n\t\t</select><img align=center src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\n\t\t</td>\n\n\t\t<td class=\'label\' width=\'23%\' id=\'term_code_lbl\'  style=\'";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="</td>\n\t\t<td width=\'25%\' id=\'term_code_td\' style =\'";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\' class=\"fields\">\n\t\t<input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\">\n\t\t\t\n\t\t<input type=\'text\' width=\'18%\' name=\'term_desc\' id=\'term_desc\' size=\'28\' maxlength=\'30\'\n\t\t";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\n\t\tonBlur=\"parent.parent.parent.before_show_term_code_window(term_set_id);\"  value=\"";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\">\n\t\t<input type=\'button\' class=\'button\' name=\'term_code_button\' id=\'term_code_button\' value=\'?\' ";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\n\t\tonClick=\"parent.parent.parent.show_term_code_window(term_set_id);\">\n\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img><input type=\"hidden\" name=\"temp_term_desc\" id=\"temp_term_desc\" value=\"\">\n\t\t</td> \n \t</tr> \n\t  </table>\n\t  </td>\n\t  </tr>\n<!--IN068314 Starts-->\t  \n";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\n<TR>\n\t<td>\n\t<table border=\'0\'  cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" >\n\t<tr><td class=\'columnheader\' colspan=\'3\' align=\"left\">";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="</th><tr>\n\t<tr>\n\t  <td  class=\"label\" >";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="</td>\n\t  <td  class=\"label\"  width=\'25%\'><input type=\"radio\" name=\"fpp_yn\" id=\"fpp_yn\" value=\"N\" width=\'25%\' onclick=\"loadfppCategory(this)\" ";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 =" /></td>\n\t  <td  class=\"label\"  width=\'50%\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t  <td  class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 =" </td>\n\t  <td  class=\"label\" width=\'50%\' ><input type=\"radio\" name=\"fpp_yn\" id=\"fpp_yn\" value=\"Y\" onclick=\"loadfppCategory(this)\" ";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 =" /> </td>\n\t   <td  class=\"label\"  width=\'50%\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t  <td width=\'25%\' id=\'fppCategoryApplicable_lbl_td\'  style=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="</td>\n\t  <TD width=\'25%\' id=\'fppCategoryApplicable_td\' class=\"label\" style=\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\">\n\t   <select name=\"fpp_category\" id=\"fpp_category\">\n\t\t   <option  value=\"S\" ";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="</option>\n\t\t   <option  value=\"M\" ";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="</option>\n\t\t   <option  value=\"C\" ";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="</option>\n\t   </select>\n\t   </td>\n\t    <td  class=\"label\"  width=\'50%\'>&nbsp;</td>\n\t</tr>\n\t</table>\n\t</td> \n</TR>\n";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\n<!--IN068314 Ends-->\n \n\n</table>\n<!-- --------------------- CHARTING----------------------------- -->\n\n<!-- ---------------------The  End-------------------------------- -->\n\t<input type=\"hidden\" name=\"notes_sql\" id=\"notes_sql\" \tvalue=\"";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\">\n\t<input type=\"hidden\" name=\"sql_or_catalog_discrete_auto_report_yn\" id=\"sql_or_catalog_discrete_auto_report_yn\" \tvalue=\"";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\">\n\t\n\t<input type=\"hidden\" name=\"sql_or_catalog_discrete_profile\" id=\"sql_or_catalog_discrete_profile\" \tvalue=\"";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\">\n\n\t<input type=\"hidden\" name=\"sql_or_catalog_culture_test_atomic\" id=\"sql_or_catalog_culture_test_atomic\" \tvalue=\"";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\">\n\n\t<input type=\"hidden\" name=\"ResultTemplate_sql\" id=\"ResultTemplate_sql\" \tvalue=\"";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\">\n\n\t<input type=\"hidden\" name=\"ResultMatrix_sql\" id=\"ResultMatrix_sql\" \tvalue=\"";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\">\n\t<input type=\"hidden\" name=\"sql_or_catalog_discrete_atomic\" id=\"sql_or_catalog_discrete_atomic\" \tvalue=\"";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\">\n\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">\n\t<input type=\"hidden\" name=\"qry_str\" id=\"qry_str\" value=\"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\">\n\t<input type=\"hidden\" name=\"bill_install_Yn\" id=\"bill_install_Yn\" value=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\">\n\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\">\n\t<input type=\"hidden\" name=\"result_applicable_yn_db\" id=\"result_applicable_yn_db\" value=\"";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\">\n\t<input type=\"hidden\" name=\"tabType\" id=\"tabType\" value=\"C\">\n\n\t<input type=\"hidden\" name=\"qty_uom_sql\" id=\"qty_uom_sql\" \tvalue=\"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\">\n\n\t<input type=\"hidden\" name=\"chart_sql\" id=\"chart_sql\" \tvalue=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\">\n\n\t<input type=\"hidden\" name=\"update_soft_stop_yn_db\" id=\"update_soft_stop_yn_db\" \tvalue=\'";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\'>\n\t<input type=\"hidden\" name=\"update_cont_order_yn_db\" id=\"update_cont_order_yn_db\" \tvalue=\'";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\'>\n\t\n\t\n\n\t\n\n\t\n";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\n<script>\nvar eff_status=\"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\";\t\nvar flag=true;\n//var order_category=document.detailLowerForm.order_category.value;\nvar order_category=document.getElementById(\'order_category\').value;\nif(order_category == \"RD\" || order_category == \"RX\" || order_category == \"PC\" || order_category == \"DS\")\t\n\t{\n\t\t//parent.parent.parent.chkCompleteOnOrder(document.detailLowerForm.complete_on_order_yn);\n\t\tif((document.detailLowerForm.complete_on_order_yn.checked==true &&  document.detailLowerForm.result_applicable_yn.checked==true) || (document.detailLowerForm.complete_on_order_yn.checked==false &&  document.detailLowerForm.result_applicable_yn.checked==true))\n\t\tflag=false;\n\t\t\n\t\t\n\t}else{\n\t\n\t\t//flag=document.detailLowerForm.complete_on_order_yn.checked;\n\t\tflag=document.getElementById(\'complete_on_order_yn\').checked;\n\t}\n\nif(!flag){\n\t\n\t//if(document.detailLowerForm.result_applicable_yn!=null){\n\t\tif(document.getElementById(\'result_applicable_yn\')!=null){\n\t\t//document.detailLowerForm.result_applicable_yn.value=\'";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\';\n\t\tdocument.getElementById(\'result_applicable_yn\').value=\'";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\';\n\t\t//parent.parent.parent.chkChart(document.detailLowerForm.result_applicable_yn);\n\t\tparent.parent.parent.chkChart(document.getElementById(\'result_applicable_yn\'));\n\t}\n\t//if(document.detailLowerForm.auto_report_yn !=null){\n\t\tif(document.getElementById(\'auto_report_yn\') !=null){\n\t\tvar auto_report_yn=\'";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\';\n\t\t//alert(\"auto_report_yn=\"+auto_report_yn);\n\t\t//document.detailLowerForm.auto_report_yn.value=auto_report_yn;\n\t\tdocument.getElementById(\'auto_report_yn\').value=auto_report_yn;\n\t\tif (auto_report_yn==\"Y\")\n\t\t\t//document.detailLowerForm.auto_report_yn.checked=true;\n\t\t    document.getElementById(\'auto_report_yn\').checked=true;\n\t\telse\n\t\t\t//document.detailLowerForm.auto_report_yn.checked=false;\n\t\t\tdocument.getElementById(\'auto_report_yn\').checked=false;\n\t\t//parent.parent.parent.chkAutoReport(document.detailLowerForm.auto_report_yn);\n\t\tparent.parent.parent.chkAutoReport(document.getElementById(\'auto_report_yn\'));\n\t}\n\tdocument.detailLowerForm.order_catalog_nature.value=\'";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\';\n\tdocument.detailLowerForm.order_catalog_nature.disabled=true;\n\tif(document.detailLowerForm.result_applicable_yn!=null && document.detailLowerForm.result_applicable_yn.checked ==true){\n\tparent.parent.parent.chkNature(document.detailLowerForm.order_catalog_nature);\n\tdocument.detailLowerForm.chart_result_type.value=\'";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\';\n\tparent.parent.parent.chkResultType(document.detailLowerForm.chart_result_type);\n\t\n\t\n\n\tdocument.detailLowerForm.proc_coding_scheme.value=\'";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\';\n\tdocument.detailLowerForm.proc_link_applicable.value=\'";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\';\n\tdocument.detailLowerForm.proc_link_resulting_option.value=\'";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\';\n\tif(document.detailLowerForm.chart_result_type.value==\'P\'){\n\t\tdocument.detailLowerForm.proc_link_applicable.disabled=true;\t\t\n\t}\n\tparent.parent.parent.showProc_link_resulting_option(document.detailLowerForm.proc_link_applicable);\n    document.detailLowerForm.term_set_id.value=\'";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\';\n\tdocument.detailLowerForm.term_code.value=\'";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\';\n\tvar temp=\'";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\';\n    document.detailLowerForm.term_desc.value=\'";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\';\t\n\tif(order_category==\"PC\" )\t\n\t{\n\t\tif(temp!= \"P\")\n\t\t{\n\t\t\tdocument.detailLowerForm.discr_msr_panel_id_lbl.innerText = \'";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\';\n\t\t\tdocument.detailLowerForm.discr_msr_panel_id_desc.value=\'";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\';\n\t\t\t\n\t\t\t//document.getElementById(\"discr_msr_panel_id_lbl\").innerText = \'";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\';\n\t\t\t//document.getElementById(\"discr_msr_panel_id_desc\").value=\'";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\';\n\t\t}\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'discr_msr_panel_id_lbl\').innerText = \'";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\';\n\t\tdocument.getElementById(\'discr_msr_panel_id_desc\').value=\'";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\'; \n\t\t\n\t\t//document.detailLowerForm.discr_msr_panel_id_lbl.innerText = \'";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\';\n\t\t//document.detailLowerForm.discr_msr_panel_id_desc.value=\'";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\';\n\t}\n\t\n    document.detailLowerForm.discr_msr_panel_id.value=\'";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\';\n\tif(document.detailLowerForm.chart_result_type.value !=\"\" && document.detailLowerForm.discr_msr_panel_id.value !=\"\"){\n\t\tdocument.detailLowerForm.chart_result_type.disabled=true;\n\t\tdocument.detailLowerForm.discr_msr_panel_id_desc.disabled=true;\n\t\tdocument.detailLowerForm.appl_button.disabled=true;\n\t\tif(document.detailLowerForm.chart_result_type.value==\"P\"){\n\t\t\tdocument.detailLowerForm.proc_coding_scheme.disabled=true;\t\t\t\n\t\t}\n\t}\n\tif(document.detailLowerForm.ChartProceApplicable.value == \"N\"){\n\t\tdocument.detailLowerForm.proc_link_applicable.disabled = true;\n\t\tdocument.detailLowerForm.appl_button.disabled = true;\n\t\t\n\t}\n}\n\n}else{\t\n\tif(order_category == \"RD\" || order_category == \"RX\" || order_category == \"PC\" || order_category == \"DS\")\n\t\tparent.parent.parent.chkCompleteOnOrder(document.detailLowerForm.complete_on_order_yn);\n\telse{\n\tdocument.detailLowerForm.result_applicable_yn.checked\t\t    = false;\n\tdocument.detailLowerForm.result_applicable_yn.disabled\t\t= true;\n\talert(\" Inside Other Details Setup Form 1945 document.detailLowerForm.result_applicable_yn : \"+document.detailLowerForm.result_applicable_yn);\n\tparent.parent.parent.chkChart(document.detailLowerForm.result_applicable_yn);\n\t}\n\t\t\n}\n//document.detailLowerForm.order_catalog_nature.disabled=true;\n\t\tif(eff_status==\"D\"){\n\t\t\tif(document.detailLowerForm.charge_type_applicable!=null)\n\t\t\t\tdocument.detailLowerForm.charge_type_applicable.disabled=true;\n\t\t\tif(document.detailLowerForm.confidential_yn!=null)\n\t\t\t\tdocument.detailLowerForm.confidential_yn.disabled=true;\n\t\t\tdocument.detailLowerForm.result_auth_reqd_yn.disabled=true;\n\t\t\tif(document.detailLowerForm.auto_report_yn !=null)\n\t\t\t\tdocument.detailLowerForm.auto_report_yn.disabled=true;\n\t\t\tif(document.detailLowerForm.result_applicable_yn!=null){\n\t\t\t\tdocument.detailLowerForm.order_catalog_nature.disabled=true;\n\t\t\t\tdocument.detailLowerForm.chart_result_type.disabled=true;\n\t\t\t\tdocument.detailLowerForm.proc_coding_scheme.disabled=true;\n\t\t\t\tdocument.detailLowerForm.proc_link_applicable.disabled=true;\n\t\t\t\tdocument.detailLowerForm.proc_link_resulting_option.disabled=true;\n\t\t\t\tdocument.detailLowerForm.term_set_id.disabled=true;\n\t\t\t\tdocument.detailLowerForm.term_desc.disabled=true;\n\t\t\t\tdocument.detailLowerForm.term_code_button.disabled=true;\n\t\t\t\tdocument.detailLowerForm.discr_msr_panel_id_desc.disabled=true;\n\t\t\t\tif(document.detailLowerForm.appl_button!=null)\n\t\t\t\tdocument.detailLowerForm.appl_button.disabled=true;\n\t\t\t\t}\n\t\t}\n\n</script>\n";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\n\t\n\n </form>\n\n";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
 
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date		Rev.Name		 Description
-------------------------------------------------------------------------------------------------------------------------------
?             100           ?												created
28/02/2013	  LiveIssue		Chowminya G									the Procedure name displayed incorrectly (code same as discr_msr)
10/03/2014	  IN024984		Chowminya	 								Duplicate order recording with reason - new mandatory option	
13/03/2014	  IN047644		Karthi		 								Duplicate Override check box is still displayed and enabled even though order catalog is disabled
20/05/2016	  51135		Karthi		 									MO-CRF-20085 [IN051135]
08/05/2017	IN063816		Vijayakumar K									GHL-CRF-0445.1 [IN:063816]
15/12/2017	IN065942	Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
10/05/2019  IN068926       sivabagyam      10/05/2019      Ramesh G    	 ML-MMOH-CRF-1290																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
24/12/2019	IN068314	Nijitha		  23/12/2019			Ramesh G	 ML-MMOH-CRF-1229
07/09/2020	7540			Nijitha S		07/12/2020		Nijitha S		PMG2019-MMS-CRF-0004.1
-------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


try{


	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */	
	String mode			= request.getParameter( "mode" ) ;
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	//String disabled = "" ;
	String FppModificaion =""; //IN068314
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);
	//String function_id  =bean.checkForNull(request.getParameter("function_id"));		
	//headerStore
	HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();


/*****DEFAULT VALUES****/
	String result_auth_reqd_yn_default	   = "N";



	String eff_status					   = "E" ; //For modify mode Only

	//to display the various tab
	String StyleDefaultSyn				   = "bottom-margin:0;"  ;	
	String StyleDefaultTiming			   = "bottom-margin:0;display:none ;"  ;
	String StyleDefaultInstrns			   = "bottom-margin:0;display:none ;"  ;
	String tabFlag=request.getParameter("tabFlag");
	

	if (tabFlag.equalsIgnoreCase("Timing")){
		StyleDefaultSyn			   = "bottom-margin:0;display:none;";
		StyleDefaultTiming			   = "bottom-margin:0;";
		StyleDefaultInstrns			   = "bottom-margin:0;display:none;";
	}else if(tabFlag.equalsIgnoreCase("O")){
		StyleDefaultSyn			   = "bottom-margin:0;display:none;";
		StyleDefaultTiming			   = "bottom-margin:0;display:none;";
		StyleDefaultInstrns			   = "bottom-margin:0;";
	
	}
	String StyleDefaultDup				   = "bottom-margin:0;display:none ;"  ;
	String StyleDefaultCon				   = "bottom-margin:0;display:none ;"  ;
	String StyleDefaultexpText			   = "bottom-margin:0;display:none ;"  ;
	
	String uom_style						= "display:none";
	String ChargeTypeApplicable_style		= "display:none";


	/**********UPDATABLE DEF******************/
	 //Syn  Tab
	String catalog_synonym_directCare_updatable			 = "Y";
	String effective_status_directCare_updatable		 = "Y";
	String catalog_synonym_ancillaryDept_updatable		 = "Y";
	String effective_status_ancillaryDept_updatable		 = "Y";

	//Timing Tab
	String qty_reqd_yn_updatable						 = "Y" ;
	String split_dose_yn_updatable						 = "Y" ;
	String taper_dose_yn_updatable				 		 = "Y" ;
	String none_yn_updatable				 		 = "Y" ;
	String appl_sliding_scale_yn_updatable               = "Y" ;
	String taper_up_updatable				 		     = "Y" ;
	String none_yn_value								 =  "Y" ;
	String update_freq_yn								 = "N" ;
	String update_soft_stop_yn							 = "N" ;
	String update_cont_order_yn							 = "N" ;

	String contineous_freq_order_updatable				 = "Y";
	//**String indexed_yn_updatable						     = "Y";//moved to header frame

	String consent_reqd_yn_updatable					 = "Y" ;
	String multi_consent_yn_updatable					 = "Y" ;
	String consent_stage_updatable						 = "N" ;
	String consent_form_id_updatable					 = "N" ;
	String priority_appl_updatable                       = "Y" ;
	String refusalNoteText_appl_updatable                = "Y" ;

	String qty_reqd_yn_def								 = "N" ;
	String update_refill_cont_order_yn					 = "N" ;
	String refill_cont_order_yn_default					 = "N";

	//Duplicate
	String reqUpdatable									 = "N" ;//Dupl chk req Feild....
	
	//Expalnatory
	String explanatory_textUpdatable					 = "Y" ;

//review	//(Charting)
	String dept_only_yn_updatable						 = "Y";
	String com_on_ord_Updateble							 = "N";	
	String bill_Updateble								 = "N";	
	//**String image_link_id_Updateble						 = "N";//moved to header frame
	String chart_res_Updateble							 = "N";	//Autho req	
	//String athu_req_Updateble							 = "N";
	String ord_cat_nature_Updateble						 = "N";	
	String chart_result_type_updateble					 = "N";	
	//String discr_msr_pan_id_Updateble					 = "N";	// depend on 	chart_res_Updateble
	//String optionsLink_Updateble					 	 = "y";
	String contr_mod_id_Updateble						 = "y";// depend on
	String ChartProceApplicable							 = "Y" ;
	String proc_link_resulting_option_style				="visibility:hidden";
	/*term set store*/
	ArrayList TermSetID=new ArrayList();
	String[] record=null;
	String term_set_style								="visibility:hidden";
	String proc_term_set_style								="display:none";
	String auto_report_style;	
	String dupl_reason_set_style						="display:none";//IN024984
	//String contr_msr_panel_id_Updateble				 	 = "y";// depend on
	/***///review
	String barcode_required_yn_updatable				= "Y";	//IN063816
	//IN063816 start
	String barcodeSiteSpecificYN = "";

	boolean isSiteSpecific = false;
	boolean isfppapplicable= false;//IN068314
	Connection connection =  null;
	try{
	connection = ConnectionManager.getConnection(request); 
	isSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","GHL_BARCODE_LABEL_REPORT");
	isfppapplicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","FPP_APPLICABLE_YN");//IN068314
	}catch(Exception e1){
		e1.printStackTrace();
	}finally{
		if(connection!=null) connection.close();
	}
	if(isSiteSpecific)
	{
		barcodeSiteSpecificYN = "Y";
	}
	else
	{
		barcodeSiteSpecificYN = "N";
	}
	//IN063816 ends


	/*Billing installed chks*/
	String bill_install_Yn ="N";
	String single_selected="selected";
	String multi_selected="";
	try
	{
		HashMap   billingChk      = bean.getSqlResult("SQL_OR_CHECK_MODULE_INSTALL_YN");
		bill_install_Yn =(String)billingChk.get("INSTALL_YN1");
		//bill_install_Yn="Y";
		if(bill_install_Yn == null)
			bill_install_Yn="N";
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	/****/



	/****Passed from Other Module*********/
	String module_id		 = bean.checkForNull(request.getParameter( "module_id"));
	//String module_id		 = "PH"; --Kavithas testing string
	String uom_code			 = bean.checkForNull(request.getParameter( "uom_code"));
	
	String uom_desc			 = bean.checkForNull(request.getParameter( "uom_desc"));

	
	String order_category	 = bean.checkForNull(request.getParameter( "order_category"));
	String order_type_code	 = bean.checkForNull(request.getParameter( "order_type_code"));
	String qry_str				= request.getQueryString();
	String tpn_item_yn	 = bean.checkForNull(request.getParameter( "tpn_item_yn"));//IN068926
	/***/
	/***if(order_category.trim().equalsIgnoreCase("RX") || order_category.trim().equalsIgnoreCase("RD")|| order_category.trim().equalsIgnoreCase("TR") )
		image_link_id_Updateble = "Y" ;****///moved to header frame



	/******Retriving Store for this tab*******/
	ArrayList  characteristicsRecStr =  bean.getCharacteristicsRecStr();

	//String proc_coding_scheme=bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_coding_scheme","");						
	String term_code=bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code","");	
	String term_desc=bean.getdefaultArrListValue(characteristicsRecStr,0,"term_desc","");	
	//IN068314 Starts
	String fppCategoryApplicable_style="display:none";
	String fpp_yn=bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_yn","N");	
	String fpp_category=bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_category","S");
	
	if("Y".equals(fpp_yn)){
		fppCategoryApplicable_style="";
	}
	
	//IN068314 Ends
	/********MODIFY MODE **************************/

	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
		FppModificaion ="disabled"; //IN068314
 		//In modify mode if the eff status is no then all should be disabled
	//eff_status  =  bean.checkForNull((String)orderCatalogHeaderStr.get("eff_status"));
		eff_status  =  (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();
 		//PH VALIDATION
		if(module_id.trim().equalsIgnoreCase("PH")){


		//Always be checked for PH & updateble or not depends on PH
		 update_refill_cont_order_yn	   = request.getParameter("update_refill_cont_order_yn");

		 StyleDefaultSyn				   = "bottom-margin:0;display:none ";  //Primary tab to be hidden
		 if(tabFlag.equalsIgnoreCase("C")){
		 StyleDefaultTiming				   = "bottom-margin:0;display:none "  ;//Shown by default
		 StyleDefaultCon				   = "bottom-margin:0;;"  ;//Shown by default
		 }else{
			StyleDefaultTiming			   = "bottom-margin:0;"  ;//Shown by default
			StyleDefaultCon				   = "bottom-margin:0;display:none ;"  ;//Shown by default	 
		 }
		 StyleDefaultDup				   = "bottom-margin:0;display:none ;"  ;		 
		 StyleDefaultexpText			   = "bottom-margin:0;display:none ;"  ;
		 StyleDefaultInstrns			   = "bottom-margin:0;display:none ;" ; //Instr's tab to be hidden
	  } else if (!order_category.trim().equalsIgnoreCase("PH")) {
		  
	  	if (!bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom",uom_code).equals("")) { 		uom_desc=bean.getqty_uom_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom",uom_code));
	  	}
	  }else if(order_category.trim().equalsIgnoreCase("PH"))
		{

			 StyleDefaultSyn				   = "bottom-margin:0;display:none ";  //Primary tab to be hidden
			 if(tabFlag.equalsIgnoreCase("C")){
			 StyleDefaultTiming				   = "bottom-margin:0;display:none "  ;
			 StyleDefaultCon				   = "bottom-margin:0;;"  ;//Shown by default
			 }else{
				StyleDefaultTiming			   = "bottom-margin:0;"  ;//Shown by default
				StyleDefaultCon				   = "bottom-margin:0;display:none ;"  ;	 
			 }
			 StyleDefaultDup				   = "bottom-margin:0;display:none ;"  ;
			 StyleDefaultexpText				= "bottom-margin:0;display:none ;"  ;
			 StyleDefaultInstrns			   = "bottom-margin:0;display:none ;" ; //Instr's tab to be hidden
	  
		 }

}


	/**CALLED FROM DIFFERENT MODULE --INSERT MODE***/
	if(!module_id.equalsIgnoreCase("OR")&& !mode.equals( 								CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
	{
		if(module_id.trim().equalsIgnoreCase("PH"))
		{

		 String sql_auth_level = bean.checkForNull(request.getParameter("sql_auth_level"));
		 sql_auth_level = "SELECT A.ORDER_AUTH_LEVEL ord_auth_level,A.ORDER_COSIGN_LEVEL ord_cosign_level,A.SPL_APPR_LEVEL ord_spl_appr_level,A.DISP_AUTH_REQD_YN result_auth_reqd_yn,A.REPEAT_SINGLE_CONT_ORDER_YN FROM PH_DRUG_SCHEDULE_LANG_VW A WHERE SCHEDULE_ID='"+sql_auth_level+"' AND EFF_STATUS='E' AND A.LANGUAGE_ID = '"+localeName+"' ";
		 //checked  & updateble depends on PH
		 refill_cont_order_yn_default = request.getParameter("update_refill_cont_order_yn");;
		 update_refill_cont_order_yn  = request.getParameter("update_refill_cont_order_yn");		
		 int sizeDef =0;
		 String sqlParam[]  = {};
		 if(!(sql_auth_level.equals("") && sql_auth_level.equals("null")))
		 {
			 Hashtable defVal = bean.reviewsDefault(sql_auth_level,"auth_level",sqlParam);
			 sizeDef = defVal.size();
			 if(sizeDef != 0)
			 {
				 HashMap retRec						= (HashMap)defVal.get("*A");
				 result_auth_reqd_yn_default         = (String)retRec.get("result_auth_reqd_yn1");
			 }
		 }

		 StyleDefaultSyn				   = "bottom-margin:0;display:none ;" ;  //Primary tab to be hidden
		if(tabFlag.equalsIgnoreCase("C"))
		{
			StyleDefaultTiming				   = "bottom-margin:0;display:none "  ;
			StyleDefaultCon				   = "bottom-margin:0;;"  ;//Shown by default
		}
		else
		{
			StyleDefaultTiming			   = "bottom-margin:0;"  ;//Shown by default
			StyleDefaultCon				   = "bottom-margin:0;display:none ;"  ;	 
		}
		 StyleDefaultDup				   = "bottom-margin:0;display:none ;"  ;
		 StyleDefaultexpText			   = "bottom-margin:0;display:none ;"  ;
		 StyleDefaultInstrns			   = "bottom-margin:0;display:none ;" ; //Instr's tab to be hidden

		 qty_reqd_yn_def				   = "Y" ;

		}
	}
	/***/

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(StyleDefaultSyn));
            _bw.write(_wl_block10Bytes, _wl_block10);

		
	if(eff_status.trim().equalsIgnoreCase("D"))
	{//only in mod mode if eff_staus is disabled
		catalog_synonym_directCare_updatable	 =  "N" ;
		catalog_synonym_ancillaryDept_updatable  =  "N" ;
		effective_status_directCare_updatable	 =  "N"	;
		effective_status_ancillaryDept_updatable =  "N"	;
		explanatory_textUpdatable				 =	"N"	;
	}

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"catalog_synonym_primary","")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"effective_status_primary",""))));
            _bw.write(_wl_block17Bytes, _wl_block17);

 try
 { 
 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",catalog_synonym_directCare_updatable,"","disabled")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"catalog_synonym_directCare","")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",effective_status_directCare_updatable,"","disabled")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y",  bean.getdefaultArrListValue(characteristicsRecStr,0,"effective_status_directCare",""))));
            _bw.write(_wl_block23Bytes, _wl_block23);

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",catalog_synonym_ancillaryDept_updatable,"","disabled")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"catalog_synonym_ancillaryDept","")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",effective_status_ancillaryDept_updatable,"","disabled")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"effective_status_ancillaryDept",""))));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(StyleDefaultTiming));
            _bw.write(_wl_block10Bytes, _wl_block10);
	
if(eff_status.trim().equalsIgnoreCase("D"))
{//only in mod mode if eff_staus is disabled
	qty_reqd_yn_updatable					 =  "N" ;
	catalog_synonym_ancillaryDept_updatable  =  "N" ;
	taper_dose_yn_updatable					 =  "N" ;
	appl_sliding_scale_yn_updatable          =  "N" ;
	taper_up_updatable					     =  "N" ;
	none_yn_value							 = "N";
	none_yn_updatable							 = "N";
	split_dose_yn_updatable					 =  "N" ;
	update_refill_cont_order_yn					 =  "N" ;

}

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",qty_reqd_yn_updatable,"","disabled")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_reqd_yn",qty_reqd_yn_def))));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_category.trim()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(module_id.trim()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
if(module_id.trim().equalsIgnoreCase("PH") || order_category.trim().equalsIgnoreCase("PH") || (bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_reqd_yn",qty_reqd_yn_def).equalsIgnoreCase("Y"))){
  			 	uom_style = "";
  			 }
			  
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((uom_style.equals(""))?"UOM":""));
            _bw.write(_wl_block37Bytes, _wl_block37);
if (uom_style.equals("")) {
            _bw.write(_wl_block38Bytes, _wl_block38);
            _bw.write(_wl_block39Bytes, _wl_block39);

				String qty_uom		 = bean.checkForNull(request.getParameter( "uom_code"));
				if(qty_uom.equals(""))
					qty_uom		 = bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom","");

			
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom_desc",uom_desc)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((((module_id.trim().equalsIgnoreCase("PH") || order_category.trim().equalsIgnoreCase("PH") || eff_status.trim().equalsIgnoreCase("D")) ||( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))) && (!(bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom_desc",uom_desc).equals(""))))?"disabled":""));
            _bw.write(_wl_block43Bytes, _wl_block43);
if(!module_id.trim().equalsIgnoreCase("PH") && !order_category.trim().equalsIgnoreCase("PH")){
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) && (!(bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom_desc",uom_desc).equals(""))))?"disabled":""));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block46Bytes, _wl_block46);

			//String module_id="PH";
			if(module_id.trim().equalsIgnoreCase("PH"))
			{
			
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",split_dose_yn_updatable,"","disabled")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"split_dose_yn",""))));
            _bw.write(_wl_block50Bytes, _wl_block50);
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",taper_up_updatable,"","disabled")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"taper_up",""))));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",taper_dose_yn_updatable,"","disabled")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"taper_dose_yn",""))));
            _bw.write(_wl_block56Bytes, _wl_block56);

			  if(bean.getdefaultArrListValue(characteristicsRecStr,0,"taper_up","").equals("N") && (bean.getdefaultArrListValue(characteristicsRecStr,0,"taper_dose_yn","").equals("N")))
			  {
				none_yn_value="Y";			 
			  }
			  else
				none_yn_value="N";	
			
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(none_yn_value));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",taper_dose_yn_updatable,"","disabled")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y",none_yn_value)));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",appl_sliding_scale_yn_updatable,"","disabled")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"appl_sliding_scale_yn",""))));
            _bw.write(_wl_block63Bytes, _wl_block63);
}else{//this in case of  Ph to adjust the screen 
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);

			String params[] = {order_category.trim(),order_type_code.trim()} ;
			HashMap   freq_chk      = bean.getSqlResultParam("SQL_OR_CATALOG_FREQ_VALIDATION",params);
			String  result_applicable_yn		=
			(String)freq_chk.get("RESULT_APPLICABLE_YN1");
			String deflt_freq_yn        =
			(String)freq_chk.get("DEFLT_FREQ_YN1");
			String deflt_soft_stop_yn   =
			(String) freq_chk.get("DEFLT_SOFT_STOP_YN1");
			String deflt_cont_order_yn1  = (String)freq_chk.get("DEFLT_CONT_ORDER_YN1");
			String deflt_cont_order_yn  = "";
			//7540 Starts
			String deflt_freq_order_split_indi_yn="N";
			deflt_freq_order_split_indi_yn = bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_order_split_indvi_yn",deflt_freq_order_split_indi_yn);
			//7540 Ends

			
			update_freq_yn       =(String)freq_chk.get("UPDATE_FREQ_YN1");
			update_soft_stop_yn  =(String)freq_chk.get("UPDATE_SOFT_STOP_YN1");
			update_cont_order_yn =(String)freq_chk.get("UPDATE_CONT_ORDER_YN1");

			String cont_order_yn_options = "";

			if(deflt_freq_yn.trim().equalsIgnoreCase("N"))
			{
				deflt_soft_stop_yn	 = "N"  ;
				deflt_cont_order_yn1  = "N"  ;
				update_freq_yn		 = "N"  ;
				update_soft_stop_yn  = "N"  ;
				update_cont_order_yn = "N"  ;
			}
		  // To stop the Updatable of Stop Soft && cont when frequency  is no
			//String freqChk  =  bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_applicable_yn",deflt_freq_yn);
			deflt_soft_stop_yn = bean.getdefaultArrListValue(characteristicsRecStr,0,"soft_stop_yn",deflt_soft_stop_yn);
			deflt_cont_order_yn = bean.getdefaultArrListValue(characteristicsRecStr,0,"cont_order_yn",deflt_cont_order_yn);
			/* if(freqChk.equalsIgnoreCase("N")){
				  update_cont_order_yn	 = "N" ;
  				  update_soft_stop_yn	 = "N" ;
				  deflt_soft_stop_yn     = "N" ;
				  deflt_cont_order_yn    = "N" ;
			 }
			*/

			if(deflt_cont_order_yn.trim().equalsIgnoreCase("Y"))
			{
				cont_order_yn_options = "<option 	value=''>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</option><option value='D'   " +  eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"contineous_freq_order",""),"D") + ">Explode By Day</option>";
			}
			else
			{
				cont_order_yn_options = "<option value=''>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels")+"</option>";
			}

			if(eff_status.trim().equalsIgnoreCase("D"))
			{//only in mod mode if eff_staus is disabled
				update_freq_yn								 = "N" ;
				update_soft_stop_yn							 = "N" ;
				update_cont_order_yn						 = "N" ;
			}

			if(!order_category.equals("PH"))
			{
			
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_applicable_yn",deflt_freq_yn))));
            out.print( String.valueOf(eHISFormatter.chkReturn("y",update_freq_yn,"","disabled")));
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y",deflt_soft_stop_yn )));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(eHISFormatter.chkReturn("Y",update_soft_stop_yn,"","disabled")));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y",deflt_cont_order_yn)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",update_cont_order_yn,"","disabled")));
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(deflt_freq_order_split_indi_yn ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_order_split_indvi_yn",deflt_freq_order_split_indi_yn))));
            _bw.write(_wl_block78Bytes, _wl_block78);

		if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
			contineous_freq_order_updatable = "N";
			//**indexed_yn_updatable			= "N";//moved to header frame
		}


            _bw.write(_wl_block79Bytes, _wl_block79);
if(!order_category.equals("PH")){ 
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",contineous_freq_order_updatable,"","disabled")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(cont_order_yn_options));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
if(module_id.trim().equalsIgnoreCase("PH") && deflt_cont_order_yn1.equals("Y")){
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",update_refill_cont_order_yn,"","disabled")));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"refill_cont_order_yn",refill_cont_order_yn_default))));
            _bw.write(_wl_block88Bytes, _wl_block88);
}else{
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block90Bytes, _wl_block90);

	if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
	priority_appl_updatable                      = "N" ;
	}
	String priority_appl = bean.getdefaultArrListValue(characteristicsRecStr,0,"priority_appl","");

            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",priority_appl_updatable,"","disabled")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf((priority_appl.equals("") ? "selected" : "")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf((priority_appl.equals("2") ? "selected" : "")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf((priority_appl.equals("1") ? "selected" : "")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf((priority_appl.equals("3") ? "selected" : "")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
if(module_id.trim().equalsIgnoreCase("PH"))
{
 try
 {
 
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_Updateble,"","disabled")));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"result_auth_reqd_yn",result_auth_reqd_yn_default))));
            _bw.write(_wl_block102Bytes, _wl_block102);

  }
  catch (Exception e)
  {
	e.printStackTrace();
  }			 
}

            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(StyleDefaultDup));
            _bw.write(_wl_block104Bytes, _wl_block104);

				String reqDefault		    = bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_yn","N") ;
				reqUpdatable			    = "Y" ;
				String periodDefault	    = "";
				String unitDefault		    = "";
				String optionsStatus	    = "";
				String optionsActionType	= "";
				//String activity_type = "";
				//Values when user already seleted when val when he has visted the tab
				//String optBehindSel     = "";
				//String optAheadSel      = "";
				String optionsBehindAct =
				"<option value=''>--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option>"+
				"<option value='R'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action",""),"R") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")+"</option>" +
				"<option value='W'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action",""),"W") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels")+"</option>" +
				"<option value='N'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action",""),"N") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NoCheck.label","or_labels")+"</option>";

				String optionsAheadAct	=
				"<option value=''>--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option>"+
				"<option value='R'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action",""),"R") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")+"</option>" +
				"<option value='W'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action",""),"W") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels")+"</option>" +
				"<option value='N'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action",""),"N") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NoCheck.label","or_labels")+"</option>";
			//	module_id = "PH" ;

			 if(module_id.trim().equalsIgnoreCase("PH"))
			 {
				reqDefault		 = "Y" ;
				reqUpdatable	 = "N" ;
				periodDefault	 = "N";
				unitDefault		 = "N";

				optionsStatus	 = "<option value='D'"+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_status",""),"D") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ActiveGeneric.label","or_labels")+"</option>" ;

				optionsBehindAct = "<option value='W'"+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action",""),"W") + ">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warn.label","common_labels")+"</option>";

				optionsAheadAct	 = "<option value='W'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action",""),"W") + ">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warn.label","common_labels")+"</option>";

			 }
			 else
			 {
				periodDefault	 = reqDefault;
				unitDefault		 = reqDefault;
				optionsStatus	 = "<option value=''>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</option>"+
				
				"<option value='A' "+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_status",""),"A") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ActiveOrderableStatus.label","or_labels")+"</option>"  +
				"<option value='Z'"+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_status",""),"Z") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AnyOrderableStatus.label","or_labels")+"</option>" +
				"<option value='C' "+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_status",""),"C") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CompletedOrderStatus.label","or_labels")+"</option>" ; // added CompletedOrderStatus for MO-CRF-20085 [IN051135]

				optionsActionType	 = "<option value=''> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</option>"+
				"<option value='O' "+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"check_for_dupl_level",""),"O") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ByOrderable.label","or_labels")+"</option>"  +
				"<option value='A'"+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"check_for_dupl_level",""),"A") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ByActivityType.label","or_labels")+"</option>" ;  
			 }
			 
			if(eff_status.trim().equalsIgnoreCase("D"))
			{//only in mod mode if eff_staus is disabled
				reqUpdatable = "N";
				reqDefault	 = "N";
				periodDefault= "N" ;
				unitDefault	 = "N" ;
			}
			
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_yn",reqDefault))));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")));
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("Y",bean.getdefaultArrListValue(characteristicsRecStr,0,"routine_chk_for_dupl_yn","N"))));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")));
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("Y",bean.getdefaultArrListValue(characteristicsRecStr,0,"urgent_chk_for_dupl_yn","N"))));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")));
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("Y",bean.getdefaultArrListValue(characteristicsRecStr,0,"stat_chk_for_dupl_yn","N"))));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqDefault.trim(),"","disabled")));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(optionsStatus));
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqDefault.trim(),"","disabled")));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(optionsActionType));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqDefault.trim(),"","disabled")));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(optionsActionType));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(((bean.getdefaultArrListValue(characteristicsRecStr,0,"check_for_dupl_level","")).equals("A"))?"Activity Type":""));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(((bean.getdefaultArrListValue(characteristicsRecStr,0,"check_for_dupl_level","")).equals("A"))?"<input type='text' size='20' maxlength='20' onkeypress='return CheckForSpecChars(event)'  onBlur='ChangeUpperCase(this);' "+eHISFormatter.chkReturn("y",reqDefault,"","disabled")+" name='activity_type' id='activity_type' value='"+bean.getdefaultArrListValue(characteristicsRecStr,0,"activity_type","")+"'>":"<input type='hidden' size='20' maxlength='20' name='activity_type' id='activity_type' value=''>"));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqDefault,"","disabled")));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(optionsBehindAct));
            _bw.write(_wl_block129Bytes, _wl_block129);

			String  chk_for_dupl_behind_period= bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_period","");
			if(chk_for_dupl_behind_period.trim().equals("0"))
			chk_for_dupl_behind_period = "" ;
			
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",periodDefault,"","disabled")));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(chk_for_dupl_behind_period));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",unitDefault,"","disabled")));
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"M")));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"W")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"D")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"H")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"I")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqDefault,"","disabled")));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(optionsAheadAct));
            _bw.write(_wl_block142Bytes, _wl_block142);

			String  chk_for_dupl_ahead_period= bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_period","")	  ;
			if(chk_for_dupl_ahead_period.trim().equals("0"))
			chk_for_dupl_ahead_period = "" ;
			
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",periodDefault,"","disabled")));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(chk_for_dupl_ahead_period));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",unitDefault,"","disabled")));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"M")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"W")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"D")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"H")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"I")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);
 String dup_reason_reqd1 = bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action","") ;
			String dup_reason_reqd2 = bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action","") ;
		 
		 	if(dup_reason_reqd1.trim().equals("W") || dup_reason_reqd2.trim().equals("W"))
		 		dupl_reason_set_style = "display:inline";
		 
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(dupl_reason_set_style));
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"dup_reason_reqd_yn",reqDefault))));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(StyleDefaultCon));
            _bw.write(_wl_block156Bytes, _wl_block156);

  try
  {
	String consent_reqd_yn_def	   =	bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_reqd_yn","N") ;
	String consent_form_list_def   =	bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_form_list","F") ;
	String consent_stage_def	   =
	bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_stage","") ;
	consent_stage_updatable	   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");
	//bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_form_id","") ;	
	consent_form_id_updatable	   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");
	//String multi_consent_yn_def		= "N";
	String num_of_consent_req_bo	=	bean.getdefaultArrListValue(characteristicsRecStr,0,"num_of_consent_req_bo","") ;
	String num_of_consent_req_br	=	bean.getdefaultArrListValue(characteristicsRecStr,0,"num_of_consent_req_br","") ;	
	if((num_of_consent_req_bo==null || num_of_consent_req_bo.equals("")) && (consent_stage_def.equals("") || consent_stage_def.equals("A") || consent_stage_def.equals("R")))
	{
		num_of_consent_req_bo = "0";
	}
	if((num_of_consent_req_br==null || num_of_consent_req_br.equals("")) && (consent_stage_def.equals("") || consent_stage_def.equals("R") || consent_stage_def.equals("A")))
	{
		num_of_consent_req_br = "0";
	}
	String multi_consent_yn_def		= 	bean.getdefaultArrListValue(characteristicsRecStr,0,"multiple_consent_yn","N") ; 
	multi_consent_yn_def			=	multi_consent_yn_def.equals("N")?(( (!num_of_consent_req_bo.equals("") && !num_of_consent_req_br.equals("") && (Integer.parseInt(num_of_consent_req_bo) + Integer.parseInt(num_of_consent_req_br) ) >1 ) )?"Y":"N"):multi_consent_yn_def;

	multi_consent_yn_updatable	   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");
	consent_stage_updatable		   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");
	//consent_form_id_updatable	   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");

	if(eff_status.trim().equalsIgnoreCase("D"))//only in mod mode if eff_staus is disabled
	{
		consent_reqd_yn_updatable				= "N" ;
		multi_consent_yn_updatable				= "N" ;	
		consent_stage_updatable					= "N" ;
		consent_form_id_updatable				= "N" ;
		priority_appl_updatable                 = "N" ;
		refusalNoteText_appl_updatable          = "N" ;
	}
	if(multi_consent_yn_def.equals("Y"))
	{
		consent_form_id_updatable				= "N" ;
		consent_stage_updatable					= "N" ;
	}

            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y",consent_reqd_yn_def)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",consent_reqd_yn_updatable,"","disabled")));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",multi_consent_yn_updatable,"","disabled")));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf((consent_form_list_def.equals("F")? "selected":"")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf((consent_form_list_def.equals("V")? "selected":"")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);

		//bean.setInstructionsConsentStr();
		//HashMap instructionsConsentStr   =	 bean.getInstructionsConsentStr();
	HashMap instructionsConsentStr   =	bean.getSqlResult("SQL_OR_CATALOG_CONSENT_FORMAT");
	Integer	noOfRecConsentTemp		 = (Integer)instructionsConsentStr.get("noRec");
	int noOfRecConsent               =   noOfRecConsentTemp.intValue() ;
	StringBuffer optionsConsent      =   new StringBuffer() ;
	if(noOfRecConsent != 0)
	{
		for(int i=1 ; i <= noOfRecConsent; i++)
		{
			optionsConsent.append("<option value=\""+(String)instructionsConsentStr.get("CONSENT_FORM_ID"+i)
			+  "\"   " + 		eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_form_id",""),(String)instructionsConsentStr.get("CONSENT_FORM_ID"+i))+"> "+ (String)instructionsConsentStr.get("CONSENT_FORM_LABEL"+i)+"</option>");
		}
	}

            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",consent_stage_updatable,"","disabled")));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf((consent_stage_def.equals("A")? "selected":"")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf((consent_stage_def.equals("R")? "selected":"")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("Y",multi_consent_yn_def)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(eHISFormatter.chkReturn("Y",multi_consent_yn_updatable,"","disabled")));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",multi_consent_yn_updatable,"","disabled")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(eHISFormatter.chkReturn("N",multi_consent_yn_def,"disabled","")));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(num_of_consent_req_bo));
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(eHISFormatter.chkReturn("N",multi_consent_yn_def,"disabled","")));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",multi_consent_yn_updatable,"","disabled")));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(num_of_consent_req_br));
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",consent_form_id_updatable,"","disabled")));
            out.print( String.valueOf((consent_form_list_def.equals("V")? "disabled":"")));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(optionsConsent.toString()));
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
	
	HashMap   PopulatelistBox      = bean.getSqlResult("SQL_OR_CATALOG_REFUSAL_NOTE_TEXT");
	Integer noOfRecRefusalTemp =(Integer)PopulatelistBox.get("noRec");
	int noOfRecRefusal               =   noOfRecRefusalTemp.intValue() ;	
	StringBuffer optionsRefusal      =   new StringBuffer() ;
	if(noOfRecRefusal != 0)
	{
		for(int i=1 ; i <= noOfRecRefusal; i++)
		{
			optionsRefusal.append("<option value=\""+(String)PopulatelistBox.get("CONSENT_FORM_ID"+i)+  "\"   " +eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"refusal_form_id",""),(String)PopulatelistBox.get("CONSENT_FORM_ID"+i))+"> "+ (String)PopulatelistBox.get("CONSENT_FORM_LABEL"+i)+"</option>");
		}
	}

	
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",refusalNoteText_appl_updatable,"","disabled")));
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(optionsRefusal.toString()));
            _bw.write(_wl_block186Bytes, _wl_block186);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(StyleDefaultexpText));
            _bw.write(_wl_block188Bytes, _wl_block188);

String explanatory_text=bean.getdefaultArrListValue(characteristicsRecStr,0,"explanatory_text","");

            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",explanatory_textUpdatable,"","disabled")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(explanatory_text));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(StyleDefaultInstrns));
            _bw.write(_wl_block10Bytes, _wl_block10);
				
		String auto_report_yn								 =bean.getdefaultArrListValue(characteristicsRecStr,0,"auto_report_yn","N");
		String com_on_ord_Default	="";
		if(order_category.trim().equalsIgnoreCase("CN"))
		{
			com_on_ord_Default			=  bean.getdefaultArrListValue(characteristicsRecStr,0,"complete_on_order_yn","Y") ;
		}
		else
		{
			com_on_ord_Default			=  bean.getdefaultArrListValue(characteristicsRecStr,0,"complete_on_order_yn","N") ;
		}
		String chart_res_Default			= bean.getdefaultArrListValue(characteristicsRecStr,0,"result_applicable_yn",result_applicable_yn) ;
	//	String bill_Default					= bean.getdefaultArrListValue(characteristicsRecStr,0,"bill_yn","N") ;
		String confidential_yn_Default	    = bean.getdefaultArrListValue(characteristicsRecStr,0,"confidential_yn","N") ;
		String extrlReqForm_default 		= bean.getdefaultArrListValue(characteristicsRecStr, 0, "external_requisition_yn", "N"); //68801
		String prn_regd_ord_def = bean.getdefaultArrListValue(characteristicsRecStr,0,"prn_regd_ord","N");//IN065942

	   // String athu_req_Default				= "N";
		String ord_cat_nature_Default		= "A";
		//String optionsLink					= "";
		//String discr_msr_pan_id				= "";
		//String contr_mod_id					= "";
		String contr_msr_panel_id			= "";
	   /** String scheme						= "";
		String scheme_desc					= "";**/
	   // String chart_values					= "";
		/**ArrayList proc_code_scheme = bean.getProc_code_scheme();
		for (int i = 0; i < proc_code_scheme.size();i++) {
			String [] record = (String [])proc_code_scheme.get(i);
			scheme							= record[0];
			scheme_desc						= record[1];
		}**/
		
		String chk_complete_on_order_yn = bean.getdefaultArrListValue(characteristicsRecStr,0,"complete_on_order_yn","N") ;
	//	String dependend_updatable = "Y";
		com_on_ord_Updateble			= "y" ;
		chart_res_Updateble					= "N" ;
		chart_result_type_updateble			= "Y" ;
		//discr_msr_pan_id_Updateble			= "Y" ;
		ord_cat_nature_Updateble			= "Y" ;
		bill_Updateble						= "y" ;
		//athu_req_Updateble					= "y";
		//optionsLink_Updateble				= "y";
		contr_mod_id_Updateble				= "y";
		//contr_msr_panel_id_Updateble		= "y";
		String chart_res_hidden				= "N" ;
		String bill_hidden					= "N" ;
		//String ord_cat_nature_hidden		= "N";
		//String optionsLink_hidden			= "N";
		//String discr_msr_pan_id_hidden		= "N";
		//String ord_cat_nature_Options		= "<option value='A'>Individual</option><option value='P'>Profile</option>" ;
		String chartManHMTL					=""  ;

		//if(bill_install_Yn.trim().equalsIgnoreCase("Y")){
		//bill_Default = "Y";
		 //}else{
		if(bill_install_Yn.trim().equalsIgnoreCase("N"))
		{
			bill_Updateble = "N";
			bill_hidden	   = "Y";
		}

		if(module_id.trim().equalsIgnoreCase("PH"))
		{
			com_on_ord_Updateble	 = "N";
			bill_hidden				 = "Y";
			chart_res_Default		 = "N" ;
			confidential_yn_Default  = "N";
			chart_res_Updateble      = "N"  ;
			ord_cat_nature_Updateble = "N";
			chart_res_hidden	     = "Y"  ;
			ord_cat_nature_Default   = "N" ;
		}
		else
		{ ;
		}

		if(chk_complete_on_order_yn.trim().equalsIgnoreCase("N") &&   result_applicable_yn.trim().equalsIgnoreCase("Y"))
			chart_res_Updateble = "Y" ;
		else
			chart_res_Updateble = "N" ;
			
		if(order_category.equalsIgnoreCase("RD") || order_category.equalsIgnoreCase("RX")|| order_category.equalsIgnoreCase("PC") || order_category.equalsIgnoreCase("DS"))
		{
			auto_report_style="visibility:visible";
			if(chk_complete_on_order_yn.trim().equalsIgnoreCase("Y") &&   chart_res_Default.trim().equalsIgnoreCase("Y"))
			{
				auto_report_yn="Y";
				chart_res_Updateble = "Y" ;
			} 
		}
		else
		{
			auto_report_style="visibility:hidden";
			auto_report_yn="N";
		}


		 if(chart_res_Default.trim().equalsIgnoreCase("Y"))
		 {
			ord_cat_nature_Updateble		= "Y" ;
			chart_result_type_updateble		= "Y" ;
			//discr_msr_pan_id_Updateble	    = "Y" ;
			if(!(order_category.equalsIgnoreCase("LB")
				||order_category.equalsIgnoreCase("RD") || order_category.equalsIgnoreCase("RX")) )
			{
			chartManHMTL					="<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			}
		}
		else
		{
			ord_cat_nature_Updateble		= "N"      ;
			chart_result_type_updateble		= "N" ;
			//discr_msr_pan_id_Updateble	    = "N" ;
		}
		//IN063816 starts
		String barcode_required_yn_Default	= "";
		if(order_category.trim().equalsIgnoreCase("TR") && "Y".equals(barcodeSiteSpecificYN))
		{
			barcode_required_yn_Default			=  bean.getdefaultArrListValue(characteristicsRecStr,0,"barcode_reqd_yn","N") ;
			
		}
		//IN063816 ends
	 	if(eff_status.trim().equalsIgnoreCase("D"))
		{//only in mod mode if eff_staus is disabled
			dept_only_yn_updatable						 = "N";
			com_on_ord_Updateble						 = "N";
			bill_Updateble								 = "N";
			//** image_link_id_Updateble					 = "N";//moved to header frame
			chart_res_Updateble						 = "N";
			ord_cat_nature_Updateble					 = "N";
			chart_result_type_updateble				 = "N";
			// discr_msr_pan_id_Updateble					 = "N";
			//optionsLink_Updateble					 	 = "N";
			contr_mod_id_Updateble						 = "N";
			ChartProceApplicable						 = "N";
			
			// contr_msr_panel_id_Updateble				 = "N";
			barcode_required_yn_updatable				 = "N";//IN063816
		}

		if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) 
		{

			String term_code_param[]={bean.getdefaultArrListValue(characteristicsRecStr,0,"term_set_id",""),bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code",term_code)};
			//***String term_code_param[]={"ICD10",bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code",term_code)};
			HashMap term_code_map=bean.getSqlResultParam("SQL_OR_ORDER_CATALOG_TERM_DESC",term_code_param);
			String term_desc_temp=term_code_map.get("DESCRIPTION1")==null?"":(String)term_code_map.get("DESCRIPTION1");
			term_desc=bean.getdefaultArrListValue(characteristicsRecStr,0,"term_desc",term_desc_temp);	
			term_code_param=null;
			ord_cat_nature_Updateble = "N";
			if (bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P")) 
			{
				chart_result_type_updateble = "N";
				chart_res_Updateble = "N";
			}
		}
 
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",dept_only_yn_updatable,"","disabled")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"dept_only_yn",""))));
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",com_on_ord_Updateble,"","disabled")));
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"complete_on_order_yn",com_on_ord_Default))));
            _bw.write(_wl_block196Bytes, _wl_block196);
if(order_category.trim().equalsIgnoreCase("CN")){
            _bw.write(_wl_block197Bytes, _wl_block197);
}
            _bw.write(_wl_block198Bytes, _wl_block198);

				  //bill_hidden = "Y" ;  //Billing is hidden for time being

			  if(Boolean.valueOf(eHISFormatter.chkReturn("y",bill_hidden,"false",
				"True")).booleanValue()){
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",bill_hidden,"Visibility:hidden","")));
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",bill_hidden,"Visibility:hidden","")));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",bill_Updateble,"","disabled")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"bill_yn",""))));
            _bw.write(_wl_block203Bytes, _wl_block203);


			if (bean.getdefaultArrListValue(characteristicsRecStr,0,"bill_yn","").equalsIgnoreCase("Y"))
			{
  				ChargeTypeApplicable_style = "";
  			}
			   
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",bill_hidden,"Visibility:hidden","")));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf((ChargeTypeApplicable_style.equals(""))?"Charge Type Applicable":""));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",bill_hidden,"Visibility:hidden","")));
            _bw.write(_wl_block206Bytes, _wl_block206);
if (ChargeTypeApplicable_style.equals("")) {				  if(bean.getdefaultArrListValue(characteristicsRecStr,0,"charge_type_applicable","").equals("S")){
			  single_selected="selected";
			  multi_selected="";
		  }else{
			  single_selected="";
			  multi_selected="selected";			  
		  }
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(single_selected));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(multi_selected));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);

		  }

			 }else{
            _bw.write(_wl_block210Bytes, _wl_block210);
}
            _bw.write(_wl_block211Bytes, _wl_block211);
 if(order_category.trim().equalsIgnoreCase("TR")&&"Y".equals(barcodeSiteSpecificYN)) {
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(barcode_required_yn_Default));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",barcode_required_yn_updatable,"","disabled")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"barcode_reqd_yn",barcode_required_yn_Default))));
            _bw.write(_wl_block214Bytes, _wl_block214);
}
            _bw.write(_wl_block215Bytes, _wl_block215);
if(Boolean.valueOf(eHISFormatter.chkReturn("y",chart_res_hidden,"false","True")).booleanValue()){ 
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_hidden,"Visibility:hidden","")));
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_hidden,"Visibility:hidden","")));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_Updateble.trim(),"","disabled")));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y",chart_res_Default)));
            _bw.write(_wl_block221Bytes, _wl_block221);
if ((com_on_ord_Default.equals(chart_res_hidden) && com_on_ord_Default.equals("Y")))
				  auto_report_style="visibility:hidden";
			  
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(auto_report_yn));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("Y",auto_report_yn)));
            _bw.write(_wl_block225Bytes, _wl_block225);
}else{
            _bw.write(_wl_block226Bytes, _wl_block226);
}
            _bw.write(_wl_block227Bytes, _wl_block227);
if(Boolean.valueOf(eHISFormatter.chkReturn("y",chart_res_hidden,"false","True")).booleanValue()){
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_hidden,"Visibility:hidden","")));
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_hidden,"Visibility:hidden","")));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_Updateble.trim(),"","disabled")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y",confidential_yn_Default)));
            _bw.write(_wl_block232Bytes, _wl_block232);
} else {
            _bw.write(_wl_block233Bytes, _wl_block233);
}
            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y",extrlReqForm_default)));
            _bw.write(_wl_block236Bytes, _wl_block236);
 
			//IN065942, starts
			if("RX".equalsIgnoreCase(order_category.trim()))
			{
		
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"prn_regd_ord",""))));
            _bw.write(_wl_block239Bytes, _wl_block239);

			}	
			//IN065942, ends
		
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_Updateble,"","disabled")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"result_auth_reqd_yn",""))));
            _bw.write(_wl_block243Bytes, _wl_block243);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",ord_cat_nature_Updateble,"","disabled")));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature",ord_cat_nature_Default),"A")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature",ord_cat_nature_Default),"P")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_result_type_updateble.trim(),"","disabled")));
            _bw.write(_wl_block249Bytes, _wl_block249);
if (auto_report_yn.equals("N"))
				 {
				 
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);

				}
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"D")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block252Bytes, _wl_block252);

				if (auto_report_yn.equals("N"))
				{
				
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"M")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"N")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

					if(!( (eCA._ca_license_rights.getKey()).equals("CABASIC")))
					{
					
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"C")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

					}
					//if( (order_category.equals("TR") || order_category.equals("PC") || order_category.equals("OT"))&&  (auto_report_yn.equals("N")) )
					if( (order_category.equals("TR")  || order_category.equals("OT"))&&  (auto_report_yn.equals("N")) )
					{
						if(!order_category.equals("PC")){
					
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"P")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

					}}
			  }
			//if (order_category.equals("RD") || order_category.equals("TR") ||order_category.equals("PC") || order_category.equals("OT")) {
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"N")));
            _bw.write(_wl_block259Bytes, _wl_block259);
//}
            _bw.write(_wl_block32Bytes, _wl_block32);
//if (order_category.equals("RD") || order_category.equals("TR") ||order_category.equals("PC") || order_category.equals("OT")) {
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"C")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
//}
            _bw.write(_wl_block32Bytes, _wl_block32);
//if (order_category.equals("RD") || order_category.equals("TR") ||order_category.equals("PC") || order_category.equals("OT")) {
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"I")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
//}--
            _bw.write(_wl_block70Bytes, _wl_block70);
/*if (order_category.equals("LB") && ((bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature",ord_cat_nature_Default)).equals("A"))) {*/
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"T")));
            _bw.write(_wl_block264Bytes, _wl_block264);
//}--
            _bw.write(_wl_block32Bytes, _wl_block32);
//if (order_category.equals("LB") && ((bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature",ord_cat_nature_Default)).equals("A")))
			 /* {
				  
			  	  chart_values = bean.getComboOptions("CHART_VALUES",bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"");

			  }*/
			 
			  
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(chartManHMTL));
            _bw.write(_wl_block266Bytes, _wl_block266);

				  if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equalsIgnoreCase("P")))
				 {
					proc_term_set_style = "display:visible";
  				 }		

			     String display_name = "";
			     if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P")))
				 {
			         display_name =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
			     }
				 else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("M")))
				 {
			         display_name =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.resultmatrix.label","or_labels");
			  	 }
				 else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("N"))) 
				 {
			         display_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.note.label","common_labels");
			     } 
				 else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("C"))&&(!((eCA._ca_license_rights.getKey()).equals("CABASIC")))) 
				 {
			         display_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Charting.label","or_labels"); 
			     } /*else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("I"))) {
			         display_name = "Intravenous";
			     }*/ 
				 else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("D"))) 
				 {
			         display_name =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasure.label","common_labels");
			     } 
				 else
				 { // if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("T")))
			         display_name =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasure.label","common_labels");
			     }
			 
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(display_name));
            _bw.write(_wl_block268Bytes, _wl_block268);

				
		  String display_text = "";
		  String onClick_text = "";

		  if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P"))) 
		  {
			String discr_msr_panel_id_param[]={bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_coding_scheme",""),bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id","")};
			//**String discr_msr_panel_id_param[]={"ICD10",bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id","")};
			HashMap discr_msr_panel_id_map=bean.getSqlResultParam("SQL_OR_ORDER_CATALOG_TERM_DESC",discr_msr_panel_id_param);
			
			String display_text_temp=discr_msr_panel_id_map.get("DESCRIPTION1")==null?"":(String)discr_msr_panel_id_map.get("DESCRIPTION1");
			//LiveIssue  - Added if condition
			if(!display_text_temp.equals(""))
			{
				display_text = display_text_temp;
			}
			else
			{
				display_text=bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id_desc",display_text_temp);
			}
			discr_msr_panel_id_param=null;
			//display_text =bean.getProc_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			onClick_text = "onClick='parent.parent.parent.show_window(proc_coding_scheme)'";
		  }
		  else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("M")))
		  {
			display_text = bean.getResultMatrix_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			onClick_text = "onClick='parent.parent.parent.show_ResultMatrix_window()'";
		  }
		  else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("N"))) 
		  {
			display_text = bean.getNotes_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			onClick_text = "onClick='parent.parent.parent.show_notes_window()'";
		  } 
		  else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("C"))) 
		  {
			 display_text = bean.getChart_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			 onClick_text = "onClick='parent.parent.parent.show_charting_window()'";
		  } /*else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("I"))) {
			   display_text = bean.getProc_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			   onClick_text = "";
		  }*/ 
		  else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("D"))) 
		  {
			  display_text = bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id_desc","");
			  onClick_text = "onClick='parent.parent.parent.showApplUserWindow()'";
		  } 
		  else 
		  { //if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("T")))				  
			  display_text = bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id_desc","");			   
			  onClick_text = "onClick='parent.parent.parent.showCultureTestWindow(discr_msr_panel_id_desc,discr_msr_panel_id)'";
		  }


              
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(proc_term_set_style));
            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block271Bytes, _wl_block271);

			TermSetID=bean.populateTermSetID();
			for(int k=0;k<TermSetID.size(); k++)
			{
				record = (String [])TermSetID.get(k);
				
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"term_set_id",""),record[0])));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block273Bytes, _wl_block273);

			}
			TermSetID=null;
			record=null;
			
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(display_text));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id","")));
            _bw.write(_wl_block276Bytes, _wl_block276);

				if (!(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("I"))) 
				{
				
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_Updateble,"","disabled")));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(onClick_text));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(chartManHMTL));
            _bw.write(_wl_block280Bytes, _wl_block280);

				}
				else 
				{
				
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(chartManHMTL));
            _bw.write(_wl_block280Bytes, _wl_block280);

				}
				
            _bw.write(_wl_block282Bytes, _wl_block282);

		String style  = "";
		if(module_id.trim().equalsIgnoreCase("OR"))
		{ //hide in case if called from OR
			style = "bottom-margin:0;display:none";
			module_id ="";
		}

		if(mode.trim().equalsIgnoreCase("2"))
		{
			style = "";
			contr_mod_id_Updateble = "N";
		}

		 module_id= bean.getdefaultArrListValue(characteristicsRecStr,0,"contr_mod_id",module_id);

		String  contr_msr_panel_desc =  "";
		contr_msr_panel_id =bean.getdefaultArrListValue(characteristicsRecStr,0,"contr_msr_panel_id","");
		contr_msr_panel_desc = 	 contr_msr_panel_id ;
	
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(style));
            _bw.write(_wl_block284Bytes, _wl_block284);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",contr_mod_id_Updateble,"",
			 "disabled")));
            _bw.write(_wl_block286Bytes, _wl_block286);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(contr_msr_panel_desc));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(contr_msr_panel_id));
            _bw.write(_wl_block289Bytes, _wl_block289);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block290Bytes, _wl_block290);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(ChartProceApplicable));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(eHISFormatter.disabled(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"P")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chart_res_Updateble.trim(),"","disabled")));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable",""),"X")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable",""),"P")));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable",""),"R")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block296Bytes, _wl_block296);

			  if (bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable","").equalsIgnoreCase("R"))
				{
					
  					proc_link_resulting_option_style = "visibility:visible";

  				}
				if ( (bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable","").equalsIgnoreCase("P") || bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable","").equalsIgnoreCase("C")) )
				{
					
  					term_set_style = "visibility:visible";

  				}		
		  
		  
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(proc_link_resulting_option_style));
            _bw.write(_wl_block298Bytes, _wl_block298);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(proc_link_resulting_option_style));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_resulting_option",""),"M")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_resulting_option",""),"O")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_resulting_option",""),"")));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(term_set_style));
            _bw.write(_wl_block304Bytes, _wl_block304);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(term_set_style));
            _bw.write(_wl_block306Bytes, _wl_block306);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block307Bytes, _wl_block307);

		
			TermSetID=bean.populateTermSetID();
			for(int k=0;k<TermSetID.size(); k++){
			record = (String [])TermSetID.get(k);

            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"term_set_id",""),record[0])));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block309Bytes, _wl_block309);

			}TermSetID=null;
			record=null;

            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(term_set_style));
            _bw.write(_wl_block298Bytes, _wl_block298);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(term_set_style));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code","")));
            _bw.write(_wl_block313Bytes, _wl_block313);
//onBlur="parent.parent.parent.before_show_term_code_window(this,term_code);" 
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block315Bytes, _wl_block315);
// onClick="parent.parent.parent.show_term_code_window(term_desc,term_code);"
            _bw.write(_wl_block316Bytes, _wl_block316);
 if(isfppapplicable)
{
	
            _bw.write(_wl_block317Bytes, _wl_block317);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block318Bytes, _wl_block318);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("N", fpp_yn)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(FppModificaion));
            _bw.write(_wl_block320Bytes, _wl_block320);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("Y", fpp_yn)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(FppModificaion));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(eHISFormatter.chkReturn("N",fpp_yn,"Visibility:hidden","")));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf((fppCategoryApplicable_style.equals(""))?"FPP Applicable Category":""));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(eHISFormatter.chkReturn("N",fpp_yn,"Visibility:hidden","")));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_category",""),"S")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_category",""),"M")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_category",""),"C")));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block327Bytes, _wl_block327);

}
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(OrRepository.getOrKeyValue("SQL_OR_CATALOG_NOTES_SELECT")));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(OrRepository.getOrKeyValue("SQL_OR_CATALOG_DISCRETE_AUTO_REPORT_YN")));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(OrRepository.getOrKeyValue("sql_or_catalog_discrete_profile")));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(OrRepository.getOrKeyValue("SQL_OR_CATALOG_CULTURE_TEST_ATOMIC")));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(OrRepository.getOrKeyValue("SQL_OR_CATALOG_RESULT_TEMPLATE_SELECT")));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(OrRepository.getOrKeyValue("SQL_OR_CATALOG_RESULT_MATRIX_SELECT")));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(OrRepository.getOrKeyValue("sql_or_catalog_discrete_atomic")));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(bill_install_Yn));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(result_applicable_yn));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(OrRepository.getOrKeyValue("SQL_OR_CATALOG_QTY_UOM_SELECT")));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CATALOG_CHARTING_LOOKUP")));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf((String)freq_chk.get("UPDATE_SOFT_STOP_YN1")));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf((String)freq_chk.get("UPDATE_CONT_ORDER_YN1")));
            _bw.write(_wl_block347Bytes, _wl_block347);
if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){

	
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(chart_res_Default));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(chart_res_Default));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(auto_report_yn));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature","ord_cat_nature_Default")));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","")));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_coding_scheme","")));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable","X")));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_resulting_option","M")));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"term_set_id","")));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code","")));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","")));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(display_name));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(display_text));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(display_name));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(display_text));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(display_name));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(display_text));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(display_name));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(display_text));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id","")));
            _bw.write(_wl_block370Bytes, _wl_block370);
}
            _bw.write(_wl_block371Bytes, _wl_block371);

	putObjectInBean(bean_id,bean,request);
}catch(Exception e){
	e.printStackTrace();

}

            _bw.write(_wl_block372Bytes, _wl_block372);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.active.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primary.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.DirectCare.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.AncillaryDept.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChangeQtydose.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Split.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Up.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.down.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Both.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SlidingScale.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FrequencyRequired.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.SoftStopforInpatients.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CreateasContinuingOrder.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FreqOrderAsIndividualOrders.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ContinousFrequencyAction.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.AllowRefills.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityApplicable.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.RoutineUrgent.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stat.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.DispenseAuthRequired.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.required.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderPriorityApplicable.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stat.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.StatusConsidered.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ActionType.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BehindAction.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minutes.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.AheadAction.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minutes.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.DuplicateReasonRequired.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConsentRequired.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ConsentFormList.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Fixed.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Variable.label", java.lang.String .class,"key"));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConsentStage.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BeforeOrderRelease.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BeforeOrderRegistration.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NumberOfConsentRequired.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.MultipleConsent.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BeforeOrderRelease.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BeforeOrderRegistration.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConsentNote.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.RefusalNoteText.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Text.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.DepartmentOnly.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CompleteonOrder.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Billable.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.single.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Multi.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BarcodeRequired.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChartApplicable.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.AutoReport.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Confidential.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ExternalRequisitionForm.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.PrintRegStatus.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChartingCharacteristics.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.AuthorizationRequired.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Nature.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Individual.label", java.lang.String .class,"key"));
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
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Panel.label", java.lang.String .class,"key"));
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
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChartResultType.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiscreteMeasure.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.resultmatrix.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Charting.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Charting.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Intravenous.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModuleId.label", java.lang.String .class,"key"));
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
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.MeasureDrugName.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ProcedureLink.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Applicable.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.AutoLink.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.manuallink.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Atresulting.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mandatory.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Optional.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSetID.label", java.lang.String .class,"key"));
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
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCode.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FPPDETAILS.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NONFPPPATIENT.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FPPPATIENT.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Simple.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Medium.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Complex.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
