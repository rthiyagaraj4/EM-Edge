package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __blinsuranceblnglinkaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInsuranceBlngLinkAddModify.jsp", 1742751656614L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eBL/js/BLInsAgeLimit.js\'></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/PolicyDefinition.js\"></script>\n\n\n</head>\n\n<script language=\'javascript\'>\n\nfunction enableAppy()\n{\n//\talert(\"load apply\");\nparent.commontoolbarFrame.document.forms[0].apply.disabled=false;\n}\n\nfunction checkForSpecChars(event)\n{\n    var strCheck = \'0123456789\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n\nfunction checkNumeric(obj)\n{\n\t\n\tvar dat = obj.value;\n\t\n\t \n\tif(dat.charAt(0)==\'.\'  || dat.charAt(1)== \'.\')\n\t\t obj.value =\'\';\n\t\t\nif(isNaN(obj.value) == false)\n\t{\n\tif(obj.value <= 0 && obj.value != \'\')\n\t{\t\n\t\talert(\'Priority value should be greater then  Zero\');\n\t\tobj.value = \'\';\n\t\t}\n\t}\nelse\n\t{\n\tobj.value=\'\';\n\tobj.focus();\n\t}\n\t\t\t\n}\n\n\n\nasync function billGrpLkup(billGrp_desc,billGrp_id,empty_chk)\n{\t\t\n\tif(empty_chk==\'Y\' && billGrp_desc.value==\'\')\n\t{\n\t\treturn false;\n\t}\n\tvar locale  = document.forms[0].locale.value;\t\t\t\n\tvar facility_id  = document.forms[0].facility_id.value;\t\t\t\n\tvar target\t\t\t= document.forms[0].billingGrp;\t\t\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= getLabel(\"eBL.BillingGroup.label\",\"BL\");\n\t//46197 - Karthik added condition as Cash and Credit Billing Group should not be displayed in Setup Payer by Billing Group function \n\tvar sql1=\"SELECT BLNG_GRP_ID code, SHORT_DESC description FROM BL_BLNG_GRP_LANG_VW WHERE status is null and settlement_ind = \'X\' and LANGUAGE_ID = \'\"+locale+\"\' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 1 \";\n\t\n\tvar argArray = new Array();\n\tvar namesArray = new Array();\n\tvar valuesArray = new Array();\n\tvar datatypesArray = new Array();\n\targArray[0] = sql1;\n\targArray[1] = namesArray;\n\targArray[2] = valuesArray;\n\targArray[3] = datatypesArray;\n\targArray[4] = \"1,2\";\t\n   \targArray[5] = target.value;\t    \n\targArray[6] = DESC_LINK;\t\n\targArray[7] = DESC_CODE;\n\t\n\t//alert(\"argArray[5]\"+argArray[5]);\n\t\n\tretArray = await CommonLookup( title, argArray );\n\t\n\tif(retArray != null && retArray !=\"\")\n\t{\t\t\t\t\t\n\t\t\tvar ret1=unescape(retArray);\n\t\t\tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t}\n\t\tbillGrp_id.value=arr[0];\n\t\tbillGrp_desc.value=arr[1];\t\n\t\t//alert(\"\"+billGrp_id.value+\"/\"+billGrp_desc.value);\n\t\t\n\t}\n\telse\n\t{\n\t\tbillGrp_id.value=\"\";\n\t\tbillGrp_desc.value=\"\";\t\n\t}\n\t\n}\n\nasync function payerGrpLkup(pyrGrp_desc,pyrGrp_code,empty_chk)\n{\t\t\n\tif(empty_chk==\'Y\' && pyrGrp_desc.value==\'\')\n\t{\n\t\treturn false;\n\t}\n\t\n\n\tvar locale  = document.forms[0].locale.value;\t\n\tvar facility_id  = document.forms[0].facility_id.value;\t\n\tvar target\t\t\t= document.forms[0].payerGroup;\t\t\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= getLabel(\"eBL.PAYER_GROUP.label\",\"BL\");\n\n\tvar sql1=\"select cust_group_code code,short_desc description from ar_cust_group_lang_vw  where  language_id=\'\"+locale+\"\' and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 1\";\n\t\n\t\n\tvar argArray = new Array();\n\tvar namesArray = new Array();\n\tvar valuesArray = new Array();\n\tvar datatypesArray = new Array();\n\targArray[0] = sql1;\n\targArray[1] = namesArray;\n\targArray[2] = valuesArray;\n\targArray[3] = datatypesArray;\n\targArray[4] = \"1,2\";\t\t\n   \targArray[5] = target.value;   \n\targArray[6] = DESC_LINK;\n\t//alert(argArray[6]);\n\targArray[7] = DESC_CODE;\n\t\n\t//alert(\"argArray[5]\"+argArray[5]);\n\t\n\tretArray = await CommonLookup( title, argArray );\n\tif(retArray != null && retArray !=\"\")\n\t{\t\n\t\tvar ret1=unescape(retArray);\n\t\tvar arr=ret1.split(\",\");\n\t\tif(arr[1]==undefined) \n\t\t{\n\t\t \tarr[0]=\"\";\t\n\t\t \tarr[1]=\"\";\t\n\t\t}\n\t\tpyrGrp_code.value=arr[0];\n\t\tpyrGrp_desc.value=arr[1];\t\t\n\t}\n\telse\n\t{\t\t\n\t\tpyrGrp_code.value=\"\";\n\t\tpyrGrp_desc.value=\"\";\t\n\t}\n\t\n}\n\n\nasync function payerlkup(payer_desc,payer_code,empty_chk)\n{\t\t\t\t\n\tif(empty_chk==\'Y\' && payer_desc.value==\'\')\n\t{\n\t\treturn false;\n\t}\n\t\n\tvar target\t\t\t= document.forms[0].payer;\t\n\t\n\t//alert(\"target.value\"+target.value);\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= encodeURIComponent(getLabel(\"Common.Payer.label\",\"common\"));\n\tvar locale  = document.forms[0].locale.value;\n\n\tvar cust_group_code=document.forms[0].payerGrpCode.value;\n//\talert(\"cust_group_code\"+cust_group_code);\n\t\n\t\tvar sql1=\"select  cust_code  code,SHORT_NAME description from ar_customer_lang_vw where language_id = \'\"+locale+\"\'   and cust_group_code = \'\"+cust_group_code+\"\' and upper(cust_code) like upper(?) and upper(long_name) like upper(?) order by 1\";\n\t\t\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql1;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\t\t\t\t\t\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\n\t\targArray[5] = target.value;\n\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = DESC_CODE;\n\t\t\n\t\tretArray = await CommonLookup( title, argArray );\t\t\t\t\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\t\t\t\t\t\n\t\t\tvar ret1=unescape(retArray);\n\t\t\tvar arr=ret1.split(\",\");\n\t\t\tif(arr[1]==undefined) \n\t\t\t{\n\t\t\t\tarr[0]=\"\";\t\n\t\t\t\tarr[1]=\"\";\t\n\t\t\t}\n\t\t\tpayer_code.value=arr[0];\n\t\t\tpayer_desc.value=arr[1];\t\t\n\t\t\t//alert(\"payer\"+payer_code.value+\"/\"+payer_desc.value);\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\n\t\t\tpayer_code.value=\"\";\n\t\t\tpayer_desc.value=\"\";\t\t\t\n\t\t}\n\t\t\n\t\n}\n\n\nasync function policyLkup(policy_desc,policy_code,empty_chk)\n{\t\t\n\n\tif(empty_chk==\'Y\' && policy_desc.value==\'\')\n\t{\n\t\treturn false;\n\t}\n\tvar locale  = document.forms[0].locale.value;\t\t\t\n\tvar facility_id  = document.forms[0].facility_id.value;\t\t\t\n\tvar target\t\t\t= document.forms[0].policyType;\t\t\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= getLabel(\"eBL.POLICY.label\",\"BL\");\n\t\n\tvar cust_group_code= document.forms[0].payerGrpCode.value;\n\tvar cust_code= document.forms[0].payerCode.value;\n\t\n//\talert(\"cust_group_code/cust_code\"+cust_group_code+\"/\"+cust_code);\n\n//\tvar sql1=\"select policy_type_code code,short_desc description from bl_ins_policy_types_lang_vw   where  language_id=\'\"+locale+\"\'  and operating_facility_id = \'\"+facility_id+\"\' and upper(policy_type_code) like upper(?) and upper(short_desc) like upper(?) order by 1\";\n\t\n\tvar sql1=\" select a.policy_type_code code,a.short_desc description from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id=\'\"+locale+\"\' \"+\t\t\t\n\t\t\t\" AND b.cust_group_code =  \'\"+cust_group_code+\"\'  AND (b.cust_code = \'\"+cust_code+\"\' OR b.cust_code = \'**\') \"+\n\t\t\t\" AND a.policy_type_code = b.policy_type_code \"+\n\t\t\t\" AND a.operating_facility_id = \'\"+facility_id+\"\'  AND UPPER (a.language_id) = UPPER (\'\"+locale+\"\') \"+\n\t\t\t\" AND upper(a.policy_type_code) like upper(?) and upper(short_desc) like upper(?) order by 1 \";\n\t\n\tvar argArray = new Array();\n\tvar namesArray = new Array();\n\tvar valuesArray = new Array();\n\tvar datatypesArray = new Array();\n\targArray[0] = sql1;\n\targArray[1] = namesArray;\n\targArray[2] = valuesArray;\n\targArray[3] = datatypesArray;\n\targArray[4] = \"1,2\";\t\n   \targArray[5] = target.value;\t\n  //  alert(\"1\");\n\targArray[6] = DESC_LINK;\n//\talert(argArray[6]);\n\targArray[7] = DESC_CODE;\t\t\n//\talert(\"8\");\n\tretArray = await CommonLookup( title, argArray );\n\tvar ret1=unescape(retArray);\n\t\t\t\tvar arr=ret1.split(\",\");\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t}\t\t\n//\talert(\"9\");\n\n\tif(retArray != null && retArray !=\"\")\n\t{\t\t\t\t\t\n\t\t\n\t\tpolicy_code.value=arr[0];\n\t\tpolicy_desc.value=arr[1];\t\t\t\n\t//\talert(\"policy\"+policy_code.value+\"/\"+policy_desc.value);\n\t}\n\telse\n\t{\n\t\t//policy_code.value=\"\";\n\t\t//policy_desc.value=\"\";\t\n\t\tpolicy_code.value = arr[0]; \n\t\tpolicy_desc.value = arr[1]; \n\t}\n\t\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<body  OnLoad=\"enableAppy();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n<form name=\"Insurance_BlngLinkForm\" id=\"Insurance_BlngLinkForm\"  onload=\'FocusFirstElement();\'  action=\"../../servlet/eBL.BLInsuranceBlngLinkServlet\" method=\"post\" target=\"messageFrame\">  \n<br><br><br><br><br><br>\n<TABLE width=\"100%\" CELLSPACING=0 cellpadding=3 align=\'center\'>\n\t\t\t<tr >\n\t\t\t\t<th  class=\"columnheader\" align=\'left\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t</tr>\t\n</TABLE>\t\n<table cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" border=0>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\n      \t\t<tr>\n      \t\t\t<td width=\'20%\'  nowrap class=\'label\'>\n      \t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n      \t\t\t</td>\n      \t\t\t<td colspan=\'2\' nowrap class=\'fields\'>\n      \t\t\t\t<select name=\'facility\' id=\'facility\' id=\'facility\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" >\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n      \t\t\t</td>\t\t\n\t\t\t </tr>\n\n\t\t\t<tr>\n\t\t\t \t<td width=\'20%\' class=\"label\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"fields\" >\n\t\t\t\t\t<INPUT TYPE=\"TEXT\"  name=\"billingGrp\" id=\"billingGrp\" SIZE=\"30\"  MAXLENGTH=\'40\'\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="  VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onBlur=\"billGrpLkup(this,document.forms[0].billingGrpCode,\'Y\')\">\n\t\t\t\t\t<input type= \'hidden\' name=\"billingGrpCode\" id=\"billingGrpCode\"  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"billingGrpBut\" id=\"billingGrpBut\" value=\'?\'  ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" onClick=\"billGrpLkup(document.forms[0].billingGrp,document.forms[0].billingGrpCode)\" tabindex=\'\' >\t\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\t\t \n\t\t\t   </td>\t\t\n\t\t\t </tr>\n\n\t\t\t <tr>\n\t\t\t \t<td width=\'20%\' nowrap class=\'label\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td width=\'25%\' nowrap class=\'fields\' >\n\t\t\t\t\t<input type=\'text\' name=\'payerGroup\' id=\'payerGroup\' size=\'30\' maxlength=\'40\'   ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onblur=\"payerGrpLkup(this,document.forms[0].payerGrpCode,\'Y\')\"/>\n\t\t\t\t\t<input type=\'hidden\' name=\'payerGrpCode\' id=\'payerGrpCode\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"payerGroupBtn\" id=\"payerGroupBtn\" value=\'?\'  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" onClick=\"payerGrpLkup(document.forms[0].payerGroup,document.forms[0].payerGrpCode)\" tabindex=\'2\'>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td> \t\n\t\t\t</tr>\t\n\t\t\t\t\t \n\t\t\t <tr>\t\t\t\t\t\t\n\t\t\t\t<td  width=\"20%\" class=\"label\" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\t\n\t\t\t\t<td  width=\"25%\" class=\"fields\" >\n\t\t\t\t\t<INPUT TYPE=\"TEXT\"  name=\"payer\" id=\"payer\" SIZE=\"30\"  MAXLENGTH=\'40\'\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onBlur=\"payerlkup(this,document.forms[0].payerCode,\'Y\')\"/>\n\t\t\t\t\t<input type= \'hidden\' name=\"payerCode\" id=\"payerCode\"  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"payerBtn\" id=\"payerBtn\" value=\'?\'  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" onClick=\"payerlkup(document.forms[0].payer,document.forms[0].payerCode)\" tabindex=\'2\' >\t\t\t\t\t\t\t\t\t \n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t <tr>\n\t\t\t\t\t   <td width=\'25%\'  class=\'label\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\t\n\t\t\t   \t<td width=\'25%\'>\n\t\t\t\t<Select id=\"patient_class\" name=\"patient_class\" id=\"patient_class\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" selected>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\t\t  \t\t\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\t\n\t\t\t</tr>\t\t\t\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td width=\'20%\' nowrap class=\'label\' >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t<td width=\'25%\' nowrap class=\'fields\' >\n\t\t\t\t\t<input type=\'text\' name=\'policyType\' id=\'policyType\' size=\'30\' maxlength=\'40\'  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="  value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' onblur=\"policyLkup(this,document.forms[0].policyTypeCode,\'Y\')\"/>\n\t\t\t\t\t<input type=\'hidden\' name=\'policyTypeCode\' id=\'policyTypeCode\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"policyType_btn\" id=\"policyType_btn\" value=\'?\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" onClick=\"policyLkup(document.forms[0].policyType,document.forms[0].policyTypeCode)\" tabindex=\'2\'>\n\t\t\t\t</td>   \n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td width=\'20%\' nowrap class=\'label\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t<td width=\'25%\' nowrap class=\'fields\' >\n\t\t\t\t\t<input type=\'text\' name=\'priority\' id=\'priority\'  size=\'30\' maxlength=\'2\'  value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" onblur =\"checkNumeric(this);\" onkeypress=\"return checkForSpecChars(event);\" />\n\t\t\t\t</td>  \t\t\t\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t\n<!-- \t\t\t<tr -->\n<!-- \t\t\t<td class=\"fields\" width=\"5%\"><input type=\'checkbox\' name=\'enabledYN\' id=\'enabledYN\' id=\'enabledYN\' checked> -->\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<!-- \t\t\t</tr> -->\n\n\t\t\t<tr>\n\t\t\t\t<td class=label >\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"status\" id=\"status\" onClick=\'setCheckValue();\'  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" >\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\n\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n<input type=\'hidden\' name=\'patClass_hid\' id=\'patClass_hid\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\'hidden\' name=\'facId_hid\' id=\'facId_hid\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\'hidden\' name=\'prior_hid\' id=\'prior_hid\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type= hidden name=\"facility_id\" id=\"facility_id\"  value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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

