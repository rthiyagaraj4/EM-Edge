package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import eBL.BLReportIdMapper;
import eBL.Common.BLHelper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetails2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetails2.jsp", 1743572483082L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<!--For Date Validation-->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script> \n<script language=\'javascript\' src=\'../js/AddModifyPatFinClassDetails.js\'></script>\n<script language=\"javascript\" src=\'../js/AddModifyPatFinDetailsPkgDiscDtls.js\'></script> \n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script language=\"javascript\" src=\'../../eBL/js/BLeGLInterface.js\'></script>\n<script language=\'javascript\' src=\'../../eXH/js/ExternalApplication.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\'javascript\'>\n\nfunction funDisable(flag)\n{\n\tvar oper = document.forms[0].operation_fun.value;\n\tvar cust_id =parent.parent.frames[0].document.forms[0].customer_id.value;\n\tvar calling_function_id = document.forms[0].function_id.value;\n\tvar operation=document.forms[0].operation.value;\n\tvar booleanSecurity = parent.parent.frames[0].document.forms[0].boolean_security.value;\n\tvar SiteSpecific =parent.parent.frames[0].document.forms[0].SiteSpecific.value;\n\tvar mode = document.forms[0].operation_mode.value;\n\tvar varSettlementInd =\"\";\n\tvar varModuleId = \"\";\n\tvar SettlementInd = document.forms[0].setlmt_ind.value;\n\tvar ModuleId = document.forms[0].calling_module_id.value;\t\n\t\n\tvar payerGrpBySetup= document.forms[0].payerGrpBySetup.value;\n\n\ttry\n\t{\n\t\tvar bl_data_from_repos_yn = document.forms[0].bl_data_from_repos_yn.value;\n\n\t\tif (  (bl_data_from_repos_yn == \'Y\')  && ( varModuleId  ==\'MP\') )\n\t\t{\n\t\t\tif(document.forms[0].credit_doc_start_date1.value==\'\')\n\t\t\t{ \n\t\t\t\tdocument.forms[0].credit_doc_start_date1.value = document.forms[0].sys_date.value;\n\t\t\t}\n\t\t}\n\t}\n\tcatch(e)\n\t{\n\t}\n\n\tif (flag == 1) \n\t{\n\t\tif(\'Y\'!=payerGrpBySetup)\n\t\t{\n\t\tdisableAllElements();\n\t\tdisableFields();\n\t\t\n\t\t}\n\t\tif (varSettlementInd == \"C\" && (varModuleId==\"OP\" ||varModuleId==\"AE\" || varModuleId==\"IP\" || varModuleId==\"DC\" ) )\n\t\t{\n\t\t\t//If Condition for cash_set_type1 is added throughout the Page to fix Script error - Rajesh V\n\t\t\tif(document.forms[0].cash_set_type1 != undefined){\n\t\t\t\tdocument.forms[0].cash_set_type1.disabled = false;\n\t\t\t}\t\t\t\t\n\t\t}\n\t\tdisableFields();\n\t\treturn;\n\t}\n\t\n\ttry\n\t{\n\t\tvar setValue =\"\";\n\t\tif (varSettlementInd == \"C\" && (varModuleId==\"OP\" ||varModuleId==\"AE\"|| varModuleId==\"IP\" || varModuleId==\"DC\") )\n\t\t{\n\t\t\ttry\n\t\t\t{\n\t\t\t\tif(document.forms[0].cash_set_type1 != undefined){\n\t\t\t\t\tfor(i=0;i<document.forms[0].cash_set_type1.options.length;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar cashSetValue = document.forms[0].cash_set_type1.options[i].value;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif (cashSetValue == null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tcontinue;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar len = cashSetValue.length;\n\t\t\t\t\t\tvar subValue =\"\";\n\t\t\t\t\t\tif (len >0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tsubValue = cashSetValue.substring(len-1,len);\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif (subValue  == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].cash_set_type1.value = cashSetValue;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tcatch(e)\n\t\t\t{\n\t\t\t}\n\t\t\t//document.forms[0].cash_set_type1.remove(document.forms[0].cash_set_type1.options[0]);\n\t\t\tif(document.forms[0].cash_set_type1 != undefined){\n\t\t\t\tdocument.forms[0].cash_set_type1.disabled = false;\n\t\t\t}\n\t\t\tif(document.forms[0].cash_set_type1 != undefined){\n\t\t\tdisableFields();\n\t\t\t}\n\t\t}\n\t}\n\tcatch(e)\n\t{\n\t}\n\t\n\tdisableFields();\n}\n\t\nfunction disableFields(){\n\tvar operation=document.forms[0].operation.value;\n\tvar booleanSecurity = parent.parent.frames[0].document.forms[0].boolean_security.value;\n\tvar SiteSpecific =parent.parent.frames[0].document.forms[0].SiteSpecific.value;\n\tvar ModuleId = document.forms[0].calling_module_id.value;\n\tvar calling_function_id = document.forms[0].function_id.value;\n\tif(calling_function_id == \"PAT_REG\" && (operation ==\"Insert\" || operation ==\"Update\") && SiteSpecific== \"Y\" && booleanSecurity== \"true\")\n\t{  \n\t\tif(document.forms[0].cash_set_type1 != undefined && document.forms[0].cash_set_type1 != null  ){\n\t\t\tdocument.forms[0].cash_set_type1.disabled = true;\t\n\t\t}\t\t\n\t}\n}\n\nfunction showCalendar_loc(Val1, Val2)\n{\t\n\tif (Val2.disabled == true)\t\t\n\t{\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\treturn showCalendar(Val1);\n\t}\n}\n\nasync function noninsblnggrplkup()\n{\t\t\n\tvar target\t\t\t= document.forms[0].non_ins_billing_group_desc;\t\t\n\tvar billinggroup    = document.forms[0].non_insur_blng_grp.value;\t\n\tvar retVal\t\t\t= new String();\t\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar sql1\t\t\t\t= \"\";\t\t\n\t\t\n//\tvar title=\"Non-Insurance Billing Groups\";\n\tvar title=getLabel(\"eBL.NON_INS_BILLING_GROUP.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"10%,30%,60%\");\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\tvar expnote=getLabel(\"eBL.EXPLANATORY_NOTE.label\",\"BL\");\n\texpnote=encodeURIComponent(expnote);\n\tvar column_descriptions = code+\",\"+desc+\",\"+expnote;\n\n//\tvar column_descriptions = escape(\"Code,Description,Explanatory Note\"); \n\n\tvar message = \'\';\t\t\n\tmessage=encodeURIComponent(message);\n\tvar strCitizenYn = document.forms[0].CitizenYn.value;\n\tvar strModuleId = document.forms[0].calling_module_id.value;\n\tvar locale = document.forms[0].locale.value;\n\n\tsql1 = \"select blng_grp_id BLG_GP,rpad(short_desc,15,\' \')||\' (\' || decode(settlement_ind|| adm_rec_flag, \'C\',\t\'CASH\', \'C0\',\'CASH\',\'C1\',\'CASH\',\'C2\',\'CASH\',\'R\', \'CREDIT\',\'R0\', \'CREDIT\',\'R1\', \'CREDIT\',\'R2\', \'CREDIT\',\'X1\', \'SPONSOR\',\'X2\',\'INSURANCE\')||\')\' SRT_DESC,replace(detail_desc,chr(10),\'<br>\') DTL_DESC from bl_blng_grp_lang_vw where language_id=\'\"+locale+\"\' and status is null and settlement_ind || adm_rec_flag != \'X2\' and ((\'\"+strModuleId+\"\'=\'MP\' and ref_yn = \'Y\' and ref_valid_for_regn_yn = \'Y\') or (\'\"+strModuleId+\"\'=\'AE\' and ae_yn = \'Y\') or (\'\"+strModuleId+\"\'=\'OP\' and op_yn = \'Y\') or (\'\"+strModuleId+\"\'=\'IP\' and ip_yn = \'Y\') or (\'\"+strModuleId+\"\'=\'DC\' and dy_yn = \'Y\')) and (NVL(category,\'UNRESTRICTED\') IN ( DECODE(\'\"+strCitizenYn+\"\',\'Y\',\'NATIONALS\',\'N\',\'OTHERS\',\'UNRESTRICTED\'), \'UNRESTRICTED\'))\";\t\t\t\t\t\t\t\n\n\tsql = escape(sql1);\t\t\t\t\t\t\t\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message;\n\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\n\tvar arr=new Array();\t\t\n\n    if(retVal == null) retVal=\'\';\n\n\tif (retVal != null || retVal!=\"\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\t \n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\t\t\t   \n\n\t   \t\tdocument.forms[0].non_ins_billing_group_desc.value=arr[1];\n\t\t\tdocument.forms[0].non_insur_blng_grp.value=arr[0];\t\t\t\t\t  \n\n\t\t\tdocument.forms[0].blnggrpappyn.value = \"Y\";\n\t\t\tdocument.forms[0].BlngGrpStatus.value = \"\";\n\t\t\tdocument.forms[0].blnggrpcatgappyn.value = \"Y\";\n\t\t\t\t   \n\t\t\tcallNonInsurance(document.forms[0].non_insur_blng_grp);\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttarget.focus();\n\t\t}\n\t}\n}\n\nasync function getNonInsBlngGrpSearch()\n{\n\tvar billing_group=document.forms[0].non_insur_blng_grp.value;\t\t\n\n\tif(billing_group==\"select\") billing_group=\"\";\t\t\n\t\t\n\tif((billing_group!=\"\"))\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"15\" ;\n\t\tvar dialogWidth\t= \"43\" ;\n\t\tvar dialogTop = \"205\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLBillingGrpDet.jsp?billing_group=\t\"+billing_group;\n\t\tretVal = await window.showModalDialog(url,arguments,features);\n\t}\n}\n\nfunction valfield(obj)\n{\n\tif (obj.value != \'\')\n\t{\n\t\tif (parseInt(obj.value) < 0 )\n\t\t{\n\t\t\talert(\"BL9520\",\"BL\");\n\t\t\tobj.focus();\n\t\t}\n\t}\n\treturn 1;\n}\n\nasync function getCustDet()\n{\n\tvar cust_1=document.forms[0].cust_1.value;\t\t\t\t\n\t\n\tif(cust_1==\"select\") cust_1=\"\";\n\tif(cust_1==\"\")\n\t{\n\t\t//document.forms[0].cust_1.focus();\n\t\t//document.forms[0].cust_1_desc.focus();\n\t}\n\t\t\t\t\n\tif((cust_1!=\"\"))\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"14\" ;\n\t\tvar dialogWidth\t= \"23\" ;\n\t\tvar dialogTop = \"350\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLCustomerDet.jsp?cust_code=\"+cust_1;\n\t\tretVal = await window.showModalDialog(url,arguments,features);\n\t}\n}\n\nasync function getCustDetSponser()\n{\n\tvar cust_2=document.forms[0].cust_2.value;\n\t\n\tif(cust_2==\"select\") cust_2=\"\";\n\tif(cust_2==\"\")\n\t{\n\t\t//document.forms[0].cust_2_desc.focus();\n\t}\n\tif((cust_2!=\"\"))\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"60vh\" ;\n\t\tvar dialogWidth\t= \"70vw\" ;\n\t\tvar dialogTop = \"0\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLCustomerDet.jsp?cust_code=\"+cust_2;\n\t\tretVal = await top.window.showModalDialog(url,arguments,features);\n\t}\n}\n\nfunction changeOnSelectCustomerGrp(selectObj)\n{\n\tvar cust_1 = selectObj.value;\n\tvar optlength = document.forms[0].cust_1.options.length;\n\tvar slmt_ind  = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\tvar adm_rec_flag  = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\tvar module_id = document.forms[0].calling_module_id.value;\t\t\t\t\n\n\tfor (var i=0; i<optlength; i++)\n\t{\n\t\tdocument.forms[0].cust_1.options.remove(\"cust_1\");\n\t}\n\t\t\t\n\tif((cust_1==\"\") ||(cust_1==\"select\")) \n\t{\t\t\t\t\n\t\tvar cust_code\t= \'select\';\n\t\tvar short_desc\t= \'         ---- Select ----         \';\n\t\tvar opt=document.createElement(\'OPTION\'); \n\t\topt.text\t=\tshort_desc; \n\t\topt.value\t=\tcust_code; \n\t\tdocument.forms[0].cust_1.add(opt); \n\t\tdocument.forms[0].cust_1.selectedIndex = 0;\n\t\t//return false;\n\t}\n\n\tvar HTMLVal=\"<html><body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'><form name=\'BLCustomerForm\' id=\'BLCustomerForm\' method=\'post\' action=\'../../eBL/jsp/BLCustomerCode.jsp\'>\"+\n\t\t\t\"<input type=\'hidden\' name=\'cust_group_code\' id=\'cust_group_code\' value=\\\"\"+cust_1+\"\\\">\"+\n            \"<input type=\'hidden\' name=\'slmt_ind\' id=\'slmt_ind\' value=\\\"\"+slmt_ind+\"\\\">\"+ \n\t\t\t\"<input type=\'hidden\' name=\'adm_rec_flag\' id=\'adm_rec_flag\' value=\\\"\"+adm_rec_flag+\"\\\">\"+\n            \"<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\\\"\"+module_id+\"\\\">\"+\n\t\t\t\"</form></body></html>\";\n\t\t\t\n\tparent.parent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\tparent.parent.frames[2].document.BLCustomerForm.submit();\n\n\treturn true;\n}\n\nfunction changeOnSelectCustomerGrp2(selectObj)\n{\n\tvar cust_2 = selectObj.value;\n\tvar optlength = document.forms[0].cust_2.options.length;\n\tvar slmt_ind  = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\tvar module_id = document.forms[0].calling_module_id.value;\t\t\t\t\n\n\tfor (var i=0; i<optlength; i++)\n\t{\n\t\tdocument.forms[0].cust_2.options.remove(\"cust_2\");\n\t}\t\t\t\t\n\n\tif((cust_2==\"\") ||(cust_2==\"select\")) \n\t{\t\t\t\t\n\t\tvar cust_code\t= \'select\';\n\t\tvar short_desc\t= \'         ---- Select ----         \';\n\t\tvar opt=document.createElement(\'OPTION\'); \n\t\topt.text\t=\tshort_desc; \n\t\topt.value\t=\tcust_code; \n\t\tdocument.forms[0].cust_2.add(opt); \n\t\tdocument.forms[0].cust_2.selectedIndex = 0;\n\t\t//return false;\n\t}\t\t\t\n\t\t\t\n\tvar HTMLVal=\"<html><body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'><form name=\'BLCustomerForm\' id=\'BLCustomerForm\' method=\'post\' action=\'../../eBL/jsp/BLCustomerCode.jsp\'>\"+\n\t\t\t\"<input type=\'hidden\' name=\'cust_group_code\' id=\'cust_group_code\' value=\\\"\"+cust_2+\"\\\">\"+\n            \"<input type=\'hidden\' name=\'slmt_ind\' id=\'slmt_ind\' value=\\\"\"+slmt_ind+\"\\\">\"+ \n\t\t\t\"<input type=\'hidden\' name=\'adm_rec_flag\' id=\'adm_rec_flag\' value=\\\"\"+adm_rec_flag+\"\\\">\"+\n            \"<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\\\"\"+module_id+\"\\\">\"+\n\t\t\t\"</form></body></html>\";\n\t\t\t\n\tparent.parent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\tparent.parent.frames[2].document.BLCustomerForm.submit();\n\n\treturn true;\t\t\t\n}\n\nasync function credit_custgrouplkup(clng_evnt)\n{\n\n\tvar site_id= document.forms[0].site_id.value;\n\tvar autoFinChk = document.forms[0].autoFinChk.value;\n\tvar target\t\t\t\t= document.forms[0].cust_group_desc_1;\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].cust_group_desc_1.value=\'\';\n\t\t\tdocument.forms[0].cust_group_code_1.value = \'\';\n\t\t\treturn;\n\t\t}\n\t}\n\tvar msg=\"\";\n\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar message\t\t\t\t= \"\";\n\tif(site_id == \'true\'){\n\t\tvar column_sizes = escape(\"25%,35%,40%\");\n\t}else{\n\tvar column_sizes = escape(\"30%,70%\");\n\t}\n\tvar locale = document.forms[0].locale.value;\n\t\t\n\tif (autoFinChk == \"Y\")\n\t{\n\t\t\t\tvar blng_grp_id = document.forms[0].billing_group.value;\n\t\tvar class_code = document.forms[0].class_code.value;\n\t\tif(site_id == \'true\'){\n\t\tsql = \" SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME,b.LONG_DESC LONG_DESC FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id=\'\"+locale+\"\' AND a.CLASSIFICATION_CODE = \'\"+class_code+\"\' AND a.APPL_BLNG_GRP_ID = \'\"+blng_grp_id+\"\' AND b.status IS NULL\";\n\t\t}else{\n\t\t\tsql = \" SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id=\'\"+locale+\"\' AND a.CLASSIFICATION_CODE = \'\"+class_code+\"\' AND a.APPL_BLNG_GRP_ID = \'\"+blng_grp_id+\"\' AND b.status IS NULL\";\n\t\t}\n\t\t}\n\telse\n\t{\n\t\tif(site_id == \'true\'){\n\t\tsql = \"\tselect cust_group_code cust_group_code,short_desc short_name,LONG_DESC LONG_DESC from ar_cust_group_lang_vw where language_id=\'\"+locale+\"\' and status is null\";\n\t\t}else{\n\t\t\tsql = \"\tselect cust_group_code cust_group_code,short_desc short_name from ar_cust_group_lang_vw where language_id=\'\"+locale+\"\' and status is null\";\n\n\t\t}\n\t}\n\n\tvar title=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\"); \n\ttitle=encodeURIComponent(title);\t\n\tif(site_id == \'true\'){\n\tvar code=getLabel(\"eBL.CustomerGroupCode.label\",\"BL\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"eBL.description.label\",\"eBL\");\n\tdesc=encodeURIComponent(desc);\n\tvar cust_group_long_name=getLabel(\"eBL.long_desc.label\",\"BL\");\n\tcust_group_long_name=encodeURIComponent(cust_group_long_name);\n\t}else{\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\t}\n\tif(site_id == \'true\'){\n\tcolumn_descriptions = code+\",\"+desc+\",\"+cust_group_long_name;\n\t}else{\n\t\tcolumn_descriptions = code+\",\"+desc;\n\t}\n\tsql = escape(sql);\n\tif(site_id == \'true\'){\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYY\";\n\t}else{\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\t\n\t}\n\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"^~^\");\n\t\n\t\tdocument.forms[0].cust_group_desc_1.value=arr[1];\n\t    document.forms[0].cust_group_code_1.value=arr[0];\n\t  \n\t\tchk_for_gl_valid(document.forms[0].credit_doc_ref1);\n\t}\n\telse\n\t{\t\n\t\tdocument.forms[0].cust_group_desc_1.value=\'\';\n\t    document.forms[0].cust_group_code_1.value=\'\';\t\t\t\t\t\t\t\t\t\t\t\t\n\t}\n\t\n}\n\nasync function custgrouplkup1(clng_evnt)\n{\t\n\tvar autoFinChk = document.forms[0].autoFinChk.value;\n\n\tvar target\t\t\t\t= document.forms[0].cust_group_desc_2;\n\tvar locale = document.forms[0].locale.value;\n\tvar site_id= document.forms[0].site_id.value;\n\tvar selecltd_cust_grp_frm_pkg = document.forms[0].selecltd_cust_grp_frm_pkg.value;\n\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].cust_group_desc_2.value=\'\';\n\t\t\tdocument.forms[0].cust_group_code_2.value = \'\';\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar message=\"\";\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"0\";\n\tvar dialogHeight\t\t= \"60vh\" ;\n\tvar dialogWidth\t\t\t= \"70vw\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tif(site_id == \'true\'){\n\t\t\n\t\tvar column_sizes = escape(\"25%,35%,40%\");\n\t\t}else{\n\t\tvar column_sizes = escape(\"30%,70%\");\n\t\t}\n\t\n\n\tvar locale = document.forms[0].locale.value;\n\t\n\tif (autoFinChk == \"Y\")\n\t{\n\t\t\t\tvar blng_grp_id = document.forms[0].billing_group.value;\n\t\tvar class_code = document.forms[0].class_code.value;\n\t\tif(site_id == \'true\'){\n\t\tsql = \" SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME,b.LONG_DESC LONG_DESC FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id=\'\"+locale+\"\' AND a.CLASSIFICATION_CODE = \'\"+class_code+\"\' AND a.APPL_BLNG_GRP_ID = \'\"+blng_grp_id+\"\' AND b.status IS NULL\";\n\t\t}else{\n\t\t\tsql = \" SELECT DISTINCT a.appl_cust_group_code CUST_GROUP_CODE, b.SHORT_DESC SHORT_NAME FROM BL_APPL_BG_BY_CLASSFCTN a, ar_cust_group_lang_vw b WHERE a.appl_cust_group_code = b.CUST_GROUP_CODE AND language_id=\'\"+locale+\"\' AND a.CLASSIFICATION_CODE = \'\"+class_code+\"\' AND a.APPL_BLNG_GRP_ID = \'\"+blng_grp_id+\"\' AND b.status IS NULL\";\n\t\t}\n\t\t}\n\telse\n\t{\n\t\tif(site_id == \'true\'){\n\t\tsql = \"\tselect cust_group_code cust_group_code,short_desc short_name,LONG_DESC LONG_DESC from ar_cust_group_lang_vw where language_id=\'\"+locale+\"\' and status is null\";\n\t\t}else{\n\t\t\tsql = \"\tselect cust_group_code cust_group_code,short_desc short_name from ar_cust_group_lang_vw where language_id=\'\"+locale+\"\' and status is null\";\n\n\t\t}\n\t}\n\n\tif(selecltd_cust_grp_frm_pkg != \"\")\n\t{\n\t\tvar cust_group_arr = selecltd_cust_grp_frm_pkg.split(\"@@\");\n\t\t\n\t\tsql = sql + \" and cust_group_code in (\'\";\n\t\tfor(var i=0;i<cust_group_arr.length;i++)\n\t\t{\n\t\t\t\n\t\t\tif(i != (cust_group_arr.length-1))\n\t\t\t\tsql = sql + cust_group_arr[i] + \"\',\'\";\n\t\t\telse\n\t\t\t\tsql = sql + cust_group_arr[i] +\"\')\";\n\t\t}\n\t\t\n\t}\n\n\tvar title=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\"); \n\ttitle=encodeURIComponent(title);\t\n\tif(site_id == \'true\'){\n\tvar code=getLabel(\"eBL.CustomerGroupCode.label\",\"BL\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"eBL.description.label\",\"eBL\");\n\tdesc=encodeURIComponent(desc);\n\tvar cust_group_long_name=getLabel(\"eBL.long_desc.label\",\"BL\");\n\tcust_group_long_name=encodeURIComponent(cust_group_long_name);\n\t}else{\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\t}\n\tif(site_id == \'true\'){\n\t\n\tcolumn_descriptions = code+\",\"+desc+\",\"+cust_group_long_name;\n\t}else{\n\t\tcolumn_descriptions = code+\",\"+desc;\n\t}\n\tsql = escape(sql);\n\t\n\tif(site_id == \'true\'){\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYY\";\n\t}else{\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\t\n\t}\n\n\t\n\n\n\tretVal=await top.window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n\t\t\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"^~^\");\n\t\t\n\t\tdocument.forms[0].cust_group_desc_2.value=arr[1];\n\t    document.forms[0].cust_group_code_2.value=arr[0];\t\n\t\tchk_for_gl_valid(document.forms[0].credit_doc_ref2);\n\t}\n\telse\n\t{\t\n\t\tdocument.forms[0].cust_group_desc_2.value=\'\';\n\t    document.forms[0].cust_group_code_2.value=\'\';\t\t\t\t\t\t\t\t\t\t\t\t\n\t}\n}\n/*\nfunction cust1grouplkup()\n{\t\n\tvar msg=\"\";\n\tvar target\t\t\t= document.forms[0].cust_1_desc;\n\tvar retVal\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t= \"\";\n\tvar search_desc\t\t\t= \"\";\n\tvar tit\t\t\t\t= \"\";\t\t\n\tvar ModuleId     = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13_0 ="\';\n\tvar custgroup = document.forms[0].cust_group_1.value;\n\tvar locale = document.forms[0].locale.value;\n\n\tvar cust_valid_frm=getLabel(\"eBL.VALID_FROM.label\",\"BL\");\n\tcust_valid_frm=encodeURIComponent(cust_valid_frm);\t\n\tvar cust_valid_to=getLabel(\"eBL.VALID_TO.label\",\"BL\");\n\tcust_valid_to=encodeURIComponent(cust_valid_to);\t\n\t\t\n\tsql = \"\tselect cust_code, short_name,to_char(a.VALID_FROM,\'dd/mm/yyyy\') VALID_FROM,to_char(a.VALID_TO,\'dd/mm/yyyy\') VALID_TO from ar_customer_lang_vw where language_id=`\"+locale+\"` and patient_flag = `Y` and pat_com_flag = `Y` and status is null and ((`\"+ModuleId+\"` in (`OP`,`AE`) and nvl(op_yn,`N`) = `Y`) or (`\"+ModuleId+\"` in (`IP`,`DC`) and nvl(ip_yn,`N`) = `Y`) or (`\"+ModuleId+\"` = `MP` and nvl(ref_yn,`N`) = `Y`)) and (( cust_group_code = `\"+custgroup+\"` and  `\"+custgroup+\"` is not null ) or `\"+custgroup+\"` is null )\";\t\n\t\t\n\tsearch_code=\"cust_code\";\n\tsearch_desc=\"short_name\";\n//\ttit=\"Customers \"; \n\ttit=getLabel(\"Common.Customer.label\",\"common\"); \n\ttit=encodeURIComponent(tit);\t\t\n\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n\t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"::\");\n\t\t\n\t\tdocument.forms[0].cust_1_desc.value=arr[0];\n\t    document.forms[0].cust_1.value=arr[1];\t\t\t\t\t\n\t}\n\telse\n\t{\t\t\t\t\n\t\tdocument.forms[0].cust_1_desc.value=\'\';\n\t\tdocument.forms[0].cust_1.value = \'\';\n\t\n\t\ttarget.focus();\n\t}\n}\n*/\n/* Function for Credit Customer Lkup */\nasync function credit_custlkup(clng_evnt)\n{\t\t\n\tvar autoFinChk = document.forms[0].autoFinChk.value;\n\tvar package_enabled_yn=document.forms[0].package_enabled_yn.value;\n\tvar target\t\t\t= document.forms[0].cust_1_desc;\t\n\tvar calling_module_id = document.forms[0].calling_module_id.value;\n\tvar site_id= document.forms[0].site_id.value;\n\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\n\t\t\tdocument.forms[0].cust_1_desc.value=\'\';\n\t\t\tdocument.forms[0].cust_1.value = \'\';\n\t\t\tif(package_enabled_yn == \'Y\' && (calling_module_id == \'OP\' || calling_module_id == \'IP\'))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pkg_disc_disp\').style.display=\"none\";\t\t\t\n\t\t\t}\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar retVal\t\t\t= new String();\t\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar message = \'\';\t\n\n\tvar search_by_items = document.forms[0].search_by_items.value;\n\tvar search_code = document.forms[0].search_code.value;\n\n\tvar locale = document.forms[0].locale.value;\n\tvar strModuleId = document.forms[0].calling_module_id.value;\n\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;\n\tvar strCustGroupCode = document.forms[0].cust_group_code_1.value;\n\tvar blng_grp_curr_code = parent.parent.frames[0].document.forms[0].currency_code_for_bg.value;\n\tvar selecltd_cust_frm_pkg = document.forms[0].selecltd_cust_frm_pkg.value;\n\tvar facility_id = document.forms[0].facility_id.value;\n\tvar blng_grp_id = document.forms[0].billing_group.value;\n\tvar class_code = document.forms[0].class_code.value;\n\n\tvar cust_valid_from_date=\"\", cust_valid_to_date = \"\", cust_curr_code=\"\",cust_curr_desc=\"\";\n\tif(site_id == \'true\'){\n\tvar column_sizes = escape(\"10%,10%,10%,10%,10%,10%,5%,5%,5%,5%,0%,0%\");\n\t}else{\n\t\tvar column_sizes = escape(\"5%,25%,5%,25%,10%,10%,10%,10%,0%,0%\");\n\t}\n\tvar title=getLabel(\"Common.Customer.label\",\"common\"); \n\ttitle=encodeURIComponent(title);\n\tif(site_id == \'true\'){\n\tvar code=getLabel(\"eBL.CustomerCode.label\",\"BL\");\n\tcode=encodeURIComponent(code);\n\tvar long_name=getLabel(\"eBL.long_name.label\",\"BL\");\n\tlong_name=encodeURIComponent(long_name);\n\tvar cust_short_name=getLabel(\"eBL.CUSTOMER_GROUPS.label\",\"BL\");\n\tcust_short_name=encodeURIComponent(cust_short_name);\n\tvar cust_group_code=getLabel(\"eBL.CustomerGroupCode.label\",\"BL\");\n\tcust_group_code=encodeURIComponent(cust_group_code);\n\tvar long_desc=getLabel(\"eBL.long_desc.label\",\"BL\");\n\tlong_desc=encodeURIComponent(long_desc);\n\tvar cust_long_name=getLabel(\"eBL.description.label\",\"BL\");\n\tcust_long_name=encodeURIComponent(cust_long_name);\n\t}else{\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\tvar cust_group_code=getLabel(\"eBL.CUST_GROUP_CODE.label\",\"BL\");\n\tcust_group_code=encodeURIComponent(cust_group_code);\n\tvar cust_group=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\");\n\tcust_group=encodeURIComponent(cust_group);\n\t}\n\tvar country = getLabel(\"Common.country.label\",\"common\");\n\tcountry = encodeURIComponent(country);\n\tvar region = getLabel(\"eMP.region.label\",\"MP\");\n\tregion = encodeURIComponent(region);\n\tvar cust_valid_frm=getLabel(\"eBL.VALID_FROM.label\",\"BL\");\n\tcust_valid_frm=encodeURIComponent(cust_valid_frm);\t\n\tvar cust_valid_to=getLabel(\"eBL.VALID_TO.label\",\"BL\");\n\tcust_valid_to=encodeURIComponent(cust_valid_to);\t\n\tvar curr_code=getLabel(\"eBL.CURR_CODE.label\",\"BL\");\n\tcust_curr_code=encodeURIComponent(cust_curr_code);\n\tvar curr_desc=getLabel(\"eBL.CURR_DESC.label\",\"BL\");\n\tcurr_desc=encodeURIComponent(curr_desc);\n\tif(site_id == \'true\'){\n\tvar column_descriptions = code+\",\"+long_name+\",\"+cust_short_name+\",\"+cust_group_code+\",\"+long_desc+\",\"+cust_long_name+\",\"+country+\",\"+region+\",\"+cust_valid_frm+\",\"+cust_valid_to+\",\"+curr_code+\",\"+curr_desc;\n\t}else{\n\t\tvar column_descriptions = code+\",\"+desc+\",\"+cust_group_code+\",\"+cust_group+\",\"+country+\",\"+region+\",\"+cust_valid_frm+\",\"+cust_valid_to+\",\"+curr_code+\",\"+curr_desc;\n\t}\n\tif(site_id == \'true\'){\n\tsql = \"called_for=CREDITPAYERLKUP&locale=\"+locale+\"&auto_fin_chk=\"+autoFinChk+\"&blng_grp_id=\"+blng_grp_id+\"&class_code=\"+class_code+\"&cust_grp_code=\"+strCustGroupCode+\"&facility_id=\"+facility_id+\"&module_id=\"+strModuleId+\"&search_by_items=\"+search_by_items+\"&search_code=\"+search_code+\"&select_cust_frm_pkg=\"+selecltd_cust_frm_pkg+\"&site_id=\"+site_id;\n\t}else{\n\t\tsql = \"called_for=CREDITPAYERLKUP&locale=\"+locale+\"&auto_fin_chk=\"+autoFinChk+\"&blng_grp_id=\"+blng_grp_id+\"&class_code=\"+class_code+\"&cust_grp_code=\"+strCustGroupCode+\"&facility_id=\"+facility_id+\"&module_id=\"+strModuleId+\"&search_by_items=\"+search_by_items+\"&search_code=\"+search_code+\"&select_cust_frm_pkg=\"+selecltd_cust_frm_pkg;\n\t}\n\t/*\t\t\n\tif (autoFinChk == \"Y\")\n\t{\n//Added facility_id in the customer lookup query for PE Changes\n\t\tsql=\"select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,\"\n\t\t\t+\" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC\" \n\t\t\t+\" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c,BL_APPL_BG_BY_CLASSFCTN D \"\n\t\t\t+\" where a.language_id = b.language_id\" \n\t\t\t+\" and a.language_id=\'\"+locale+\"\'\"\n\t\t\t+\" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE\"\n\t\t\t+\" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE\"\n\t\t\t+\" and d.OPERATING_FACILITY_ID=\'\"+facility_id+\"\'\"\n\t\t\t+\" and b.cust_group_code = c.cust_group_code\"\n\t\t\t+\" and c.cust_group_code = d.APPL_CUST_GROUP_CODE\"\n\t\t\t+\" and a.cust_code = c.cust_code\" \n\t\t\t+\" and c.cust_code = d.APPL_CUST_CODE\" \n\t\t\t+\" and (b.cust_group_code=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null)\"\n\t\t\t+\" and d.CLASSIFICATION_CODE=\'\"+class_code+\"\'\"\n\t\t\t+\" and d.APPL_BLNG_GRP_ID=\'\"+blng_grp_id+\"\'\"\n\t\t\t+\" and (d.APPL_CUST_GROUP_CODE=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null)\"\n\t\t\t+\" and a.patient_flag = \'Y\'\" \n\t\t\t+\" and a.pat_com_flag = \'Y\'\" \n\t\t\t+\" and nvl (insurance_yn,\'N\') = \'N\'\" \n\t\t\t+\" and a.status is null\" \n\t\t\t+\" and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(a.op_yn,\'N\') = \'Y\')\" \n\t\t\t+\" or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(a.ip_yn,\'N\') = \'Y\')\" \n\t\t\t+\" or (\'\"+strModuleId+\"\' = \'MP\' and nvl(a.ref_yn,\'N\') = \'Y\'))\" \n\t\t\t+\" and decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')) = nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')))\";\n\t}\n\telse\n\t{\n\t\tsql=\"select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,\"\n\t\t\t+\" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC\" \n\t\t\t+\" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c \"\n\t\t\t+\" where a.language_id = b.language_id\" \n\t\t\t+\" and a.language_id=\'\"+locale+\"\'\"\n\t\t\t+\" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE\"\n\t\t\t+\" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE\"\t\t\t\n\t\t\t+\" and b.cust_group_code = c.cust_group_code\"\n\t\t\t+\" and a.cust_code = c.cust_code\" \n\t\t\t+\" and (b.cust_group_code=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null)\"\n\t\t\t+\" and a.patient_flag = \'Y\'\" \n\t\t\t+\" and a.pat_com_flag = \'Y\'\" \n\t\t\t+\" and nvl (insurance_yn,\'N\') = \'N\'\" \n\t\t\t+\" and a.status is null\" \n\t\t\t+\" and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(a.op_yn,\'N\') = \'Y\')\" \n\t\t\t+\" or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(a.ip_yn,\'N\') = \'Y\')\" \n\t\t\t+\" or (\'\"+strModuleId+\"\' = \'MP\' and nvl(a.ref_yn,\'N\') = \'Y\'))\" \n\t\t\t+\" and decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')) = nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')))\";\n\t}\n\tif(selecltd_cust_frm_pkg != \"\")\n\t{\n\t\tvar cust_arr = selecltd_cust_frm_pkg.split(\"@@\");\n\t\tsql = sql + \" and c.cust_code in (\'\";\n\t\tfor(var i=0;i<cust_arr.length;i++)\n\t\t{\n\t\t\tif(i != (cust_arr.length-1))\n\t\t\t\tsql = sql + cust_arr[i] + \"\',\'\";\n\t\t\telse\n\t\t\t\tsql = sql + cust_arr[i] +\"\')\";\n\t\t}\n\t}\n\n//\tsql = escape(sql);\t\t\t\t\t\t\t\n*/\n//\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYYYYYYNN\";\nif(site_id == \'true\'){\n\t\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=3\"+\"&col_show_hide=YYYYYYYYYYNN\";\n}else{\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYYYYYYNN\";\n}\n\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\n\tvar arr=new Array();\t\t\n\n    if(retVal == null) retVal=\'\';\n\n\tif (retVal ";
    private final static byte[]  _wl_block13_0Bytes = _getBytes( _wl_block13_0 );

    private final static java.lang.String  _wl_block13_1 ="!= null || retVal!=\"\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\t\n\n\t\t\tif(site_id == \'true\'){\n\t\t\tcust_valid_from_date = arr[8].substring(0,10);\n\t\t\tcust_valid_to_date = arr[9].substring(0,10);\n\t\t\tcust_curr_code = arr[10];\n\t\t\tcust_curr_desc= arr[11];\n\t\t\t}else{\n\t\t\t\tcust_valid_from_date = arr[6].substring(0,10);\n\t\t\t\tcust_valid_to_date = arr[7].substring(0,10);\n\t\t\t\tcust_curr_code = arr[8];\n\t\t\t\tcust_curr_desc= arr[9];\t\n\t\t\t}\n\t\t\tif(cust_valid_from_date != \"\")\n\t\t\t{\n\t\t\t\tvar cust_valid_from_date_loc= cust_valid_from_date;\n\t\t\t\tif(locale != \'en\')\n\t\t\t\t\tcust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,\'DMY\',\'en\',locale);\n\n\t\t\t\tif(!isAfter(encounter_date_aft_trunc,cust_valid_from_date_loc,\'DMY\',locale))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].cust_1_desc.value=\'\';\n\t\t\t\t\tdocument.forms[0].cust_1.value = \'\';\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(cust_valid_to_date != \"\")\n\t\t\t{\n\t\t\t\tvar cust_valid_to_date_loc = cust_valid_to_date;\n\t\t\t\tif(locale != \'en\')\n\t\t\t\t\tcust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,\'DMY\',\'en\',locale);\n\n\t\t\t\tif(!isBefore(encounter_date_aft_trunc,cust_valid_to_date_loc,\'DMY\',locale))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].cust_1_desc.value=\'\';\n\t\t\t\t\tdocument.forms[0].cust_1.value = \'\';\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tif((blng_grp_curr_code != \"\" && cust_curr_code == \"\") || (blng_grp_curr_code == \"\" && cust_curr_code != \"\") || (blng_grp_curr_code != \"\" && cust_curr_code != \"\" && cust_curr_code != blng_grp_curr_code))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6312\",\"BL\"));\n\t\t\t\tdocument.forms[0].cust_1_desc.value=\'\';\n\t\t\t\tdocument.forms[0].cust_1.value = \'\';\n\t\t\t\tdocument.forms[0].cust_curr_code.value = \"\";\n\t\t\t\tdocument.forms[0].cust_curr_desc.value = \"\";\n\t\t\t\tdocument.getElementById(\'cust_curr_desc_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'cust_curr_desc_val\').innerText=\"\";\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].cust_curr_code.value = cust_curr_code;\n\t\t\t\tdocument.forms[0].cust_curr_desc.value = cust_curr_desc;\n\t\t\t}\n\t\t\t\n\t\t\tif(site_id == \'true\'){\n\t\t\tdocument.forms[0].cust_1.value=arr[0];\n\t\t\tdocument.forms[0].cust_1_desc.value=arr[2];\n\t\t\tdocument.forms[0].cust_group_desc_1.value=arr[5];\n\t\t\tdocument.forms[0].cust_group_code_1.value=arr[3];\t\n\t\t\tdocument.forms[0].cust_valid_from_date.value=cust_valid_from_date;\n\t\t\tdocument.forms[0].cust_valid_to_date.value=cust_valid_to_date;\n\t\t\t}else{\n\t\t\tdocument.forms[0].cust_1.value=arr[0];\t\n\t\t\tdocument.forms[0].cust_1_desc.value=arr[1];\n\t\t\tdocument.forms[0].cust_group_desc_1.value=arr[3];\n\t\t\tdocument.forms[0].cust_group_code_1.value=arr[2];\t\n\t\t\tdocument.forms[0].cust_valid_from_date.value=cust_valid_from_date;\n\t\t\tdocument.forms[0].cust_valid_to_date.value=cust_valid_to_date;\n\t\t}\n\t\t\tif(package_enabled_yn == \'Y\' && (calling_module_id == \'OP\' || calling_module_id == \'IP\'))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pkg_disc_disp\').style.display=\"inline\";\t\t\t\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\tvar updation=formValidation(xmlStr,\"clearBean\");\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].cust_1_desc.value=\'\';\n\t\t\tdocument.forms[0].cust_1.value = \'\';\n\t\t\ttarget.focus();\n\t\t\t\n\t\t\tif(package_enabled_yn == \'Y\' && (calling_module_id == \'OP\' || calling_module_id == \'IP\'))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pkg_disc_disp\').style.display=\"none\";\t\t\t\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\tvar updation=formValidation(xmlStr,\"clearBean\");\n\t\t\t}\n\t\t}\n\t}\n\tcurr_desc_1();\n\tchk_for_gl_valid(document.forms[0].credit_doc_ref1);\n}\n/*\nfunction cust2grouplkup()\n{\t\t\t\n\tvar msg=\"\";\n\tvar target\t\t\t= document.forms[0].cust_2_desc;\n\tvar retVal\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t= \"\";\n\tvar search_desc\t\t\t= \"\";\n\tvar tit\t\t\t\t= \"\";\t\t\n\tvar ModuleId     = \'";
    private final static byte[]  _wl_block13_1Bytes = _getBytes( _wl_block13_1 );

    private final static java.lang.String  _wl_block14_0 ="\';\n\tvar custgroup = document.forms[0].cust_group_1.value;\n\tvar locale = document.forms[0].locale.value;\n\t\t\n\tsql=\" select cust_code, short_name from ar_customer_lang_vw where language_id=`\"+locale+\"` and patient_flag = `Y` and pat_com_flag = `N`   and nvl (insurance_yn,`N`) = `N`  and status is null and ((`\"+ModuleId+\"` in (`OP`,`AE`) and nvl(op_yn,`N`) = `Y`) or (`\"+ModuleId+\"` in (`IP`,`DC`) and nvl(ip_yn,`N`) = `Y`) or (`\"+ModuleId+\"` = `MP` and nvl(ref_yn,`N`) = `Y`)) and (( cust_group_code = `\"+custgroup+\"` and  `\"+custgroup+\"` is not null ) or `\"+custgroup+\"` is null )\";\t\n\t\t\n\tsearch_code=\"cust_code\";\n\tsearch_desc=\"short_name\";\n//\ttit=\"Customers \"; \n\ttit=getLabel(\"Common.Customer.label\",\"common\"); \n\ttit=encodeURIComponent(tit);\t\n\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"::\");\n\t\n\t\tdocument.forms[0].cust_2_desc.value=arr[0];\n\t    document.forms[0].cust_2.value=arr[1];\t\t\t\t\t\n\t}\n\telse\n\t{\t\t\t\t\n\t\tdocument.forms[0].cust_2_desc.value=\'\';\n\t\tdocument.forms[0].cust_2.value = \'\';\t\t\t\t\t\t\t\t\t\n\t\ttarget.focus();\n\t}\n}\t  \n*/\n/* Function for Sponsor Customer Lkup */\nasync function cust2grouplkup(clng_evnt)\n{\t\t\n\tvar autoFinChk = document.forms[0].autoFinChk.value;\n\tvar package_enabled_yn=document.forms[0].package_enabled_yn.value;\n\tvar target\t\t\t= document.forms[0].cust_2_desc;\t\n\tvar calling_module_id = document.forms[0].calling_module_id.value;\nvar site_id= document.forms[0].site_id.value;\n\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].cust_2_desc.value=\'\';\n\t\t\tdocument.forms[0].cust_2.value=\'\';\t\n\n\t\t\tif(package_enabled_yn == \'Y\' && (calling_module_id == \'OP\' || calling_module_id == \'IP\'))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pkg_disc_disp\').style.display=\"none\";\t\t\t\n\t\t\t}\n\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar retVal\t\t\t= new String();\t\n\tvar dialogTop\t\t\t= \"0\";\n\tvar dialogHeight\t\t= \"60vh\" ;\n\tvar dialogWidth\t\t\t= \"70vw\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar message = \'\';\t\n\n\tvar search_by_items = document.forms[0].search_by_items.value;\n\tvar search_code = document.forms[0].search_code.value;\n\n\tvar locale = document.forms[0].locale.value;\n\tvar strModuleId = document.forms[0].calling_module_id.value;\n\tvar encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;\n\tvar strCustGroupCode = document.forms[0].cust_group_code_2.value;\n\tvar blng_grp_curr_code = parent.parent.frames[0].document.forms[0].currency_code_for_bg.value;\n\tvar selecltd_cust_frm_pkg = document.forms[0].selecltd_cust_frm_pkg.value;\n\tvar facility_id = document.forms[0].facility_id.value;\n\tvar blng_grp_id = document.forms[0].billing_group.value;\n\tvar class_code = document.forms[0].class_code.value;\n\n\tvar cust_valid_from_date=\"\", cust_valid_to_date = \"\", cust_curr_code=\"\",cust_curr_desc=\"\";\n\t\tif(site_id == \'true\'){\n\tvar column_sizes = escape(\"5%,25%,5%,25%,10%,10%,10%,10%,10%,10%,0%,0%\");\n\t}else{\n\tvar column_sizes = escape(\"5%,25%,5%,25%,10%,10%,10%,10%,0%,0%\");\n\t}\t\n\t\n\n\tvar title=getLabel(\"Common.Customer.label\",\"common\"); \n\ttitle=encodeURIComponent(title);\n\t\n\t\n\tif(site_id == \'true\'){\n\tvar code=getLabel(\"eBL.CustomerCode.label\",\"BL\");\n\tcode=encodeURIComponent(code);\n\tvar long_name=getLabel(\"eBL.long_name.label\",\"BL\");\n\tlong_name=encodeURIComponent(long_name);\n\tvar cust_short_name=getLabel(\"eBL.CUSTOMER_GROUPS.label\",\"BL\");\n\tcust_short_name=encodeURIComponent(cust_short_name);\n\tvar cust_group_code=getLabel(\"eBL.CustomerGroupCode.label\",\"BL\");\n\tcust_group_code=encodeURIComponent(cust_group_code);\n\tvar long_desc=getLabel(\"eBL.long_desc.label\",\"BL\");\n\tlong_desc=encodeURIComponent(long_desc);\n\tvar cust_long_name=getLabel(\"eBL.description.label\",\"BL\");\n\tcust_long_name=encodeURIComponent(cust_long_name);\n\t}else{\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\tvar cust_group_code=getLabel(\"eBL.CUST_GROUP_CODE.label\",\"BL\");\n\tcust_group_code=encodeURIComponent(cust_group_code);\n\tvar cust_group=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\");\n\tcust_group=encodeURIComponent(cust_group);\n\t}\n\t\n\tvar country = getLabel(\"Common.country.label\",\"common\");\n\tcountry = encodeURIComponent(country);\n\tvar region = getLabel(\"eMP.region.label\",\"MP\");\n\tregion = encodeURIComponent(region);\n\tvar cust_valid_frm=getLabel(\"eBL.VALID_FROM.label\",\"BL\");\n\tcust_valid_frm=encodeURIComponent(cust_valid_frm);\t\n\tvar cust_valid_to=getLabel(\"eBL.VALID_TO.label\",\"BL\");\n\tcust_valid_to=encodeURIComponent(cust_valid_to);\t\n\tvar curr_code=getLabel(\"eBL.CURR_CODE.label\",\"BL\");\n\tcurr_code=encodeURIComponent(curr_code);\n\tvar curr_desc=getLabel(\"eBL.CURR_DESC.label\",\"BL\");\n\tcurr_desc=encodeURIComponent(curr_desc);\n\n\tif(site_id == \'true\'){\n\tvar column_descriptions = code+\",\"+long_name+\",\"+cust_short_name+\",\"+cust_group_code+\",\"+long_desc+\",\"+cust_long_name+\",\"+country+\",\"+region+\",\"+cust_valid_frm+\",\"+cust_valid_to+\",\"+curr_code+\",\"+curr_desc;\n\t}else{\n\t\tvar column_descriptions = code+\",\"+desc+\",\"+cust_group_code+\",\"+cust_group+\",\"+country+\",\"+region+\",\"+cust_valid_frm+\",\"+cust_valid_to+\",\"+curr_code+\",\"+curr_desc;\n\t}\n\t\nif(site_id == \'true\'){\n\tsql = \"called_for=SPONSORPAYERLKUP&locale=\"+locale+\"&auto_fin_chk=\"+autoFinChk+\"&blng_grp_id=\"+blng_grp_id+\"&class_code=\"+class_code+\"&cust_grp_code=\"+strCustGroupCode+\"&facility_id=\"+facility_id+\"&module_id=\"+strModuleId+\"&search_by_items=\"+search_by_items+\"&search_code=\"+search_code+\"&select_cust_frm_pkg=\"+selecltd_cust_frm_pkg+\"&site_id=\"+site_id;\n\t}else{\n\t\tsql = \"called_for=SPONSORPAYERLKUP&locale=\"+locale+\"&auto_fin_chk=\"+autoFinChk+\"&blng_grp_id=\"+blng_grp_id+\"&class_code=\"+class_code+\"&cust_grp_code=\"+strCustGroupCode+\"&facility_id=\"+facility_id+\"&module_id=\"+strModuleId+\"&search_by_items=\"+search_by_items+\"&search_code=\"+search_code+\"&select_cust_frm_pkg=\"+selecltd_cust_frm_pkg;\n\t}\n\n/*\t\t\n\tif (autoFinChk == \"Y\")\n\t{\n\t\tvar blng_grp_id = document.forms[0].billing_group.value;\n\t\tvar class_code = document.forms[0].class_code.value;\n//Added facility_id in the customer lookup query for PE Changes\n\t\tsql=\"select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,\"\n\t\t\t+\" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC\" \n\t\t\t+\" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c,BL_APPL_BG_BY_CLASSFCTN D \"\n\t\t\t+\" where a.language_id = b.language_id\" \n\t\t\t+\" and a.language_id=\'\"+locale+\"\'\"\n\t\t\t+\" and d.OPERATING_FACILITY_ID=\'\"+facility_id+\"\'\"\n\t\t\t+\" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE\"\n\t\t\t+\" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE\"\n\t\t\t+\" and b.cust_group_code = c.cust_group_code\"\n\t\t\t+\" and c.cust_group_code = d.APPL_CUST_GROUP_CODE\"\n\t\t\t+\" and a.cust_code = c.cust_code\" \n\t\t\t+\" and c.cust_code = d.APPL_CUST_CODE\" \n\t\t\t+\" and (b.cust_group_code=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null)\"\n\t\t\t+\" and d.CLASSIFICATION_CODE=\'\"+class_code+\"\'\"\n\t\t\t+\" and d.APPL_BLNG_GRP_ID=\'\"+blng_grp_id+\"\'\"\n\t\t\t+\" and (d.APPL_CUST_GROUP_CODE=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null)\"\n\t\t\t+\" and a.patient_flag = \'Y\'\" \n\t\t\t+\" and a.pat_com_flag = \'N\'\" \n\t\t\t+\" and nvl (insurance_yn,\'N\') = \'N\'\" \n\t\t\t+\" and a.status is null\" \n\t\t\t+\" and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(a.op_yn,\'N\') = \'Y\')\" \n\t\t\t+\" or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(a.ip_yn,\'N\') = \'Y\')\" \n\t\t\t+\" or (\'\"+strModuleId+\"\' = \'MP\' and nvl(a.ref_yn,\'N\') = \'Y\'))\" \n\t\t\t+\" and decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')) = nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')))\";\n\t}\n\telse\n\t{\n\t\tsql=\"select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,\"\n\t\t+\" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC\" \n\t\t+\" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c \"\n\t\t+\" where a.language_id = b.language_id\" \n\t\t+\" and a.language_id=\'\"+locale+\"\'\"\n\t\t+\" and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE\"\n\t\t+\" and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE\"\t\t\t\n\t\t+\" and b.cust_group_code = c.cust_group_code\"\n\t\t+\" and a.cust_code = c.cust_code\" \n\t\t+\" and (b.cust_group_code=\'\"+strCustGroupCode+\"\' or \'\"+strCustGroupCode+\"\' is null)\"\n\t\t+\" and a.patient_flag = \'Y\'\" \n\t\t+\" and a.pat_com_flag = \'N\'\" \n\t\t+\" and nvl (insurance_yn,\'N\') = \'N\'\" \n\t\t+\" and a.status is null\" \n\t\t+\" and ((\'\"+strModuleId+\"\' in (\'OP\',\'AE\') and nvl(a.op_yn,\'N\') = \'Y\')\" \n\t\t+\" or (\'\"+strModuleId+\"\' in (\'IP\',\'DC\') and nvl(a.ip_yn,\'N\') = \'Y\')\" \n\t\t+\" or (\'\"+strModuleId+\"\' = \'MP\' and nvl(a.ref_yn,\'N\') = \'Y\'))\" \n\t\t+\" and decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')) = nvl(\'\"+search_code+\"\',decode(\'\"+search_by_items+\"\',\'CY\',nvl(a.country_code,\'XXXX\'),\'RN\',nvl(a.region_code,\'XXXX\')))\";\n\t}\n\tif(selecltd_cust_frm_pkg != \"\")\n\t{\n\t\tvar cust_arr = selecltd_cust_frm_pkg.split(\"@@\");\n\t\tsql = sql + \" and c.cust_code in (\'\";\n\t\tfor(var i=0;i<cust_arr.length;i++)\n\t\t{\n\t\t\tif(i != (cust_arr.length-1))\n\t\t\t\tsql = sql + cust_arr[i] + \"\',\'\";\n\t\t\telse\n\t\t\t\tsql = sql + cust_arr[i] +\"\')\";\n\t\t}\n\t}\n\n//\tsql = escape(sql);\t\t\t\t\t\t\t\n*/\n//\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYYYYYYNN\";\n\nif(site_id == \'true\'){\n\t\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=3\"+\"&col_show_hide=YYYYYYYYYYNN\";\n}else{\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYYYYYYNN\";\n}\n\t\n\n\tretVal=await top.window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t\n\n\tvar arr=new Array();\t\t\n\n    if(retVal == null) retVal=\'\';\n\n\tif (retVal != null || retVal!=\"\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\t\t\t   \n\n\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block14_0Bytes = _getBytes( _wl_block14_0 );

    private final static java.lang.String  _wl_block14_1 ="\tif(site_id == \'true\'){\n\t\t\tcust_valid_from_date = arr[8].substring(0,10);\n\t\t\tcust_valid_to_date = arr[9].substring(0,10);\n\t\t\tcust_curr_code = arr[10];\n\t\t\tcust_curr_desc= arr[11];\n\t\t\t}else{\n\t\t\t\tcust_valid_from_date = arr[6].substring(0,10);\n\t\t\t\tcust_valid_to_date = arr[7].substring(0,10);\n\t\t\t\tcust_curr_code = arr[8];\n\t\t\t\tcust_curr_desc= arr[9];\t\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\n\n\t\t\tif(cust_valid_from_date != \"\")\n\t\t\t{\n\t\t\t\tvar cust_valid_from_date_loc=cust_valid_from_date;\n\t\t\t\tif(locale != \'en\')\n\t\t\t\t\tcust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,\'DMY\',\'en\',locale);\n\n\t\t\t\tif(!isAfter(encounter_date_aft_trunc,cust_valid_from_date_loc,\'DMY\',locale))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].cust_2_desc.value=\'\';\n\t\t\t\t\tdocument.forms[0].cust_2.value=\'\';\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(cust_valid_to_date != \"\")\n\t\t\t{\n\t\t\t\tvar cust_valid_to_date_loc=cust_valid_to_date;\n\t\t\t\tif(locale != \'en\')\n\t\t\t\t\tcust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,\'DMY\',\'en\',locale);\n\n\t\t\t\tif(!isBefore(encounter_date_aft_trunc,cust_valid_to_date_loc,\'DMY\',locale))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL8227\",\"BL\"));\n\t\t\t\t\tdocument.forms[0].cust_2_desc.value=\'\';\n\t\t\t\t\tdocument.forms[0].cust_2.value=\'\';\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tif((blng_grp_curr_code != \"\" && cust_curr_code == \"\") || (blng_grp_curr_code == \"\" && cust_curr_code != \"\") || (blng_grp_curr_code != \"\" && cust_curr_code != \"\" && cust_curr_code != blng_grp_curr_code))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6312\",\"BL\"));\n\t\t\t\tdocument.forms[0].cust_2_desc.value=\'\';\n\t\t\t\tdocument.forms[0].cust_2.value=\'\';\t\n\t\t\t\tdocument.forms[0].cust_curr_code.value = \"\";\n\t\t\t\tdocument.forms[0].cust_curr_desc.value = \"\";\n\t\t\t\tdocument.getElementById(\'cust_curr_desc_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'cust_curr_desc_val\').innerText=\"\";\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].cust_curr_code.value = cust_curr_code;\n\t\t\t\tdocument.forms[0].cust_curr_desc.value = cust_curr_desc;\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\tif(site_id == \'true\'){\n\t\t\tdocument.forms[0].cust_2.value=arr[0];\t\n\t\t\tdocument.forms[0].cust_2_desc.value=arr[2];\n\t\t\tdocument.forms[0].cust_group_desc_2.value=arr[4];\n\t\t\tdocument.forms[0].cust_group_code_2.value=arr[3];\n\t\t\tdocument.forms[0].cust_valid_from_date.value=cust_valid_from_date;\n\t\t\tdocument.forms[0].cust_valid_to_date.value=cust_valid_to_date;\n\t\t\t}else{\n\t\t\tdocument.forms[0].cust_2.value=arr[0];\t\n\t\t\tdocument.forms[0].cust_2_desc.value=arr[1];\n\t\t\tdocument.forms[0].cust_group_desc_2.value=arr[3];\n\t\t\tdocument.forms[0].cust_group_code_2.value=arr[2];\t\n\t\t\tdocument.forms[0].cust_valid_from_date.value=cust_valid_from_date;\n\t\t\tdocument.forms[0].cust_valid_to_date.value=cust_valid_to_date;\n\t\t}\n\t\t\t\n\n\t\t\tif(package_enabled_yn == \'Y\' && (calling_module_id == \'OP\' || calling_module_id == \'IP\'))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pkg_disc_disp\').style.display=\"inline\";\t\t\t\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\tvar updation=formValidation(xmlStr,\"clearBean\");\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].cust_2_desc.value=\'\';\n\t\t\tdocument.forms[0].cust_2.value=\'\';\t\n\t\t\ttarget.focus();\n\n\t\t\tif(package_enabled_yn == \'Y\' && (calling_module_id == \'OP\' || calling_module_id == \'IP\'))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'pkg_disc_disp\').style.display=\"none\";\t\t\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\tvar updation=formValidation(xmlStr,\"clearBean\");\t\t\t\t\n\t\t\t}\n\t\t}\n\t\tcurr_desc_1();\n\t\tchk_for_gl_valid(document.forms[0].credit_doc_ref2);\n\t}\n}\nfunction curr_desc_1()\n{\n\tvar setlmt_ind = document.forms[0].setlmt_ind.value;\n\tif(setlmt_ind == \'X\' || setlmt_ind == \'R\')\n\t{\n\t\tvar cust_curr_desc = document.forms[0].cust_curr_desc.value;\n\n\t\tif(cust_curr_desc != \"\")\n\t\t{\n\t\t\tdocument.getElementById(\'cust_curr_desc_disp\').style.display=\"inline\";\n\t\t\tdocument.getElementById(\'cust_curr_desc_val\').innerText=cust_curr_desc;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\'cust_curr_desc_disp\').style.display=\"none\";\n\t\t\tdocument.getElementById(\'cust_curr_desc_val\').innerText=\"\";\n\t\t}\n\t}\n}\n\nfunction dfltslmt()\n{\n\tvar dfltslmt = document.forms[0].dflt_slmt_type_code.value;\n\tvar operation = document.forms[0].operation_fun.value;\n\tvar autoFinChk = document.forms[0].autoFinChk.value;\n//\tvar cash_settl_ind = document.forms[0].cash_settl_ind.value;\n\tvar cash_slmt_type = document.forms[0].cash_slmt_type.value;\n\n\tif(( autoFinChk == \"Y\" && cash_slmt_type==\"\") || (autoFinChk==\"N\" ))\n\t{\n\t\tif(document.forms[0].cash_set_type1 != null && document.forms[0].cash_set_type1 != undefined)\n\t\t{\n\t\t\tfor(i=0;i<document.forms[0].cash_set_type1.options.length;i++)\n\t\t\t{\t\t\t\t\t\t\t\t\t\n\t\t\t\tvar cashSetValue = document.forms[0].cash_set_type1.options[i].value;\t\t\t\t\t\t\t\t\t\n\t\t\t\tif (cashSetValue == null)\n\t\t\t\t{\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\n\t\t\t\tvar len = cashSetValue.length;\n\t\t\t\tvar subValue =\"\";\n\t\t\t\tif (len >0)\n\t\t\t\t{\n\t\t\t\t\tsubValue = cashSetValue.substring(0,len-1);\n\t\t\t\t}\n\n\t\t\t\tif (subValue == dfltslmt)\n\t\t\t\t{\t\t\t\t\t\t\t\t\n\t\t\t\t\tif(document.forms[0].cash_set_type1.value==\'\'){\n\t\t\t\t\tdocument.forms[0].cash_set_type1.value = cashSetValue;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction srch_by_crit_for_cust()\n{\n\tvar setlmt_ind = document.forms[0].setlmt_ind.value;\n\tif(setlmt_ind != \'C\')\n\t{\n\t\tvar srch_by = document.forms[0].search_by_items.value;\n/*\n\t\tif(srch_by == \"CG\")\n\t\t{\n\t\t\tdocument.getElementById(\'srch_by_leg\').innerText=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\");\n\t\t}\n\t\telse \n*/\n\t\tif (srch_by == \"CY\")\n\t\t{\n\t\t\tdocument.getElementById(\'srch_by_leg\').innerText=getLabel(\"Common.country.label\",\"common\");\n\t\t}\n\t\telse if (srch_by == \"RN\")\n\t\t{\n\t\t\tdocument.getElementById(\'srch_by_leg\').innerText=getLabel(\"eMP.region.label\",\"MP\");\n\t\t}\n\n\t\tdocument.forms[0].srch_by_desc.value=\'\';\n\t\tdocument.forms[0].search_code.value = \'\';\n\t}\n}\n\nasync function srchbylkup(clng_evnt)\n{\t\n\tvar srch_by = document.forms[0].search_by_items.value;\n\tvar locale = document.forms[0].locale.value;\n\n\tvar target_code\t= document.forms[0].search_code ;\n\tvar target = document.forms[0].srch_by_desc;\n\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t\t{\t\n\t\t\tdocument.forms[0].srch_by_desc.value=\'\';\n\t\t\tdocument.forms[0].search_code.value = \'\';\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar message=\"\";\n\tvar retVal\t\t\t\t= new String();\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar title\t\t\t\t= \"\";\n\tvar column_descriptions = \"\";\n/*\t\n\tif(srch_by == \"CG\")\n\t{\n\t\tvar title=getLabel(\"eBL.CUSTOMER_GROUP.label\",\"BL\"); \n\t\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\t\tsql = \"\tselect cust_group_code CUST_GRP_CODE,short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id=\'\"+locale+\"\' and status is null\";\t\n\t}\n\telse \n*/\n\tif (srch_by == \"CY\")\n\t{\n\t\tvar title=getLabel(\"Common.country.label\",\"common\"); \n\t\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\t\tsql = \"select country_code COUNTRY_CODE,short_name SHORT_NAME from mp_country_lang_vw where language_id=\'\"+locale+\"\' and eff_status = \'E\'\";\t\n\t}\n\telse if (srch_by == \"RN\")\n\t{\n\t\tvar title=getLabel(\"eMP.region.label\",\"MP\"); \n\t\ttitle=encodeURIComponent(title);\t\t\n\t\t\n\t\tsql = \"select region_code REGION_CODE,short_desc SHORT_NAME from mp_region_lang_vw where language_id=\'\"+locale+\"\' and eff_status = \'E\'\";\t\n\t}\n\n\tvar column_sizes = escape(\"30%,70%\");\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\n\tcolumn_descriptions = code+\",\"+desc;\n\n\tsql=escape(sql);\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\n\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\t\n\tvar arr=new Array();\n\n\tif (!(retVal == null))\n\t{\n  \t    var retVal=unescape(retVal);\n\t\tarr=retVal.split(\"^~^\");\n\n\t\ttarget.value=arr[1];\n\t\ttarget_code.value = arr[0];\n\t}\n\telse\n\t{\t\n\t\ttarget.value=\'\';\n\t\ttarget_code.value = \'\';\n\t}\n}\n\nfunction chk_for_gl_valid(credit_doc_ref)\n{\n\tvar calling_module_id = document.forms[0].calling_module_id.value;\n\tvar function_id = document.forms[0].function_id.value;\n\n\tif(calling_module_id != \'MP\' && function_id!=\"BOOKING\")\n\t{\n\t\tvar facility_id = document.forms[0].facility_id.value;\n\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\tvar episode_type = document.forms[0].episode_type.value;\n\t\tvar gl_holder_name = parent.parent.frames[0].document.forms[0].gl_holder_name.value;\n\t\tvar setlmt_ind = document.forms[0].setlmt_ind.value;\n\t\tvar adm_rec_flag = document.forms[0].adm_rec_flag.value;\n\t\tvar cust_grp_code = \"\",cust_code=\"\";\n\t\tvar doc_ref = credit_doc_ref.value;\n\n\t\tif(setlmt_ind == \'R\')//Credit\n\t\t{\n\t\t\tcust_grp_code = document.forms[0].cust_group_code_1.value;\n\t\t\tcust_code = document.forms[0].cust_1.value;\n\t\t}\n\t\telse if(setlmt_ind == \'X\' && adm_rec_flag == \'1\')//Sponsor\n\t\t{\n\t\t\tcust_grp_code = document.forms[0].cust_group_code_2.value;\n\t\t\tcust_code = document.forms[0].cust_2.value;\t\t\n\t\t}\n\n\t\tvar gl_holder_name = parent.parent.frames[0].document.forms[0].gl_holder_name.value;\n\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\tvar xmlDoc = \"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\t\t\t\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\tvar param=\"facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&episode_type=\"+episode_type+\"&gl_holder_name=\"+gl_holder_name+\"&cust_group_code=\"+cust_grp_code+\"&cust_code=\"+cust_code+\"&doc_ref=\"+doc_ref+\"&called_from=gl_enc_chk\";\n\t\tvar temp_jsp=\"../../eBL/jsp/BLInsuranceValidations.jsp?\"+param;\t\t\t\n\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText = trimString(xmlHttp.responseText);\t\t\n//\t\talert(responseText);\n\t\tif(responseText != \"\")\n\t\t{\n\t\t\tvar retArray = new Array();\n\t\t\tretArray=responseText.split(\"/\");\n\n\t\t\tvar gl_doc_ref_exist_YN = \tretArray[0] ;\n\t\t\tdocument.forms[0].gl_doc_ref_exist_YN.value = gl_doc_ref_exist_YN;\n\n\t\t\tvar tot_valid_enc_with_gl = retArray[1];\n\t\t\tif(tot_valid_enc_with_gl == null || tot_valid_enc_with_gl==\" \") tot_valid_enc_with_gl=\"\";\n\n\t\t\tvar tot_valid_op_enc_with_gl = retArray[2];\n\t\t\tif(tot_valid_op_enc_with_gl == null || tot_valid_op_enc_with_gl==\" \") tot_valid_op_enc_with_gl=\"\";\n\n\t\t\tvar tot_valid_ae_enc_with_gl = retArray[3];\n\t\t\tif(tot_valid_ae_enc_with_gl == null || tot_valid_ae_enc_with_gl==\" \") tot_valid_ae_enc_with_gl=\"\";\n\n\t\t\tvar tot_valid_ip_enc_with_gl = retArray[4];\n\t\t\tif(tot_valid_ip_enc_with_gl == null || tot_valid_ip_enc_with_gl==\" \") tot_valid_ip_enc_with_gl=\"\";\n\n\t\t\tvar tot_valid_dc_enc_with_gl = retArray[5];\n\t\t\tif(tot_valid_dc_enc_with_gl == null || tot_valid_dc_enc_with_gl==\" \") tot_valid";
    private final static byte[]  _wl_block14_1Bytes = _getBytes( _wl_block14_1 );

    private final static java.lang.String  _wl_block14_2 ="_dc_enc_with_gl=\"\";\n\n\t\t\tvar tot_availed_enc_with_gl = retArray[6];\n\t\t\tif(tot_availed_enc_with_gl == null || tot_availed_enc_with_gl==\" \") tot_availed_enc_with_gl=\"0\";\n\n\t\t\tvar tot_availed_op_enc_with_gl = retArray[7];\n\t\t\tif(tot_availed_op_enc_with_gl == null || tot_availed_op_enc_with_gl==\" \") tot_availed_op_enc_with_gl=\"0\";\n\n\t\t\tvar tot_availed_ae_enc_with_gl = retArray[8];\n\t\t\tif(tot_availed_ae_enc_with_gl == null || tot_availed_ae_enc_with_gl==\" \") tot_availed_ae_enc_with_gl=\"0\";\n\n\t\t\tvar tot_availed_ip_enc_with_gl = retArray[9];\n\t\t\tif(tot_availed_ip_enc_with_gl == null || tot_availed_ip_enc_with_gl==\" \") tot_availed_ip_enc_with_gl=\"0\";\n\n\t\t\tvar tot_availed_dc_enc_with_gl = retArray[10];\n\t\t\tif(tot_availed_dc_enc_with_gl == null || tot_availed_dc_enc_with_gl==\" \") tot_availed_dc_enc_with_gl=\"0\";\n\n\t\t\tif(gl_doc_ref_exist_YN == \'Y\')\n\t\t\t{\n\t\t\t\tif(setlmt_ind == \'R\')//Credit\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].credit_doc_start_date1.disabled=true;\t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].credit_doc_date1.disabled=true;\n\t\t\t\t}\n\t\t\t\telse if(setlmt_ind == \'X\' && adm_rec_flag == \'1\')//Sponsor\n\t\t\t\t{\t\n\t\t\t\t\tdocument.forms[0].credit_doc_start_date2.disabled=true;\n\t\t\t\t\tdocument.forms[0].credit_doc_date2.disabled=true;\n\t\t\t\t}\n\n\t\t\t\tdocument.forms[0].tot_valid_enc_with_gl.value = tot_valid_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_op_enc_with_gl.value = tot_valid_op_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_ae_enc_with_gl.value = tot_valid_ae_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_ip_enc_with_gl.value = tot_valid_ip_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_dc_enc_with_gl.value = tot_valid_dc_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_enc_with_gl.disabled=true;\n\t\t\t\tdocument.forms[0].tot_valid_op_enc_with_gl.disabled=true;\n\t\t\t\tdocument.forms[0].tot_valid_ae_enc_with_gl.disabled=true;\n\t\t\t\tdocument.forms[0].tot_valid_ip_enc_with_gl.disabled=true;\n\t\t\t\tdocument.forms[0].tot_valid_dc_enc_with_gl.disabled=true;\n\t\t\t\tdocument.forms[0].tot_availed_enc_with_gl.value = tot_availed_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_availed_op_enc_with_gl.value = tot_availed_op_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_availed_ae_enc_with_gl.value = tot_availed_ae_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_availed_ip_enc_with_gl.value = tot_availed_ip_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_availed_dc_enc_with_gl.value = tot_availed_dc_enc_with_gl;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(setlmt_ind == \'R\')//Credit\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].credit_doc_start_date1.disabled=false;\t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].credit_doc_date1.disabled=false;\n\t\t\t\t}\n\t\t\t\telse if(setlmt_ind == \'X\' && adm_rec_flag == \'1\')//Sponsor\n\t\t\t\t{\t\n\t\t\t\t\tdocument.forms[0].credit_doc_start_date2.disabled=false;\n\t\t\t\t\tdocument.forms[0].credit_doc_date2.disabled=false;\n\t\t\t\t}\n\n\t\t\t\tdocument.forms[0].tot_valid_enc_with_gl.value = tot_valid_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_op_enc_with_gl.value = tot_valid_op_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_ae_enc_with_gl.value = tot_valid_ae_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_ip_enc_with_gl.value = tot_valid_ip_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_dc_enc_with_gl.value = tot_valid_dc_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_valid_enc_with_gl.disabled=false;\n\t\t\t\tdocument.forms[0].tot_valid_op_enc_with_gl.disabled=false;\n\t\t\t\tdocument.forms[0].tot_valid_ae_enc_with_gl.disabled=false;\n\t\t\t\tdocument.forms[0].tot_valid_ip_enc_with_gl.disabled=false;\n\t\t\t\tdocument.forms[0].tot_valid_dc_enc_with_gl.disabled=false;\n\t\t\t\tdocument.forms[0].tot_availed_enc_with_gl.value = tot_availed_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_availed_op_enc_with_gl.value = tot_availed_op_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_availed_ae_enc_with_gl.value = tot_availed_ae_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_availed_ip_enc_with_gl.value = tot_availed_ip_enc_with_gl;\n\t\t\t\tdocument.forms[0].tot_availed_dc_enc_with_gl.value = tot_availed_dc_enc_with_gl;\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction chk_max_entry(obj,obj1)\n{\n\tvar tot_valid_enc_with_gl = obj1.value;\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar op_valid_enc_value = document.forms[0].tot_valid_op_enc_with_gl;\n\tvar ae_valid_enc_value = document.forms[0].tot_valid_ae_enc_with_gl;\n\tvar ip_valid_enc_value = document.forms[0].tot_valid_ip_enc_with_gl;\n\tvar dc_valid_enc_value = document.forms[0].tot_valid_dc_enc_with_gl;\n\n\tif(episode_type == \"O\")\n\t{\n\t\tif(op_valid_enc_value.value != \"\")\n\t\t{\n\t\t\tif(eval(op_valid_enc_value.value) == 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6429\",\"BL\"));\n\t\t\t\top_valid_enc_value.value=\'\';\n\t\t\t\top_valid_enc_value.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\n\tif(episode_type == \"E\")\n\t{\n\t\tif(ae_valid_enc_value.value != \"\")\n\t\t{\n\t\t\tif(eval(ae_valid_enc_value.value) == 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6429\",\"BL\"));\n\t\t\t\tae_valid_enc_value.value=\'\';\n\t\t\t\tae_valid_enc_value.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\n\tif(episode_type == \"I\")\n\t{\n\t\tif(ip_valid_enc_value.value != \"\")\n\t\t{\n\t\t\tif(eval(ip_valid_enc_value.value) == 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6429\",\"BL\"));\n\t\t\t\tip_valid_enc_value.value=\'\';\n\t\t\t\tip_valid_enc_value.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\n\tif(episode_type == \"D\")\n\t{\n\t\tif(dc_valid_enc_value.value != \"\")\n\t\t{\n\t\t\tif(eval(dc_valid_enc_value.value) == 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL6429\",\"BL\"));\n\t\t\t\tdc_valid_enc_value.value=\'\';\n\t\t\t\tdc_valid_enc_value.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\n\tif(tot_valid_enc_with_gl!=\"\")\n\t{\n\t\tif( eval(obj.value) > eval(tot_valid_enc_with_gl) )\n\t\t{\n\t\t\talert(getMessage(\"BL6427\",\"BL\"));\n\t\t\tobj.value=\'\';\n\t\t\tobj.select();\n\t\t\treturn false;\n\t\t}\n\t}\n}\n\nfunction chk_max_entry_total(obj)\n{\n\tvar tot_valid_enc_with_gl = obj.value;\n\tvar episode_type=document.forms[0].episode_type.value;\n\n\tif(tot_valid_enc_with_gl != \"\")\n\t{\n\t\tvar op_valid_enc_value = document.forms[0].tot_valid_op_enc_with_gl;\n\t\tvar ae_valid_enc_value = document.forms[0].tot_valid_ae_enc_with_gl;\n\t\tvar ip_valid_enc_value = document.forms[0].tot_valid_ip_enc_with_gl;\n\t\tvar dc_valid_enc_value = document.forms[0].tot_valid_dc_enc_with_gl;\n\t\tvar tot_invalid_entry = 0;\n\t\tvar op_invalid_entry = 0;\n\t\tvar ae_invalid_entry = 0;\n\t\tvar ip_invalid_entry = 0;\n\t\tvar dc_invalid_entry = 0;\n\n\t\tif(eval(tot_valid_enc_with_gl) == 0)\n\t\t{\n\t\t\talert(getMessage(\"BL6430\",\"BL\"));\n\t\t\tobj.value=\'\';\n\t\t\tobj.select();\n\t\t\treturn false;\n\t\t}\n\n\t\tif(op_valid_enc_value.value != \"\")\n\t\t{\n\t\t\tif(eval(tot_valid_enc_with_gl) < eval(op_valid_enc_value.value))\n\t\t\t{\n\t\t\t\ttot_invalid_entry++;\n\t\t\t\top_invalid_entry++;\n\t\t\t}\n\t\t}\n\n\t\tif(ae_valid_enc_value.value != \"\")\n\t\t{\n\t\t\tif(eval(tot_valid_enc_with_gl) < eval(ae_valid_enc_value.value))\n\t\t\t{\n\t\t\t\ttot_invalid_entry++;\n\t\t\t\tae_invalid_entry++;\n\t\t\t\tae_valid_enc_value.value=tot_valid_enc_with_gl;\n\t\t\t}\n\t\t}\n\n\t\tif(ip_valid_enc_value.value != \"\")\n\t\t{\n\t\t\tif(eval(tot_valid_enc_with_gl) < eval(ip_valid_enc_value.value))\n\t\t\t{\n\t\t\t\ttot_invalid_entry++;\n\t\t\t\tip_invalid_entry++;\n\t\t\t\tip_valid_enc_value.value=tot_valid_enc_with_gl;\n\t\t\t}\n\t\t}\n\n\t\tif(dc_valid_enc_value.value != \"\")\n\t\t{\n\t\t\tif(eval(tot_valid_enc_with_gl) < eval(dc_valid_enc_value.value))\n\t\t\t{\n\t\t\t\ttot_invalid_entry++;\n\t\t\t\tdc_invalid_entry++;\n\t\t\t\tdc_valid_enc_value.value=tot_valid_enc_with_gl;\n\t\t\t}\n\t\t}\n\n\t\tif(tot_invalid_entry > 0 )\n\t\t{\n\t\t\talert(getMessage(\"BL6427\",\"BL\"));\n\t\t\tif(op_invalid_entry > 0)\n\t\t\t{\n\t\t\t\top_valid_enc_value.value=tot_valid_enc_with_gl;\n\t\t\t}\n\t\t\tif(ae_invalid_entry > 0)\n\t\t\t{\n\t\t\t\tae_valid_enc_value.value=tot_valid_enc_with_gl;\n\t\t\t}\n\t\t\tif(ip_invalid_entry > 0)\n\t\t\t{\n\t\t\t\tip_valid_enc_value.value=tot_valid_enc_with_gl;\n\t\t\t}\n\t\t\tif(dc_invalid_entry > 0)\n\t\t\t{\n\t\t\t\tdc_valid_enc_value.value=tot_valid_enc_with_gl;\n\t\t\t}\n\t\t}\n\t}\n}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block14_2Bytes = _getBytes( _wl_block14_2 );

    private final static java.lang.String  _wl_block15 ="\n\n<body onLoad=\'funDisable(1);dfltslmt();curr_desc_1();disableFields();disable();\' onMouseDown=\"CodeArrest()\" >\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<body onLoad=\'disableMappingItems();dfltslmt();curr_desc_1();disableFields();disable();\' onMouseDown=\"CodeArrest()\" >\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<body onLoad=\'funDisable(2);dfltslmt();curr_desc_1();disableFields();disable();\' onMouseDown=\"CodeArrest()\" > \n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<form name=\'PatFinCase2Form\' id=\'PatFinCase2Form\' method=\'post\' action=\'\'  scrolling=no >\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<td align=\'left\' class=\'columnHeader\' colspan=\'12\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<th align=\'left\' class=\'columnHeader\' colspan=\'15\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<tr>\n<!-- The following changes are done for Internationalisation Process\nAlign removed & legend id added by Manivel Natarajan on 10/Aug/2006 -->\n<!--\n\t\t\t<td width=\"\" align=\"right\" class=\"label\" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Settlement Indicator</td>\n\t\t\t<td width=\"\" align=\"left\" class=\'label\'>&nbsp;<select name=\'cash_settl_ind\' id=\'cash_settl_ind\' disabled ><option value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' selected>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option></td>\n\t\t\t<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'>\n-->\n<!--\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td width=\"25%\" class=\'fields\'><select name=\'cash_settl_ind\' id=\'cash_settl_ind\' disabled ><option value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option></td>\n\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option></td>\n-->\n\t\t<input type=\'hidden\' name=\'cash_settl_ind\' id=\'cash_settl_ind\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'>\n\t\t<td width=\"25%\" class=\"label\"  >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t<td class=\'fields\' width=\"25%\" ><select name=\'cash_set_type1\' id=\'cash_set_type1\' ><option value=\'\'>---";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="---</option>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="      \n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<input type=\'hidden\' name=\'cash_set_type1\' id=\'cash_set_type1\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\n\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<!--\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" ><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t</tr>\t\t\t\n\n\t<tr> \n\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\'  name=\'credit_doc_start_date1\' id=\'credit_doc_start_date1\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);\' onClick=\"return showCalendar_loc(\'credit_doc_start_date1\',document.forms[0].credit_doc_start_date1);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\n\t\t<td width=\"25%\" class=\'fields\'><input type=\'text\' name=\'credit_doc_start_date1\' id=\'credit_doc_start_date1\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);\' onClick=\"return showCalendar_loc(\'credit_doc_start_date1\',document.forms[0].credit_doc_start_date1);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_date1\' id=\'credit_doc_date1\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);\'  onClick=\"return showCalendar_loc(\'credit_doc_date1\',document.forms[0].credit_doc_date1);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\n\t\t<td width=\"25%\"  class=\'fields\' ><input type=\'text\' name=\'credit_doc_date1\' id=\'credit_doc_date1\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'  onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);\'><img src=\"../../eCommon/images/CommonCalendar.gif\"  onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);\' onClick=\"return showCalendar_loc(\'credit_doc_date1\',document.forms[0].credit_doc_date1);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\t\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\n\t</tr>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t<td class=\"label\" width=\"25%\" ></td>\n\t\t<td class=\"label\" width=\"25%\" ></td>\n\t</tr>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\t\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\"  >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'>\n\t\t<td class=\'fields\' width=\"35%\" ><select name=\'cash_set_type1\' id=\'cash_set_type1\' ><option value=\'\'>---";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="      \n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<td width=\"25%\" >&nbsp;</td>\n\t\t<td width=\"25%\" >&nbsp;</td>\n\t</tr>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n<!--\n\t\t<td width=\"25%\" class=\'fields\'><input type=\'text\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t<td width=\"25%\" class=\'fields\'><input type=\'text\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t </tr>\t\t\t\n\n\t<tr> \n\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td> \n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_start_date1\' id=\'credit_doc_start_date1\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);\'  onClick=\"return showCalendar_loc(\'credit_doc_start_date1\',document.forms[0].credit_doc_start_date1);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t\n\t\t<td width=\"25%\" class=\'fields\'  ><input type=\'text\' name=\'credit_doc_start_date1\' id=\'credit_doc_start_date1\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);\'><img src=\"../../eCommon/images/CommonCalendar.gif\"  onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);\' onClick=\"return showCalendar_loc(\'credit_doc_date1\',document.forms[0].credit_doc_date1);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\t\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_date1\' id=\'credit_doc_date1\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'  onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);\'><img src=\"../../eCommon/images/CommonCalendar.gif\"  onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date1,document.forms[0].encounter_date_aft_trunc);\' onClick=\"return showCalendar_loc(\'credit_doc_date1\',document.forms[0].credit_doc_date1);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t</tr>\n<!--\n\t\t<td width=\"\" align=\"right\" class=\"label\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Doc Reference </td>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t<td width=\"\" align=\"left\" colspan=\"2\">&nbsp;<input type=\'text\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' size=\'50\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<td width=\"\" align=\"left\" colspan=\"2\">&nbsp;<input type=\'text\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' size=\'60\' maxlength=\'20\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t<td colspan=\"2\">&nbsp;</td>\n\t</tr>\n-->\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t<tr>\n\t\t<td align=\'left\' colspan=\'4\'><div id=\'pkg_disc_disp\' style=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'><a class=\'label\' href=\"javascript:packageDiscountfromVisit(document.forms[0].patient_id.value,document.forms[0].calling_module_id.value);\">[";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="]</a></div></td>\n\t</tr>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\t\n\t<tr>\t\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\n\t\t\t\t<select name=\'search_by_items\' id=\'search_by_items\' onChange=\'srch_by_crit_for_cust();\'>\n<!--\n\t\t\t\t\t<option value=\'CG\' >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</option>\n-->\n\t\t\t\t\t<option value=\'CY\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</option>\n\t\t\t\t\t<option value=\'RN\' SELECTED>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</option>\n\t\t\t\t</select>\n\t\t</td>\n\n\t\t<td width=\"25%\" class=\"label\"><b id=\'srch_by_leg\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\"srch_by_desc\" id=\"srch_by_desc\" maxlength=\'30\' size=\'30\'  tabindex=\'0\' value=\"\" onBlur=\"return srchbylkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"srchbybut\" id=\"srchbybut\" value=\'?\' onClick=\"return srchbylkup(\'C\')\" tabindex=\'0\'><input type= \'hidden\' name=\"search_code\" id=\"search_code\"  value=\"\"></td>\t\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\t\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</div></td>\n\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\"cust_group_desc_1\" id=\"cust_group_desc_1\" maxlength=\'15\' size=\'30\'  tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" onBlur=\"return credit_custgrouplkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"cust1but\" id=\"cust1but\" value=\'?\' onClick=\"return credit_custgrouplkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'><input type= \'hidden\' name=\"cust_group_code_1\" id=\"cust_group_code_1\"  value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"></td>\n\t\t<td width=\"25%\">&nbsp;</td>\n\t\t<td width=\"25%\">&nbsp;</td>\n\t</tr>\n\n\t<tr> \n\t\t<td width=\"25%\" class=\"label\"><a href=\"javascript:getCustDet();\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a>&nbsp;&nbsp;<div id=\"cust_curr_desc_disp\" style=\"display:none\"><Font color=\'red\'><b id=\"cust_curr_desc_val\"></b></font></div>\t\n\t\t<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'2\'></td>\n\t\t<td width=\"25%\" class=\'fields\' nowrap><input type=\'text\' name=\"cust_1_desc\" id=\"cust_1_desc\" maxlength=\'40\' size=\'30\'  tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" onBlur=\"return credit_custlkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"cust1but\" id=\"cust1but\" value=\'?\' onClick=\"return credit_custlkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\t\t<input type= hidden name=\"cust_1\" id=\"cust_1\"  value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t<input type=\'hidden\' name=\'cust_curr_code\' id=\'cust_curr_code\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t<input type= \"hidden\" name=\"cust_curr_desc\" id=\"cust_curr_desc\"  value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t<input type= hidden name=\"cust_valid_from_date\" id=\"cust_valid_from_date\"  value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t<input type= hidden name=\"cust_valid_to_date\" id=\"cust_valid_to_date\"  value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\n\t\t<!--\n\t\t\n\t\t<td width=\"\" align=\"right\" class=\"label\"><a href=\"javascript:getCustDet();\">Customer</a>\t\n\t\t<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'2\'></td>\n\t\t<td width=\"\" align=\"left\" colspan=\"2\"><select name=\'cust_1\' id=\'cust_1\'  ><option value=\'\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----Select-----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n     ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\n\t     </select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\t\t\n\t\t -->\n\t\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' onBlur=\"chk_for_gl_valid(document.forms[0].credit_doc_ref1)\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" onKeyPress=\'return CheckForSpecCharsAllNotAlwSpc_local(event)\' onBlur=\"chk_for_gl_valid(document.forms[0].credit_doc_ref1)\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n<!--\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' onBlur=\"chk_for_gl_valid(document.forms[0].credit_doc_ref1)\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\n   </tr>\n\n\t<tr>\n\t\t<td width=\"25%\"  class=\"label\">";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);\'><img src=\"../../eCommon/images/CommonCalendar.gif\"  onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date1,document.forms[0].encounter_date_aft_trunc);\' onClick=\"return showCalendar_loc(\'credit_doc_start_date1\',document.forms[0].credit_doc_start_date1);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="     \n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\t\n\t</tr>\n\t</tr>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t<tr>\n\t\t<td align=\'left\' colspan=\'4\'><div id=\'pkg_disc_disp\' style=\'display:none\'><a class=\'label\' href=\"javascript:packageDiscountfromVisit(document.forms[0].patient_id.value,document.forms[0].calling_module_id.value);\">[";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\t\n\t<tr>\n\t\t<td align=\'left\' class=\'columnHeader\' colspan=\'4\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\n\t</tr>\n\n\t<tr>\n\t\t<td width=\"25%\"  class=\"label\" colspan=4>\n\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t<input type=\'text\' name=\'tot_valid_enc_with_gl\' id=\'tot_valid_enc_with_gl\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry_total(this)\'><input type=\'hidden\' name=\'tot_availed_enc_with_gl\' id=\'tot_availed_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t<input type=\'text\' name=\'tot_valid_op_enc_with_gl\' id=\'tot_valid_op_enc_with_gl\' size=\'2\' maxlength=\'2\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry(document.forms[0].tot_valid_op_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)\'><input type=\'hidden\' name=\'tot_availed_op_enc_with_gl\' id=\'tot_availed_op_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t<input type=\'text\' name=\'tot_valid_ae_enc_with_gl\' id=\'tot_valid_ae_enc_with_gl\' size=\'2\' maxlength=\'2\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry(document.forms[0].tot_valid_ae_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)\'><input type=\'hidden\' name=\'tot_availed_ae_enc_with_gl\' id=\'tot_availed_ae_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t<input type=\'text\' name=\'tot_valid_ip_enc_with_gl\' id=\'tot_valid_ip_enc_with_gl\' size=\'2\' maxlength=\'2\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry(document.forms[0].tot_valid_ip_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)\'><input type=\'hidden\' name=\'tot_availed_ip_enc_with_gl\' id=\'tot_availed_ip_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\n\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t<input type=\'text\' name=\'tot_valid_dc_enc_with_gl\' id=\'tot_valid_dc_enc_with_gl\' size=\'2\' maxlength=\'2\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry(document.forms[0].tot_valid_dc_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)\'><input type=\'hidden\' name=\'tot_availed_dc_enc_with_gl\' id=\'tot_availed_dc_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n<!--\n\t\t<input type=\'hidden\' name=\'gl_doc_ref_exist_YN\' id=\'gl_doc_ref_exist_YN\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n-->\n\t\t<input type=\'hidden\' name=\'tot_valid_enc_with_gl\' id=\'tot_valid_enc_with_gl\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'tot_valid_op_enc_with_gl\' id=\'tot_valid_op_enc_with_gl\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'tot_valid_ae_enc_with_gl\' id=\'tot_valid_ae_enc_with_gl\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'tot_valid_ip_enc_with_gl\' id=\'tot_valid_ip_enc_with_gl\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'tot_valid_dc_enc_with_gl\' id=\'tot_valid_dc_enc_with_gl\' value=\'\'>\n\n\t\t<input type=\'hidden\' name=\'tot_availed_enc_with_gl\' id=\'tot_availed_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t<input type=\'hidden\' name=\'tot_availed_op_enc_with_gl\' id=\'tot_availed_op_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t\t<input type=\'hidden\' name=\'tot_availed_ae_enc_with_gl\' id=\'tot_availed_ae_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t\t<input type=\'hidden\' name=\'tot_availed_ip_enc_with_gl\' id=\'tot_availed_ip_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t\t<input type=\'hidden\' name=\'tot_availed_dc_enc_with_gl\' id=\'tot_availed_dc_enc_with_gl\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t<!--\n\t\t<tr>\n\t\t<td width=\"\" >&nbsp;</td>\n\t\t<td width=\"\"  colspan=\"5\">&nbsp;<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'3\'></td>\n\t\t</tr>\n\t\t-->\n<!--\n    <tr>\n\t\t<td width=\"25%\"  class=\"label\">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' readonly name=\"cust_group_desc\" id=\"cust_group_desc\" maxlength=\'30\' size=\'30\'  tabindex=\'0\' value=\"\"><input type=\'button\' class=\'button\' name=\"custgroupbut\" id=\"custgroupbut\" value=\'?\' onClick=\"return custgrouplkup1()\" tabindex=\'0\'></td>\n\t\t<input type= hidden name=\"cust_group_1\" id=\"cust_group_1\"  value=\"\">\t\t\n-->\t\t\n\t<tr>\t\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</div></td>\n\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\n\t\t\t\t<select name=\'search_by_items\' id=\'search_by_items\' onChange=\'srch_by_crit_for_cust();\'>\n<!--\n\t\t\t\t\t<option value=\'CG\' SELECTED>";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</td>\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\"srch_by_desc\" id=\"srch_by_desc\" maxlength=\'30\' size=\'30\'  tabindex=\'0\' value=\"\" onBlur=\"return srchbylkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"srchbybut\" id=\"srchbybut\" value=\'?\' onClick=\"return srchbylkup(\'C\')\" tabindex=\'0\'><input type= hidden name=\"search_code\" id=\"search_code\"  value=\"\"></td>\t\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n<div id=\'egl_id_type\' >\n<tr>\t\n<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n<td width=\"25%\"  class=\'fields\' ><select name=\"identify_type\" id=\"identify_type\" id=\'identify_type\' tabIndex=\'3\' >\n\t\t\n<!--<option value=\"\">---";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="---</option>\n<option value=\"01\">Old IC</option>\n<option value=\"02\">New IC (Eliminate dash)</option>\n<option value=\"03\">Millitary Card Number</option>\n<option value=\"04\">Police Card Number</option>\n<option value=\"05\">Mother\'s IC </option>\n<option value=\"06\">Father\'s IC </option>\n<option value=\"07\">Work Permit</option>\n<option value=\"08\">Passport</option>\n<option value=\"09\">Birth Certificate</option>\n<option value=\"10\">Pension Card</option>\n<option value=\"11\">Driving License</option>\n<option value=\"20\">MRN</option> -->\n\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="      \n</select>\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="      \n<img src=\'../../eCommon/images/mandatory.gif\'>\n<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</td>\n<td width=\"25%\"  class=\'fields\' > <input type =\'text\' id=\'nid\' name=\'nid\' id=\'nid\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' size=30 length=20>\n<img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;\n\n\n<input type=button class=\'button\' id=\'eGL\' name=\'eGL\' id=\'eGL\' value=\"eGL\" onClick=\"eGLInterface()\" ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =" >\n\n\n </td>\n</div>\n</tr>\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</div></td>\n\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' name=\"cust_group_desc_2\" id=\"cust_group_desc_2\" maxlength=\'15\' size=\'30\'  tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" onBlur=\"return custgrouplkup1(\'B\')\"><input type=\'button\' class=\'button\' name=\"cust1but\" id=\"cust1but\" value=\'?\' onClick=\"return custgrouplkup1(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'><input type= \'hidden\' name=\"cust_group_code_2\" id=\"cust_group_code_2\"  value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"></td>\n\t\t<td width=\"25%\">&nbsp;</td>\n\t\t<td width=\"25%\">&nbsp;</td>\n\t</tr>\n\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\"><a href=\"javascript:getCustDetSponser();\">";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</a>&nbsp;&nbsp;<div id=\"cust_curr_desc_disp\" style=\"display:none\" align=\'right\'><Font color=\'red\'><b id=\"cust_curr_desc_val\"></b></font></div>\n\t\t<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'3\'></td>\n\t\t<td width=\"25%%\" class=\'fields\' ><input type=\'text\' name=\"cust_2_desc\" id=\"cust_2_desc\" maxlength=\'40\' size=\'30\'  tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" onBlur=\"return cust2grouplkup(\'B\')\"><input type=\'button\' class=\"button\" name=\"cust2but\" id=\"cust2but\" value=\'?\' onClick=\"return cust2grouplkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\t\t<input type= hidden name=\"cust_2\" id=\"cust_2\"  value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\n\t\t<td width=\"25%\"  class=\"label\">";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n<!--\n\t\t<td width=\"25%\" class=\'fields\'  ><input type=\'text\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' onBlur=\"chk_for_gl_valid(document.forms[0].credit_doc_ref2)\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t<td width=\"25%\" class=\'fields\'  ><input type=\'text\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"  onBlur=\"chk_for_gl_valid(document.forms[0].credit_doc_ref2)\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n<!--\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" onKeyPress=\'return CheckForSpecChars_local(event)\' onBlur=\"chk_for_gl_valid(document.forms[0].credit_doc_ref2)\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\n     </tr>\n\n\t<tr>\n\t \t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td> \n ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_start_date2\' id=\'credit_doc_start_date2\' size=\'10\' maxlength=\'10\'  value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date2,document.forms[0].encounter_date_aft_trunc);\'><img name=\'credit_doc_start_date2Img\' src=\"../../eCommon/images/CommonCalendar.gif\"  onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date2,document.forms[0].encounter_date_aft_trunc);\' onClick=\"return showCalendar_loc(\'credit_doc_start_date2\',document.forms[0].credit_doc_start_date2);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_start_date2\' id=\'credit_doc_start_date2\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date2,document.forms[0].encounter_date_aft_trunc);\'><img name=\'credit_doc_start_date2Img\'  src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\'return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_start_date2,document.forms[0].encounter_date_aft_trunc);\'onClick=\"return showCalendar_loc(\'credit_doc_start_date2\',document.forms[0].credit_doc_start_date2);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t<td width=\"25%\"  class=\"label\">";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'credit_doc_date2\' id=\'credit_doc_date2\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date2,document.forms[0].encounter_date_aft_trunc);\'><img name=\'credit_doc_date2Img\'  src=\"../../eCommon/images/CommonCalendar.gif\"  onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date2,document.forms[0].encounter_date_aft_trunc);\' onClick=\"return showCalendar_loc(\'credit_doc_date2\',document.forms[0].credit_doc_date2);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date2,document.forms[0].encounter_date_aft_trunc);\'><img  name=\'credit_doc_date2Img\'  src=\"../../eCommon/images/CommonCalendar.gif\" onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date2,document.forms[0].encounter_date_aft_trunc);\' onClick=\"return showCalendar_loc(\'credit_doc_date2\',document.forms[0].credit_doc_date2);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t<tr>\n\t\t<td align=\'left\' class=\'columnHeader\' colspan=\'4\'>";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry_total(this)\'><input type=\'hidden\' name=\'tot_availed_enc_with_gl\' id=\'tot_availed_enc_with_gl\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry(document.forms[0].tot_valid_op_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)\'><input type=\'hidden\' name=\'tot_availed_op_enc_with_gl\' id=\'tot_availed_op_enc_with_gl\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry(document.forms[0].tot_valid_ae_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)\'><input type=\'hidden\' name=\'tot_availed_ae_enc_with_gl\' id=\'tot_availed_ae_enc_with_gl\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry(document.forms[0].tot_valid_ip_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)\'><input type=\'hidden\' name=\'tot_availed_ip_enc_with_gl\' id=\'tot_availed_ip_enc_with_gl\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\n\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\' style=\'text-align:right\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'chk_max_entry(document.forms[0].tot_valid_dc_enc_with_gl,document.forms[0].tot_valid_enc_with_gl)\'><input type=\'hidden\' name=\'tot_availed_dc_enc_with_gl\' id=\'tot_availed_dc_enc_with_gl\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n\n<!--\n\t\t\t<input type=\'hidden\' name=\'gl_doc_ref_exist_YN\' id=\'gl_doc_ref_exist_YN\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n-->\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n\n";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n<!-- The following changes are done for Internationalisation Process\nblank row removed by Manivel Natarajan on 10/Aug/2006 -->\n<!--\n\t<tr><td colspan=\'6\'>&nbsp;</td></tr>\n-->\n\t\t<!--<tr><td colspan=\'6\'>&nbsp;</td></tr>-->\n";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n    <tr>\n\t\t<td width=\"25%\"  class=\"label\" >";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'4\'></td> \n\t\n\t\t<td width=\"25%\" class=\'fields\' ><select name=\'cust_3\' id=\'cust_3\' onchange=\'return changeOnSelectCustomer(this);\'><option value=\'\'>---";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="      \n\t   </select><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n<!--\t<td width=\"\" align=\"right\" class=\"label\"><a href=\"javascript:getPolicySearch();\">Policy Type</a></td>\n-->\n\t\t<td width=\"25%\"  class=\"label\" ><a href=\"javascript:getPolicySearch();\">";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</a></td>\n\n<!--\t<td width=\"\" align=\"left\" colspan=\"2\"> -->\n\t\t<td width=\"25%\" class=\'fields\' ><select name=\'policy_type\' id=\'policy_type\'><option value=\'\'>---";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="      \n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'><!--<a href=\"javascript:getPolicySearch();\">View Policy</a>--><!--<input type=\'button\' class=\'button\' name=\'policy_search\' id=\'policy_search\' value=\'?\' onClick=\'return getPolicySearch();\'>--></td>\n\t</tr>\n\t<tr>\n\t    <td width=\"\" class=\"label\">";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'policy_no\' id=\'policy_no\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t<td width=\"25%\" class=\'fields\'><input type=\'text\' name=\'policy_no\' id=\'policy_no\' size=\'30\' maxlength=\'30\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t<td class=\'fields\' width=\"25%\"  ><input type=\'text\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\'onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].policy_expiry_date,document.forms[0].encounter_date_aft_trunc);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'policy_expiry_date\',document.forms[0].policy_expiry_date);\" onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].policy_expiry_date,document.forms[0].encounter_date_aft_trunc);\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t<td class=\'fields\' width=\"25%\" ><input type=\'text\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' size=\'10\' maxlength=\'10\' onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].policy_expiry_date,document.forms[0].encounter_date_aft_trunc);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'policy_expiry_date\',document.forms[0].policy_expiry_date);\" onBlur=\'return chkDtGreaterEqualThanEncDateNew(document.forms[0].policy_expiry_date,document.forms[0].encounter_date_aft_trunc);\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t</tr>\n\t\n\t<tr>\n\t\t<td class=\'label\' width=\"25%\" class=\"label\"><a href=\"javascript:getNonInsBlngGrpSearch();\">";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</a></td>\t\n\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\n\t <!--\n\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t -->\n\n\t\t<td class=\'fields\' width=\"25%\"><input type=\'text\' readonly name=\"non_ins_billing_group_desc\" id=\"non_ins_billing_group_desc\" maxlength=\'30\' size=\'30\' tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" ><input type=\'button\' class=\'button\' name=\"noninsblnggrpbut\" id=\"noninsblnggrpbut\" value=\'?\' onClick=\"return noninsblnggrplkup()\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\t\t<input type= hidden name=\"non_insur_blng_grp\" id=\"non_insur_blng_grp\"  value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\n\t\t<td width=\"25%\" ></td>\n\t\t<td width=\"25%\" ></td>\n\t</tr>\n";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n   <tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</td>\n\t\t<td class=\'fields\' width=\"25%\"  ><input type=\'text\' name=\'credit_auth_ref\' id=\'credit_auth_ref\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\"></td>\n\t\t<td  width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</td>\n\t\t<td class=\'fields\' width=\"25%\" ><input type=\'text\' name=\'credit_auth_date\' id=\'credit_auth_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' onBlur=\'return chkDtLessWithSysDate(this,sys_date);\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'credit_auth_date\',document.forms[0].credit_auth_date);\" onBlur=\'return chkDtLessWithSysDate(document.forms[0].credit_auth_date,sys_date);\'></td>\n\t</tr>\n\t\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</td>\n\t\t<td class=\'fields\' width=\"25%\" ><input type=\'text\' name=\'app_days\' id=\'app_days\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' onBlur=\'return valfield(this);\'></td>\n\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="</td>\n\t\t<td class=\'fields\' width=\"25%\" ><input type=\'text\' name=\'app_amount\' id=\'app_amount\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' onBlur=\'return valfield(this);\'></td>\n\t</tr>\n\n\t<tr>\n\t\t<td width=\"25%\"  class=\"label\">";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="</td>\n\t\t<td class=\'fields\' width=\"25%\"  ><input type=\'text\' name=\'eff_frm_date\' id=\'eff_frm_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\' onBlur=\'return chkDtLessWithSysDate(this,sys_date);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'eff_frm_date\',document.forms[0].eff_frm_date);\" onBlur=\'return chkDtLessWithSysDate(document.forms[0].eff_frm_date,sys_date);\'></td>\n\t\t<td width=\"\"></td>\n\t\t<td width=\"\"></td>\n    </tr>\n\t\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n\t<tr><td colspan=6>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t<tr>\n\t\t<td width=\'25%\'>&nbsp;</td>\n\t\t<td width=\'25%\'>&nbsp;</td>\n\t\t<td width=\'25%\'>&nbsp;</td>\n\t\t<td width=\'25%\'>&nbsp;</td>\n\t</tr>\n\n<input type=\'hidden\' name=\'gl_doc_ref_exist_YN\' id=\'gl_doc_ref_exist_YN\' value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'>\n<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\'>\n<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'>\n<input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' value=\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\'>\n<input type=\'hidden\' name=\'adm_rec_flag\' id=\'adm_rec_flag\' value=\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\'>\t\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'>\n<input type=\'hidden\' name=\'ins_auth_flag\' id=\'ins_auth_flag\' value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'>\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n<input type=\'hidden\' name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n<input type=\'hidden\' name=\"bl_data_from_repos_yn\" id=\"bl_data_from_repos_yn\" value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\t\n<input type=\'hidden\' name=\"items_disabled\" id=\"items_disabled\" value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'>\t\n<input type=\'hidden\' name=\"calling_module_id\" id=\"calling_module_id\" value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'>\t\n<input type=\'hidden\' name=\"function_id\" id=\"function_id\" value=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\'>\t\n<input type=\'hidden\' name=\"operation_fun\" id=\"operation_fun\" value=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'>\t\n<input type=\'hidden\' name=\"operation_mode\" id=\"operation_mode\" value=\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\'>\t\n<input type=\'hidden\' name=\"billing_mode\" id=\"billing_mode\" value=\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'>\t\n<input type=hidden name=\'operation\' id=\'operation\'\tvalue=\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'>\n<input type=\'hidden\' name=\'CitizenYn\' id=\'CitizenYn\' value=\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'>\n<input type=\'hidden\' name=\'blnggrpappyn\' id=\'blnggrpappyn\' value=\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\'>\t\t\n<input type=\'hidden\' name=\'blnggrpcatgappyn\' id=\'blnggrpcatgappyn\' value=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'>\n<input type=\'hidden\' name=\'BlngGrpStatus\' id=\'BlngGrpStatus\' value=\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'>\t\t\n<input type=\'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\'>\n<input type=\'hidden\' name=\"dflt_slmt_type_code\" id=\"dflt_slmt_type_code\"  value=\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\'>\n<input type=\'hidden\' name=\"sel_frm_prev_enc\" id=\"sel_frm_prev_enc\"  value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'>\n\n<input type=\'hidden\' name=\'selecltd_cust_grp_frm_pkg\' id=\'selecltd_cust_grp_frm_pkg\' value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n<input type=\'hidden\' name=\'selecltd_cust_frm_pkg\' id=\'selecltd_cust_frm_pkg\' value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n\n<input type=\'hidden\' name=\'encounter_date_aft_trunc\' id=\'encounter_date_aft_trunc\' value=\'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\'>\n\n<input type=\'hidden\' name=\'third_party_gl_in_use_yn\' id=\'third_party_gl_in_use_yn\' value=\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\'>\n\n<input type=\'hidden\' name=\'cash_slmt_type\' id=\'cash_slmt_type\' value=\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\'>\n<input type=\'hidden\' name=\'package_enabled_yn\' id=\'package_enabled_yn\' value=\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\'>\n\n<input type=\'hidden\' name=\'fin_class_flag_YN\' id=\'fin_class_flag_YN\' value=\'";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\'>\n<input type=\'hidden\' name=\'autoFinChk\' id=\'autoFinChk\' value=\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'>\n<input type=\'hidden\' name=\'class_code\' id=\'class_code\' value=\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\'>\n<input type=\'hidden\' name=\'payerGrpBySetup\' id=\'payerGrpBySetup\' value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'>\n<input type=hidden name=\'logged_user_id\' id=\'logged_user_id\'   value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\'>\n<input type=\'hidden\' name=\'strclientip\' id=\'strclientip\' value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'>\n<input type=\'hidden\' name=\'site_id\' id=\'site_id\' value=\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'> \n\n\n</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 =" \n\n";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	PreparedStatement pstmt_pack= null;
	Statement stmt1				= null;
	//Connection conn				= null;//V210413
	ResultSet rs4				= null;
	ResultSet rs5				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rs_pack				= null;
	String  nid  ="";
	ResultSet rs1				= null;
	CallableStatement call_pkg = null;

	String locale			= (String)session.getAttribute("LOCALE");
	//String sql=""; //V210413
	boolean site_id = false;
	try
	{
		//conn = ConnectionManager.getConnection();	//V210413
		con	=	ConnectionManager.getConnection(request);//V210413
		//site_id = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","DISP_CUST_LONG_DESC");
		site_id = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_CUST_LONG_DESC");
		System.err.println("site_id"+site_id);
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in site specific "+e);
	}
	finally{
	//	ConnectionManager.returnConnection(conn);//V210413
		System.err.println("Conection closed");
	}
	session.setAttribute( "siteSpecf", site_id );	

	try
  	{
		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
		//con	=	ConnectionManager.getConnection(request);//V210413
		
		Properties p = (Properties)httpSession.getValue("jdbc");
		String strclientip=p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";		
		
		String strLoggedUser = p.getProperty("login_user");
		if(strLoggedUser == null) strLoggedUser="";
		
//		System.err.println("querstring  in 2.jsp page:"+request.getQueryString());
		String nd_settlement_ind ="",/*ar_install_yn="",*/query_cust="", strEpisodeType="", str_function_id="";
		String nd_adm_rec_flag ="";
		String slmt_type_code="",dflt_slmt_type_code="", cash_slmt_flag="", cust_code1="",ins_auth_flag="";
		String mcash_set_type1="", mcust_1="", mcust_group_1="", mcredit_doc_ref1="", mcredit_doc_date1="", mcredit_doc_start_date1="", mcust_2="",mcust_group_2="";
		String mcredit_doc_ref2="", mcredit_doc_date2="",mcredit_doc_start_date2="", mcust_3="", mins_cust_priority="",mpolicy_type="", mpolicy_no="";
		String mpolicy_start_date="",mpolicy_expiry_date="", mnon_insur_blng_grp="", sys_date="",sys_date_wht_sec="";
		String mcredit_auth_ref="", mcredit_auth_date="", mapp_days="",mapp_amount="",meff_frm_date="",meff_to_date="";	
		String billing_group="";
		String str_cust_grp_code_for_pkg="", str_cust_code_for_pkg="";
		String payerGrpBySetup="";

		String rtn_slmt_type_code="";String rtn_credit_cust_group_code="";String rtn_credit_cust_code="";String rtn_credit_doc_ref="";String rtn_credit_doc_end_date="";String rtn_credit_doc_start_date="";String rtn_sponsor_cust_group_code="";String rtn_sponsor_cust_code="";String rtn_sponsor_credit_doc_ref="";String rtn_sponsor_credit_doc_end_date="";String rtn_sponsor_credit_doc_start_date="";String rtn_ins_cust_group_code="";String rtn_ins_cust_code="";String rtn_ins_cust_priority="";String rtn_ins_policy_type_code="";String rtn_ins_policy_no="";String rtn_ins_policy_start_date="";String rtn_ins_policy_expiry_date="";String rtn_non_ins_blng_grp="";String rtn_ins_credit_auth_ref="";String rtn_ins_credit_auth_date="";String rtn_ins_credit_approval_days="";String rtn_ins_credit_approval_amount="";String rtn_ins_policy_eff_from_date="";String rtn_ins_policy_eff_to_date="";

		String rtn_tot_valid_enc_with_gl="", rtn_tot_valid_op_enc_with_gl="", rtn_tot_valid_ae_enc_with_gl="", rtn_tot_valid_ip_enc_with_gl ="", rtn_tot_valid_dc_enc_with_gl="";

		String rtn_no_of_enc_gl_availed ="0", rtn_no_of_op_enc_gl_availed ="0", rtn_no_of_ae_enc_gl_availed ="0", rtn_no_of_ip_enc_gl_availed= "0", rtn_no_of_dc_enc_gl_availed ="0";

		String fin_class_flag_YN="N",autoFinChk="N",class_code = "",class_blng_grp_id="";
		String rtn_gl_doc_ref_exist_YN="N";
		String third_party_gl_in_use_yn ="", third_party_gl_mandatory_yn="";
		String encounter_date_time = "", encounter_date_aft_trunc="";
		String str_valid_pkg_for_pat_bg_avail_YN="N";
		String str_facility_id = (String)httpSession.getValue("facility_id");

		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		String strSettlementDesc = "0";
		String billing_mode =(String) request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");

		str_function_id = request.getParameter("calling_function_id");
		if(str_function_id == null) str_function_id="";
		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}

		if(operation==null) operation = "Insert";

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="N";

		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";

		third_party_gl_in_use_yn = request.getParameter("third_party_gl_in_use_yn");
		if(third_party_gl_in_use_yn == null) third_party_gl_in_use_yn="N";

		third_party_gl_mandatory_yn = request.getParameter("third_party_gl_mandatory_yn");
		if(third_party_gl_mandatory_yn == null) third_party_gl_mandatory_yn="N";
		
		//added by sarathkumar 27/june/16 for ML-MMOH-SCF-0399.1 
		//if count is greater than zero then egl should be enabled
		int eglEnableCount=Integer.parseInt(BLHelper.getDescriptionViaSQL(con,"select count(*) from XH_STANDARD_PROFILE where PROFILE_ID ='EGLPROF1' and EFF_STATUS = 'E'"));
		
		payerGrpBySetup = request.getParameter("payerGrpBySetup");
		if(payerGrpBySetup == null) payerGrpBySetup="N";
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				billing_group=((String)bl_data.get("blng_grp")).trim();
				rtn_slmt_type_code=((String)bl_data.get("slmt_type_code")).trim();
				rtn_credit_cust_group_code=((String)bl_data.get("credit_cust_group_code")).trim();
				rtn_credit_cust_code=((String)bl_data.get("credit_cust_code")).trim();
				rtn_credit_doc_ref=((String)bl_data.get("credit_doc_ref")).trim();
				rtn_credit_doc_start_date=((String)bl_data.get("credit_doc_start_date")).trim();
				rtn_credit_doc_end_date=((String)bl_data.get("credit_doc_end_date")).trim();
				rtn_sponsor_cust_group_code=((String)bl_data.get("sponsor_cust_group_code")).trim();
				rtn_sponsor_cust_code=((String)bl_data.get("sponsor_cust_code")).trim();
				rtn_sponsor_credit_doc_ref=((String)bl_data.get("sponsor_credit_doc_ref")).trim();
				rtn_sponsor_credit_doc_start_date=((String)bl_data.get("sponsor_credit_doc_start_date")).trim();
				rtn_sponsor_credit_doc_end_date=((String)bl_data.get("sponsor_credit_doc_end_date")).trim();
				rtn_ins_cust_group_code=((String)bl_data.get("ins_cust_group_code")).trim();
				rtn_ins_cust_code=((String)bl_data.get("ins_cust_code")).trim();
				rtn_ins_cust_priority=((String)bl_data.get("ins_cust_priority")).trim();
				rtn_ins_policy_type_code=((String)bl_data.get("ins_policy_type_code")).trim();
				rtn_ins_policy_no=((String)bl_data.get("ins_policy_no")).trim();
				rtn_ins_policy_start_date=((String)bl_data.get("ins_policy_start_date")).trim();
				rtn_ins_policy_expiry_date=((String)bl_data.get("ins_policy_expiry_date")).trim();
				rtn_ins_credit_auth_ref=((String)bl_data.get("ins_credit_auth_ref")).trim();
				rtn_ins_credit_auth_date=((String)bl_data.get("ins_credit_auth_date")).trim();
				rtn_ins_credit_approval_days=((String)bl_data.get("ins_credit_approval_days")).trim();
				rtn_ins_credit_approval_amount=((String)bl_data.get("ins_credit_approval_amount")).trim();
				rtn_ins_policy_eff_from_date=((String)bl_data.get("ins_policy_eff_from_date")).trim();
				rtn_ins_policy_eff_to_date=((String)bl_data.get("ins_policy_eff_to_date")).trim();

				rtn_tot_valid_enc_with_gl =((String)bl_data.get("tot_valid_enc_with_gl")).trim();
				rtn_tot_valid_op_enc_with_gl =((String)bl_data.get("tot_valid_op_enc_with_gl")).trim();
				rtn_tot_valid_ae_enc_with_gl =((String)bl_data.get("tot_valid_ae_enc_with_gl")).trim();
				rtn_tot_valid_ip_enc_with_gl =((String)bl_data.get("tot_valid_ip_enc_with_gl")).trim();
				rtn_tot_valid_dc_enc_with_gl =((String)bl_data.get("tot_valid_dc_enc_with_gl")).trim();


				rtn_no_of_enc_gl_availed =((String)bl_data.get("no_of_enc_gl_availed")).trim();
				rtn_no_of_op_enc_gl_availed =((String)bl_data.get("no_of_op_enc_gl_availed")).trim();
				rtn_no_of_ae_enc_gl_availed =((String)bl_data.get("no_of_ae_enc_gl_availed")).trim();
				rtn_no_of_ip_enc_gl_availed =((String)bl_data.get("no_of_ip_enc_gl_availed")).trim();
				rtn_no_of_dc_enc_gl_availed =((String)bl_data.get("no_of_dc_enc_gl_availed")).trim();

				rtn_gl_doc_ref_exist_YN =((String)bl_data.get("gl_doc_ref_exist_YN")).trim();
				
				if(rtn_tot_valid_enc_with_gl == null) rtn_tot_valid_enc_with_gl="";
				if(rtn_tot_valid_op_enc_with_gl == null) rtn_tot_valid_op_enc_with_gl="";
				if(rtn_tot_valid_ae_enc_with_gl == null) rtn_tot_valid_ae_enc_with_gl="";
				if(rtn_tot_valid_ip_enc_with_gl == null) rtn_tot_valid_ip_enc_with_gl="";
				if(rtn_tot_valid_dc_enc_with_gl == null) rtn_tot_valid_dc_enc_with_gl="";

				if(rtn_no_of_enc_gl_availed == null) rtn_no_of_enc_gl_availed="0";
				if(rtn_no_of_op_enc_gl_availed == null) rtn_no_of_op_enc_gl_availed="0";
				if(rtn_no_of_ae_enc_gl_availed == null) rtn_no_of_ae_enc_gl_availed="0";
				if(rtn_no_of_ip_enc_gl_availed == null) rtn_no_of_ip_enc_gl_availed="0";
				if(rtn_no_of_dc_enc_gl_availed == null) rtn_no_of_dc_enc_gl_availed="0";
