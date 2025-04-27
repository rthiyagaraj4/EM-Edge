package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;

public final class __rep2monthlyipsummarynursingunit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/Rep2MonthlyIPSummaryNursingUnit.jsp", 1720629120766L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<HEAD>\n<TITLE></TITLE>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\'JavaScript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\'JavaScript\'></script>\n\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\'JavaScript\'></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'JavaScript\'></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\" language=\'JavaScript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tasync function searchCode(obj,target)\n\t\t{\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= \"400px\" ;\n\t\t\t\tvar dialogWidth=\"900px\";\n\t\t\t\t/* var dialogHeight= \"28\" ;\n\t\t\t\tvar dialogWidth\t= \"43\" ; */\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tvar sql=\"\";\n\t\t\t\tvar search_code=\"\";\n\t\t\t\tvar search_desc=\"\";\n\t\t\t\tvar tit=\"\";\n\t\t\t\tvar locale= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tvar facilityid = document.forms[0].p_facility_id.value;\n\t\t\t\tvar argumentArray  = new Array();\n\t\t\t\tvar dataNameArray  = new Array();\n\t\t\t\tvar dataValueArray = new Array();\n\t\t\t\tvar dataTypeArray  = new Array();\n\t\n\t\t\t\tif(obj.name==\"nursing_unit\") \n\t\t\t\t{\n\t\t\t\t\ttit=getLabel(\'Common.nursingUnit.label\',\'common\');\n\t\t\t\t\targumentArray[0]=\"select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT_LANG_VW where language_id = \'\"+locale+\"\' and facility_id like ? and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) \";\n\t\t\t\t\targumentArray[1]=new Array(\"facility_id\");\n\t\t\t\t\targumentArray[2]=new Array(facilityid);\n\t\t\t\t\targumentArray[3]=new Array(STRING);\n\t\t\t\t\targumentArray[4]=\"2,3\";\n\t\t\t\t\targumentArray[5]=target.value;\n\t\t\t\t\targumentArray[6]=CODE_LINK;\n\t\t\t\t\targumentArray[7]=CODE_DESC;\n\n\t\t\t\t}else if(obj.name==\"billing_group\"){\n\t\t\t\t\ttit=getLabel(\'Common.BillingGroup.label\',\'common\');\n\t\t\t\t\targumentArray[0]=\"select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where  language_id=\'\"+locale+\"\' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?)\";\n\t\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\t\targumentArray[5] = target.value;\n\t\t\t\t\targumentArray[6] = CODE_LINK;\n\t\t\t\t\targumentArray[7] = CODE_DESC;\n\t\t\t\t}else if(obj.name==\"cust_grp_code\"){\n\t\t\t\t\ttit=getLabel(\'Common.Customer.label\',\'common\'+\'\'+\'Common.GroupCode.label\',\'common\');\n\t\t\t\t\targumentArray[0]=\"select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id=\'\"+locale+\"\' and (cust_group_code) like upper(nvl(?,cust_group_code)) and upper(short_desc) like upper(nvl(?,short_desc)) \";\n\t\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\t\targumentArray[5] = target.value;\n\t\t\t\t\targumentArray[6] = CODE_LINK;\n\t\t\t\t\targumentArray[7] = CODE_DESC;\n\n\t\t\t\t}else if(obj.name==\"cust_code\"){\n\t\t\t\t\ttit=getLabel(\'Common.CustomerCode.label\',\'common\');\n\t\t\t\t\tvar group_id\t= \"\";\n\t\t\t\t\tif(target.name==\"P_FRM_CUST_CODE\"){\n\t\t\t\t\t\tgroup_id\t= document.forms[0].P_FRM_CUST_GROUP_CODE.value;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tgroup_id\t= document.forms[0].P_TO_CUST_GROUP_CODE.value;\n\t\t\t\t\t}\n\t\t\t\t\tif(group_id==\"\"){\n\t\t\t\t\t\targumentArray[0]=\"select cust_code code, long_name description from ar_customer_lang_vw where \'1\' like ? and language_id=\'\"+locale+\"\' and upper(cust_code) like upper(nvl(?,cust_code)) and upper(long_name) like upper(nvl(?,long_name)) order by 2 \";\n\t\t\t\t\t}else{\n\t\t\t\t\t\targumentArray[0]=\"select code,description from (SELECT a.cust_code code, a.long_name description FROM ar_customer_lang_vw a,ar_cust_group_lang_vw b, bl_cust_by_cust_group d  WHERE a.acc_entity_code =  b.acc_entity_code AND b.acc_entity_code =d.acc_entity_code AND a.language_id = b.language_id AND b.cust_group_code = d.cust_group_code AND a.cust_group_code = b.cust_group_code AND a.cust_code = d.cust_code AND b.cust_group_code = \'\"+group_id+\"\' AND a.language_id = \'\"+locale+\"\' AND a.acc_entity_code IN (SELECT d.acc_entity_code FROM sy_acc_entity d  WHERE acc_entity_id = d.acc_entity_id) ) where 1 like ? and UPPER (code) LIKE UPPER (NVL (?, code)) AND UPPER (description) LIKE UPPER (NVL (?, description)) ORDER BY 2\"; \n\t\t\t\t\t}\t\n\t\t\t\t\targumentArray[1]=new Array(\"1\");\n\t\t\t\t\targumentArray[2]=new Array(\"1\");\n\t\t\t\t\targumentArray[3]=new Array(STRING);\n\t\t\t\t\targumentArray[4]=\"2,3\";\n\t\t\t\t\targumentArray[5]=target.value;\n\t\t\t\t\targumentArray[6]=CODE_DESC_LINK;\n\t\t\t\t\targumentArray[7]=CODE_DESC; \n\t\t\t\t}\n\n\t\t\t\tretVal = await CommonLookup( tit, argumentArray ) ;\n\n\t\t\t\tif(retVal != null && retVal != \"\" )\n\t\t\t\t{\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\ttarget.value=arr[0];\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\ttarget.value=\'\';\n\t\t\t\t}\n\t\t}\n\t</script>\n</HEAD>\n\n<BODY onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<br>\n<br>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<form name=\"Rep2MonthlyIPSummaryNursingUnitForm\" id=\"Rep2MonthlyIPSummaryNursingUnitForm\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n\t\t<table width=\'80%\' align=\'center\' valign=\'top\'>\n\n\t\t<th align=\'left\'> ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</th>\n\n\t<tr>\n\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\n\t\t\t<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\' >\n\n\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'  >\n\t\t\t\t\t\t\t\t<input type=text id=\"census_date\"  name=\'p_trn_date\' id=\'p_trn_date\' size=\"7\" maxlength=\"7\" align=\"center\" onblur=\'validDateObj(this,\"MY\",localeName);\'><input type=\"image\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'census_date\',\'mm/y\',null);\">\n\t\t\t\t\t\t\t\t<img align=\'center\' src=\'../../eMP/images/mandatory.gif\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td colspan =\'2\'>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t\t<Td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td align=\"center\" width=\"35%\">&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"querydata\" width=\"20%\" style=\"font-weight: bold;\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t<td class=\"querydata\" width=\"40%\" style=\"font-weight: bold;\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t</tr>\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'20%\'  >\n\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_fr_nursing_unit\' id=\'p_fr_nursing_unit\' size=\"4\" maxlength=\"4\" align=\"center\"/><input type=\'button\' name=\'nursing_unit\' id=\'nursing_unit\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_fr_nursing_unit)\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'40%\'>\n\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_to_nursing_unit\' id=\'p_to_nursing_unit\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'nursing_unit\' id=\'nursing_unit\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_to_nursing_unit)\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t\t<Td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'20%\'  >\n\t\t\t\t\t\t\t\t\t<input type=text  name=\'P_FRM_BLNG_GRP_ID\' id=\'P_FRM_BLNG_GRP_ID\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'billing_group\' id=\'billing_group\' value=\'?\' class=\'button\' onclick=\'searchCode(this, P_FRM_BLNG_GRP_ID)\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'40%\'>\n\t\t\t\t\t\t\t\t\t<input type=text  name=\'P_TO_BLNG_GRP_ID\' id=\'P_TO_BLNG_GRP_ID\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'billing_group\' id=\'billing_group\' value=\'?\' class=\'button\' onclick=\'searchCode(this,  P_TO_BLNG_GRP_ID)\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t\t<Td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'20%\'  >\n\t\t\t\t\t\t\t\t\t<input type=text  name=\'P_FRM_CUST_GROUP_CODE\' id=\'P_FRM_CUST_GROUP_CODE\' size=\"2\" maxlength=\"2\" align=\"center\"><input type=\'button\' name=\'cust_grp_code\' id=\'cust_grp_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this, P_FRM_CUST_GROUP_CODE)\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'40%\'>\n\t\t\t\t\t\t\t\t\t<input type=text  name=\'P_TO_CUST_GROUP_CODE\' id=\'P_TO_CUST_GROUP_CODE\' size=\"2\" maxlength=\"2\" align=\"center\"><input type=\'button\' name=\'cust_grp_code\' id=\'cust_grp_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this, P_TO_CUST_GROUP_CODE)\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t\t<Td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'20%\'  >\n\t\t\t\t\t\t\t\t\t<input type=text  name=\'P_FRM_CUST_CODE\' id=\'P_FRM_CUST_CODE\' size=\"8\" maxlength=\"8\" align=\"center\"><input type=\'button\' name=\'cust_code\' id=\'cust_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this, P_FRM_CUST_CODE)\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'40%\'>\n\t\t\t\t\t\t\t\t\t<input type=text  name=\'P_TO_CUST_CODE\' id=\'P_TO_CUST_CODE\' size=\"8\" maxlength=\"8\" align=\"center\"><input type=\'button\' name=\'cust_code\' id=\'cust_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this, P_TO_CUST_CODE)\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t\t<Td class=\"label\">&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"P_FRM_BLNG_GRP_ID\" id=\"P_FRM_BLNG_GRP_ID\" value=\"\" />\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"P_TO_BLNG_GRP_ID\" id=\"P_TO_BLNG_GRP_ID\" value=\"\" />\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"P_FRM_CUST_GROUP_CODE\" id=\"P_FRM_CUST_GROUP_CODE\" value=\"\" />\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"P_TO_CUST_GROUP_CODE\" id=\"P_TO_CUST_GROUP_CODE\" value=\"\" />\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"P_FRM_CUST_CODE\" id=\"P_FRM_CUST_CODE\" value=\"\" />\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"P_TO_CUST_CODE\" id=\"P_TO_CUST_CODE\" value=\"\" />\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</table>\n\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<!-- <INPUT TYPE=\"hidden\" name=\"p_passing_local_date\" id=\"p_passing_local_date\" value=\"N\"> -->\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<INPUT TYPE=\"hidden\" name=\"P_passing_local_date\" id=\"P_passing_local_date\" value=\"Y\">\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\n\t\t\t\t\n\t\t</form>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBMCSNN" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String BL_installed = (String)session.getValue("mp_bl_oper_yn");
	Connection con			= null;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String isSpltyNurUnitToEnableYNAppl="";
	try{
		con =ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
		Boolean isBillingFilterAvailable	= CommonBean.isSiteSpecific(con, "IP","REP_BILLING_GRP_FILTER"); 


            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(isSpltyNurUnitToEnableYNAppl.equals("N")){
            _bw.write(_wl_block13Bytes, _wl_block13);
            {java.lang.String __page ="CommonNursingUnitLookup.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("nursing_unit_code_Appl"), weblogic.utils.StringUtils.valueOf("p_fr_nursing_unit")},{ weblogic.utils.StringUtils.valueOf("nursing_unit_to_code_Appl"), weblogic.utils.StringUtils.valueOf("p_to_nursing_unit")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
if(BL_installed.equals("Y") && isBillingFilterAvailable){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(localeName.equals("en"))
			{
            _bw.write(_wl_block32Bytes, _wl_block32);
}
			else if(localeName.equals("th"))
			{
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);

 }catch(Exception e)
		{
			out.println("Exception in Rep2MonthlyIPSummaryNursingUnit.jsp : "+e.toString());
            e.printStackTrace();

        }   
        finally   
        {
			if(con != null)
				if(con != null)ConnectionManager.returnConnection(con,request);  
        }

            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportcritera.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CensusMonthYear.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitCode.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GroupCode.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CustomerCode.label", java.lang.String .class,"key"));
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
}
