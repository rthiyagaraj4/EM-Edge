package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetails3 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetails3.jsp", 1742743905380L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\n<script language=\'javascript\'>\n\nfunction showCalendar_loc(Val1, Val2)\n{\t\n\tif (Val2.disabled == true)\t\t\n\t{\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\treturn showCalendar(Val1);\n\t}\n}\n\nfunction dfltslmt()\n{\n\tvar dfltslmt = document.forms[0].dflt_slmt_type_code.value;\t\n\t\t\n\tif(document.forms[0].cash_set_type2 != null)\n\t{\n\t\tfor(i=0;i<document.forms[0].cash_set_type2.options.length;i++)\n\t\t{\t\t\t\t\t\t\t\t\t\n\t\t\tvar cashSetValue = document.forms[0].cash_set_type2.options[i].value;\t\t\t\t\t\t\t\t\t\n\t\t\tif (cashSetValue == null)\n\t\t\t{\n\t\t\t\tcontinue;\n\t\t\t}\n\n\t\t\tvar len = cashSetValue.length;\n\t\t\tvar subValue =\"\";\n\t\t\tif (len >0)\n\t\t\t{\n\t\t\t\tsubValue = cashSetValue.substring(0,len-1);\n\t\t\t}\n\n\t\t\tif (subValue == dfltslmt)\n\t\t\t{\t\t\t\t\t\t\t\t\n\t\t\t\tdocument.forms[0].cash_set_type2.value = cashSetValue;\n\t\t\t}\n\t\t}\n\t}\n}\n\nasync function noninscustlkup(clng_evnt)\n{\t\t\n\tvar target\t\t\t= document.forms[0].cust_4_desc;\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].cust_4_desc.value=\'\';\n\t\t\tdocument.forms[0].cust_4.value = \'\';\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar retVal\t\t\t= new String();\t\n\tvar dialogTop\t\t\t= \"0vh\";//40\n\tvar dialogHeight\t\t= \"60vh\" ;//10\n\tvar dialogWidth\t\t\t= \"50vw\" ;//40\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar message = \'\';\t\n\n\tvar search_by_items = document.forms[0].search_by_items.value;\n\tvar search_code = document.forms[0].search_code.value;\n\n\tvar locale = document.forms[0].locale.value;\n\tvar strModuleId = document.forms[0].calling_module_id.value;\n\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;\n\tvar non_ins_settlement_ind =document.forms[0].non_ins_settlement_ind.value;\n\tvar non_ins_adm_flag =document.forms[0].non_ins_adm_flag.value;\n\tvar strCustGroupCode = document.forms[0].non_ins_cust_group_code.value;\n\tvar blng_grp_curr_code = parent.parent.frames[0].frames[2].document.forms[0].currency_code_for_bg.value;\n\t\n\tvar cust_valid_from_date=\"\", cust_valid_to_date = \"\";\n\t\n\tvar column_sizes = escape(\"5%,25%,5%%,25%,10%,10%,10%,10%,0%,0%\");\n\n\tvar title=getLabel(\"Common.Customer.label\",\"common\"); \n\ttitle=encodeURIComponent(title);\n\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\tvar cust_group_code=getLabel(\"eBL.CUST_GROUP_CODE.label\",\"BL\");\n\tcust_group_code=encodeURIComponent(cust_group_code);\n\tvar cust_group=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\");\n\tcust_group=encodeURIComponent(cust_group);\n\tvar country = getLabel(\"Common.country.label\",\"common\");\n\tcountry = encodeURIComponent(country);\n\tvar region = getLabel(\"eMP.region.label\",\"MP\");\n\tregion = encodeURIComponent(region);\n\tvar cust_valid_frm=getLabel(\"eBL.VALID_FROM.label\",\"BL\");\n\tcust_valid_frm=encodeURIComponent(cust_valid_frm);\t\n\tvar cust_valid_to=getLabel(\"eBL.VALID_TO.label\",\"BL\");\n\tcust_valid_to=encodeURIComponent(cust_valid_to);\t\n\tvar curr_code=getLabel(\"eBL.CURR_CODE.label\",\"BL\");\n\tcurr_code=encodeURIComponent(curr_code);\n\tvar curr_desc=getLabel(\"eBL.CURR_DESC.label\",\"BL\");\n\tcurr_desc=encodeURIComponent(curr_desc);\n\n\tvar column_descriptions = code+\",\"+desc+\",\"+cust_group_code+\",\"+cust_group+\",\"+country+\",\"+region+\",\"+cust_valid_frm+\",\"+cust_valid_to+\",\"+curr_code+\",\"+curr_desc;\n\t\n\tsql = \"called_for=NONINSCUSTLKUP&locale=\"+locale+\"&module_id=\"+strModuleId+\"&search_code=\"+search_code+\"&search_by_items=\"+search_by_items+\"&cust_grp_code=\"+strCustGroupCode+\"&non_ins_slmt_ind=\"+non_ins_settlement_ind+\"&non_ins_adm_flag=\"+non_ins_adm_flag;\n/*\n\tif( non_ins_settlement_ind == \'R\')\n\t{\n\t\tsql=\"select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,\"\n\t\t+\" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC\" \n\t\t+\" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c \"\n\t\t+\" where a.language_id = b.language_id\" \n\t\t+\" and a.language_id=\'\"+locale+\"\'\" \n\t\t+\" and b.cust_group_code = c.cust_group_code\"\n\t\t+\" and a.cust_code = c.cust_code\" \n\t\t+\" and (b.cust_group_code=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null)\"\n\t\t+\" and a.patient_flag = \'Y\'\" \n\t\t+\" and a.pat_com_flag = \'Y\'\" \n\t\t+\" and nvl (insurance_yn,\'N\') = \'N\'\" \n\t\t+\" and a.status is null\" \n\t\t+\" and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(a.op_yn,\'N\') = \'Y\')\" \n\t\t+\" or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(a.ip_yn,\'N\') = \'Y\')\" \n\t\t+\" or (\'\"+strModuleId+\"\' = \'MP\' and nvl(a.ref_yn,\'N\') = \'Y\'))\" \n\t\t+\" and decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')) = nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')))\";\n\t}\n\telse if(non_ins_settlement_ind == \'X\' && non_ins_adm_flag == \'1\')\n\t{\n\t\tsql=\"select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,\"\n\t\t+\" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC\" \n\t\t+\" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c \"\n\t\t+\" where a.language_id = b.language_id\" \n\t\t+\" and a.language_id=\'\"+locale+\"\'\" \n\t\t+\" and b.cust_group_code = c.cust_group_code\"\n\t\t+\" and a.cust_code = c.cust_code\" \n\t\t+\" and (b.cust_group_code=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null)\"\n\t\t+\" and a.patient_flag = \'Y\'\" \n\t\t+\" and a.pat_com_flag = \'N\'\" \n\t\t+\" and nvl (insurance_yn,\'N\') = \'N\'\" \n\t\t+\" and a.status is null\" \n\t\t+\" and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(a.op_yn,\'N\') = \'Y\')\" \n\t\t+\" or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(a.ip_yn,\'N\') = \'Y\')\" \n\t\t+\" or (\'\"+strModuleId+\"\' = \'MP\' and nvl(a.ref_yn,\'N\') = \'Y\'))\" \n\t\t+\" and decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')) = nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')))\";\n\t}\n//\tsql = escape(sql);\t\t\t\t\t\t\t\n*/\n//\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYYYYYYNN\";;\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYYYYYYNN\";\n\n\tretVal=await top.window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\n\tvar arr=new Array();\t\t\n\n    if(retVal == null) retVal=\'\';\n\n\tif (retVal != null || retVal!=\"\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\t\t\t   \n\n\t\t\tcust_valid_from_date = arr[6].substring(0,10);\n\t\t\tcust_valid_to_date = arr[7].substring(0,10);\n\t\t\tcust_curr_code = arr[8];\n\t\t\tcust_curr_desc = arr[9];\n\n\t\t\tif(cust_valid_from_date != \"\")\n\t\t\t{\n\t\t\t\tvar cust_valid_from_date_loc = cust_valid_from_date;\n\t\t\t\tif(locale != \'en\')\n\t\t\t\t\tcust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,\'DMY\',\'en\',locale);\n\n\t\t\t\tif(!isAfter(encounter_date_aft_trunc,cust_valid_from_date_loc,\'DMY\',locale))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(cust_valid_to_date != \"\")\n\t\t\t{\n\t\t\t\tvar cust_valid_to_date_loc= cust_valid_to_date\n\t\t\t\tif(locale != \'en\')\n\t\t\t\t\tcust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,\'DMY\',\'en\',locale);\n\n\t\t\t\tif(!isBefore(encounter_date_aft_trunc,cust_valid_to_date_loc,\'DMY\',locale))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tif((blng_grp_curr_code != \"\" && cust_curr_code == \"\") || (blng_grp_curr_code == \"\" && cust_curr_code != \"\") || (blng_grp_curr_code != \"\" && cust_curr_code != \"\" && cust_curr_code != blng_grp_curr_code))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6312\",\"BL\"));\n\t\t\t\tdocument.forms[0].cust_4_desc.value=\'\';\n\t\t\t\tdocument.forms[0].cust_4.value = \'\';\n\t\t\t\tdocument.forms[0].cust_curr_code.value = \"\";\n\t\t\t\tdocument.forms[0].cust_curr_desc.value = \"\";\n\t\t\t\tdocument.getElementById(\'cust_curr_desc_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'cust_curr_desc_val\').innerText=\"\";\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].cust_curr_code.value = cust_curr_code;\n\t\t\t\tdocument.forms[0].cust_curr_desc.value = cust_curr_desc;\n\t\t\t}\n\n\n\t\t\tdocument.forms[0].cust_4_desc.value=arr[1];\n\t\t\tdocument.forms[0].cust_4.value=arr[0];\n\t\t\tdocument.forms[0].non_ins_cust_group_desc.value=arr[3];\n\t\t\tdocument.forms[0].non_ins_cust_group_code.value=arr[2];\n\t\t\tdocument.forms[0].non_ins_cust_valid_from_date.value=cust_valid_from_date;\n\t\t\tdocument.forms[0].non_ins_cust_valid_to_date.value=cust_valid_to_date;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].cust_4_desc.value=\'\';\n\t\t\tdocument.forms[0].cust_4.value = \'\';\n\t\t\ttarget.focus();\n\t\t}\n\t}\n\tcurr_desc_1();\n}\n\nasync function noninscustgrouplkup(clng_evnt)\n{\n\t\n\n\tvar target\t\t\t\t= document.forms[0].non_ins_cust_group_desc;\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].non_ins_cust_group_desc.value=\'\';\n\t\t\tdocument.forms[0].non_ins_cust_group_code.value = \'\';\n\t\t\treturn;\n\t\t}\n\t}\n\tvar msg=\"\";\n\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"0vh\";//40\n\tvar dialogHeight\t\t= \"60vh\" ;//10\n\tvar dialogWidth\t\t\t= \"50vw\" ;//40\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar message\t\t\t\t= \"\";\n\tvar column_sizes = escape(\"30%,70%\");\n\n\tvar locale = document.forms[0].locale.value;\n\t\t\n\tsql = \"\tselect cust_group_code cust_group_code, short_desc short_name from ar_cust_group_lang_vw \" + \n\t\t\t\" where  language_id=\'\"+locale+\"\' and status is null\";\t\n\n\tvar title=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\"); \n\ttitle=encodeURIComponent(title);\t\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\n\tcolumn_descriptions = code+\",\"+desc;\n\n\tsql = escape(sql);\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descri";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="ptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\n\tretVal=await top.window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"^~^\");\n\t\t\n\t\tdocument.forms[0].non_ins_cust_group_desc.value=arr[1];\n\t    document.forms[0].non_ins_cust_group_code.value=arr[0];\t\t\t\t\t\n\t}\n\telse\n\t{\t\n\t\tdocument.forms[0].non_ins_cust_group_desc.value=\'\';\n\t    document.forms[0].non_ins_cust_group_code.value=\'\';\t\t\t\t\t\t\t\t\t\t\t\t\n\t}\n}\n\nfunction srch_by_crit_for_cust()\n{\n\tvar non_ins_settlement_ind = document.forms[0].non_ins_settlement_ind.value;\n\tif(non_ins_settlement_ind != \'C\')\n\t{\n\t\tvar srch_by = document.forms[0].search_by_items.value;\n\n\t\tif(srch_by == \"CG\")\n\t\t{\n\t\t\tdocument.getElementById(\'srch_by_leg\').innerText=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\");\n\t\t}\n\t\telse if (srch_by == \"CY\")\n\t\t{\n\t\t\tdocument.getElementById(\'srch_by_leg\').innerText=getLabel(\"Common.country.label\",\"common\");\n\t\t}\n\t\telse if (srch_by == \"RN\")\n\t\t{\n\t\t\tdocument.getElementById(\'srch_by_leg\').innerText=getLabel(\"eMP.region.label\",\"MP\");\n\t\t}\n\n\t\tdocument.forms[0].srch_by_desc.value=\'\';\n\t\tdocument.forms[0].search_code.value = \'\';\n\t}\n}\n\nasync function srchbylkup(clng_evnt)\n{\t\n\t\n\n\tvar srch_by = document.forms[0].search_by_items.value;\n\tvar locale = document.forms[0].locale.value;\n\n\tvar target_code\t= document.forms[0].search_code ;\n\tvar target = document.forms[0].srch_by_desc;\n\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].srch_by_desc.value=\'\';\n\t\t\tdocument.forms[0].search_code.value = \'\';\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar message=\"\";\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"0vh\";\n\tvar dialogHeight\t\t= \"60vh\" ;\n\tvar dialogWidth\t\t\t= \"50vw\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar title\t\t\t\t= \"\";\n\tvar column_descriptions = \"\";\n\t\n\tif(srch_by == \"CG\")\n\t{\n\t\tvar title=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\"); \n\t\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\t\tsql = \"\tselect cust_group_code CUST_GRP_CODE,short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id=\'\"+locale+\"\' and status is null\";\t\n\t}\n\telse if (srch_by == \"CY\")\n\t{\n\t\tvar title=getLabel(\"Common.country.label\",\"common\"); \n\t\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\t\tsql = \"select country_code COUNTRY_CODE,short_name SHORT_NAME from mp_country_lang_vw where language_id=\'\"+locale+\"\' and eff_status = \'E\'\";\t\n\t}\n\telse if (srch_by == \"RN\")\n\t{\n\t\tvar title=getLabel(\"eMP.region.label\",\"MP\"); \n\t\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\t\tsql = \"select region_code REGION_CODE,short_desc SHORT_NAME from mp_region_lang_vw where language_id=\'\"+locale+\"\' and eff_status = \'E\'\";\t\n\t}\n\n\tvar column_sizes = escape(\"30%,70%\");\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\n\tcolumn_descriptions = code+\",\"+desc;\n\n\tsql=escape(sql);\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\n\tretVal=await top.window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"^~^\");\n\n\t\ttarget.value=arr[1];\n\t\ttarget_code.value = arr[0];\n\t}\n\telse\n\t{\t\n\t\ttarget.value=\'\';\n\t\ttarget_code.value = \'\';\n\t}\n}\n\nasync function getCustDet()\n{\n\tvar cust_4=document.forms[0].cust_4.value;\t\t\t\t\n\t\t\t\t\n\tif((cust_4!=\"\"))\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"14\" ;\n\t\tvar dialogWidth\t= \"23\" ;\n\t\tvar dialogTop = \"350\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLCustomerDet.jsp?cust_code=\"+cust_4;\n\t\tretVal = await window.showModalDialog(url,arguments,features);\n\t}\n}\n\nfunction curr_desc_1()\n{\n\tvar non_ins_settlement_ind = document.forms[0].non_ins_settlement_ind.value;\n\n\tif(non_ins_settlement_ind == \'X\' || non_ins_settlement_ind == \'R\')\n\t{\n\t\tvar cust_curr_desc = document.forms[0].cust_curr_desc.value;\n\n\t\tif(cust_curr_desc != \"\")\n\t\t{\n\t\t\tdocument.getElementById(\'cust_curr_desc_disp\').style.display=\"inline\";\n\t\t\tdocument.getElementById(\'cust_curr_desc_val\').innerText=cust_curr_desc;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\'cust_curr_desc_disp\').style.display=\"none\";\n\t\t\tdocument.getElementById(\'cust_curr_desc_val\').innerText=\"\";\n\t\t}\n\t}\n}\n\nfunction enablectrlbut()\n{\n\tparent.parent.parent.frames[0].document.getElementById(\'modify_button\').disabled = false;\n\tparent.parent.parent.frames[0].document.getElementById(\'close_button\').disabled = false;\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n</head>\n";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n<body onLoad=\'disableAllElements();curr_desc_1(); disable();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t\t<body onLoad=\'curr_desc_1(); disable();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body onLoad=\'dfltslmt();curr_desc_1(); disable();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\'PatFinCase4Form\' id=\'PatFinCase4Form\' method=\'post\' action=\'\'  scrolling=no >\n<table border=\'0\' cellpadding=\'1\' cellspacing=\'0\' width=\'100%\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n<td align=\'left\' class=\'COLUMNHEADER\' colspan=\'6\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<tr>\t\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div></td>\n\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\n\t\t\t\t<select name=\'search_by_items\' id=\'search_by_items\' onChange=\'srch_by_crit_for_cust();\'>\n<!--\n\t\t\t\t\t<option value=\'CG\' SELECTED>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n-->\n\t\t\t\t\t<option value=\'CY\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t\t\t<option value=\'RN\' SELECTED>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t</select>\n\t\t</td>\n\n\t\t<td width=\"25%\" class=\"label\"><b id=\'srch_by_leg\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\"srch_by_desc\" id=\"srch_by_desc\" maxlength=\'30\' size=\'30\'  tabindex=\'0\' value=\"\" onBlur=\"return srchbylkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"srchbybut\" id=\"srchbybut\" value=\'?\' onClick=\"return srchbylkup(\'C\')\" tabindex=\'0\'><input type= \'hidden\' name=\"search_code\" id=\"search_code\"  value=\"\"></td>\t\t\t\n\t</tr>\n\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div></td>\n\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\"non_ins_cust_group_desc\" id=\"non_ins_cust_group_desc\" maxlength=\'15\' size=\'30\'  tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onBlur=\"return noninscustgrouplkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"cust1but\" id=\"cust1but\" value=\'?\' onClick=\"return noninscustgrouplkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'><input type= \'hidden\' name=\"non_ins_cust_group_code\" id=\"non_ins_cust_group_code\"  value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></td>\n\t\t<td width=\"25%\">&nbsp;</td>\n\t\t<td width=\"25%\">&nbsp;</td>\n\t</tr>\n\n\t<tr> \n\t\t<td width=\"25%\" class=\"label\"><a href=\"javascript:getCustDet();\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a>&nbsp;&nbsp;<div id=\"cust_curr_desc_disp\" style=\"display:none\"><Font color=\'red\'><b id=\"cust_curr_desc_val\"></b></font></div>\t\n\t\t<input type=\'hidden\' name=\'Case_1\' id=\'Case_1\' value=\'1\'></td>\n\t\t<td width=\"25%\" class=\'fields\' nowrap><input type=\'text\' name=\"cust_4_desc\" id=\"cust_4_desc\" maxlength=\'40\' size=\'30\'  tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onBlur=\"return noninscustlkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"cust1but\" id=\"cust1but\" value=\'?\' onClick=\"return noninscustlkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\t\t<input type= \'hidden\' name=\"cust_4\" id=\"cust_4\"  value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\'hidden\' name=\'cust_curr_code\' id=\'cust_curr_code\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type= \"hidden\" name=\"cust_curr_desc\" id=\"cust_curr_desc\"  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type= \'hidden\' name=\"non_ins_cust_valid_from_date\" id=\"non_ins_cust_valid_from_date\"  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type= \'hidden\' name=\"non_ins_cust_valid_to_date\" id=\"non_ins_cust_valid_to_date\"  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n<!--\n\t      <td width=\"25%\" class=\'fields\'><input type=\'text\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t      <td width=\"25%\" class=\'fields\'><input type=\'text\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onKeyPress=\'return CheckForSpecCharsAllNotAlwSpc_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t</tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n<!--\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' size=\'30\' maxlength=\'30\' onKeyPress=\'return CheckForSpecChars_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\' ></td>\n-->\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' size=\'30\' maxlength=\'30\' onKeyPress=\'return CheckForSpecCharsAllNotAlwSpc_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\' ></td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</tr>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t<td colspan=\'15\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<input type=\'hidden\' name=\'Case_1\' id=\'Case_1\' value=\'2\'></td>\n\t\t<td width=\"25%\" class=\'fields\' ><select name=\'cash_set_type2\' id=\'cash_set_type2\' ><option value=\'\'>---";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="---</option>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="      \n\t</select><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n<!--\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' size=\'15\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' size=\'15\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onKeyPress=\'return CheckForSpecCharsAllNotAlwSpc_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n<!--\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' size=\'15\' maxlength=\'30\' onKeyPress=\'return CheckForSpecChars_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' size=\'15\' maxlength=\'30\' onKeyPress=\'return CheckForSpecCharsAllNotAlwSpc_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t</tr>    \n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t   <td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_st_date3\' id=\'credit_doc_st_date3\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'\' onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_st_date3,document.forms[0].encounter_date_aft_trunc);\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\"return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_st_date3,document.forms[0].encounter_date_aft_trunc);\" onClick=\"return showCalendar_loc(\'credit_doc_st_date3\',document.forms[0].credit_doc_st_date3);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_st_date3\' id=\'credit_doc_st_date3\' size=\'10\' maxlength=\'10\' onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_st_date3,document.forms[0].encounter_date_aft_trunc);\'><img  name=\'stdate3but\'  src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\"return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_st_date3,document.forms[0].encounter_date_aft_trunc);\" onClick=\"return showCalendar_loc(\'credit_doc_st_date3\',document.forms[0].credit_doc_st_date3);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\n\t\t<td width=\"25%\"  class=\"label\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_date3\' id=\'credit_doc_date3\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date3,document.forms[0].encounter_date_aft_trunc);\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date3,document.forms[0].encounter_date_aft_trunc);\'  onClick=\"return showCalendar_loc(\'credit_doc_date3\',document.forms[0].credit_doc_date3);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<td width=\"25%\" class=\'fields\'><input type=\'text\' name=\'credit_doc_date3\' id=\'credit_doc_date3\' size=\'10\' maxlength=\'10\' onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date3,document.forms[0].encounter_date_aft_trunc);\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date3,document.forms[0].encounter_date_aft_trunc);\'   onClick=\"return showCalendar_loc(\'credit_doc_date3\',document.forms[0].credit_doc_date3);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t</tr>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\t\t<td width=\"\" class=\"label\"></td>\n\t\t<td width=\"\"  colspan=\"5\" class=\"label\"></td>\t\n    \n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t</tr>\n\n\t<tr>\n\t\t<td colspan=\"15\"></td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=\"15\"></td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=\"15\"></td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=\"15\"></td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=\"15\"></td>\n\t</tr>\n\n<input type=\'hidden\' name=\'credit_doc_reqd_yn2\' id=\'credit_doc_reqd_yn2\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\t\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\t\t\n<input type=\'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n<input type=hidden name=\'operation\' id=\'operation\'\tvalue=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n<input type=hidden name=\'billing_mode\' id=\'billing_mode\' \tvalue=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n<input type=\'hidden\' name=\"dflt_slmt_type_code\" id=\"dflt_slmt_type_code\"  value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n<input type=\'hidden\' name=\"non_ins_settlement_ind\" id=\"non_ins_settlement_ind\"  value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n<input type=\'hidden\' name=\"non_ins_adm_flag\" id=\"non_ins_adm_flag\"  value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<input type=\'hidden\' name=\'encounter_date_aft_trunc\' id=\'encounter_date_aft_trunc\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<input type=\'hidden\' name=\'calling_module_id\' id=\'calling_module_id\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n<input type=\'hidden\' name=\"function_id\" id=\"function_id\" value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\t\n<input type=\'hidden\' name=\'sel_frm_prev_enc\' id=\'sel_frm_prev_enc\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\n<input type=\'hidden\' name=\'fin_class_flag_YN\' id=\'fin_class_flag_YN\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n<input type=\'hidden\' name=\'autoFinChk\' id=\'autoFinChk\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" \n</table>\n</form>\n</body>\n</html>\n\t\n\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);


	Connection con = null;
	PreparedStatement pstmt	= null;
	PreparedStatement pstmt1 =	null;
	Statement stmt	= null;
	ResultSet rs	= null;
	ResultSet rs2	= null;
	Statement stmtDate1 = null;
	String locale			= (String)session.getAttribute("LOCALE");

	try
  	{	
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);
		String sys_date = "",sys_date_wht_sec="";
		String non_ins_settlement_ind ="",non_ins_adm_flag="",query_cust="";
