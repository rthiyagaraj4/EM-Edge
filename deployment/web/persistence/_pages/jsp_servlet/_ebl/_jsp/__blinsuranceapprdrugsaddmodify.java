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

public final class __blinsuranceapprdrugsaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInsuranceApprDrugsAddModify.jsp", 1715927702304L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BLInsuranceApprDrugs.js\"></script>\n\n</head>\n\n<script language=\'javascript\'>\n\nfunction enableAppy()\n{\n\tparent.commontoolbarFrame.document.forms[0].apply.disabled=false;\n}\n\nfunction checkForSpecChars(event)\n{\n    var strCheck = \'0123456789\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n\nfunction checkNumeric(obj)\n{\n\t\n\tvar dat = obj.value;\n\t \n\tif(dat.charAt(0)==\'.\'  || dat.charAt(1)== \'.\')\n\t\t obj.value =\'\';\n\t\t\nif(isNaN(obj.value) == false)\n\t{\n\tif(obj.value <= 0 && obj.value != \'\')\n\t{\t\n\t\talert(\'Priority value should be greater then  Zero\');\n\t\tobj.value = \'\';\n\t\t}\n\t}\nelse\n\t{\n\tobj.value=\'\';\n\tobj.focus();\n\t}\n\t\t\t\n}\n\nasync function billGrpLkup(billGrp_desc,billGrp_id,empty_chk)\n{\t\t\n\tif(empty_chk==\'Y\' && billGrp_desc.value==\'\')\n\t{\n\t\tbillGrp_id.value = \'\';\n\t\treturn false;\n\t}\n\n\tvar locale  = document.forms[0].locale.value;\t\n\tvar facility_id  = document.forms[0].facility_id.value;\t\n\tvar target\t\t\t= document.forms[0].billingGrp;\t\t\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= getLabel(\"eBL.BillingGroup.label\",\"BL\");\n\n\tvar sql1 = \"select code, description from (SELECT SHORT_DESC description, BLNG_GRP_ID code FROM BL_BLNG_GRP_LANG_VW where status is null and \" +\n                \" settlement_ind = \'X\' AND upper(language_id) = upper(\'\" + locale + \"\') union Select \'All Billing Group\',\'**\' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2\";\n\t\n\tvar argumentArray = new Array();\n\tvar dataNameArray = new Array();\n\tvar dataValueArray = new Array();\n\tvar dataTypeArray = new Array();\n\targumentArray[0] = sql1;\n\targumentArray[1] = dataNameArray;\n\targumentArray[2] = dataValueArray;\n\targumentArray[3] = dataTypeArray;\n\targumentArray[4] = \"2,1\";\t\t\n   \targumentArray[5] = target.value;   \n\targumentArray[6] = DESC_LINK;\n\targumentArray[7] = DESC_CODE;\n\t\n\tretArray = await CommonLookup( title, argumentArray );\t\t\n\tvar ret1=unescape(retArray);\n\t\tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t}\t\n\tif(retArray != null && retArray !=\"\")\n\t{\n\t\tbillGrp_id.value=arr[0];\n\t\tbillGrp_desc.value=arr[1];\t\t\n\t}\n\telse\n\t{\n\t\t//billGrp_id.value=\"\";\n\t\t//billGrp_desc.value=\"\";\t\n\t\tbillGrp_id.value = arr[0]; \n\t\tbillGrp_desc.value = arr[1];\n\t}\t\n\tChkForRecordAvail();\n}\n\nasync function payerGrpLkup(pyrGrp_desc,pyrGrp_code,empty_chk)\n{\t\t\n\tif(empty_chk==\'Y\' && pyrGrp_desc.value==\'\')\n\t{\n\t\tpyrGrp_code.value = \'\';\n\t\treturn false;\n\t}\n\t\n\tvar chkForMandFields1 = chkForMandFields(\'PG\');\n\t\n\tif(!chkForMandFields1)\n\t\treturn false;\n\n\tvar locale  = document.forms[0].locale.value;\t\n\tvar facility_id  = document.forms[0].facility_id.value;\t\n\tvar target\t\t\t= document.forms[0].payerGroup;\t\t\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= getLabel(\"eBL.PAYER_GROUP.label\",\"BL\");\n\n\tvar sql1 = \"select code, description from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and \" +\n                \"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw \" +\n                \"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = \'\" +\n                facility_id +\n                \"\') and upper(language_id) = upper(\'\" +\n                locale +\n                \"\') \" +\n                \"and nvl(patient_flag,\'N\')  =\'Y\' And Nvl(Insurance_Yn, \'N\') = \'Y\' )) \" +\n                \"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = \'\" +\n                facility_id +\n                \"\') and upper(language_id) = upper(\'\" +\n                locale +\n                \"\') union Select \'All Payer Group\',\'**\' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) \" +\n                \" order by 2\";\n\t\n\tvar argumentArray = new Array();\n\tvar dataNameArray = new Array();\n\tvar dataValueArray = new Array();\n\tvar dataTypeArray = new Array();\n\targumentArray[0] = sql1;\n\targumentArray[1] = dataNameArray;\n\targumentArray[2] = dataValueArray;\n\targumentArray[3] = dataTypeArray;\n\targumentArray[4] = \"2,1\";\t\t\n   \targumentArray[5] = target.value;   \n\targumentArray[6] = DESC_LINK;\n\targumentArray[7] = DESC_CODE;\n\t\n\tretArray = await CommonLookup( title, argumentArray );\t\t\n\tvar ret1=unescape(retArray);\n\t\tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t}\n\tif(retArray != null && retArray !=\"\")\n\t{\n\t\tpyrGrp_code.value=arr[0];\n\t\tpyrGrp_desc.value=arr[1];\t\t\n\t}\n\telse\n\t{\n\t\t//pyrGrp_code.value=\"\";\n\t\t//pyrGrp_desc.value=\"\";\t\n\t\tpyrGrp_code.value = arr[0]; \n\t\tpyrGrp_desc.value = arr[1];\n\t}\t\n\tChkForRecordAvail();\n}\n\nasync function payerlkup(payer_desc,payer_code,empty_chk)\n{\t\t\t\n\tif(empty_chk==\'Y\' && payer_desc.value==\'\')\n\t{\n\t\tpayer_code.value = \'\';\n\t\treturn false;\n\t}\n\t\n\tvar chkForMandFields1 = chkForMandFields(\'P\');\n\t\n\tif(!chkForMandFields1)\n\t\treturn false;\t\n\t\n\tvar target\t\t\t= document.forms[0].payer;\t\n\tvar locale  = document.forms[0].locale.value;\t\n\tvar facility_id  = document.forms[0].facility_id.value;\t\t\n\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= encodeURIComponent(getLabel(\"Common.Payer.label\",\"common\"));\n\tvar locale  = document.forms[0].locale.value;\n\n\tvar cust_group_code=document.forms[0].payerGrpCode.value;\n\t\n\tvar sql = \"Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw \" +\n\t\"Where Cust_Code In ( SELECT cust_code \" +\n\t\"FROM bl_cust_by_cust_group \" +\n\t\"WHERE cust_group_code = \" +\n\t\"DECODE (\'\" +\n\tcust_group_code +\n\t\"\', \" +\n\t\"\'**\', cust_group_code, \'\" +\n\tcust_group_code +\n\t\"\')) \" +\n\t\"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = \'\" +\n\tfacility_id +\n\t\"\') \" +\n\t\"and nvl(patient_flag,\'N\')  =\'Y\' \" +\n\t\"and nvl(pat_com_flag,\'N\')=\'N\' \" +\n\t\"And Nvl(Insurance_Yn, \'N\') = \'Y\' And Status Is Null \" +\n\t\"and upper(language_id) = upper(\'\" +\n\tlocale +\n\t\"\') union  Select \'All Payer\',\'**\' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) order by 2\";\n\n\tvar argumentArray = new Array();\n\tvar dataNameArray = new Array();\n\tvar dataValueArray = new Array();\n\tvar dataTypeArray = new Array();\n\targumentArray[0] = sql;\n\targumentArray[1] = dataNameArray;\n\targumentArray[2] = dataValueArray;\n\targumentArray[3] = dataTypeArray;\n\targumentArray[4] = \"2,1\";\n\targumentArray[5] = target.value;\n\targumentArray[6] = DESC_LINK;\n\targumentArray[7] = DESC_CODE;\n\n\tvar returnedValues = await CommonLookup(title, argumentArray);\t\n\tvar ret1=unescape(retArray);\n\t\t\tvar arr=ret1.split(\",\");\n\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t{\n\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t}\t\n\t\n\tif(returnedValues != null && returnedValues !=\"\")\n\t{\n\t\tpayer_code.value=arr[0];\n\t\tpayer_desc.value=arr[1];\t\t\n\t}\n\telse\n\t{\t\n\t\t//payer_code.value=\"\";\n\t\t//payer_desc.value=\"\";\t\n\t\tpayer_code.value = arr[0]; \n\t\tpayer_desc.value = arr[1]; \n\t}\n\t\n\tChkForRecordAvail();\n}\n\nasync function policyLkup(policy_desc,policy_code,empty_chk)\n{\t\t\n\tif(empty_chk==\'Y\' && policy_desc.value==\'\')\n\t{\n\t\tpolicy_code.value = \'\';\n\t\treturn false;\n\t}\n\t\n\tvar chkForMandFields1 = chkForMandFields(\'PL\');\n\t\n\tif(!chkForMandFields1)\n\t\treturn false;\n\t\n\tvar locale  = document.forms[0].locale.value;\t\t\t\n\tvar facility_id  = document.forms[0].facility_id.value;\t\t\t\n\tvar target\t\t\t= document.forms[0].policyType;\t\t\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= getLabel(\"eBL.POLICY.label\",\"BL\");\n\t\n\tvar cust_group_code= document.forms[0].payerGrpCode.value;\n\tvar cust_code= document.forms[0].payerCode.value;\n\t\n\tvar sql=\"SELECT description,code from ( select a.long_desc description, a.policy_type_code code from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id=\'\"+locale+\t\t  \"\' AND (b.cust_group_code =  \'\"+cust_group_code+\"\' OR b.cust_group_code = \'**\') AND (b.cust_code = \'\"+cust_code+\"\' OR b.cust_code = \'**\') \"+\n\t\t\t\" AND a.policy_type_code = b.policy_type_code \"+\n\t\t\t\" AND a.operating_facility_id = \'\"+facility_id+\"\'  AND UPPER (a.language_id) = UPPER (\'\"+locale+\"\') \"+\n\t\t\t\" union  Select \'All Policy\',\'**\' From Dual)\" +\n\t\t\t\" WHERE upper(description) like upper(?) and upper(code) like upper(?) order by 2 \";\n\t\t\t\n\tvar argumentArray = new Array();\n\tvar dataNameArray = new Array();\n\tvar dataValueArray = new Array();\n\tvar dataTypeArray = new Array();\n    argumentArray[0] = sql;\n    argumentArray[1] = dataNameArray;\n    argumentArray[2] = dataValueArray;\n    argumentArray[3] = dataTypeArray;\n    argumentArray[4] = \"2,1\";\n    argumentArray[5] = target.value;\n    argumentArray[6] = DESC_LINK;\n    argumentArray[7] = DESC_CODE;\n\n    var returnedValues =await  CommonLookup(title, argumentArray);\n\tvar ret1=unescape(returnedValues);\n\t\t\t\tvar arr=ret1.split(\",\");\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t}\n    if ((returnedValues != null) && (returnedValues != \"\"))\n\t{\n\t\tpolicy_code.value=arr[0];\n\t\tpolicy_desc.value=arr[1];\t\t\t\n\t}\n\telse\n\t{\n\t\t//policy_code.value=\"\";\n\t\t//policy_desc.value=\"\";\t\n\t\tpolicy_code.value = arr[0]; \n\t\tpolicy_desc.value = arr[1]; \n\t}\t\n\t\n\tChkForRecordAvail();\n}\n\nfunction ChkForRecordA";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="vail(){\n\tvar facilityID = document.forms[0].facilityID.value;\n\tvar billingGrpID = document.forms[0].billingGrpCode.value;\n\tvar payerGroupCode = document.forms[0].payerGrpCode.value;\n\tvar payerCode = document.forms[0].payerCode.value;\n\tvar policyTypeCode = document.forms[0].policyTypeCode.value;\n\t\n\tif(facilityID != \"\" && billingGrpID != \"\" && payerGroupCode != \"\" && payerCode != \"\" && policyTypeCode != \"\"){\n\t\tvar temp_jsp = \"../jsp/BLCommonAjax.jsp?functionMode=ChkForRecordAvail&facilityID=\"+facilityID+\"&billingGrpID=\"+billingGrpID+\"&payerGroupCode=\"+payerGroupCode+\"&payerCode=\"+payerCode+\"&policyTypeCode=\"+policyTypeCode;\n\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\txmlHttp.open(\"POST\", temp_jsp, false);\n\t\txmlHttp.send();\n\t\n\t\tvar retVal = trimString(xmlHttp.responseText);\n\n\t\tif(retVal == \"Y\"){\n\t\t\talert(getMessage(\"CODE_ALREADY_EXISTS\",\"common\"));\n\t\t\t\n\t\t\tdocument.forms[0].billingGrp.value = \"\";\n\t\t\tdocument.forms[0].billingGrpCode.value = \"\";\t\t\t\n\t\t\tdocument.forms[0].payerGroup.value = \"\";\n\t\t\tdocument.forms[0].payerGrpCode.value = \"\";\t\t\t\n\t\t\tdocument.forms[0].payer.value = \"\";\n\t\t\tdocument.forms[0].payerCode.value = \"\";\t\t\t\n\t\t\tdocument.forms[0].policyType.value = \"\";\n\t\t\tdocument.forms[0].policyTypeCode.value = \"\";\n\t\t\tdocument.forms[0].billingGrp.focus();\n\t\t}\n\t}\t\n}\n\nasync function drugLkup(drug_desc,drug_code,empty_chk)\n{\t\t\n\tif(empty_chk==\'Y\' && drug_desc.value==\'\')\n\t{\n\t\tvar clickedTab = \"\";\n\t\tvar qry_string = \"clickedTab=\"+clickedTab+\"&mode=1\";\t\n\t\tparent.ApprovedDrugsFrame.location.href = \"../../eBL/jsp/BLInsuranceApprDrugsApproval.jsp?\"+qry_string;\n\t\t\n\t\tdrug_code.value = \'\';\n\t\treturn false;\n\t}\n\t\n\tvar chkForMandFields1 = chkForMandFields(\'D\');\n\t\n\tif(!chkForMandFields1)\n\t\treturn false;\n\t\n\tvar locale  = document.forms[0].locale.value;\t\t\t\n\tvar facility_id  = document.forms[0].facility_id.value;\t\t\t\n\tvar target\t\t\t= document.forms[0].drugDesc;\t\t\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= getLabel(\"Common.item.label\", \"common\");\n\t\n\tvar cust_group_code= document.forms[0].payerGrpCode.value;\n\tvar cust_code= document.forms[0].payerCode.value;\n\t\t\t\t\t\t\t\t\t\t\n\tvar sql=\"SELECT description,code from ( select DRUG_DESC description, item_code code from ph_drug_lang_vw where language_id=\'\"+locale+\"\' AND DRUG_YN=\'Y\'\" +\n\t\t    \" union  Select \'All Drugs\',\'**\' From Dual)\" +\n\t\t\t\" WHERE upper(description) like upper(?) and upper(code) like upper(?) order by 2 \";\t\t\t\t\t\t\t\t\t\t\n\n\tvar argumentArray = new Array();\n\tvar dataNameArray = new Array();\n\tvar dataValueArray = new Array();\n\tvar dataTypeArray = new Array();\n    argumentArray[0] = sql;\n    argumentArray[1] = dataNameArray;\n    argumentArray[2] = dataValueArray;\n    argumentArray[3] = dataTypeArray;\n    argumentArray[4] = \"2,1\";\n    argumentArray[5] = target.value;\n    argumentArray[6] = DESC_LINK;\n    argumentArray[7] = DESC_CODE;\t\n\t\n\tvar retArray = await CommonLookup(title, argumentArray);\n\tvar ret1=unescape(retArray);\n\t\t\t\tvar arr=ret1.split(\",\");\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t}\t\n\n\tif(retArray != null && retArray !=\"\")\n\t{\n\t\tdrug_code.value=arr[0];\n\t\tdrug_desc.value=arr[1];\t\t\t\n\t\tvar row = \"\";\n\t\t\n\t\tloadInsApprovedDrugsSelDrug(drug_code.value, drug_desc.value);\n\t}\n\telse\n\t{\n\t\t//drug_code.value=\"\";\n\t\t//drug_desc.value=\"\";\n\t\tdrug_code.value = arr[0]; \n\t\tdrug_desc.value = arr[1]; \n\t}\t\n}\n\nfunction loadInsApprovedDrugsList(calledFrm){\n\tvar clickedTab = \"SEARCH\";\n\tvar mode = document.forms[0].mode.value;\n\tvar billingGrp = document.forms[0].billingGrpCode.value;\n\tvar payerGroup = document.forms[0].payerGrpCode.value;\n\tvar payer = document.forms[0].payerCode.value;\n\tvar policyType = document.forms[0].policyTypeCode.value;\t\t\n\t\n\tvar qry_string = \"clickedTab=\"+clickedTab+\"&mode=\"+mode+\"&billingGrp=\"+billingGrp+\"&payerGroup=\"+payerGroup+\"&payer=\"+payer+\"&policyType=\"+policyType+\"&calledFrm=\"+calledFrm;\t\t\n\n\tparent.ApprovedDrugsFrame.location.href = \"../../eBL/jsp/BLInsuranceApprDrugsApproval.jsp?\"+qry_string;\n}\n\n\t\nfunction chkForMandFields(called_frm){\n\tvar billingGrp = document.forms[0].billingGrp.value;\n\tvar payerGroup = document.forms[0].payerGroup.value;\n\tvar payer = document.forms[0].payer.value;\n\tvar policyType = document.forms[0].policyType.value;\n\tvar drugDesc = document.forms[0].drugDesc.value;\n\t\n\tif(called_frm == \"PG\"){\n\t\tif(billingGrp == \"\"){\n\t\t\talert(getMessage(\"BL9301\",\"BL\"));\n\t\t\tdocument.forms[0].billingGrp.focus();\n\t\t\tdocument.forms[0].payerGroup.value = \"\";\n\t\t\tdocument.forms[0].payerGrpCode.value = \"\";\n\t\t\treturn false;\n\t\t}\n\t}\n\t\n\tif(called_frm == \"P\"){\n\t\tif(billingGrp == \"\"){\n\t\t\talert(getMessage(\"BL9301\",\"BL\"));\n\t\t\tdocument.forms[0].billingGrp.focus();\n\t\t\tdocument.forms[0].payer.value = \"\";\n\t\t\tdocument.forms[0].payerCode.value = \"\";\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tif(payerGroup == \"\"){\n\t\t\talert(getMessage(\"BL6277\",\"BL\"));\n\t\t\tdocument.forms[0].payerGroup.focus();\n\t\t\tdocument.forms[0].payer.value = \"\";\n\t\t\tdocument.forms[0].payerCode.value = \"\";\n\t\t\treturn false;\n\t\t}\t\t\n\t}\t\n\n\tif(called_frm == \"PL\"){\n\t\tif(billingGrp == \"\"){\n\t\t\talert(getMessage(\"BL9301\",\"BL\"));\n\t\t\tdocument.forms[0].billingGrp.focus();\n\t\t\tdocument.forms[0].policyType.value = \"\";\n\t\t\tdocument.forms[0].policyTypeCode.value = \"\";\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tif(payerGroup == \"\"){\n\t\t\talert(getMessage(\"BL6277\",\"BL\"));\n\t\t\tdocument.forms[0].payerGroup.focus();\n\t\t\tdocument.forms[0].policyType.value = \"\";\n\t\t\tdocument.forms[0].policyTypeCode.value = \"\";\n\t\t\treturn false;\n\t\t}\n\n\t\tif(payer == \"\"){\n\t\t\talert(getMessage(\"BL0746\",\"BL\"));\n\t\t\tdocument.forms[0].payer.focus();\n\t\t\tdocument.forms[0].policyType.value = \"\";\n\t\t\tdocument.forms[0].policyTypeCode.value = \"\";\n\t\t\treturn false;\n\t\t}\n\t}\t\t\n\t\n\tif(called_frm == \"D\"){\n\t\tif(billingGrp == \"\"){\n\t\t\talert(getMessage(\"BL9301\",\"BL\"));\n\t\t\tdocument.forms[0].billingGrp.focus();\n\t\t\tdocument.forms[0].drugDesc.value = \"\";\n\t\t\tdocument.forms[0].drugCode.value = \"\";\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tif(payerGroup == \"\"){\n\t\t\talert(getMessage(\"BL6277\",\"BL\"));\n\t\t\tdocument.forms[0].payerGroup.focus();\n\t\t\tdocument.forms[0].drugDesc.value = \"\";\n\t\t\tdocument.forms[0].drugCode.value = \"\";\n\t\t\treturn false;\n\t\t}\n\n\t\tif(payer == \"\"){\n\t\t\talert(getMessage(\"BL0746\",\"BL\"));\n\t\t\tdocument.forms[0].payer.focus();\n\t\t\tdocument.forms[0].drugDesc.value = \"\";\n\t\t\tdocument.forms[0].drugCode.value = \"\";\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tif(policyType == \"\"){\n\t\t\talert(getMessage(\"BL9103\",\"BL\"));\n\t\t\tdocument.forms[0].policyType.focus();\n\t\t\tdocument.forms[0].drugDesc.value = \"\";\n\t\t\tdocument.forms[0].drugCode.value = \"\";\n\t\t\treturn false;\n\t\t}\t\t\n\t}\n\t\n\treturn true;\t\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<body  OnLoad=\"enableAppy();loadInsApprovedDrugsList(\'";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\');\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n\t<form name=\"Insurance_BlngLinkForm\" id=\"Insurance_BlngLinkForm\">  \n\t<TABLE width=\"100%\" CELLSPACING=0 cellpadding=3 align=\'center\'>\n\t\t<tr>\n\t\t\t<td  class=\"columnheader\" >Insurance Approved Drugs</td>\n\t\t</tr>\t\n\t</TABLE>\t\n\t<table cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" border=0>\t\t\n\t\t<tr>\n\t\t\t<td width=\'20%\'  nowrap class=\'label\'>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</td>\n\t\t\t<td colspan=\'2\' nowrap class=\'fields\'>\n\t\t\t\t<select name=\'facilityID\' id=\'facilityID\' id=\'facilityID\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" >\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\t\t\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\'20%\' class=\"label\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\" >\n\t\t\t\t<INPUT TYPE=\"TEXT\"  name=\"billingGrp\" id=\"billingGrp\" SIZE=\"30\"  MAXLENGTH=\'40\'\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="  VALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onBlur=\"billGrpLkup(this,document.forms[0].billingGrpCode,\'Y\')\">\n\t\t\t\t<input type= \'hidden\' name=\"billingGrpCode\" id=\"billingGrpCode\"  value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"billingGrpBut\" id=\"billingGrpBut\" value=\'?\'  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" onClick=\"billGrpLkup(document.forms[0].billingGrp,document.forms[0].billingGrpCode)\" tabindex=\'2\' >\t\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\t\t \n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\'20%\' nowrap class=\'label\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td width=\'25%\' nowrap class=\'fields\' >\n\t\t\t\t<input type=\'text\' name=\'payerGroup\' id=\'payerGroup\' size=\'30\' maxlength=\'40\'   ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="  value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onblur=\"payerGrpLkup(this,document.forms[0].payerGrpCode,\'Y\')\"/>\n\t\t\t\t<input type=\'hidden\' name=\'payerGrpCode\' id=\'payerGrpCode\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"payerGroupBtn\" id=\"payerGroupBtn\" value=\'?\'  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" onClick=\"payerGrpLkup(document.forms[0].payerGroup,document.forms[0].payerGrpCode)\" tabindex=\'2\'>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td> \t\n\t\t</tr>\t\n\n\t\t<tr>\t\t\t\t\t\t\n\t\t\t<td  width=\"20%\" class=\"label\" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\t\n\t\t\t<td  width=\"25%\" class=\"fields\" >\n\t\t\t\t<INPUT TYPE=\"TEXT\"  name=\"payer\" id=\"payer\" SIZE=\"30\"  MAXLENGTH=\'40\'\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onBlur=\"payerlkup(this,document.forms[0].payerCode,\'Y\')\"/>\n\t\t\t\t<input type= \'hidden\' name=\"payerCode\" id=\"payerCode\"  value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"payerBtn\" id=\"payerBtn\" value=\'?\'  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onClick=\"payerlkup(document.forms[0].payer,document.forms[0].payerCode)\" tabindex=\'2\'>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\'20%\' nowrap class=\'label\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t<td width=\'25%\' nowrap class=\'fields\' >\n\t\t\t\t<input type=\'text\' name=\'policyType\' id=\'policyType\' size=\'30\' maxlength=\'40\'  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="  value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onblur=\"policyLkup(this,document.forms[0].policyTypeCode,\'Y\')\"/>\n\t\t\t\t<input type=\'hidden\' name=\'policyTypeCode\' id=\'policyTypeCode\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"policyType_btn\" id=\"policyType_btn\" value=\'?\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" onClick=\"policyLkup(document.forms[0].policyType,document.forms[0].policyTypeCode)\" tabindex=\'2\'>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>   \n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\'20%\' nowrap class=\'label\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t<td width=\'25%\' nowrap class=\'fields\' >\n\t\t\t\t<input type=\'text\' name=\'drugDesc\' id=\'drugDesc\' size=\'30\' maxlength=\'40\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' onblur=\"drugLkup(this,document.forms[0].drugCode,\'Y\')\"/>\n\t\t\t\t<input type=\'hidden\' name=\'drugCode\' id=\'drugCode\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"drug_btn\" id=\"drug_btn\" value=\'?\' onClick=\"drugLkup(document.forms[0].drugDesc,document.forms[0].drugCode)\" tabindex=\'2\'>\n\t\t\t</td>   \n\t\t</tr>\t\t\t\n\t\t<tr>\n\t\t\t<td  class=\"columnheader\" colspan=2>&nbsp;</td>\n\t\t</tr>\t\t\t\n\t</table>\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\'hidden\' name=\"facility_id\" id=\"facility_id\"  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\'hidden\' name=\"facility\" id=\"facility\"  value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\'hidden\' name=\"strloggeduser\" id=\"strloggeduser\"  value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\'hidden\' name=\"strclientip\" id=\"strclientip\"  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n</form>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );
 
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
String drugCode = "";
String drugDesc = "";
String calledFrm = "";