/*
if(autoFinChk.equals("Y"))
{
	System.err.println("Inside Class Loop in 2.jsp");
	class_code = ((String)bl_data.get("class_code")).trim();
}
*/
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");	
			if( billing_group == null) billing_group="";
/*			
HashMap bl_data=(HashMap)session.getAttribute("financial_details");
if(!(bl_data==null || bl_data.isEmpty()))
{
	if(autoFinChk.equals("Y"))
	{
		System.err.println("Inside Class Loop in 2.jsp");
		class_code = ((String)bl_data.get("class_code")).trim();
	}
}
*/
		}
		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}
		String strdfltbgyn = "N";
		String srtencdfltbgyn="N";

		String strBlngGrpAppYN= "Y";
		String strBlngGrpStatus="";
		String strCategory = "";
		String strBlngGrpCatgAppYN = "Y";		

		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		String clinic_code = request.getParameter("clinic_code");
		String visit_type_code = request.getParameter("visit_type_code");
		String strshowHideBlngClass = request.getParameter("show_hide_blng_class");
		if (strshowHideBlngClass == null) strshowHideBlngClass = "";

		String l_credit_doc_ref_desc = "";
		String l_credit_doc_ref_start_date = "";
		String l_credit_doc_ref_date =  "";
		String l_cust_code = "";
		String l_slmt_ind = "";
		String l_adm_rec_flag = "";

		String str_blng_grp_id = "";
		String str_short_desc = "";	

		String cust_code_1 = "", cust_group_code_1 = "", str_cust_curr_code="",str_cust_curr_desc="";
		String short_name_1 = "", cust_group_desc_1 = "";

		String cust_code_2 = "" , cust_group_code_2 = "";
		String short_name_2 = "", cust_group_desc_2 = "" ;

		String patient_id = request.getParameter("patient_id");		
		if (patient_id == null ) patient_id = "";

		String strCitizenYn = "N";		
		String nationalityyn = "";
		String cust_valid_from_date = "" , cust_valid_to_date = "";
		String  str_charge_logic = "";

		try
		{
			String query_date="select NVL(charge_logic_yn,'N') charge_logic,to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from bl_parameters where operating_facility_id='"+str_facility_id+"'";
			stmt1 = con.createStatement();
			rs4 = stmt1.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{
					str_charge_logic = rs4.getString(1);
					sys_date = rs4.getString(2);
					sys_date_wht_sec = rs4.getString(3);			
				}
			}
			if(rs4 !=null) rs4.close();
			stmt1.close();
		/* Commented and added below for PE Changes
			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt1 = con.createStatement();
			rs4 = stmt1.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date_wht_sec = rs4.getString(1);
				}
			}
			if(rs4 !=null) rs4.close();
			stmt1.close();
		*/
		}
		catch(Exception e)
		{
			out.println("Exception @ install"+e);
			e.printStackTrace();
		}
		/* Commented for PE Changes and values are passed from AddModifyPatFinDetails.jsp
		try
		{
			String sql2 = "select nvl(third_party_gl_in_use_yn,'N') third_party_gl_in_use_yn, nvl(third_party_gl_mandatory_yn,'N') third_party_gl_mandatory_yn,to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from bl_parameters where operating_facility_id = '"+str_facility_id +"'";
			System.err.println("sql2="+str_facility_id+"/"+sql2);
			pstmt = con.prepareStatement(sql2);
			rs4 = pstmt.executeQuery() ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					third_party_gl_in_use_yn = rs4.getString("third_party_gl_in_use_yn");
					third_party_gl_mandatory_yn = rs4.getString("third_party_gl_mandatory_yn");
					sys_date = rs4.getString(3);
					sys_date_wht_sec = rs4.getString(4);			
				}
			}
			if (rs4 != null) rs4.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in sql2:"+e);
		}
		if (third_party_gl_in_use_yn == null ) third_party_gl_in_use_yn ="";
		if (third_party_gl_mandatory_yn == null ) third_party_gl_mandatory_yn ="";
		*/
		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		if(encounter_date_time.equals(""))
		encounter_date_time = sys_date_wht_sec;

		try
		{
			String sql_trunc_time="select to_char( (to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

		//	stmt1 = con.createStatement();
			pstmt=con.prepareStatement(sql_trunc_time);
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
			e.printStackTrace();
		}
		if(!encounter_date_aft_trunc.equals(""))
		{
			encounter_date_aft_trunc = com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale) ;
		}

		strCitizenYn = request.getParameter("CitizenYn");
		if(strCitizenYn == null) strCitizenYn="N";
		/*		
		if(!patient_id.equals(""))
		{
			String sqlCiti = "select citizen_yn from mp_patient where patient_id ='"+patient_id+"'";
			pstmt = con.prepareStatement(sqlCiti);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() )
				{  
					strCitizenYn = rs2.getString("citizen_yn");
				}
			}
			if(rs2 !=null) rs2.close();
			if(pstmt != null) pstmt.close();	
		}
		*/
		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

		/*
			String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg,nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N') last_enc_bg from bl_mp_param ";
			pstmt = con.prepareStatement(sql0);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
			while( rs2.next() )
			{  
				strdfltbgyn = rs2.getString("bg");
				srtencdfltbgyn=rs2.getString("last_enc_bg");
			}
			}
			if(pstmt != null) pstmt.close();
			if(rs2 !=null) rs2.close();

			if ( strdfltbgyn == null) strdfltbgyn = "N";
			if ( srtencdfltbgyn == null) srtencdfltbgyn="N";
		*/
		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}
		String sqlstr="select credit_doc_ref_desc, to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date, to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date, cust_code, settlement_ind, decode(non_ins_blng_grp_id,null,decode(settlement_ind,'X',1,0),2) adm_rec_flag from bl_patient_fin_dtls where patient_id = ? ";
		pstmt = con.prepareStatement(sqlstr);
		pstmt.setString(1,patient_id);
		rs5 = pstmt.executeQuery();
		if( rs5 != null ) 
		{
			while( rs5.next() )
			{  
				l_credit_doc_ref_desc =  rs5.getString("credit_doc_ref_desc");
				l_credit_doc_ref_start_date =  rs5.getString("credit_doc_ref_start_date");
				l_credit_doc_ref_date =  rs5.getString("credit_doc_ref_date");
				l_cust_code =  rs5.getString("cust_code");	
				l_slmt_ind = rs5.getString("settlement_ind");			
				l_adm_rec_flag = rs5.getString("adm_rec_flag");			
			}
		}
		if(rs5 !=null) rs5.close();
		if(pstmt != null) pstmt.close();
		if (l_credit_doc_ref_desc == null) l_credit_doc_ref_desc = "";
		if (l_credit_doc_ref_start_date == null) l_credit_doc_ref_start_date = "";
		if (l_credit_doc_ref_date == null) l_credit_doc_ref_date = "";
		if (l_cust_code == null) l_cust_code = "";
		if (l_slmt_ind == null) l_slmt_ind = "";
		if (l_adm_rec_flag == null) l_adm_rec_flag = "";		
		
		String strCreditDoc_YN="N";
		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");

		String package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";
		String pkg_disc_disp = "";

		if (strModuleId.equals("OP")) 
		{
			strEpisodeType = "O";
		}
		else if (strModuleId.equals("AE")) 
		{
			strEpisodeType = "E";
		}
		else if (strModuleId.equals("IP")) 
		{
			strEpisodeType = "I";
		}
		else if (strModuleId.equals("DC")) 
		{
			strEpisodeType = "D";
		}
		else if(strModuleId.equals("MP"))
		{
			strEpisodeType = "R";
		}
		
		String strExtSettlType ="";
		String strSettlTypeOverride ="";		

		nationalityyn = request.getParameter("nationality_yn");		
	    if (nationalityyn == null) nationalityyn = "";	

		if (strModuleId.equals("MP"))
		{
			strCitizenYn = nationalityyn;
			strdfltbgyn = "Y";
		}

		if (strRepositoryYN == null)
		{
			strRepositoryYN = "";
		}

		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}
		if (strModuleId ==null)
		{
			strModuleId = "";		
		}	
		if (strRepositoryYN.equals("Y") && strModuleId.equals("MP"))
		{

			String strTempFunId = request.getParameter("id_fun");
			if (strTempFunId== null)
			{
				strExtSettlType = rtn_slmt_type_code;
			}
			else if (strTempFunId.equals("1"))
			{
				strExtSettlType = request.getParameter("set_typ_from_frame1");
			}
			
			if (strExtSettlType == null)
			{
				strExtSettlType = "";
			}
			
			try
			{
				StringTokenizer strTokenizer = new StringTokenizer(strItemsDisabled,"|");
				String strTotData = "";
				int intIdx = 0;
				String strColumn="";
				String strOverride ="N";
				while(strTokenizer.hasMoreElements())
				{	
					strTotData = strTokenizer.nextToken();
					intIdx = strTotData.indexOf("-");
					strColumn = strTotData.substring(0,intIdx);
					strOverride = strTotData.substring(intIdx+1);
					if (strColumn.equals("cash_set_type1")) 
					{
						if (strOverride.equals("N"))
						{
							strSettlTypeOverride = "N";
						}
						else 
						{
							strSettlTypeOverride = "Y";
						}
					}
				}
			}
			catch(Exception excep)
			{
				excep.printStackTrace();
			}
		}
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			mcash_set_type1		= rtn_slmt_type_code;// rtn_slmt_type_code
			if ( mcash_set_type1 == null ) mcash_set_type1 ="";			
			
			mcust_group_1	= rtn_credit_cust_group_code;
			if (mcust_group_1 == null) mcust_group_1 = "";
			
			mcust_1				= rtn_credit_cust_code;//rtn_credit_cust_code
			if (mcust_1 == null) mcust_1 = "";			

			mcredit_doc_ref1	= rtn_credit_doc_ref;//rtn_credit_doc_ref
			if ( mcredit_doc_ref1 == null ) mcredit_doc_ref1 = "";			

			mcredit_doc_date1	= rtn_credit_doc_end_date;//rtn_credit_doc_end_date
			if ( mcredit_doc_date1 == null ) mcredit_doc_date1 ="";

			mcredit_doc_start_date1	= rtn_credit_doc_start_date;//rtn_credit_doc_start_date
			if ( mcredit_doc_start_date1 == null ) mcredit_doc_start_date1 = "";

			mcust_group_2		= rtn_sponsor_cust_group_code;
			if(mcust_group_2 == null) mcust_group_2="";

			mcust_2				= rtn_sponsor_cust_code;// rtn_sponsor_cust_code
			if ( mcust_2 == null ) mcust_2 = "";			

			mcredit_doc_ref2	= rtn_sponsor_credit_doc_ref;//rtn_sponsor_credit_doc_ref
			if ( mcredit_doc_ref2 == null ) mcredit_doc_ref2 = "";

			mcredit_doc_date2	= rtn_sponsor_credit_doc_end_date;//rtn_sponsor_credit_doc_end_date
			if ( mcredit_doc_date2 == null ) mcredit_doc_date2 = "";		

			mcredit_doc_start_date2	= rtn_sponsor_credit_doc_start_date;//rtn_sponsor_credit_doc_start_date

			if ( mcredit_doc_start_date2 == null ) mcredit_doc_start_date2 = "";
			if(mcredit_doc_start_date2.equals(""))
			{
				mcredit_doc_start_date2	= rtn_sponsor_credit_doc_start_date;//rtn_sponsor_credit_doc_start_date
			if ( mcredit_doc_start_date2 == null ) mcredit_doc_start_date2 = "";
			}				
			
			mcust_3		=rtn_ins_cust_code;//rtn_ins_cust_code 

			if ( mcust_3 == null ) mcust_3 = "";
			mins_cust_priority	= rtn_ins_cust_priority;//rtn_ins_cust_priority

			if ( mins_cust_priority == null ) mins_cust_priority = "";
			mpolicy_type	= rtn_ins_policy_type_code;//rtn_ins_policy_type_code

			if ( mpolicy_type == null ) mpolicy_type = "";
			mpolicy_no	= rtn_ins_policy_no;//rtn_ins_policy_no

			if ( mpolicy_no == null ) mpolicy_no ="";
			mpolicy_start_date	= rtn_ins_policy_start_date;//rtn_ins_policy_start_date

			if ( mcust_3 == null ) mcust_3 = "";
			
			mpolicy_expiry_date = rtn_ins_policy_expiry_date;//rtn_ins_policy_expiry_date
			if ( mpolicy_expiry_date == null ) mpolicy_expiry_date = "";			

			mnon_insur_blng_grp = rtn_non_ins_blng_grp;//rtn_non_ins_blng_grp 
			if ( mnon_insur_blng_grp == null ) mnon_insur_blng_grp = "";

			mcredit_auth_ref	= rtn_ins_credit_auth_ref;//rtn_ins_credit_auth_ref
			if ( mcredit_auth_ref == null ) mcredit_auth_ref = "";
			
			mcredit_auth_date	= rtn_ins_credit_auth_date;//rtn_ins_credit_auth_date
			if ( mcredit_auth_date == null ) mcredit_auth_date = "";			

			mapp_days			= rtn_ins_credit_approval_days;//rtn_ins_credit_approval_days
			if  ( mapp_days == null ) mapp_days = ""; 

			mapp_amount			= rtn_ins_credit_approval_amount;//rtn_ins_credit_approval_amount 
			if ( mapp_amount == null ) mapp_amount = "";

			meff_frm_date		= rtn_ins_policy_eff_from_date;//rtn_ins_policy_eff_from_date 
			if ( meff_frm_date == null ) meff_frm_date = "";

			meff_to_date		= rtn_ins_policy_eff_to_date;//rtn_ins_policy_eff_to_date 
			if ( meff_to_date == null ) meff_to_date = "";

			clinic_code			= request.getParameter("clinic_code");
			if ( clinic_code == null ) clinic_code = "";

			visit_type_code		= request.getParameter("visit_type_code");
			if ( visit_type_code == null ) visit_type_code = "";			
		}		

		if((mpolicy_type==null) || (mpolicy_type.equals("null")))
		mpolicy_type = java.net.URLEncoder.encode(mpolicy_type);

		if((mcredit_auth_ref==null) || (mcredit_auth_ref.equals("null"))) mcredit_auth_ref="";
		if((mcredit_auth_date==null) || (mcredit_auth_date.equals("null"))) mcredit_auth_date="";
		if((mapp_days==null) || (mapp_days.equals("null"))) mapp_days="";
		if((mapp_amount==null) || (mapp_amount.equals("null"))) mapp_amount="";
		if((meff_frm_date==null) || (meff_frm_date.equals("null"))) meff_frm_date="";
		if((clinic_code==null) || (clinic_code.equals("null"))) clinic_code="";
		if((visit_type_code==null) || (visit_type_code.equals("null"))) visit_type_code="";

		nd_settlement_ind = request.getParameter("setlmt_ind");
		if(nd_settlement_ind == null) nd_settlement_ind = "";
		nd_adm_rec_flag = request.getParameter("adm_rec_flag");
		if(nd_adm_rec_flag == null) nd_adm_rec_flag = "";

		strCreditDoc_YN = request.getParameter("credit_doc_ref_reqd_yn");
		if(strCreditDoc_YN == null) strCreditDoc_YN = "";
	/* Commented for PE Changes, values are passed from 6.jsp
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			sql="select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N') from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		else
		{
			sql="select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N') from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				nd_settlement_ind = rs.getString("settlement_ind");
				nd_adm_rec_flag = rs.getString("adm_rec_flag");
				strCreditDoc_YN = rs.getString(3);
			}
		}
		if(rs !=null) rs.close();
		if(pstmt != null) pstmt.close();

		if(nd_settlement_ind==null)nd_settlement_ind="";
		if(nd_adm_rec_flag==null)nd_adm_rec_flag="";	
	*/		

		if (l_slmt_ind.equals(nd_settlement_ind) && (nd_adm_rec_flag.equals(l_adm_rec_flag) ||l_slmt_ind.equals("C")||l_slmt_ind.equals("R")))
		{
			if (l_credit_doc_ref_desc == null) l_credit_doc_ref_desc = "";
		}
		else
		{
			l_credit_doc_ref_desc = "";
			l_credit_doc_ref_start_date = "";
			l_credit_doc_ref_date = "";
			l_cust_code = "";
			l_slmt_ind = "";
			l_adm_rec_flag = "";		
		}
		
		if(!patient_id.equals("") && !billing_group.equals(""))
		{
			try
			{
				call_pkg = con.prepareCall("{ ? = call  blcore.package_blng_grp_yn(?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?)}");
				call_pkg.registerOutParameter(1,java.sql.Types.VARCHAR);

				call_pkg.setString(2,str_facility_id);
				call_pkg.setString(3,patient_id);
				call_pkg.setString(4,strEpisodeType);
				call_pkg.setString(5,str_function_id);
				call_pkg.setString(6,billing_group);
				call_pkg.setString(7,com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en"));
				call_pkg.setString(8,"B");
				if(strCitizenYn.equals("Y"))
				{
					call_pkg.setString(9,"NATIONALS");
				}
				else
				{
					call_pkg.setString(9,"OTHERS");
				}

				call_pkg.execute();							
				str_valid_pkg_for_pat_bg_avail_YN = call_pkg.getString(1);				
				call_pkg.close();
				if ( str_valid_pkg_for_pat_bg_avail_YN == null ) str_valid_pkg_for_pat_bg_avail_YN = "";
			}
			catch(Exception e)
			{
				System.out.println("Exception while chekcing package:"+e.toString());
				out.println("Exception while chekcing package:"+e.toString());
				e.printStackTrace();
			}

			if(str_valid_pkg_for_pat_bg_avail_YN.equals("Y"))
			{
				String sql_pkg_dtl_hdr_qry="SELECT A.CUST_GROUP_CODE,A.CUST_CODE FROM bl_patient_package_hdr A, BL_PRICE_CLASS_LANG_VW B, BL_BLNG_GRP_LANG_VW C WHERE A.operating_facility_id = '"+str_facility_id+"' AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"' and B.LANGUAGE_ID = C.LANGUAGE_ID and  A.PRICE_CLASS_CODE = B.PRICE_CLASS_CODE AND A.BLNG_GRP_ID = C.BLNG_GRP_ID AND A.patient_id = '"+patient_id+"' AND to_date('"+com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en")+"','DD/MM/YYYY') BETWEEN eff_date_from AND nvl(eff_date_to, to_date('"+com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY",locale,"en")+"','DD/MM/YYYY')) AND A.status = 'O' and A.BLNG_GRP_ID='"+billing_group+"'";

				pstmt_pack = con.prepareStatement(sql_pkg_dtl_hdr_qry);
				rs_pack = pstmt_pack.executeQuery() ;

				if( rs_pack != null) 
				{
					while( rs_pack.next() )
					{
						String str_cust_grp_code=rs_pack.getString(1);
						if(str_cust_grp_code == null) str_cust_grp_code="";

						str_cust_grp_code_for_pkg = str_cust_grp_code_for_pkg + str_cust_grp_code + "@@";

						String str_cust_code=rs_pack.getString(2);
						if(str_cust_code == null) str_cust_code="";

						str_cust_code_for_pkg = str_cust_code_for_pkg + str_cust_code + "@@";
					}
				}
				if (rs_pack != null)   rs_pack.close();
				if (pstmt_pack != null) pstmt_pack.close();
			}
		}
		
	//unused variable, commented on 09/06/05
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
		

            _bw.write(_wl_block6Bytes, _wl_block6);


            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nd_settlement_ind));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nd_adm_rec_flag));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nd_settlement_ind));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nd_adm_rec_flag));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block13_0Bytes, _wl_block13_0);
            _bw.write(_wl_block13_1Bytes, _wl_block13_1);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block14_0Bytes, _wl_block14_0);
            _bw.write(_wl_block14_1Bytes, _wl_block14_1);
            _bw.write(_wl_block14_2Bytes, _wl_block14_2);

		if(operation.equals("Update"))
		{

            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		else if (strRepositoryYN.equals("Y") && strModuleId.equals("MP") )
		{

            _bw.write(_wl_block16Bytes, _wl_block16);

		}
		else
		{

            _bw.write(_wl_block17Bytes, _wl_block17);

		}

            _bw.write(_wl_block18Bytes, _wl_block18);

		if (nd_settlement_ind.equals("X")  && nd_adm_rec_flag.equals("2"))
		{

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		else
		{

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}

		if(strModuleId.equals("MP") && (nd_settlement_ind.equals("C")))		
		{

//			if (nd_settlement_ind.equals("C"))
//				strSettlementDesc = "Cash Settlement";
				

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(nd_settlement_ind ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strSettlementDesc ));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nd_settlement_ind ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strSettlementDesc ));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nd_settlement_ind ));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nd_settlement_ind ));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