//		String ar_install_yn="";
		String slmt_type_code="",dflt_slmt_type_code="", cash_slmt_flag="";
		String mcust_4="",mcust_group_4="",mcredit_doc_ref3="",mcredit_doc_date3="",mcash_set_type2="";
		String non_ins_cust_code="", non_ins_short_name="";
		String str_cust_curr_code="", str_cust_curr_desc="";
		String non_ins_cust_group_code="", non_ins_cust_group_desc="";
		String cust_valid_from_date = "", cust_valid_to_date = "";
		String mcredit_doc_st_date3="";
		String non_insur_blng_grp="";
		String billing_group="";
		String rtn_blng_grp="";
		String rtn_non_ins_blng_grp ="";
		String rtn_non_ins_credit_doc_reqd_yn="";
		String rtn_non_ins_slmt_type_code="";
		String rtn_non_ins_inst_ref ="";
		String rtn_non_ins_inst_date="";
		String rtn_non_ins_inst_remarks ="";
		String rtn_non_ins_cust_code="";
		String rtn_non_ins_cust_group_code = "";
		String rtn_non_ins_credit_doc_ref="";
		String rtn_non_ins_credit_doc_start_date="";
		String rtn_non_ins_credit_doc_end_date  ="";	
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";
		
		String payerGrpBySetup=request.getParameter("payerGrpBySetup");

		String encounter_date_time = "", encounter_date_aft_trunc="";

		String fin_class_flag_YN="N",autoFinChk="N";

		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(bl_data!=null)
			{
				rtn_blng_grp=((String)bl_data.get("blng_grp")).trim();
				rtn_non_ins_blng_grp =((String)bl_data.get("non_ins_blng_grp")).trim();
				rtn_non_ins_credit_doc_reqd_yn=((String)bl_data.get("non_ins_credit_doc_reqd_yn")).trim();
				rtn_non_ins_slmt_type_code=((String)bl_data.get("non_ins_slmt_type_code")).trim();
				rtn_non_ins_inst_ref =((String)bl_data.get("non_ins_inst_ref")).trim();
				rtn_non_ins_inst_date=((String)bl_data.get("non_ins_inst_date")).trim();
				rtn_non_ins_inst_remarks  =((String)bl_data.get("non_ins_inst_remarks")).trim();
				rtn_non_ins_cust_code=((String)bl_data.get("non_ins_cust_code")).trim();
				rtn_non_ins_cust_group_code=((String)bl_data.get("non_ins_cust_group_code")).trim();
				rtn_non_ins_credit_doc_ref=((String)bl_data.get("non_ins_credit_doc_ref")).trim();
				rtn_non_ins_credit_doc_start_date=((String)bl_data.get("non_ins_credit_doc_start_date")).trim();
				rtn_non_ins_credit_doc_end_date  =((String)bl_data.get("non_ins_credit_doc_end_date")).trim(); 
			}
		}
		else
		{
			billing_group=request.getParameter("billing_group");
		}

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
//			String non_insur_blng_grp= request.getParameter("non_insur_blng_grp");
			non_insur_blng_grp= rtn_non_ins_blng_grp;
			if( non_insur_blng_grp == null) non_insur_blng_grp="";
		}
		else
		{
			non_insur_blng_grp= request.getParameter("non_insur_blng_grp");
			if( non_insur_blng_grp == null) non_insur_blng_grp="";
		}

