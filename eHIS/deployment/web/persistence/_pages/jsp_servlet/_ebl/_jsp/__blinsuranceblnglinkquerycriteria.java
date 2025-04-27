package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;

public final class __blinsuranceblnglinkquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInsuranceBlngLinkQueryCriteria.jsp", 1715937995766L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n<title>Policy Definition</title>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\n<link rel=\'stylesheet\' type=\'text/css\'\n\thref=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script src=\'../../eCommon/js/CommonCalendar.js\' language=\'JavaScript\'></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'JavaScript\'></script>\n<Script src=\'../../eCommon/js/common.js\' language=\'JavaScript\'></Script>\n<Script src=\'../../eBL/js/PolicyDefinition.js\' language=\'JavaScript\'></Script>\n<script language=\'javascript\'>\nfunction focusObject() {\n\tdocument.forms[0].elements[0].focus();\n}\nfunction addOrderByCol() {\n\tvar i = 0;\n\tvar from = document.getElementById(\'orderbycols\');\n\tif (from.options.length > 0) {\n\t\tvar to = document.getElementById(\'orderbycolumns\');\n\t\tvar element = document.createElement(\'OPTION\');\n\t\telement.text = from.options[from.selectedIndex].text;\n\t\telement.value = from.options[from.selectedIndex].value;\n\t\tto.add(element);\n\t\tfrom.remove(from.selectedIndex);\n\t\tif (from.options[i])\n\t\t\tfrom.options[i].selected = true;\n\t\ti++;\n\t}\n}\nfunction removeOrderByCol() {\n\tvar j = 0;\n\tvar from = document.getElementById(\'orderbycolumns\');\n\tif (from.options.length > 0) {\n\t\tvar to = document.getElementById(\'orderbycols\');\n\t\tvar element = document.createElement(\'OPTION\');\n\t\telement.text = from.options[from.selectedIndex].text;\n\t\telement.value = from.options[from.selectedIndex].value;\n\t\tto.add(element);\n\t\tfrom.remove(from.selectedIndex);\n\t\tif (from.options[j])\n\t\t\tfrom.options[j].selected = true;\n\t\tj++;\n\t}\n}\nfunction SelectAll() {\n\tvar i = 0;\n\tdocument.getElementById(\"orderbycolumns\").selectedIndex = 0;\n\twhile (i < document.getElementById(\"orderbycolumns\").length) {\n\t\tdocument.getElementById(\"orderbycolumns\").options[i].selected = true;\n\t\ti++;\n\t}\n}\nfunction execQuery() {\n\tif (document.getElementById(\"orderbycolumns\").options.length > 0) {\n\t\tSelectAll();\n\t\tdocument.query_form.submit();\n\t} else {\n\t\talert(getMessage(\'ORDERBY_NOT_BLANK\', \'Common\'))\n\t}\n}\n\nfunction clearPolicyFields(obj){\n\tobj.value = \'\';\n}\n\nasync function billGrpLkup(billGrp_desc,billGrp_id,empty_chk)\n{\t\t\n//\talert(\"billGrpLkup\");\n\tif(empty_chk==\'Y\' && billGrp_desc.value==\'\')\n\t{\n\t\treturn false;\n\t}\n\tvar locale  = document.forms[0].locale.value;\t\t\t\n\tvar facility_id  = document.forms[0].facility_id.value;\t\t\t\n\tvar target\t\t\t= document.forms[0].billingGrp;\t\t\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= getLabel(\"eBL.BillingGroup.label\",\"BL\");\n\n\tvar sql1=\"SELECT BLNG_GRP_ID code, SHORT_DESC description FROM BL_BLNG_GRP_LANG_VW WHERE  LANGUAGE_ID = \'\"+locale+\"\' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 1 \";\n\t\n\tvar argArray = new Array();\n\tvar namesArray = new Array();\n\tvar valuesArray = new Array();\n\tvar datatypesArray = new Array();\n\targArray[0] = sql1;\n\targArray[1] = namesArray;\n\targArray[2] = valuesArray;\n\targArray[3] = datatypesArray;\n\targArray[4] = \"1,2\";\t\n   \targArray[5] = target.value;\t    \n\targArray[6] = DESC_LINK;\t\n\targArray[7] = DESC_CODE;\n\t\n\t//alert(\"argArray[5]\"+argArray[5]);\n\t\n\tretArray = await CommonLookup( title, argArray );\t\t\n\tvar ret1=unescape(retArray);\n\tvar arr=ret1.split(\",\");\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t}\t\n\n\tif(retArray != null && retArray !=\"\")\n\t{\t\t\t\t\t\n\t\t\n\t\tbillGrp_id.value=arr[0];\n\t\tbillGrp_desc.value=arr[1];\t\t\t\t\t\t\t\t\n\t}\n\telse\n\t{\n\t\t//billGrp_id.value=\"\";\n\t\t//billGrp_desc.value=\"\";\t\n\t\tbillGrp_id.value = arr[0]; \n\t\t    billGrp_desc.value = arr[1]; \n\t}\n\t\n}\n\n\tasync function billGrpLkup(billGrp_desc,billGrp_id,empty_chk)\n\t{\t\t\n\t\tif(empty_chk==\'Y\' && billGrp_desc.value==\'\')\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t\tvar locale  = document.forms[0].locale.value;\t\t\t\n\t\tvar facility_id  = document.forms[0].facility_id.value;\t\t\t\n\t\tvar target\t\t\t= document.forms[0].billingGrp;\t\t\n\t\tvar retVal\t\t\t=  new String();\n\t\tvar dialogTop\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar title\t\t\t= getLabel(\"eBL.BillingGroup.label\",\"BL\");\n\n\t\tvar sql1=\"SELECT BLNG_GRP_ID code, SHORT_DESC description FROM BL_BLNG_GRP_LANG_VW WHERE  LANGUAGE_ID = \'\"+locale+\"\' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 1 \";\n\t\t\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql1;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\t\n\t\targArray[5] = target.value;\t    \n\t\targArray[6] = DESC_LINK;\t\n\t\targArray[7] = DESC_CODE;\n\t\t\n\t\tretArray = await CommonLookup( title, argArray );\n\t\tvar ret1=unescape(retArray);\n\t\tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t}\t\n\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\t\t\n\t\t\tbillGrp_id.value=arr[0];\n\t\t\tbillGrp_desc.value=arr[1];\t\t\t\t\t\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//billGrp_id.value=\"\";\n\t\t\t//billGrp_desc.value=\"\";\t\n\t\t\tbillGrp_id.value = arr[0]; \n\t\t\tbillGrp_desc.value = arr[1]; \n\t\t}\t\n\t}\n\n\tasync function payerGrpLkup(pyrGrp_desc,pyrGrp_code,empty_chk)\n\t{\t\n\t\tif(empty_chk==\'Y\' && pyrGrp_desc.value==\'\')\n\t\t{\n\t\t\treturn false;\n\t\t}\t\n\n\t\tvar locale  = document.forms[0].locale.value;\t\n\t\tvar facility_id  = document.forms[0].facility_id.value;\t\n\t\tvar target\t\t\t= document.forms[0].payerGroup;\t\t\n\t\tvar retVal\t\t\t=  new String();\n\t\tvar dialogTop\t= \"40\";\n\t\tvar dialogHeight\t= \"10\" ;\n\t\tvar dialogWidth\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar title\t\t\t= getLabel(\"eBL.PAYER_GROUP.label\",\"BL\");\n\n\t\tvar sql1=\"select cust_group_code code,short_desc description from ar_cust_group_lang_vw  where  language_id=\'\"+locale+\"\' and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 1\";\n\t\t\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql1;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\t\t\n\t\targArray[5] = target.value;   \n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = DESC_CODE;\t\n\t\t\n\t\tretArray = await CommonLookup( title, argArray );\n\t\tvar ret1=unescape(retArray);\n\t\tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t}\t\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\t\t\t\t\t\n\t\t\tpyrGrp_code.value=arr[0];\n\t\t\tpyrGrp_desc.value=arr[1];\t\t\t\t\t\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//pyrGrp_code.value=\"\";\n\t\t\t//pyrGrp_desc.value=\"\";\t\n\t\tpyrGrp_code.value = arr[0]; \n\t\tpyrGrp_desc.value = arr[1];\n\t\t}\t\n\t}\n\n\tasync function payerlkup(payer_desc,payer_code,empty_chk)\n\t{\t\n\t\tif(empty_chk==\'Y\' && payer_desc.value==\'\')\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tvar target\t\t\t= document.forms[0].payer;\t\n\t\tvar retVal\t\t\t=  new String();\n\t\tvar dialogTop\t= \"40\";\n\t\tvar dialogHeight\t= \"10\" ;\n\t\tvar dialogWidth\t= \"40\" ;\n\t\tvar features\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t= \"\" ;\n\t\tvar search_desc\t= \"\";\n\t\tvar title\t= encodeURIComponent(getLabel(\"Common.Payer.label\",\"common\"));\n\t\tvar locale  = document.forms[0].locale.value;\n\t\tvar cust_group_code=document.forms[0].payerGrpCode.value;\n\t\t\n\t\t//var sql1=\"select  cust_code  code,SHORT_NAME description from ar_customer_lang_vw where language_id = \'\"+locale+\"\'   and cust_group_code = \'\"+cust_group_code+\"\' and upper(cust_code) like upper(?) and upper(long_name) like upper(?) order by 1\";  //commented V190603-Dhananjay/MMS-DM-CRF-130/70600 /Start\n\n\t\tvar sql1=\"select code, description from ( select  cust_code  code,SHORT_NAME description from ar_customer_lang_vw where language_id = \'\"+locale+\"\'   and cust_group_code = \'\"+cust_group_code+\"\' union select \'**\' code  ,\'All\' description  from dual  WHERE \'**\' != nvl( \'\" + cust_group_code + \"\', \'**\')) where  upper(code) like upper(?) and upper(description) like upper(?)  order by decode(description,\'All\',\'A\')\"; //Added V190603-Dhananjay/MMS-DM-CRF-130/70600\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql1;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\t\t\t\t\t\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\n\t\targArray[5] = target.value;\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = DESC_CODE;\n\t\t\n\t\tretArray = await CommonLookup( title, argArray );\n        var ret1=unescape(retArray);\n\t\t\tvar arr=ret1.split(\",\");\n\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t{\n\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t}\t\t\t\n\t\t\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\t\t\t\t\t\n\t\t\tpayer_code.value=arr[0];\n\t\t\tpayer_desc.value=arr[1];\t\t\t\t\t\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//payer_code.value=\"\";\n\t\t\t//payer_desc.value=\"\";\n\t\tpayer_code.value = arr[0]; \n\t\tpayer_desc.value = arr[1]; \t\t\t\n\t\t}\t\n\t}\n\n\tasync function policyLkup(policy_desc,policy_code,empty_chk)\n\t{\t\t\n\t\tif(empty_chk==\'Y\' && policy_desc.value==\'\')\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t\tvar locale  = document.forms[0].locale.value;\t\t\t\n\t\tvar facility_id  = document.forms[0].facility_id.value;\t\t\t\n\t\tvar target\t\t= document.forms[0].policyType;\t\t\n\t\tvar retVal\t\t=  new String();\n\t\tvar dialogTop\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t= \"40\" ;\n\t\tvar features\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t= \"\" ;\n\t\tvar search_desc\t\t= \"\";\n\t\tvar title\t\t\t= getLabel(\"eBL.POLICY.label\",\"BL\");\n\t\t\n\t\tvar cust_group_code= document.forms[0].payerGrpCode.value;\n\t\tvar cust_code= document.forms[0].payerCode.value;\t\n\n\t\t//Commented for  V190603-Dhananjay/MMS-DM-CRF-130/70600\n\t\t/*var sql1=\" select a.policy_type_code code,a.short_desc description from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id=\'\"+locale+\"\' \"+\n\t\t\" AND b.cust_group_code =  \'\"+cust_group_code+\"\'  AND (b.cust_code = \'\"+cust_code+\"\' OR b.cust_code = \'**\') \"+\n\t\t\" AND a.policy_type_code = b.policy_type_code \"+\n\t\t\" AND a.operating_facility_id = \'\"+facility_id+\"\'  AND UPPER (a.language_id) = UPPER (\'\"+locale+\"\') \"+\n\t\t\" AND upper(a.policy_type_code) like upper(?) and upper(short_desc) like upper(?) order by 1 \";*/\n\t\t\t\n\t\t//Added V190603-Dhananjay/MMS-DM-CRF-130/70600 /Start\n\t\tvar sql1 = \" select code ,description from ( select  a.policy_type_code code,a.short_desc description";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 =" from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id=\'\"+locale+\"\' \"+            \n\t\t\" AND b.cust_group_code =  \'\"+cust_group_code+\"\' AND (b.cust_code = \'\"+cust_code+\"\' OR nvl( \'\" + cust_code + \"\', \'**\') = \'**\') \"+\n\t\t\" AND a.policy_type_code = b.policy_type_code \"+\n\t\t\" AND a.operating_facility_id = \'\"+facility_id+\"\'  AND UPPER (a.language_id) = UPPER (\'\"+locale+\"\') union  select \'**\' code , \'All\' description from dual     WHERE \'****\' != nvl( \'\" + cust_group_code + \"\', \'****\') )\"+\n\t\t\" where  upper(code) like upper(?) and upper(description) like upper(?)  order by decode(description,\'All\',\'A\')\";\n\t\t//Added V190603-Dhananjay/MMS-DM-CRF-130/70600 /End\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql1;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\t\n\t\targArray[5] = target.value;\t\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = DESC_CODE;\t\t\n\t\tretArray = await CommonLookup( title, argArray );\t\n\t\tvar ret1=unescape(retArray);\n\t\t\t\tvar arr=ret1.split(\",\");\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t}\t\t\t\t\n\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\t\t\n\t\t\tpolicy_code.value=arr[0];\n\t\t\tpolicy_desc.value=arr[1];\t\t\t\t\t\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//policy_code.value=\"\";\n\t\t\t//policy_desc.value=\"\";\t\n\t\t\tpolicy_code.value = arr[0]; \n\t\t    policy_desc.value = arr[1]; \n\t\t\t}\n\t}\n\t\n\t\n\n\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' onLoad=\'focusObject()\'>\n<form name=\'query_form\' id=\'query_form\' method=\'post\' action=\'../../eBL/jsp/BLInsuranceBlngLinkQueryResult.jsp\' onsubmit=\'SelectAll()\'><Script src=\'../../eCommon/js/common.js\' language=\'JavaScript\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<table width=\'100%\' align=\'center\' cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr>\n\t\t<th align=\'left\' width=\'20%\'>";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t<tr>\n\t\t\t<td width=\'60%\'>\n\t\t\t<p title=\'Query Criteria\'>\n\t\t\t<table width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t \t<td width=\'20%\' class=\"label\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"fields\" >\n\t\t\t\t\t<INPUT TYPE=\"TEXT\"  name=\"billingGrp\" id=\"billingGrp\" SIZE=\"30\"  MAXLENGTH=\'40\'\t VALUE=\'\' onBlur=\"billGrpLkup(this,document.forms[0].billingGrpCode,\'Y\')\">\n\t\t\t\t\t<input type= \'hidden\' name=\"billingGrpCode\" id=\"billingGrpCode\"  value=\'\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"billingGrpBut\" id=\"billingGrpBut\" value=\'?\' onClick=\"billGrpLkup(document.forms[0].billingGrp,document.forms[0].billingGrpCode)\" tabindex=\'\' >\t\n\t\t\t\t\t\t\t\t \n\t\t\t   </td>\t\n\t\t\t   <td width=\'20%\' nowrap class=\'label\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t<td width=\'25%\' nowrap class=\'fields\' >\n\t\t\t\t\t<input type=\'text\' name=\'payerGroup\' id=\'payerGroup\' size=\'30\' maxlength=\'40\'  value=\'\' onblur=\"payerGrpLkup(this,document.forms[0].payerGrpCode,\'Y\')\"/>\n\t\t\t\t\t<input type=\'hidden\' name=\'payerGrpCode\' id=\'payerGrpCode\' value=\'\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"payerGroupBtn\" id=\"payerGroupBtn\" value=\'?\' onClick=\"payerGrpLkup(document.forms[0].payerGroup,document.forms[0].payerGrpCode)\" tabindex=\'2\'>\n\t\t\t\t\t\n\t\t\t\t</td> \t\t\n\t\t\t </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  width=\"20%\" class=\"label\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\n\t\t\t\t<td  width=\"25%\" class=\"fields\" >\n\t\t\t\t\t<INPUT TYPE=\"TEXT\"  name=\"payer\" id=\"payer\" SIZE=\"30\"  MAXLENGTH=\'40\'\t VALUE=\'\' onBlur=\"payerlkup(this,document.forms[0].payerCode,\'Y\')\"/>\n\t\t\t\t\t<input type= \'hidden\' name=\"payerCode\" id=\"payerCode\"  value=\'\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"payerBtn\" id=\"payerBtn\" value=\'?\' onClick=\"payerlkup(document.forms[0].payer,document.forms[0].payerCode)\" tabindex=\'2\' >\t\n\t\t\t\t\t\t\t \n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td width=\'20%\' nowrap class=\'label\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t<td width=\'25%\' nowrap class=\'fields\' >\n\t\t\t\t\t<input type=\'text\' name=\'policyType\' id=\'policyType\' size=\'30\' maxlength=\'40\'  value=\'\' onblur=\"policyLkup(this,document.forms[0].policyTypeCode,\'Y\')\"/>\n\t\t\t\t\t<input type=\'hidden\' name=\'policyTypeCode\' id=\'policyTypeCode\' value=\'\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"policyType_btn\" id=\"policyType_btn\" value=\'?\'onClick=\"policyLkup(document.forms[0].policyType,document.forms[0].policyTypeCode)\" tabindex=\'2\'>\n\t\t\t\t\t\n\t\t\t\t</td>   \n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n</table>\n</p>\n<table width=\'100%\' align=\'center\'>\n\t<th width=\'20%\' align=\'left\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</td>\n\t<tr>\n\t\t<td width=\'60%\'>\n\t\t<p title=\'Sort Order\'>\n\t\t<table width=\'100%\'>\n\t\t\t<td align=\'center\'><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td align=\'center\'><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<tr>\n\t\t\t\t<td width=\'45%\' align=\'center\'><select name=\'orderbycols\' id=\'orderbycols\'\n\t\t\t\t\tsize=\'5\'>\t\t\t\t\t\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<option value=\'hdr.BLNG_GRP_ID\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t\t\t\t<option value=\'hdr.CUST_CODE\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t\t\t\t\t<option value=\'hdr.POLICY_TYPE_CODE\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\t\t\t\t\t\n\t\t\t\t</select></td>\n\t\t\t\t<td align=\'center\' width=\'3%\'><input type=\'button\' name=\'add\' id=\'add\'\n\t\t\t\t\tclass=\'button\' onclick=\'addOrderByCol()\' value=\'---->\'> <input type=\'button\' name=\'add\' id=\'add\' class=\'button\' value=\'<----\'\n\t\t\t\t\tonclick=\'removeOrderByCol()\'></img></td>\n\t\t\t\t<td width=\'45%\' align=\'center\'><select name=\'orderbycolumns\' id=\'orderbycolumns\'\n\t\t\t\t\tsize=\'5\' multiple=\'true\'>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<option value=\'hdr.CUST_GROUP_CODE\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t</select></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</p>\n\t\t</td>\n\t</tr>\n</table>\n<br>\n<table border=\'0\' width=\'100%\' align=\'center\'>\n\t<tr>\n\t\t<td width=\'100%\' align=\'center\' class=\'white\'><input type=\'button\' name=\'ExecuteQuery\' id=\'ExecuteQuery\' class=\'Button\'\n\t\t\tonclick=\'execQuery()\'></td>\n\t</tr>\n</table>\n<script>var exe=getLabel(\'Common.Execute.label\',\'common\'); document.forms[0].ExecuteQuery.value=exe;</script>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id ));
            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueryCriteria.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SortOrder.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