//Added By Vijay For MLMMOH-SCF-0754
		try{
			Boolean siteSpec=false;
			System.err.println("billing_group before change "+billing_group);
			siteSpec=	siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_CUST_LONG_DESC");
			if(siteSpec)
			{
				String billingGroup=request.getParameter("billingGroup");
				System.out.println("billing Grp "+billingGroup);	
				if(!(billingGroup==null || ("").equals(billingGroup)))
				{
					billing_group=billingGroup;
				}
			}
			System.err.println("billing_group after change  "+billing_group);
			//Ends



			pstmt = con.prepareStatement( "Select dflt_slmt_type_code from bl_blng_grp where BLNG_GRP_ID=? "); 
			pstmt.setString(1,billing_group);
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
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in gettng dflt_slmt_type_code "+e);
		}
			finally{
				if(rs2 !=null) rs2.close();
				pstmt.close() ;
					}
			pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where status is null and language_id='"+locale+"' order by short_desc  " ) ;
			
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					slmt_type_code = rs2.getString( "slmt_type_code" ) ;
					String short_desc = rs2.getString( "short_desc" ) ;
					cash_slmt_flag=rs2.getString("cash_slmt_flag") ;
					if(mcash_set_type1.equals(slmt_type_code))
					{
						out.println("<option selected value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
					}
					else
					{
						out.println("<option value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
					}
				}
			}
			
			if(rs2 !=null) rs2.close();
			pstmt.close() ;

            _bw.write(_wl_block31Bytes, _wl_block31);

			if (strRepositoryYN.equals("Y") && strModuleId.equals("MP") && strSettlTypeOverride.equals("N"))
			{

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strExtSettlType ));
            _bw.write(_wl_block33Bytes, _wl_block33);

			}
			if(nd_adm_rec_flag.equals("0") && strCreditDoc_YN.equals("Y"))
			{	

            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mcredit_doc_ref1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mcredit_doc_ref1));
            _bw.write(_wl_block37Bytes, _wl_block37);

				}
				else
				{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(l_credit_doc_ref_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(l_credit_doc_ref_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);

				}

            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{									   

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(mcredit_doc_start_date1,"DMY","en",locale)));
            _bw.write(_wl_block40Bytes, _wl_block40);

				}
				else
				{

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_start_date,"DMY","en",locale)));
            _bw.write(_wl_block42Bytes, _wl_block42);

				}

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(mcredit_doc_date1,"DMY","en",locale)));
            _bw.write(_wl_block45Bytes, _wl_block45);

				}
				else
				{

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_date,"DMY","en",locale)));
            _bw.write(_wl_block47Bytes, _wl_block47);

				}

            _bw.write(_wl_block48Bytes, _wl_block48);
 
			}
			else
			{

            _bw.write(_wl_block49Bytes, _wl_block49);

			}

            _bw.write(_wl_block50Bytes, _wl_block50);

		}
		else if((nd_settlement_ind.equals("C") && nd_adm_rec_flag.equals("0"))) 
		{ 
//			System.err.println("Inside Cash");

            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

		//Added By Vijay For MLMMOH-SCF-0754
		try{
			Boolean siteSpec=false;
			System.out.println("billing_group before change "+billing_group);
			siteSpec=	siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_CUST_LONG_DESC");
			if(siteSpec)
			{
				String billingGroup=request.getParameter("billingGroup");
				System.out.println("billing Grp "+billingGroup);	
				if(!(billingGroup==null || ("").equals(billingGroup)))
				{
					billing_group=billingGroup;
				}
			}
			System.out.println("billing_group after change  "+billing_group);
			//Ends
			pstmt = con.prepareStatement( "Select dflt_slmt_type_code from bl_blng_grp where BLNG_GRP_ID=? "); 
			pstmt.setString(1,billing_group);
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
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in getting dflt_slmt_type_code "+e);
		}
			finally{
			if(rs2 !=null) rs2.close();
			pstmt.close() ;
			}
			pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where status is null and language_id='"+locale+"' order by short_desc  " ) ;
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					slmt_type_code = rs2.getString( "slmt_type_code" ) ;
					String short_desc = rs2.getString( "short_desc" ) ;
					cash_slmt_flag=rs2.getString("cash_slmt_flag") ;
					if(mcash_set_type1.equals(slmt_type_code))
					{
						out.println("<option selected value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
					}
					else
					{
						out.println("<option value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
					}
				}
			}
			if(rs2 !=null) rs2.close();
			pstmt.close() ;

            _bw.write(_wl_block53Bytes, _wl_block53);
 
			if (strCreditDoc_YN.equals("N"))
			{	

            _bw.write(_wl_block54Bytes, _wl_block54);

			}
		
		/***** 
				The following code is added by Murugavel 
				for the Customization on 10 Aug 2002
				Purpose : If the Customer has the Credit Doc Required flag
						Yes., then it is mandatory for him to 
						provide the cred doc date and the 
						reference
				New Variables: strCreditDoc_YN.
				New Hidden Form field: credit_doc_yn
				Credit Doc Date should accept only the future date and the

		******/

			if (strCreditDoc_YN.equals("Y"))
			{	

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(mcredit_doc_ref1));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(mcredit_doc_ref1));
            _bw.write(_wl_block37Bytes, _wl_block37);

				}
				else
				{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(l_credit_doc_ref_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(l_credit_doc_ref_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);

				}

            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(mcredit_doc_start_date1,"DMY","en",locale)));
            _bw.write(_wl_block60Bytes, _wl_block60);

				}
				else
				{

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_start_date,"DMY","en",locale)));
            _bw.write(_wl_block40Bytes, _wl_block40);

				}

            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(mcredit_doc_date1,"DMY","en",locale)));
            _bw.write(_wl_block63Bytes, _wl_block63);

				}
				else
				{

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_date,"DMY","en",locale)));
            _bw.write(_wl_block65Bytes, _wl_block65);

				}

            _bw.write(_wl_block66Bytes, _wl_block66);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(mcredit_doc_ref1));
            _bw.write(_wl_block68Bytes, _wl_block68);

			}
			else
			{

            _bw.write(_wl_block69Bytes, _wl_block69);

			}

            _bw.write(_wl_block70Bytes, _wl_block70);

			}	
			if(reset_blng_grp.equals("YES") && package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
			{
				pkg_disc_disp = "display:inline";
			}
			else
			{
				pkg_disc_disp = "display:none";
			}
			if(str_charge_logic.equals("N") && package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
			{

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(pkg_disc_disp));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

			}
/***** 
				The above code is added by Murugavel 
				for the Customization on 10 Aug 2002
				Purpose : If the Customer has the Credit Doc Required flag
						Yes., then it is mandatory for him to 
						provide the cred doc date and the 
						reference.
				New Variables: strCreditDoc_YN.
				
		******/

            _bw.write(_wl_block2Bytes, _wl_block2);
 
		}
		else if ( nd_settlement_ind.equals("R") ) 
		{
//			System.out.println("Inside R");

            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

			if ( mcust_1 != null || l_cust_code != null)
			{		
//6/10/2008				query_cust="select a.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b where a.language_id = b.language_id and a.language_id='"+locale+"' and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl('"+mcust_1+"','"+l_cust_code+"') and (b.cust_group_code='"+mcust_group_1+"' or '"+mcust_group_1+"' is null)";	
//String site_id= BLReportIdMapper.getCustomerId();

//if(site_id.equals("SHALM")){
	if(eglEnableCount > 0){
	//Removed insurance_yn = 'N' conditon alone for ML-MMOH-SCF-0431 by sarathkumar 29/Jun/16
	            
				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl(?,?) and (b.cust_group_code=? or ? is null)";
	}
	else{
				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl(?,?) and (b.cust_group_code=? or ? is null)";	
	}
//				System.out.println("query_cust:"+query_cust);
		
				pstmt = con.prepareStatement(query_cust) ;
				
				pstmt.setString(1,locale);
				pstmt.setString(2,strModuleId);
				pstmt.setString(3,strModuleId);
				pstmt.setString(4,strModuleId);
				pstmt.setString(5,mcust_1);
				pstmt.setString(6,l_cust_code);
				pstmt.setString(7,mcust_group_1);
				pstmt.setString(8,mcust_group_1);
				
				
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() ) 
					{
						cust_code_1 = rs.getString( "cust_code" ) ;
						short_name_1 = rs.getString( "short_name" ) ;
						cust_group_code_1 = rs.getString( "CUST_GROUP_CODE" ) ;
						cust_group_desc_1 = rs.getString( "CUST_GROUP_DESC" ) ;
						cust_valid_from_date = rs.getString( "VALID_FROM" ) ;	
						cust_valid_to_date = rs.getString( "VALID_TO" ) ;	
					}
				}
				if(rs !=null) rs.close();
				pstmt.close() ;

				if (cust_code_1 == null ) cust_code_1 = "";
				if (short_name_1 == null ) short_name_1 = "";	
				if (cust_group_code_1 == null ) cust_group_code_1 = "";	
				if (cust_group_desc_1 == null ) cust_group_desc_1 = "";	
				if (cust_valid_from_date == null) cust_valid_from_date = "";
				if (cust_valid_to_date == null) cust_valid_to_date = "";
			}
		
			if(!mcust_1.equals(""))
			{
				String cust_curr_desc_qry="Select CURRENCY_CODE,CURRENCY_DESC from ar_customer_lang_vw where cust_code='"+mcust_1+"' and language_id='"+locale+"'";
//				System.out.println("cust_curr_desc_qry:"+cust_curr_desc_qry);
				pstmt = con.prepareStatement( cust_curr_desc_qry ) ;
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
						if(pstmt != null) pstmt.close();	
				}	
			}