/*		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";
*/		
		String strCreditDoc_YN = "N";
		
		String strModuleId = request.getParameter("calling_module_id");
		if (strModuleId==null) strModuleId="";    

		String str_function_id = request.getParameter("calling_function_id");
		if(str_function_id == null) str_function_id="";

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
//			mcust_4 = request.getParameter("cust_4");
			mcust_4 = rtn_non_ins_cust_code;
			mcust_group_4 = rtn_non_ins_cust_group_code;
//			mcredit_doc_ref3 = request.getParameter("credit_doc_ref3");
			mcredit_doc_ref3 =rtn_non_ins_credit_doc_ref;
//			mcredit_doc_date3 = request.getParameter("credit_doc_date3");
			mcredit_doc_date3 =	rtn_non_ins_credit_doc_end_date;
//			mcredit_doc_st_date3 = request.getParameter("credit_doc_start_date3");
			mcredit_doc_st_date3 =rtn_non_ins_credit_doc_start_date;
			if (mcredit_doc_st_date3==null) mcredit_doc_st_date3 = "";

//			mcash_set_type2 = request.getParameter("cash_set_type2");
			mcash_set_type2 = rtn_non_ins_slmt_type_code;

		}
		/** 
			The file modification is done by
			Murugavel on 11/08/2002
			for the Cash Patient., if the Credit doc. is required then
			the Credit doc reference and the
			Credit doc date are Mandatory	

			Credit Doc Date should accept only the future date and the
			
		
		**/	
		
		String sql="select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N'),to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from bl_blng_grp where blng_grp_id = ? ";
		//out.println("sql :"+sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, non_insur_blng_grp);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				non_ins_settlement_ind = rs.getString("settlement_ind");
				non_ins_adm_flag = rs.getString("adm_rec_flag");
				strCreditDoc_YN = rs.getString(3);
				sys_date = rs.getString(4);
				sys_date_wht_sec = rs.getString(5);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