/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
1			 V211020           25504	  COMMON-ICN-0073-TF		Mohanapriya K
 */ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");

Connection con=null;
PreparedStatement pstmt=null;
ResultSet rst=null;


String servClass="";
String servClassCode="";
String billing_group="";
String billingGrp_code="";
String payer_group="";
String payerGrp_code="";
String payer="";			
String payer_code="";
String policy="";
String policy_code="";	

String p_facility_id="";
//String priority="";
String pat_class="";
String pat_classQuery="";
String fac_Id="";
String fac_name="";

HttpSession httpSession = request.getSession(false);


locale	= (String)session.getAttribute("LOCALE");	
p_facility_id = (String)httpSession.getValue("facility_id");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

// mode=modify&blngGroup="+ blngGroup+"&payerGroup="+payerGroup+"&payer="+payer+"&patientClass="+patientClass+"&policyType="+policyType+"' target='f_query_add_mod' >");

String mode=request.getParameter("mode");
//out.println(mode);
//String age_group_code=checkForNull(request.getParameter("age_group_code"));

// String billingGrpCode=checkForNull(request.getParameter("billingGrpCode"));
// String payerGrpCode=checkForNull(request.getParameter("payerGrpCode"));
// String payerCode=checkForNull(request.getParameter("payerCode"));
// String policyTypeCode=checkForNull(request.getParameter("policyTypeCode"));