//			System.out.println("str_cust_curr_code:"+str_cust_curr_code);
//			System.out.println("str_cust_curr_desc:"+str_cust_curr_desc);

            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(cust_group_desc_1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(cust_group_code_1));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(short_name_1));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(cust_code_1));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(str_cust_curr_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(str_cust_curr_desc));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block90Bytes, _wl_block90);

	//	if(ar_install_yn.equals("Y"))
		
		query_cust="select cust_code, short_name from ar_customer where patient_flag = 'Y' and pat_com_flag = 'Y' and status is null and ((? in ('OP','AE') and nvl(op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(ip_yn,'N') = 'Y') or ? = 'MP') order by short_name";
		

		/************
		else if(ar_install_yn.equals("N"))
		{
			query_cust="select cust_code, short_name from bl_emp_ins_mst where status is null and insurance_yn='Y' and blng_grp_id='"+billing_group+"' order by short_name";
		}
		***********/
		pstmt = con.prepareStatement(query_cust) ;
		pstmt.setString(1,strModuleId);
		pstmt.setString(2,strModuleId);
		pstmt.setString(3,strModuleId);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				String cust_code = rs.getString( "cust_code" ) ;
				String short_name = rs.getString( "short_name" ) ;
				//if(billing_mode.equals("Modify"))
				//{
					if(mcust_1.equals(cust_code))
					{
						out.println("<option selected value=\""+cust_code+"\">"+short_name+"</option>");
					}
					else if(l_cust_code.equals(cust_code))
					{
						out.println("<option selected value=\""+cust_code+"\">"+short_name+"</option>");
					}				
					
					else
					{
						out.println("<option value=\""+cust_code+"\">"+short_name+"</option>");
					}
				//}
				//out.println( "<option value='" + cust_code + "' >" + short_name ) ;
			}
		}
		pstmt.close() ;
		
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
		
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mcredit_doc_ref1));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(mcredit_doc_ref1));
            _bw.write(_wl_block94Bytes, _wl_block94);

			}
			else
			{
		
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(l_credit_doc_ref_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(l_credit_doc_ref_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);

			}
		
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
	
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(mcredit_doc_start_date1,"DMY","en",locale)));
            _bw.write(_wl_block98Bytes, _wl_block98);

			}
			else
			{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_start_date,"DMY","en",locale)));
            _bw.write(_wl_block40Bytes, _wl_block40);

			}

            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(mcredit_doc_date1,"DMY","en",locale)));
            _bw.write(_wl_block63Bytes, _wl_block63);

			}
			else
			{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_date,"DMY","en",locale)));
            _bw.write(_wl_block63Bytes, _wl_block63);

			}

            _bw.write(_wl_block101Bytes, _wl_block101);

			if(str_charge_logic.equals("N") && package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
			{

            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

			}
			if(!(strModuleId.equals("MP")) && !(str_function_id.equals("BOOKING")))
			{

            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(rtn_tot_valid_enc_with_gl));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(rtn_no_of_enc_gl_availed));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(rtn_tot_valid_op_enc_with_gl));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(rtn_no_of_op_enc_gl_availed));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(rtn_tot_valid_ae_enc_with_gl));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(rtn_no_of_ae_enc_gl_availed));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(rtn_tot_valid_ip_enc_with_gl));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rtn_no_of_ip_enc_gl_availed));
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(rtn_tot_valid_dc_enc_with_gl));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(rtn_no_of_dc_enc_gl_availed));
            _bw.write(_wl_block118Bytes, _wl_block118);

			}
			else
			{

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(rtn_gl_doc_ref_exist_YN));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(rtn_no_of_enc_gl_availed));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(rtn_no_of_op_enc_gl_availed));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rtn_no_of_ae_enc_gl_availed));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(rtn_no_of_ip_enc_gl_availed));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(rtn_no_of_dc_enc_gl_availed));
            _bw.write(_wl_block33Bytes, _wl_block33);

			}   
		}
		else if((nd_settlement_ind.equals("X") && nd_adm_rec_flag.equals("1"))
		/*||strCreditDoc_YN.equals("Y")*/
	   ) 
		{  //System.err.println("Inside X 1");

            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

			if ( mcust_2 != null )
			{		

//6/10/2008				query_cust="select a.cust_code cust_code, a.short_name short_name,to_char(a.VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(a.VALID_TO,'dd/mm/yyyy') VALID_TO,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b  where a.language_id = b.language_id and a.language_id='"+locale+"' and a.patient_flag = 'Y' and a.pat_com_flag = 'N'   and nvl (a.insurance_yn,'N') = 'N'  and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl('"+mcust_2+"','"+l_cust_code+"') and (b.cust_group_code='"+mcust_group_2+"' or '"+mcust_group_2+"' is null)";
					if(eglEnableCount > 0){
					//Removed insurance_yn = 'N' conditon alone for ML-MMOH-SCF-0431 by sarathkumar 29/Jun/16
				
				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl(?,?) and (b.cust_group_code=? or ? is null)";
					}
					else{
						query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and a.ACC_ENTITY_CODE = b.ACC_ENTITY_CODE and b.ACC_ENTITY_CODE = c.ACC_ENTITY_CODE and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'N' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = nvl(?,?) and (b.cust_group_code=? or ? is null)";
					}
				pstmt = con.prepareStatement(query_cust) ;
//				System.out.println("query_cust:"+query_cust);

				pstmt.setString(1,locale);
				pstmt.setString(2,strModuleId);
				pstmt.setString(3,strModuleId);
				pstmt.setString(4,strModuleId);
				pstmt.setString(5,mcust_2);
				pstmt.setString(6,l_cust_code);
				pstmt.setString(7,mcust_group_1);
				pstmt.setString(8,mcust_group_1);
				
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() ) 
					{
						cust_code_2 = rs.getString( "cust_code" ) ;
						short_name_2 = rs.getString( "short_name" ) ;
						cust_group_code_2 = rs.getString( "CUST_GROUP_CODE" ) ;
						cust_group_desc_2 = rs.getString( "CUST_GROUP_DESC" ) ;
						cust_valid_from_date = rs.getString( "VALID_FROM" ) ;	
						cust_valid_to_date = rs.getString( "VALID_TO" ) ;	
					}
				}
				if(rs !=null) rs.close();
				pstmt.close() ;
	
				if (cust_code_2 == null ) cust_code_2 = "";
				if (short_name_2 == null ) short_name_2 = "";	
				if (cust_group_code_2 == null ) cust_group_code_2 = "";	
				if (cust_group_desc_2 == null ) cust_group_desc_2 = "";	
				if (cust_valid_from_date == null ) cust_valid_from_date = "";	
				if (cust_valid_to_date == null ) cust_valid_to_date = "";	
			}

			if(!mcust_2.equals(""))
			{
				String cust_curr_desc_qry="Select CURRENCY_CODE,CURRENCY_DESC from ar_customer_lang_vw where cust_code='"+mcust_2+"' and language_id='"+locale+"'";
//				System.out.println("cust_curr_desc_qry:"+cust_curr_desc_qry);
				pstmt = con.prepareStatement( cust_curr_desc_qry ) ;
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
					if(pstmt != null) pstmt.close();	
				}	
			}