/*
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmtDate1 = con.createStatement();
			ResultSet rsDate = stmtDate1.executeQuery(query_date) ;
			if( rsDate != null ) 
			{
				while( rsDate.next() )
				{  
					sys_date = rsDate.getString(1);
					sys_date_wht_sec = rsDate.getString(2);
				}
			}
			if(rsDate != null) rsDate.close();
			stmtDate1.close();

			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmtDate1 = con.createStatement();
			rsDate = stmtDate1.executeQuery(query_date) ;
			if( rsDate != null ) 
			{
				while( rsDate.next() )
				{  
					sys_date_wht_sec = rsDate.getString(1);
				}
			}
			if(rsDate !=null) rsDate.close();
			stmtDate1.close();
		}
		catch(Exception e)
		{
			out.println("Exception @ sysdate"+e);
		}
*/
		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
//		System.out.println("encounter_date_time from Interface Module in 3.jsp:"+encounter_date_time);		
		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

//		System.out.println("encounter_date_time in 3.jsp page:"+encounter_date_time);
		
		try
		{
			String sql_trunc_time="select to_char( (to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

			/* stmtDate1 = con.createStatement();
			rs = stmtDate1.executeQuery(sql_trunc_time) ; */

			pstmt = con.prepareStatement(sql_trunc_time);
			pstmt.setString(1, encounter_date_time);
			rs = pstmt.executeQuery();
			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			stmtDate1.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}

		if(!("").equals(encounter_date_aft_trunc))
		{
			encounter_date_aft_trunc = com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale) ;
		}
	
		/*

		try
		{
		String query_ar="select install_yn from sm_module where module_id='AR'";

		pstmt1 = con.prepareStatement(query_ar);
		rs3 = pstmt1.executeQuery() ;
		if( rs3 != null ) 
		{
			while( rs3.next() )
			{  
				ar_install_yn = rs3.getString("install_yn");
				
			}
		}
		pstmt1.close();

		}
		catch(Exception e)
		{
			out.println("Exception @ install"+e);
		}
		*/


            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);


		if(operation.equals("Update"))
		{if(!("Y").equalsIgnoreCase(payerGrpBySetup))
		{
			
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
			else{
				
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
		}
		else
		{

            _bw.write(_wl_block10Bytes, _wl_block10);

		}

            _bw.write(_wl_block11Bytes, _wl_block11);

	if(!(non_ins_settlement_ind.equals("C")))
	{
		if ( non_ins_settlement_ind.equals("R") ) 
		{
//			System.out.println("Inside R");

			if ( mcust_4 != null )
			{		
//6/10/2008		query_cust="select a.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b where a.language_id = b.language_id and a.language_id='"+locale+"' and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = '"+mcust_4+"' and (b.cust_group_code='"+mcust_group_4+"' or '"+mcust_group_4+"' is null)";	

				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = ? and (b.cust_group_code=? or ? is null)";	
		
				pstmt = con.prepareStatement(query_cust) ;
				pstmt.setString(1, locale);
				pstmt.setString(2, strModuleId);
				pstmt.setString(3, strModuleId);
				pstmt.setString(4, strModuleId);
				pstmt.setString(5, mcust_4);
				pstmt.setString(6, mcust_group_4);
				pstmt.setString(7, mcust_group_4);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() ) 
					{
						non_ins_cust_code = rs.getString( "cust_code" ) ;
						non_ins_short_name = rs.getString( "short_name" ) ;
						non_ins_cust_group_code = rs.getString( "CUST_GROUP_CODE" ) ;
						non_ins_cust_group_desc = rs.getString( "CUST_GROUP_DESC" ) ;
						cust_valid_from_date = rs.getString( "VALID_FROM" ) ;	
						cust_valid_to_date = rs.getString( "VALID_TO" ) ;	
					}
				}
				if(rs !=null) rs.close();
				pstmt.close() ;

				if (non_ins_cust_code == null ) non_ins_cust_code = "";
				if (non_ins_short_name == null ) non_ins_short_name = "";		
				if (non_ins_cust_group_code == null ) non_ins_cust_group_code = "";	
				if (non_ins_cust_group_desc == null ) non_ins_cust_group_desc = "";	
				if(cust_valid_from_date == null) cust_valid_from_date = "";
				if(cust_valid_to_date == null) cust_valid_to_date = "";
			}
		}
		else if (non_ins_settlement_ind.equals("X") && non_ins_adm_flag.equals("1"))
		{
//			System.out.println("Inside X 1");

			if ( mcust_4 != null )
			{		
//6/10/2008		query_cust="select a.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b where a.language_id = b.language_id and a.language_id='"+locale+"' and a.patient_flag = 'Y' and a.pat_com_flag = 'N' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = '"+mcust_4+"' and (b.cust_group_code='"+mcust_group_4+"' or '"+mcust_group_4+"' is null)";

				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'N' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = ? and (b.cust_group_code=? or ? is null)";
		
				pstmt = con.prepareStatement(query_cust) ;
				pstmt.setString(1, locale);
				pstmt.setString(2, strModuleId);
				pstmt.setString(3, strModuleId);
				pstmt.setString(4, strModuleId);
				pstmt.setString(5, mcust_4);
				pstmt.setString(6, mcust_group_4);
				pstmt.setString(7, mcust_group_4);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() ) 
					{
						non_ins_cust_code = rs.getString( "cust_code" ) ;
						non_ins_short_name = rs.getString( "short_name" ) ;
						non_ins_cust_group_code = rs.getString( "CUST_GROUP_CODE" ) ;
						non_ins_cust_group_desc = rs.getString( "CUST_GROUP_DESC" ) ;
						cust_valid_from_date = rs.getString( "VALID_FROM" ) ;	
						cust_valid_to_date = rs.getString( "VALID_TO" ) ;		
					}
				}
				if(rs !=null) rs.close();
				pstmt.close() ;

				if (non_ins_cust_code == null ) non_ins_cust_code = "";
				if (non_ins_short_name == null ) non_ins_short_name = "";		
				if (non_ins_cust_group_code == null ) non_ins_cust_group_code = "";	
				if (non_ins_cust_group_desc == null ) non_ins_cust_group_desc = "";	
				if(cust_valid_from_date == null) cust_valid_from_date = "";
				if(cust_valid_to_date == null) cust_valid_to_date = "";
			}
		}

		if(!mcust_4.equals(""))
		{
			String cust_curr_desc_qry="Select CURRENCY_CODE,CURRENCY_DESC from ar_customer_lang_vw where cust_code=? and language_id=? ";
//			System.out.println("cust_curr_desc_qry:"+cust_curr_desc_qry);
			pstmt = con.prepareStatement( cust_curr_desc_qry ) ;
			pstmt.setString(1, mcust_4);
			pstmt.setString(2, locale);
			rs = pstmt.executeQuery();

			if( rs != null )
			{
				while( rs.next() ) 
				{
					str_cust_curr_code = rs.getString(1);
					str_cust_curr_desc = rs.getString(2);
				}
				if(str_cust_curr_code == null) str_cust_curr_code="";
				if(str_cust_curr_desc == null) str_cust_curr_desc="";

				if (rs != null) rs.close();
					pstmt.close();	
			}	
		}