String p_facility_id="", strloggeduser = "", strclientip = "";

String pat_classQuery="";
String fac_Id="";
String fac_name="";

HttpSession httpSession = request.getSession(false);
Properties p = (Properties)httpSession.getValue("jdbc");


locale	= (String)session.getAttribute("LOCALE");	
p_facility_id = (String)httpSession.getValue("facility_id");

strloggeduser	=  (String) session.getValue("login_user");	
if (strloggeduser==null) strloggeduser = "";

strclientip = p.getProperty("client_ip_address");
if (strclientip==null) strclientip = "";

String OpYn				=	checkForNull("","N");
String EmYn				=	checkForNull("","N");
String IpYn				=	checkForNull("","N");
String DcYn				=	checkForNull("","N");
String AllYn			=   checkForNull("","N");
String enableEpiType	=   "enabled";

calledFrm = request.getParameter("calledFrm");
if(calledFrm == null) calledFrm = "";

session.removeAttribute("sel_drug_list");
System.err.println("sel_drug_list from session:"+session.getAttribute("sel_drug_list"));

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            out.print( String.valueOf(calledFrm));
            _bw.write(_wl_block8Bytes, _wl_block8);

try
{
	con=ConnectionManager.getConnection(request);
	String mode=request.getParameter("mode");

	String billingGrpCode=checkForNull(request.getParameter("blngGroup"));
	String payerGrpCode=checkForNull(request.getParameter("payerGroup"));
	String payerCode=checkForNull(request.getParameter("payer"));
	String policyTypeCode=checkForNull(request.getParameter("policyType"));

	String patient_class=checkForNull(request.getParameter("patientClass"));
	String facility=checkForNull(request.getParameter("oprFacId"));
	 
	String strLongDesc="";
	String status="";
	String sql="";

	String disabled = "";

	System.err.println("mode>>>>>>>>>"+mode);

	if(mode.equals("modify"))
	{
		try
		{
			disabled = "disabled";			
			int column_count = 1;
			sql="SELECT decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, hdr.CUST_GROUP_CODE, "+
	        "decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, hdr.CUST_CODE, "+
	        "decode(hdr.policy_type_code,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )) policy_type, "+
		    "hdr.POLICY_TYPE_CODE,hdr.operating_facility_id, "+
		    "decode(hdr.BLNG_GRP_ID,'**','All Billing Group',(select bil.SHORT_DESC  from BL_BLNG_GRP bil where bil.BLNG_GRP_ID = hdr.BLNG_GRP_ID)) bill_desc, hdr.BLNG_GRP_ID "+
	        "FROM BL_PH_DRUG_AGREEMENT hdr	WHERE BLNG_GRP_ID=? AND CUST_GROUP_CODE=? "+
	        "AND OPERATING_FACILITY_ID=? ";
	  
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
			System.err.println("sql in modify:"+sql);
			
			pstmt=con.prepareStatement(sql);

			System.err.println("billingGrpCode/payerGrpCode/payerCode/policyTypeCode/facility "+billingGrpCode+"/"+payerGrpCode+"/"+payerCode+"/"+policyTypeCode+"/"+facility);
			/* Fixed SQL Injection for Common-ICN-0222 */
			pstmt.setString(column_count, billingGrpCode);
			pstmt.setString(++column_count, payerGrpCode);
			pstmt.setString(++column_count, facility);
			if(!"".equals(payerCode)){
				pstmt.setString(++column_count, payerCode);
			}
			if(!"".equals(policyTypeCode)){
				pstmt.setString(++column_count, policyTypeCode);
			}

			rst = pstmt.executeQuery();
			if(rst!=null && rst.next())
			{   			
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
			}
		}catch(Exception e)
		{
			//System.out.println("Exception is "+e);
			e.printStackTrace();
		}
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block11Bytes, _wl_block11);

				try
				{
					String sqlFacility = "select facility_id, facility_name from sm_facility_param_lang_vw where status = 'E' and language_id = ? and facility_id = ?";
					pstmt = con.prepareStatement(sqlFacility);
					pstmt.setString(1,locale);
					pstmt.setString(2,facility_id);
					rst = pstmt.executeQuery();

					if(rst != null){
						while(rst.next()){ 
							fac_Id=rst.getString("facility_id");
							fac_name=rst.getString("facility_name");
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(fac_Id ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fac_Id.equals(p_facility_id) ? "selected" : ""));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fac_name ));
            _bw.write(_wl_block15Bytes, _wl_block15);

						}
					}
				}catch(Exception e) 
				{
					System.err.println("facility list="+e.toString());
				}
			
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(billingGrp_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(payer_group ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(payerGrp_code ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(payer_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( policy ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(policy_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( drugDesc ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drugCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(p_facility_id ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(p_facility_id ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strloggeduser ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strclientip ));
            _bw.write(_wl_block44Bytes, _wl_block44);

} catch(Exception e) {
	System.err.println("Exception in BLInsuranceApprDrugsAddModify.jsp ->"+e.toString());
}
finally
{
	if(pstmt!=null) pstmt.close();
	if(rst!=null)rst.close();						
	ConnectionManager.returnConnection(con, request);	
}

            _bw.write(_wl_block45Bytes, _wl_block45);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
}