//			System.out.println("str_cust_curr_code:"+str_cust_curr_code);
//			System.out.println("str_cust_curr_desc:"+str_cust_curr_desc);

            _bw.write(_wl_block1Bytes, _wl_block1);

//System.out.println("str_credit_doc_reqd_yn  "+str_credit_doc_reqd_yn);
//String strCustomerId= BLReportIdMapper.getCustomerId(); //V210413
boolean setEmpty=false;
//if(strCustomerId.equals("SHALM")&&strCreditDoc_YN.equals("Y"))
	if((eglEnableCount > 0) && strCreditDoc_YN.equals("Y"))

{
	/*Code added by Karthik to check whether to make 5 fields (cust grp,cust,doc ref,doc start date,doc end date) blank */
	if(strEpisodeType.equalsIgnoreCase("O") || strEpisodeType.equalsIgnoreCase("E")){//for OP and Emergency cases
		
		String startDate="";
		String endDate="";
		
			if((billing_mode.equals("Modify")) || (operation.equals("Update"))){
				startDate=mcredit_doc_start_date2;
				endDate=mcredit_doc_date2;
			}else{	
				startDate=l_credit_doc_ref_start_date;
				endDate=l_credit_doc_ref_date;
			}
			/* If date range does not fall within from date and to date, then set fileds to blank */
			if( endDate!=null && !endDate.equals("") ){				 
				if(com.ehis.util.DateUtils.isAfterNow(endDate, "DMY", locale)==false){ //sysdate is greater than end date i.e, sysdate doesnot fall within startdate and end date range 
					setEmpty=true;	
				}
			}

			
			
		}else if(strEpisodeType.equalsIgnoreCase("I") || strEpisodeType.equalsIgnoreCase("D") ){//for IP and Daycare Cases
			
		setEmpty=true;
		
	}

            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

			pstmt = con.prepareStatement( "select LIST_ELMT_VALUE,LIST_ELMT_LABEL  from SM_LIST_ITEM   where module_id = 'BL'  and   list_Ref  ='BLTVSTFN_EGL_IND_TYPE'  and function_id ='BL_MODIFY_FIN_DTLS'  order by list_srl_no" );
			rs1 = pstmt.executeQuery() ;
			if( rs1 != null ) 
			{
				while( rs1.next() ) 
				{
					String identifier_code = rs1.getString( "LIST_ELMT_VALUE" ) ;
					String identifier_desc = rs1.getString( "LIST_ELMT_LABEL" ) ;

					    if(identifier_code.equals("02"))
						out.println("<option value=\""+identifier_code+"\" selected>"+identifier_desc+"</option>");
						else
						out.println("<option value=\""+identifier_code+"\">"+identifier_desc+"</option>");
				
				}
			}
			if(rs1 !=null) rs1.close();
			pstmt.close() ;

            _bw.write(_wl_block132Bytes, _wl_block132);

			pstmt = con.prepareStatement( "select NVL(NATIONAL_ID_NO,ALT_ID1_NO) nid from mp_patient   where patient_id=?  " );
			pstmt.setString(1,patient_id);
			rs1 = pstmt.executeQuery() ;
			if( rs1 != null ) 
			{
				while( rs1.next() ) 
				{
					 nid = rs1.getString( "nid" ) ;		
					 if(nid==null) nid="";
				
				}
			}
			if(rs1 !=null) rs1.close();
			pstmt.close() ;

            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(nid));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf( (eglEnableCount == 0)? "disabled" :"" ));
            _bw.write(_wl_block136Bytes, _wl_block136);
} 
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf( (setEmpty==true)?"": cust_group_desc_2));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(cust_group_code_2));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf((setEmpty==true)?"":short_name_2));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(cust_code_2));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(str_cust_curr_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(str_cust_curr_desc));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(mcredit_doc_ref2));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf((setEmpty==true)?"":mcredit_doc_ref2));
            _bw.write(_wl_block146Bytes, _wl_block146);

			}	
			else
			{

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(l_credit_doc_ref_desc));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf((setEmpty==true)?"":l_credit_doc_ref_desc));
            _bw.write(_wl_block146Bytes, _wl_block146);

			}

            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf((setEmpty==true)?"":com.ehis.util.DateUtils.convertDate(mcredit_doc_start_date2,"DMY","en",locale)));
            _bw.write(_wl_block152Bytes, _wl_block152);

			}
			else
			{

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf((setEmpty==true)?"":com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_start_date,"DMY","en",locale)));
            _bw.write(_wl_block154Bytes, _wl_block154);

			}

            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf((setEmpty==true)?"":com.ehis.util.DateUtils.convertDate(mcredit_doc_date2,"DMY","en",locale)));
            _bw.write(_wl_block157Bytes, _wl_block157);

			}
			else
			{

            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf((setEmpty==true)?"":com.ehis.util.DateUtils.convertDate(l_credit_doc_ref_date,"DMY","en",locale)));
            _bw.write(_wl_block158Bytes, _wl_block158);

			}

            _bw.write(_wl_block48Bytes, _wl_block48);

			if(str_charge_logic.equals("N") && package_enabled_yn.equals("Y") && (strModuleId.equals("OP") || strModuleId.equals("IP")))
			{

            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

			}
			if(!(strModuleId.equals("MP")) && !(str_function_id.equals("BOOKING")))
			{

            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(rtn_tot_valid_enc_with_gl));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(rtn_no_of_enc_gl_availed));
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(rtn_tot_valid_op_enc_with_gl));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(rtn_no_of_op_enc_gl_availed));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(rtn_tot_valid_ae_enc_with_gl));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(rtn_no_of_ae_enc_gl_availed));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(rtn_tot_valid_ip_enc_with_gl));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(rtn_no_of_ip_enc_gl_availed));
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(rtn_tot_valid_dc_enc_with_gl));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(rtn_no_of_dc_enc_gl_availed));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(rtn_gl_doc_ref_exist_YN));
            _bw.write(_wl_block169Bytes, _wl_block169);

			}
			else
			{

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(rtn_gl_doc_ref_exist_YN));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(rtn_no_of_enc_gl_availed));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(rtn_no_of_op_enc_gl_availed));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rtn_no_of_ae_enc_gl_availed));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(rtn_no_of_ip_enc_gl_availed));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(rtn_no_of_dc_enc_gl_availed));
            _bw.write(_wl_block170Bytes, _wl_block170);

			}
		} 
		else if (nd_settlement_ind.equals("X")  && nd_adm_rec_flag.equals("2")) 
		{
			if(ins_auth_flag.equals("N"))
			{

            _bw.write(_wl_block171Bytes, _wl_block171);

			}

            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

	//	if(ar_install_yn.equals("Y"))
		//{
			query_cust="select cust_code, short_name from ar_customer_lang_vw where language_id=? and patient_flag = 'Y' and pat_com_flag = 'N'  and nvl(insurance_yn,'Y') = 'Y'   and status is null  and ((? in ('OP','AE') and nvl(op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(ip_yn,'N') = 'Y') or (? = 'MP' and nvl(ref_yn,'N') = 'Y'))  order  by short_name";
		//}
		//else
		//{
		//	query_cust="select cust_code, short_name from bl_emp_ins_mst where status is null and insurance_yn='Y' and blng_grp_id='"+billing_group+"' order by short_name";
		//}
			pstmt = con.prepareStatement(query_cust) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,strModuleId);
			pstmt.setString(3,strModuleId);
			pstmt.setString(4,strModuleId);
			
		    rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					cust_code1 = rs.getString( "cust_code" ) ;
					String short_name = rs.getString( "short_name" ) ;
					cust_code1=cust_code1.trim();
					//out.println("<script>alert("+mcust_3+");</script>");
					//	out.println("<script>alert("+cust_code1+");</script>");
					//if(billing_mode.equals("Modify"))
					//{
					if(mcust_3.equals(cust_code1))
					{
						out.println("<option selected value=\""+cust_code1+"\">"+short_name+"</option>");
					}
					else
					{
						out.println("<option value=\""+cust_code1+"\">"+short_name+"</option>");
					}
				//}
				//out.println( "<option value='" + cust_code1 + "' >" + short_name ) ;
				}
			}
			if(rs !=null) rs.close();
			pstmt.close() ;

            _bw.write(_wl_block174Bytes, _wl_block174);

			String query_policy_type="select policy_type_code, short_desc from bl_ins_policy_types_lang_vw where language_id='"+locale+"' and policy_type_code = '"+mpolicy_type+"' and nvl(status,'N') <> 'S'  order  by short_desc";
		//out.println("query_policy_type :"+query_policy_type);

            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

			pstmt = con.prepareStatement(query_policy_type) ;
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					String policy_type_code = rs.getString( "policy_type_code" ) ;
					String short_desc = rs.getString( "short_desc" ) ;
					//if(billing_mode.equals("Modify"))
					//{
						if(mpolicy_type.equals(policy_type_code))
						{
							out.println("<option selected value=\""+policy_type_code+"\">"+short_desc+"</option>");
						}
						else
						{
							out.println("<option value=\""+policy_type_code+"\">"+short_desc+"</option>");
						}
					//}
					//out.println( "<option value='" + policy_type_code + "' >" + short_desc ) ;
				}
			}
			if(rs !=null) rs.close();
			pstmt.close() ;

            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(mpolicy_no));
            _bw.write(_wl_block37Bytes, _wl_block37);

			}
			else
			{

            _bw.write(_wl_block179Bytes, _wl_block179);

			}

            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{

            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(mpolicy_expiry_date));
            _bw.write(_wl_block181Bytes, _wl_block181);

			}
			else
			{

            _bw.write(_wl_block182Bytes, _wl_block182);

			}

            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

			pstmt = con.prepareStatement( "select blng_grp_id, short_desc ,DECODE(?,'MP',ref_yn,'AE',ae_yn,'OP',op_yn,'IP',ip_yn,'DC',dy_yn)episode_type_app_yn, status , category from bl_blng_grp_lang_vw where language_id=? and (( status is null and settlement_ind || adm_rec_flag != 'X2' and ((?='MP' and ref_yn = 'Y' and ref_valid_for_regn_yn = 'Y') or (?='AE' and ae_yn = 'Y') or (?='OP' and op_yn = 'Y') or (?='IP' and ip_yn = 'Y') or (?='DC' and dy_yn = 'Y')) and (NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED'))) or (blng_grp_id = ? and NVL(?,'N') = 'Y')) order  by short_desc" ) ;
			
			pstmt.setString(1,strModuleId);
			pstmt.setString(2,locale);
			pstmt.setString(3,strModuleId);
			pstmt.setString(4,strModuleId);
			pstmt.setString(5,strModuleId);
			pstmt.setString(6,strModuleId);
			pstmt.setString(7,strModuleId);
			pstmt.setString(8,strCitizenYn);
			pstmt.setString(9,mnon_insur_blng_grp);
			pstmt.setString(10,strdfltbgyn);	

			rs = pstmt.executeQuery() ;		
			
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					String non_blng_grp_id = rs.getString( "blng_grp_id" ) ;
					String short_desc = rs.getString( "short_desc" ) ;

					if((mnon_insur_blng_grp.equals(non_blng_grp_id)) && ((strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP"))))||strModuleId.equals("MP")))
					{
						str_blng_grp_id = non_blng_grp_id;
						str_short_desc = short_desc;

						strBlngGrpAppYN = rs.getString("episode_type_app_yn");
						strBlngGrpStatus = rs.getString("status");
						strCategory = rs.getString("category");

						if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
						strBlngGrpAppYN = "N";		
						if(strBlngGrpStatus == null ||strBlngGrpStatus.equals("null")) 
						strBlngGrpStatus="";
						if(strCategory == null ||strBlngGrpAppYN.equals("null") || strCategory.equals("")) 
						strCategory="UNRESTRICTED";		

						/*out.println("<option selected value=\""+non_blng_grp_id+"\">"+short_desc+"</option>");*/

						if (strCitizenYn.equals("Y"))
						{
							if (strCategory.equals("UNRESTRICTED") || strCategory.equals("NATIONALS"))
							{
								strBlngGrpCatgAppYN = "Y";
							}
							else
							{
								strBlngGrpCatgAppYN = "N";

							}
						}
						else
						{
							if (strCategory.equals("UNRESTRICTED") || strCategory.equals("OTHERS"))
							{
								strBlngGrpCatgAppYN = "Y";
							}
							else
							{
								strBlngGrpCatgAppYN = "N";

							}
						}
					}
					else
					{
						/*
						out.println("<option value=\""+non_blng_grp_id+"\">"+short_desc+"</option>");
						*/
					}

				//}
				//out.println( "<option value='" + non_blng_grp_id + "' >" + short_desc ) ;
				}	
			}
			if(rs !=null) rs.close();
			pstmt.close() ;

            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(str_short_desc));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(str_blng_grp_id));
            _bw.write(_wl_block187Bytes, _wl_block187);

			if(ins_auth_flag.equals("Y"))
			{

            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(mcredit_auth_ref));
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(mcredit_auth_date));
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(mapp_days));
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(mapp_amount));
            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(meff_frm_date));
            _bw.write(_wl_block198Bytes, _wl_block198);

			}
			else
			{

            _bw.write(_wl_block199Bytes, _wl_block199);

			}
		}

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(rtn_gl_doc_ref_exist_YN));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(str_facility_id));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(nd_settlement_ind));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(nd_adm_rec_flag));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ins_auth_flag));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(strCreditDoc_YN));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(strRepositoryYN));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(strItemsDisabled));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(str_function_id));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(billing_mode));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(billing_mode));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(strCitizenYn));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(strBlngGrpAppYN));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(strBlngGrpCatgAppYN));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(strBlngGrpStatus));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(dflt_slmt_type_code));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(sel_frm_prev_enc));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(str_cust_grp_code_for_pkg));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(str_cust_code_for_pkg));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(encounter_date_aft_trunc));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(third_party_gl_in_use_yn));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(mcash_set_type1));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(package_enabled_yn));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(fin_class_flag_YN));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(autoFinChk));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(payerGrpBySetup));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(strLoggedUser));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(strclientip));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(site_id));
            _bw.write(_wl_block240Bytes, _wl_block240);
 
	}
	catch(Exception e)
	{ 
		out.println(e);
		e.printStackTrace();
	}
	finally
	{	
		if(stmt1 != null)		stmt1.close();
		if(pstmt != null) 	pstmt.close(); 	
		if(pstmt1 != null)	pstmt1.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block241Bytes, _wl_block241);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_POLICY_DTLS.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SLMT_DTL_DOC_REF.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SLMT_INDICATOR.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SLMT_INDICATOR.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_SETTLEMENT.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SettlementType.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_REF.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_START_DATE.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_END_DATE.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageDiscount.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchby.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.region.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.region.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_REF.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_START_DATE.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_END_DATE.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageDiscount.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MAX_NO_OF_ENC_ALLOW_FOR_CREDIT_DOC.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Outpatients.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.inpatient.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daycare.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchby.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.region.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.region.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IDENTIFY_TYPE.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NID.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_REF.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_START_DATE.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_END_DATE.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PackageDiscount.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MAX_NO_OF_ENC_ALLOW_FOR_CREDIT_DOC.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Outpatients.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.inpatient.label", java.lang.String .class,"key"));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daycare.label", java.lang.String .class,"key"));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_TYPE.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EXPIRY_DATE.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NON_INS_BILLING_GROUP.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH_REF.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH_DATE.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
}