String billingGrpCode=checkForNull(request.getParameter("blngGroup"));
String payerGrpCode=checkForNull(request.getParameter("payerGroup"));
String payerCode=checkForNull(request.getParameter("payer"));
String policyTypeCode=checkForNull(request.getParameter("policyType"));

String patient_class=checkForNull(request.getParameter("patientClass"));
String facility=checkForNull(request.getParameter("oprFacId"));
String priority=checkForNull(request.getParameter("priorNo"));
 

String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String short_desc_disable="";
String strLongDesc="";
String status="";
String sql="";

String facilityId="";
//String facility="";

String disabled = "";
String totaldisabled = "";
String readonly="";

System.out.println("mode>>>>>>>>>"+mode);

if(mode.equals("modify"))
{
	try{
		readonly = "readonly";
		disabled = "disabled";
		totaldisabled = "disabled";	
		con=ConnectionManager.getConnection(request);
		int column_count = 1;
	//	sql = "SELECT LONG_DESC,SHORT_DESC,FROM_YEAR,FROM_MONTH,FROM_DAY,TO_YEAR,TO_MONTH,TO_DAY,NVL(status,'E') status1 FROM BL_INS_AGE_GROUP where age_group_code =? ";

	//	sql = "SELECT OPERATING_FACILITY_ID,BLNG_GRP_ID,CUST_GROUP_CODE,CUST_CODE,PATIENT_CLASS,POLICY_TYPE_CODE,PRIORITY_NO,NVL(status,'E') status1 FROM BL_PAYERS_PRIORITY_BY_BG 	WHERE BLNG_GRP_ID=? AND CUST_GROUP_CODE=? AND CUST_CODE=? AND POLICY_TYPE_CODE=? ";
		
	  sql="SELECT decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, hdr.CUST_GROUP_CODE, "+
	      "decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, hdr.CUST_CODE, "+
	      "(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id ) policy_type, "+
		  "hdr.POLICY_TYPE_CODE,hdr.PRIORITY_NO,NVL(hdr.status,'E') status1,hdr.operating_facility_id, "+
		  "(select bil.SHORT_DESC  from BL_BLNG_GRP bil where bil.BLNG_GRP_ID = hdr.BLNG_GRP_ID)bill_desc, hdr.BLNG_GRP_ID, "+
		  "hdr.PATIENT_CLASS "+
	      "FROM BL_PAYERS_PRIORITY_BY_BG hdr	WHERE BLNG_GRP_ID=? AND CUST_GROUP_CODE=? "+
	      "AND OPERATING_FACILITY_ID=? AND PATIENT_CLASS=? ";
	  
	  if("".equals(payerCode)){
		  sql+=" AND CUST_CODE IS NULL ";
	  }
	  else{
		  sql+=" AND CUST_CODE =? ";
	  }
	  if("".equals(policyTypeCode)){
		  sql+=" AND POLICY_TYPE_CODE IS NULL ";
	  }
	  else{
		  sql+=" AND POLICY_TYPE_CODE =? ";
	  }
	  if("".equals(priority)){
		  sql+=" AND PRIORITY_NO IS NULL ";
	  }
	  else{
		  sql+=" AND PRIORITY_NO =? ";
	  }
	      
		pstmt=con.prepareStatement(sql);

		//pstmt.setString(1,age_group_code);
		System.out.println("billingGrpCode/payerGrpCode/payerCode/policyTypeCode/facility/patient_class/priority "+billingGrpCode+"/"+payerGrpCode+"/"+payerCode+"/"+policyTypeCode+"/"+facility+"/"+patient_class+"/"+priority);
		
		pstmt.setString(column_count, billingGrpCode);
		pstmt.setString(++column_count, payerGrpCode);
		pstmt.setString(++column_count, facility);
		pstmt.setString(++column_count, patient_class);
		
		 if(!"".equals(payerCode)){
			pstmt.setString(++column_count, payerCode);
		 }
		 if(!"".equals(policyTypeCode)){
			pstmt.setString(++column_count, policyTypeCode);
		 }
		 if(!"".equals(priority)){
			pstmt.setString(++column_count, priority);
		 }

		rst = pstmt.executeQuery();
		if(rst!=null && rst.next())
		{   			
			System.out.println("result set not null");			
	
			
			facility=rst.getString("operating_facility_id");
			billing_group=rst.getString("bill_desc");		
			billingGrp_code=rst.getString("BLNG_GRP_ID");		
			payer_group= rst.getString("payer_group");  
			payerGrp_code=rst.getString("CUST_GROUP_CODE");  

			payer= rst.getString("payer");  
			if (payer==null)		payer="";

			payer_code=rst.getString("CUST_CODE");
			policy_code =rst.getString("POLICY_TYPE_CODE");	
			policy=rst.getString("policy_type");
			if (policy==null)		policy="";
			
			pat_class = rst.getString("PATIENT_CLASS");	

			priority=rst.getString("PRIORITY_NO");	
			if (priority==null)		priority="";

			status=rst.getString("status1");
			
			
			System.out.println("policy/policy_code/facility>>>>>> "+policy+"/"+policy_code+"/"+facility);	
			System.out.println("payer_group/payerGrp_code>>>>>> "+payer_group+"/"+payerGrp_code);	
			System.out.println("payer/payer_code>>>>>> "+payer+"/"+payer_code);				
			
			
		}
		if(status.equals("E"))
		{
			System.out.println("status E");
			chk_checked="checked";
			disable_flag="";
		}
		else
		{
			System.out.println("ELSE PART ");
			chk_checked="";
			disable_flag="readonly onfocus='this.blur()'";
			chk_value="D";
		}
		
	short_desc_disable="disabled";	

}catch(Exception e)
	{
	System.out.println("Exception is "+e);
	e.printStackTrace();
		}
		finally{
			try{
			if(pstmt!=null) pstmt.close();
			if(rst!=null)rst.close();
			
		}catch(Exception e)
			{
			out.println("Exception is "+e);
			}
		
		}
}


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block11Bytes, _wl_block11);

							try{
							String sqlFacility = "select facility_id, facility_name from Sm_Facility_Param where status = 'E' and facility_id = ? ";
							con = ConnectionManager.getConnection(request);
							pstmt = con.prepareStatement(sqlFacility);
							pstmt.setString(1,facility_id);
							rst = pstmt.executeQuery();

							
							if(rst != null){
								while(rst.next()){ 
									fac_Id=rst.getString("facility_id");
									fac_name=rst.getString("facility_name");
							
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(fac_Id ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fac_name ));
            _bw.write(_wl_block14Bytes, _wl_block14);

								
							}
							}
							}catch(Exception e) {
								System.out.println("currency="+e.toString());
								}
							finally{
							rst.close(); 
							pstmt.close();							
							}
						
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(billingGrp_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(payer_group ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(payerGrp_code ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(payer_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block31Bytes, _wl_block31);
	
			try{		
				pstmt = con.prepareStatement( " SELECT  PATIENT_CLASS,SHORT_DESC  FROM AM_PATIENT_CLASS");
				rst = pstmt.executeQuery();	
				System.out.println("RESULT SET :"+rst);			
				
				
			while(rst.next())
			{				
			//	String patientClass  =  rst.getString(1);
				 pat_classQuery  =  rst.getString(1);
			//	pat_class=!patientClass.substring(0, 1).equalsIgnoreCase("X")?patientClass.substring(0, 1):"R";
				String patClassShortDesc  =  rst.getString(2);						
				
				out.println("Inside while loop >> patClassShortDesc :"+patClassShortDesc);

				
            _bw.write(_wl_block32Bytes, _wl_block32);
if(pat_classQuery.equals(pat_class)){ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pat_classQuery));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( patClassShortDesc ));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else{ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pat_classQuery));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( patClassShortDesc ));
            _bw.write(_wl_block35Bytes, _wl_block35);
} 
            _bw.write(_wl_block37Bytes, _wl_block37);
 out.println("short desc >> patClassShortDesc :"+patClassShortDesc.substring(0, 2)); 
            _bw.write(_wl_block38Bytes, _wl_block38);

			}
			}catch(Exception e) {
				System.out.println("currency="+e.toString());
				}
			finally{
			rst.close(); 
			pstmt.close();
			if(con!=null) {
				ConnectionManager.returnConnection(con, request);
			}
			}
			
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( policy ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(policy_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( priority ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

				if(!(mode.equals("modify")))	  chk_checked = "checked   readonly";
				
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(chk_checked));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block52Bytes, _wl_block52);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(fac_Id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(p_facility_id ));
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_DTL.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PatientClass.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