//		System.out.println("str_cust_curr_code:"+str_cust_curr_code);
//		System.out.println("str_cust_curr_desc:"+str_cust_curr_desc);

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(non_ins_cust_group_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(non_ins_cust_group_code));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(non_ins_short_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(non_ins_cust_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(str_cust_curr_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(str_cust_curr_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mcredit_doc_ref3));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(mcredit_doc_ref3));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
			else
			{

            _bw.write(_wl_block33Bytes, _wl_block33);

			}

            _bw.write(_wl_block34Bytes, _wl_block34);

		}
		else if(non_ins_settlement_ind.equals("C"))
		{

            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

			
			pstmt = con.prepareStatement( "Select dflt_slmt_type_code from bl_blng_grp where BLNG_GRP_ID=? "); 
			pstmt.setString(1, non_insur_blng_grp);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					dflt_slmt_type_code=rs2.getString(1) ;
//					System.out.println("dflt_slmt_type_code:"+dflt_slmt_type_code);
					if(dflt_slmt_type_code==null) dflt_slmt_type_code="";
				}
			}
			
			if(rs2 !=null) rs2.close();
			pstmt.close() ;

			pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where language_id=? and status is null order by short_desc " ) ;
			pstmt.setString(1, locale);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					slmt_type_code = rs2.getString( "slmt_type_code" ) ;
					String short_desc = rs2.getString( "short_desc" ) ;
					cash_slmt_flag=rs2.getString("cash_slmt_flag") ;
					//if(billing_mode.equals("Modify"))
					//{
						if(mcash_set_type2.equals(slmt_type_code))
						{
							out.println("<option selected value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
						}
						else
						{
							out.println( "<option value='"+slmt_type_code+""+cash_slmt_flag+"' >" + short_desc ) ;
						}
				}
			}
			if(rs2 != null) rs2.close();
			pstmt.close() ;

            _bw.write(_wl_block39Bytes, _wl_block39);
 
		/***
			The Following code is added by Murugavel on
			11 Aug 2002	for the above requirements
			Purpose : If the Customer has the Credit Doc Required flag
						Yes., then it is mandatory for him to 
						provide the cred doc date and the 
						reference
			New Variables: strCreditDoc_YN.
			New Hidden Form field: credit_doc_yn

		***/
			
			if (strCreditDoc_YN.equals("Y"))		
			{

            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mcredit_doc_ref3));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mcredit_doc_ref3));
            _bw.write(_wl_block43Bytes, _wl_block43);

				}
				else
				{

            _bw.write(_wl_block44Bytes, _wl_block44);

				}	// Modify operation end if;
			}	// Credit Doc_YN end if;
		}	// Settlement Ind. end if

		if (strCreditDoc_YN.equals("Y") || (!(non_ins_settlement_ind.equals("C"))))		
		{

            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(mcredit_doc_st_date3,"DMY","en",locale)));
            _bw.write(_wl_block47Bytes, _wl_block47);

			}
			else
			{

            _bw.write(_wl_block48Bytes, _wl_block48);

			}

            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
	
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(mcredit_doc_date3,"DMY","en",locale)));
            _bw.write(_wl_block51Bytes, _wl_block51);

			}
			else
			{

            _bw.write(_wl_block52Bytes, _wl_block52);

			}
		}
		else
		{

            _bw.write(_wl_block53Bytes, _wl_block53);

		}

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strCreditDoc_YN));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(billing_mode));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(dflt_slmt_type_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(non_ins_settlement_ind));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(non_ins_adm_flag));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(encounter_date_aft_trunc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(str_function_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(sel_frm_prev_enc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(fin_class_flag_YN));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(autoFinChk));
            _bw.write(_wl_block68Bytes, _wl_block68);

	/*	String query_cash_slmt_type="Select cash_slmt_flag from bl_slmt_type where 				slmt_type_code='"+slmt_type_code+"'";
		stmt=con.createStatement();
		rs21=stmt.executeQuery(query_cash_slmt_type);
		if(rs21 != null)
		{
			while(rs21.next())
			{
				cash_slmt_flag=rs21.getString("cash_slmt_flag");
			}
		}
		if(!(cash_slmt_flag.equals("CASH")))
		{
		%->
		<tr>
			<td width="50%" align="right" class="label">Cash Instrument Ref</td>
			<td width="50%" align="left" >&nbsp;<input type='text' name='cash_insmt_ref' id='cash_insmt_ref' size='15' maxlength='15'></td>
			</tr>
		<tr>
			<td width="50%" align="right" class="label">Cash Instrument Date</td>
			<td width="50%" align="left" >&nbsp;<input type='text' name='cash_insmt_date' id='cash_insmt_date' size='15' maxlength='15'></td>
		</tr>
		<tr>
			<td width="50%" align="right" class="label">Cash Instrument Remarks</td>
			<td width="50%" align="left" >&nbsp;<input type='text' name='cash_insmt_rmks' id='cash_insmt_rmks' size='15' maxlength='15'>
			</td>
		</tr>
		<%
		}
		*/
		
            _bw.write(_wl_block69Bytes, _wl_block69);
 
	} 
	catch(Exception e )
	{ 
	e.printStackTrace();
		out.println(e);
	}
	finally
	{
		if(stmt   != null)stmt.close();
		if(pstmt  != null)pstmt.close();
		if(pstmt1 != null)pstmt1.close();	
		ConnectionManager.returnConnection(con, request);
	}
	
            _bw.write(_wl_block70Bytes, _wl_block70);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NON_INS_FRAME_TITLE.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchby.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.region.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.region.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_DOC_REF.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NON_INS_FRAME_TITLE.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SettlementType.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_REF.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_START_DATE.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_END_DATE.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
