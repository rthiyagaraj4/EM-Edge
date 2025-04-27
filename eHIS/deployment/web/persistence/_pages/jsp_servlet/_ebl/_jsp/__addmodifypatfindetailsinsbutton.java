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
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetailsinsbutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsInsButton.jsp", 1743663706351L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<script>\n/* Provide Input FormObject(POST requestXML) and JSP Page for that FormObject Processing  */\n/* Add for GHL-CRF-0550 BY PALANI NARAYANAN  STARTS */\nvar submitParamsMain\t= \"\";\nasync function dataForImage_ghl() {\n\tvar frmObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\tvar strModuleId = document.forms[0].calling_module_id.value; \n\tvar strfunction_id =\t document.forms[0].function_id.value; \n\tvar billingGroup = \"\";\n\tif(parent.parent.parent.MainFrame1 != undefined && parent.parent.parent.MainFrame1 != \"undefined\" && parent.parent.parent.MainFrame1 != null && parent.parent.parent.MainFrame1 != \"null\") {\n\t\tbillingGroup = parent.parent.parent.MainFrame1.PatFinMainForm.billing_group.value;\n\t}\n\tif(frmObj!=\"\" && frmObj!=null && frmObj !=undefined )\n\t{\n\t\tvar xmlString=formXMLStringMain_ghl(frmObj);\t\n\t\tvar patient_id1=frmObj.patient_id.value;//GHL-CRF-0550\n\t\t//GHL-CRF-0550.1\n\t\tvar totalRecords=parent.frames[1].document.forms[0].total_records.value;\n\t\tif(totalRecords==0)\n\t\t{\n\t\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\t\treturn false;\n\t\t}\n\t\tvar checked_row=parent.frames[1].document.forms[0].checked_row.value;\n\t\t//GHL-CRF-0550.1\n\t\tif(checked_row==\"\")\n\t\t{\n\t\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tvar policy_no1=eval(\"parent.frames[1].document.forms[0].policy_no\"+checked_row);//GHL-CRF-0550.1\n\t\tvar policy_no=encodeURIComponent(policy_no1.value);\n\t\tvar temp_jsp=\"../../eBL/jsp/BLInsImageIntLoadValidation_GHL.jsp?patient_id=\" +patient_id1+\"&billingGroup=\"+billingGroup+\"&calling_module_id=\"+strModuleId+\"&checked_row=\"+checked_row+\"&policy_no=\"+policy_no+\"&total_records=\"+totalRecords;//GHL-CRF-0550.1\n\t\tvar updation=formValidation_ghl(xmlString,temp_jsp);\n\t}\n\tvar patient_id=frmObj.patient_id.value;\n\tvar setlmt_ind=document.getElementById(\"setlmt_ind\").value;\n\tvar dialogUrl       = \"../../eBL/jsp/AddModifyInsUpldImgFrame.jsp?title=Upload Document&patient_id=\" +patient_id+\"&strfunction_id=\"+strfunction_id+\"&strModuleId=\"+strModuleId+\"&checked_row=\"+checked_row+\"&totalRecords=\"+totalRecords+\"&policy_no=\"+policy_no+\"&settlement_ind=\"+setlmt_ind;//GHL-CRF-0550.1\n\tvar dialogFeatures  = \"dialogHeight:\" + \"20\" + \"; dialogWidth:\" + \"70\" +\" ; scroll=auto; \";\n\tvar returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);\n}\n/* Add for GHL-CRF-0550 BY PALANI NARAYANAN  ENDS */\n\nasync function dataForImage() {\n\tvar frmObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\t\t\n\tif(frmObj!=\"\" && frmObj!=null && frmObj !=undefined )\n\t{\n\t\tvar xmlString=formXMLStringMain(frmObj);\t\t\n\t\tvar temp_jsp=\"../../eBL/jsp/BLInsImageIntLoadValidation.jsp\";\n\t\tvar updation=formValidation(xmlString,temp_jsp);\n\t}\n\t//parent.parent.parent.frames[2].messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\tvar patient_id=frmObj.patient_id.value;\n\tvar dialogUrl       = \"../../eBL/jsp/AddModifyInsUpldImgFrame.jsp?title=Upload Document&patient_id=\" +patient_id;\n\tvar dialogFeatures  = \"dialogHeight:\" + \"400px\" + \"; dialogWidth:\" + \"700px\" +\" ; scroll=auto; \";\n\tvar returnVal = await window.showModalDialog(dialogUrl,null,dialogFeatures);\n}\n\n/* Add For GHL-CRF-0550  */\nfunction formValidation_ghl(xmlStr,temp_jsp)\n{\n\t//07-May-20 To make IE Compatibility Logics\n\tvar xmlHttp;\n\tif (window.ActiveXObject)\n\t{\n\t\t//xmlHttp = new ActiveXObject(\'Microsoft.XMLHTTP\')\n\t\txmlHttp = new XMLHttpRequest();\n\t}\n\telse\n\t{\n\t\txmlHttp = new XMLHttpRequest()\n\t}\n\n\tif(submitParamsMain!=\"\"){\n\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\txmlHttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n\t\txmlHttp.setRequestHeader(\"Content-length\",submitParamsMain.length);\n\t\txmlHttp.send(submitParamsMain);\n\t\tvar responseText=xmlHttp.responseText;\n\t}\n\treturn true;\n\t//07-May-20 To make IE Compatibility Logics\n}\n\nfunction formValidation(xmlStr,temp_jsp)\n{\t\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=xmlHttp.responseText ;\n\treturn true;\n}\t\n\nfunction formXMLStringMain(frmObj)\n{\n\tif( frmObj!=null && frmObj != \"undefined\" && frmObj.length >0)\n\t{\t\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\tif(true)\n\t\t{\n\t\tvar arrObj = frmObj.elements;\n\t\tfor(var i=0;i<arrObj.length;i++)\n\t\t{\n\t\t\tvar val = \"\" ;\n\t\t\tif(arrObj[i].type == \"checkbox\")\n\t\t\t{\n\t\t\t\tval = arrObj[i].value;\n\t\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t\t\t}\n\t\t\telse if(arrObj[i].type == \"radio\")\n\t\t\t{\n\t\t\t\tif(arrObj[i].checked)\n\t\t\t\t{\n\t\t\t\t\tval = arrObj[i].value;\n\t\t\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(arrObj[i].type == \"select-multiple\" )\n\t\t\t{\n\t\t\t\tfor(var j=0; j<arrObj[i].options.length; j++)\n\t\t\t\t{\n\t\t\t\t\tif(arrObj[i].options[j].selected)\n\t\t\t\t\t\tval+=arrObj[i].options[j].value +\"~\";\n\t\t\t\t}\n\t\t\t\tval= val.substring(0,val.lastIndexOf(\'~\'));\n\t\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tval = arrObj[i].value;\n\t\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t\t\t}\n\t\t}\n\t}\n\txmlStr +=\" /></root>\";\t\n\t}\n\treturn xmlStr;\n}\n\n/* Add For GHL-CRF-0550  */\nfunction formXMLStringMain_ghl(frmObj) {\t\n\tif (frmObj != null && frmObj != \"undefined\" && frmObj.length > 0) {\n\tvar xmlStr = \"<root><SEARCH \";\n\tif (true) {\n\t\tvar arrObj = frmObj.elements;\n\t\tfor ( var i = 0; i < arrObj.length; i++) {\n\t\t\tvar val = \"\";\n\t\t\tif (arrObj[i].type == \"checkbox\") {\n\t\t\t\tval = arrObj[i].value;\n\t\t\t\tif (arrObj[i].name != null && arrObj[i].name != \"\"){\n\t\t\t\t\t/*xmlStr += arrObj[i].name + \"=\\\"\" + checkSpl(val)\n\t\t\t\t\t\t\t+ \"\\\" \";*/\t\t\t\t\t\t\n\t\t\t\t\tsubmitParamsMain\t+= arrObj[i].name+\"=\"+checkSpl(val)+\"&\";\n\t\t\t\t}\n\t\t\t} else if (arrObj[i].type == \"radio\") {\n\t\t\t\tif (arrObj[i].checked) {\n\t\t\t\t\tval = arrObj[i].value;\n\t\t\t\t\tif (arrObj[i].name != null && arrObj[i].name != \"\"){\n\t\t\t\t\t\t/*xmlStr += arrObj[i].name + \"=\\\"\" + checkSpl(val)\n\t\t\t\t\t\t\t\t+ \"\\\" \";*/\n\t\t\t\t\tsubmitParamsMain\t+= arrObj[i].name+\"=\"+checkSpl(val)+\"&\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t} else if (arrObj[i].type == \"select-multiple\") {\n\t\t\t\tfor ( var j = 0; j < arrObj[i].options.length; j++) {\n\t\t\t\t\tif (arrObj[i].options[j].selected)\n\t\t\t\t\t\tval += arrObj[i].options[j].value + \"~\"\n\t\t\t\t}\n\t\t\t\tval = val.substring(0, val.lastIndexOf(\'~\'))\n\t\t\t\tif (arrObj[i].name != null && arrObj[i].name != \"\"){\n\t\t\t\t\t/*xmlStr += arrObj[i].name + \"=\\\"\" + checkSpl(val)\n\t\t\t\t\t\t\t+ \"\\\" \";*/\n\t\t\t\t\tsubmitParamsMain\t+= arrObj[i].name+\"=\"+checkSpl(val)+\"&\";\n\t\t\t\t}\n\t\t\t} else {\n\t\t\t\tval = arrObj[i].value;\n\t\t\t\tif (arrObj[i].name != null && arrObj[i].name != \"\"){\n\t\t\t\t\t/*xmlStr += arrObj[i].name + \"=\\\"\" + checkSpl(val)\n\t\t\t\t\t\t\t+ \"\\\" \";*/\n\t\t\t\t submitParamsMain\t+= arrObj[i].name+\"=\"+checkSpl(val)+\"&\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\t\txmlStr += \" /></root>\";\n\t}\n\treturn xmlStr;\n}\n\nfunction checkSpl( val ) {\n    var result = \"\" ;\n    var ch = \"\" ;\n\n    var indVal = 0;\n    while ( (indVal = val.indexOf(\'\\n\',indVal)) != -1 )\n    {\n        val = val.replace(\"\\n\",\"\\\"\");\n    }\n\n    var spChars = new Array( \"<\", \">\", \"&\", \"\\\"\", \"\'\" ) ;\n    var chChars = new Array( \"&lt;\", \"&gt;\", \"&amp;\", \"&quot;\", \"&apos;\" ) ;\n    for(var i=0; i<val.length; i++) {\n        for(var j=0; j<spChars.length; j++) {\n            if ( val.substring(i,i+1) == spChars[j] ) {\n                ch = chChars[j] ;\n                j=spChars.length ;\n            } else {\n                ch = val.substring(i,i+1) ;\n            }\n        }\n        result += ch ;\n    }\n    return result ;\n}\n\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\n<head>\n\n<script>\n\tvar totalRecords=0;\n\tvar formObj=\"\";\n\tvar total_records=\"\";\n\tvar checked_row=\"\";\n\tvar blng_grp_code=\"\";\n\tvar payer_desc=\"\";\n\tvar cust_3=\"\";\n\tvar priority=\"\";\n\tvar policy_type_desc=\"\";\n\tvar policy_type_code=\"\";\n\tvar policy_no=\"\";\n\tvar policy_start_date=\"\";\n\tvar policy_exp_date=\"\";\n\tvar credit_auth_ref=\"\";\n\tvar credit_auth_date=\"\";\n\tvar credit_apprd_amt=\"\";\n\tvar credit_apprd_days=\"\";\n\tvar policy_eff_frm_date=\"\";\n\tvar policy_eff_to_date=\"\";\t\n\tvar adj_rule_ind=\"\";;\n\tvar adj_perc_amt_ind=\"\";\n\tvar adj_perc_amt_value=\"\";\n\tvar pmnt_diff_adj_int=\"\";\n\tvar drg_pmnt_diff_adj_int=\"\";\n\tvar spl_srv_pmnt_diff_adj_int=\"\";\n\tvar restrict_check=\"\";\n\tvar valid_payer_YN=\"\";\n\tvar valid_policy_type_code_YN=\"\";\n\tvar payer_suspended_YN=\"\"\n\tvar policy_suspended_YN=\"\"\n\tvar cust_group_code=\"\";\n\tvar cust_group_name=\"\";\n\tvar policy_coverage_basis_ind=\"\";\n\tvar cust_valid_from_date = \"\";\n\tvar cust_valid_to_date = \"\";\n\nasync function addPayer()\n{\n\t/******************added for package billing************start*********/\n\tvar calling_module_id = document.forms[0].calling_module_id.value;\t\n\tvar package_enabled_yn = document.forms[0].package_enabled_yn.value;\t\n\n\tif(package_enabled_yn==null) package_enabled_yn=\"N\";\n\t/******************added for package billing************end*********/\n\tvar retVal\t\t\t= new String();\n\n\t//var dialogTop\t\t\t= \"130\";\n//\tvar dialogHeight\t\t= \"22\" ;\n//\tvar dialogWidth\t\t\t= \"50\" ;\n\n\t//var dialogHeight\t\t= \"25\" ;\n\t\t/******************added for package billing************start*********/\n\tvar moduleIdValidation = checkModuleIdForPayerEligibility(calling_module_id);\n\tif(package_enabled_yn==\"Y\" && (calling_module_id==\"OP\" || calling_module_id==\"IP\" || moduleIdValidation == \"Y\"))\t\n\t\t dialogHeight\t\t= \"50\" ;\n\t/******************added for package billing************end*********/\n\t//var dialogWidth\t\t\t= \"55\" ;\n\t\n\tvar dialogTop\t\t\t= \"0vh\";\n\tvar dialogHeight\t\t= \"95vh\" ;\n\tvar dialogWidth\t\t\t= \"88vw\" ; \n\t\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar title=getLabel(\"eBL.ADD_PAYER.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n\n\t//var calling_module_id = document.forms[0].calling_module_id.value;\t\n\tvar getString=document.forms[0].queryString.value;\n\tvar p_patient_class=document.forms[0].p_patient_class.value;\n\tvar billing_group=parent.parent.parent.frames[0].document.forms[0].billing_group.value;\n\n\tvar encounter_date_time = parent.parent.parent.frames[0].document.forms[0].encounter_date_time.value;\n\t\n\tvar fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;\n\tvar autoFinChk = document.forms[0].autoFinChk.value;\n\tvar class_code = document.forms[0].class_code.value;\n\t\n\tformObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\ttotalRecords =eval(formObj.total_records.value);\n\n\tvar priority_arr=new Array();\n\tvar ins_blng_grp_code_arr=new Array();\n\tvar ins_blng_grp_desc_arr=new Array();\n\n\tfor(var i=0;i<totalRecords;i++)\n\t{\n\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+i);\n\t\tvar priority=priority1.value;\n\t\tvar ins_blng_grp_code1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+i);\n\t\tvar ins_blng_grp_code=ins_blng_grp_code1.value;\n\t\tvar ins_blng_grp_desc1=eval(\"parent.frames[1].document.forms[0].billing_group_desc\"+i);\n\t\tvar ins_blng_grp_desc=ins_blng_grp_desc1.value;\n\t\tvar cust_group_code1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_code\"+i);//Added against MMS-DM-CRF-0164.1_73081\n\t\tpriority_arr[i]=priority;\n\t\tins_blng_grp_code_arr[i]=ins_blng_grp_code;\n\t\tins_blng_grp_desc_arr[i]=ins_blng_grp_desc;\n\t}\n\n\tvar temp=\"\";\n\tvar temp1=\"\";\n\tvar blng_grp_count=0;\n\tvar list_of_blng_grp_arr=new Array();\n\tvar j=0;\n\n\tfor(var i=0;i<totalRecords;i++)\n\t{\n\t\ttemp=ins_blng_grp_code_arr[i];\n\t\tif((temp!=\"\" && temp1==\"\") || (temp!=temp1))\n\t\t{\n\t\t\tblng_grp_count++;\n\t\t\tlist_of_blng_grp_arr[j]=temp;\n\t\t\tj++;\n\t\t}\n\t\ttemp1=temp;\n\t}\n\n\tvar hs=new Hashtable();\n\tvar sel_priority=\"\";\n\n\tfor(var i=0;i<list_of_blng_grp_arr.length;i++)\n\t{\n\t\tvar sel_blng_grp=list_of_blng_grp_arr[i];\n\t\tsel_priority=\"\";\n\t\tfor(var j=0;j<totalRecords;j++)\n\t\t{\n\t\t\tif(sel_blng_grp==ins_blng_grp_code_arr[j])\n\t\t\t{\n\t\t\t\tvar temp=priority_arr[j];\n\t\t\t\tsel_priority=sel_priority+temp+\":\";\n\t\t\t\ths.put(sel_blng_grp,sel_priority);\n\t\t\t}\n\t\t}\n\t}\n\n\tvar total_keys=hs.keys();\n\tvar priorty_values=\"\";\n\tvar temp_arr=new Array();\n\tvar max_priority_arr=new Array();\n\t\t\n\tfor(var i=0;i<total_keys.length;i++)\n\t{\n\t\tpriorty_values=hs.get(total_keys[i]);\n\t\tpriorty_values=priorty_values.substring(0,priorty_values.length-1);\n\t\ttemp_arr=priorty_values.split(\':\');\n\t\tvar temp=\"\";\n\t\tvar temp1=\"\";\n\t\tvar max_priority=\"\";\n\t\tvar k=1;\n\n\t\tfor(var j=0;j<temp_arr.length;j++)\n\t\t{\n\t\t\tif(parseInt(k) <= temp_arr.length)\n\t\t\t{\n\t\t\t\tif(parseInt(j)==0)\n\t\t\t\t\ttemp=temp_arr[j];\n\n\t\t\t\tif(parseInt(temp_arr.length)==1)\n\t\t\t\t\ttemp1=temp_arr[j];\n\t\t\t\telse\n\t\t\t\t\ttemp1=temp_arr[k];\n\n\t\t\t\tif(temp1==null)\n\t\t\t\t\ttemp1=temp;\n\n\t\t\t\tif(parseInt(temp) > parseInt(temp1))\n\t\t\t\t\tmax_priority=temp;\n\t\t\t\telse\n\t\t\t\t\tmax_priority=temp1;\n\n\t\t\t\ttemp=max_priority;\n\t\t\t\tk++;\n\t\t\t}\n\t\t}\n\t\tmax_priority_arr[i]=max_priority;\n\t}\n\n\tvar min_priority_arr=new Array();\n\t\t\n\tfor(var i=0;i<total_keys.length;i++)\n\t{\n\t\tpriorty_values=hs.get(total_keys[i]);\n\t\tpriorty_values=priorty_values.substring(0,priorty_values.length-1);\n\t\ttemp_arr=priorty_values.split(\':\');\n\t\tvar temp=\"\";\n\t\tvar temp1=\"\";\n\t\tvar min_priority=\"\";\n\t\tvar k=1;\n\n\t\tfor(var j=0;j<temp_arr.length;j++)\n\t\t{\n\t\t\tif(parseInt(k) <= temp_arr.length)\n\t\t\t{\n\t\t\t\tif(parseInt(j)==0)\n\t\t\t\t\ttemp=temp_arr[j];\n\n\t\t\t\tif(parseInt(temp_arr.length)==1)\n\t\t\t\t\ttemp1=temp_arr[j];\n\t\t\t\telse\n\t\t\t\t\ttemp1=temp_arr[k];\n\n\t\t\t\tif(temp1==null)\n\t\t\t\t\ttemp1=temp;\n\n\t\t\t\tif(parseInt(temp) < parseInt(temp1))\n\t\t\t\t\tmin_priority=temp;\n\t\t\t\telse\n\t\t\t\t\tmin_priority=temp1;\n\n\t\t\t\ttemp=min_priority;\n\t\t\t\tk++;\n\t\t\t}\n\t\t}\n\t\tmin_priority_arr[i]=min_priority;\n\t}\n\tvar policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;\n\n\tfor(var j=0;j<totalRecords;j++)\n\t{\n\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\ttemp.checked=false;\n\t}\n\n\tvar blng_grp_code_array=\"\";\n\tvar count = 0;\n\tfor(var i=0;i<totalRecords;i++)\n\t{\n\t\tvar billing_group_desc1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+i);\n\t\tif(billing_group_desc1.value == billing_group)\n\t\t{\n\t\t\tcount++;\n\t\t}\n\t\tblng_grp_code_array=blng_grp_code_array+billing_group_desc1.value+\"|\";\n\t}\n\n\tif(count==0)\n\t{\n\t\tblng_grp_code_array=billing_group+\"|\"+blng_grp_code_array;\n\t}\n\n    if(blng_grp_code_array==null || blng_grp_code_array==\"\") blng_grp_code_array=billing_group;\n\n\tparent.frames[1].document.forms[0].target = \"InsValidationFrame\";\n\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=add&locn=outside\";\n\tparent.frames[1].document.forms[0].submit();\n\tparent.frames[1].document.forms[0].target = \"\";\n    \n\t//Added by prithivi on 11/12/2016 for mms-qh-crf-0085 \n\tvar service_code = document.forms[0].service_code.value;\n\tvar clinic_code = document.forms[0].clinic_code.value;\n\n\t//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019\n\tvar nursing_unit_code = document.forms[0].nursing_unit_code.value;\n\n\tvar param =\"&title=\"+title+\"&action=add&locn=outside\"+\"&blng_grp_code_array=\"+blng_grp_code_array+\"&patient_class=\"+p_patient_class+\"&billing_group=\"+billing_group+\"&calling_module_id=\"+calling_module_id+\"&policy_coverage_basis_gbl_ind=\"+policy_coverage_basis_gbl_ind+\"&totalRecords=\"+totalRecords+\"&total_keys=\"+total_keys+\"&max_priority_arr=\"+max_priority_arr+\"&min_priority_arr=\"+min_priority_arr+\"&priority_arr=\"+priority_arr+\"&encounter_date_time=\"+encounter_date_time+\"&fin_class_flag_YN=\"+fin_class_flag_YN+\"&autoFinChk=\"+autoFinChk+\"&class_code=\"+class_code+\"&patient_id=\"+document.add_modify_pat_fin_det_insbut.patient_id.value+\"&package_enabled_yn=\"+package_enabled_yn+\"&clinic_code=\"+clinic_code+\"&nursing_unit_code=\"+nursing_unit_code;//changed for package billing\n\t\n\tretVal=await parent.parent.window.showModalDialog(\"../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?\"+param,arguments,features);\n\n\tvar count=0;\n\tvar classval=\"\";\n\tvar\tbilling_grp=\"\";\n\n\tif(retVal!=null)\n\t{\n\t\tretVal=unescape(retVal);\n\t\tparent.frames[1].document.forms[0].retVal.value = retVal;\t\n\t\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?add_check=add&total_records=\"+totalRecords+\"&\"+getString;\n\t\t\n\t\tparent.frames[1].document.forms[0].submit();\n\t}\n\telse\n\t{\n//\t\talert(\"closed\");\n\t}\n}\n\nasync function modifyPayer()\n{\n\t\n\tformObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\ttotal_records=formObj.total_records.value;\n\n\tvar policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;\n\n\tvar encounter_date_time = parent.parent.parent.frames[0].document.forms[0].encounter_date_time.value;\n\t\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\n\tvar priority_arr=new Array();\n\tvar ins_blng_grp_code_arr=new Array();\n\tvar ins_blng_grp_desc_arr=new Array();\n\n\tfor(var i=0;i<total_records;i++)\n\t{\n\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+i);\n\t\tvar priority=priority1.value;\n\t\tvar ins_blng_grp_code1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+i);\n\t\tvar ins_blng_grp_code=ins_blng_grp_code1.value;\n\t\tvar ins_blng_grp_desc1=eval(\"parent.frames[1].document.forms[0].billing_group_desc\"+i);\n\t\tvar ins_blng_grp_desc=ins_blng_grp_desc1.value;\n\t\t\t\n\t\tpriority_arr[i]=priority;\n\t\tins_blng_grp_code_arr[i]=ins_blng_grp_code;\n\t\tins_blng_grp_desc_arr[i]=ins_blng_grp_desc;\n\t}\n\n\tvar temp=\"\";\n\tvar temp1=\"\";\n\tvar blng_grp_count=0;\n\tvar list_of_blng_grp_arr=new Array();\n\tvar j=0;\n\n\tfor(var i=0;i<total_records;i++)\n\t{\n\t\ttemp=ins_blng_grp_code_arr[i];\n\t\tif((temp!=\"\" && temp1==\"\") || (temp!=temp1))\n\t\t{\n\t\t\tblng_grp_count++;\n\t\t\tlist_of_blng_grp_arr[j]=temp;\n\t\t\tj++;\n\t\t}\n\t\ttemp1=temp;\n\t}\n\n\tvar hs=new Hashtable();\n\tvar sel_priority=\"\";\n\n\tfor(var i=0;i<list_of_blng_grp_arr.length;i++)\n\t{\n\t\tvar sel_blng_grp=list_of_blng_grp_arr[i];\n\t\tsel_priority=\"\";\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tif(sel_blng_grp==ins_blng_grp_code_arr[j])\n\t\t\t{\n\t\t\t\tvar temp=priority_arr[j];\n\t\t\t\tsel_priority=sel_priority+temp+\":\";\n\t\t\t\ths.put(sel_blng_grp,sel_priority);\n\t\t\t}\n\t\t}\n\t}\n\n\tvar total_keys=hs.keys();\n\n\tvar priorty_values=\"\";\n\tvar temp_arr=new Array();\n\t\t\n\tvar max_priority_arr=new Array();\n\n\tfor(var i=0;i<total_keys.length;i++)\n\t{\n\t\tpriorty_values=hs.get(total_keys[i]);\n\t\tpriorty_values=priorty_values.substring(0,priorty_values.length-1);\n\t\ttemp_arr=priorty_values.split(\':\');\n\t\tvar temp=\"\";\n\t\tvar temp1=\"\";\n\t\tvar max_priority=\"\";\n\t\tvar k=1;\n\n\t\tfo";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="r(var j=0;j<temp_arr.length;j++)\n\t\t{\n\t\t\tif(parseInt(k) <= temp_arr.length)\n\t\t\t{\n\t\t\t\tif(parseInt(j)==0)\n\t\t\t\t\ttemp=temp_arr[j];\n\n\t\t\t\tif(parseInt(temp_arr.length)==1)\n\t\t\t\t\ttemp1=temp_arr[j];\n\t\t\t\telse\n\t\t\t\t\ttemp1=temp_arr[k];\n\n\t\t\t\tif(temp1==null)\n\t\t\t\t\ttemp1=temp;\n\n\t\t\t\tif(parseInt(temp) > parseInt(temp1))\n\t\t\t\t\tmax_priority=temp;\n\t\t\t\telse\n\t\t\t\t\tmax_priority=temp1;\n\n\t\t\t\ttemp=max_priority;\n\t\t\t\tk++;\n\t\t\t}\n\t\t}\n\t\tmax_priority_arr[i]=max_priority;\n\t}\n\n\tvar min_priority_arr=new Array();\n\t\t\n\tfor(var i=0;i<total_keys.length;i++)\n\t{\n\t\tpriorty_values=hs.get(total_keys[i]);\n\t\tpriorty_values=priorty_values.substring(0,priorty_values.length-1);\n\t\ttemp_arr=priorty_values.split(\':\');\n\t\tvar temp=\"\";\n\t\tvar temp1=\"\";\n\t\tvar min_priority=\"\";\n\t\tvar k=1;\n\n\t\tfor(var j=0;j<temp_arr.length;j++)\n\t\t{\n\t\t\tif(parseInt(k) <= temp_arr.length)\n\t\t\t{\n\t\t\t\tif(parseInt(j)==0)\n\t\t\t\t\ttemp=temp_arr[j];\n\n\t\t\t\tif(parseInt(temp_arr.length)==1)\n\t\t\t\t\ttemp1=temp_arr[j];\n\t\t\t\telse\n\t\t\t\t\ttemp1=temp_arr[k];\n\n\t\t\t\tif(temp1==null)\n\t\t\t\t\ttemp1=temp;\n\n\t\t\t\tif(parseInt(temp) < parseInt(temp1))\n\t\t\t\t\tmin_priority=temp;\n\t\t\t\telse\n\t\t\t\t\tmin_priority=temp1;\n\n\t\t\t\ttemp=min_priority;\n\t\t\t\tk++;\n\t\t\t}\n\t\t}\n\t\tmin_priority_arr[i]=min_priority;\n\t}\n\n\tvar locale=document.forms[0].locale.value;\n\n\tchecked_row=parent.frames[1].document.forms[0].checked_row.value;\n\tif(checked_row==\"\")\n\t{\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\tparent.frames[1].document.forms[0].target = \"InsValidationFrame\";\n\t\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=modify&locn=outside&checked_row=\"+checked_row;\n\t\tparent.frames[1].document.forms[0].submit();\n\n\t\tparent.frames[1].document.forms[0].target = \"\";\n\n\t\tvar blng_grp_code1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+checked_row);\n\t\tblng_grp_code=encodeURIComponent(blng_grp_code1.value);\n\n\t\tvar payer_desc1=eval(\"parent.frames[1].document.forms[0].payer_desc\"+checked_row);\n\t\tpayer_desc=encodeURIComponent(payer_desc1.value);\n\n\t\tvar cust_31=eval(\"parent.frames[1].document.forms[0].cust_3\"+checked_row);\n\t\tcust_3=encodeURIComponent(cust_31.value);\n\n\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+checked_row);\n\t\tpriority=priority1.value;\n\n\t\tvar policy_type_desc1=eval(\"parent.frames[1].document.forms[0].policy_type_desc\"+checked_row);\n\t\tpolicy_type_desc=encodeURIComponent(policy_type_desc1.value);\n\n\t\tvar policy_type_code1=eval(\"parent.frames[1].document.forms[0].policy_type_code\"+checked_row);\n\t\tpolicy_type_code=encodeURIComponent(policy_type_code1.value);\n\n\t\tvar policy_no1=eval(\"parent.frames[1].document.forms[0].policy_no\"+checked_row);\n\t\tpolicy_no=encodeURIComponent(policy_no1.value);\n\n\t\tvar policy_start_date1=eval(\"parent.frames[1].document.forms[0].policy_start_date\"+checked_row);\n\t\tpolicy_start_date=policy_start_date1.value;\n\n\t\tvar policy_exp_date1=eval(\"parent.frames[1].document.forms[0].policy_exp_date\"+checked_row);\n\t\tpolicy_exp_date=policy_exp_date1.value;\n\n\t\tvar credit_auth_ref1=eval(\"parent.frames[1].document.forms[0].credit_auth_ref\"+checked_row);\n\t\tcredit_auth_ref=encodeURIComponent(credit_auth_ref1.value);\n\n\t\tvar credit_auth_date1=eval(\"parent.frames[1].document.forms[0].credit_auth_date\"+checked_row);\n\t\tcredit_auth_date=credit_auth_date1.value;\n\n\t\tvar credit_apprd_amt1=eval(\"parent.frames[1].document.forms[0].credit_apprd_amt\"+checked_row);\n\t\tcredit_apprd_amt=credit_apprd_amt1.value;\n\n\t\tvar credit_apprd_days1=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+checked_row);\n\t\tcredit_apprd_days=credit_apprd_days1.value;\n\n\t\tvar policy_eff_frm_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_frm_date\"+checked_row);\n\t\tpolicy_eff_frm_date=policy_eff_frm_date1.value;\n\n\t\tvar policy_eff_to_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_to_date\"+checked_row);\n\t\tpolicy_eff_to_date=policy_eff_to_date1.value;\t\t\n\t\t\n\t\tvar site_spec=parent.frames[1].document.getElementById(\'siteSpec\').value;\n\t\t\n\t\tvar adj_rule_ind1=eval(\"parent.frames[1].document.forms[0].adj_rule_ind\"+checked_row);\n\t\tif(adj_rule_ind1!=\"\")\n\t\t\tadj_rule_ind=encodeURIComponent(adj_rule_ind1.value);\n\n\t\tvar adj_perc_amt_ind1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_ind\"+checked_row);\n\t\tif(adj_perc_amt_ind1 != \"\")\n\t\tadj_perc_amt_ind=encodeURIComponent(adj_perc_amt_ind1.value);\n\n\t\tvar adj_perc_amt_value1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_value\"+checked_row);\n\t\tadj_perc_amt_value=encodeURIComponent(adj_perc_amt_value1.value);\n\n\t\tvar pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].pmnt_diff_adj_int\"+checked_row);\n\t\tpmnt_diff_adj_int=encodeURIComponent(pmnt_diff_adj_int1.value);\n\n\t\tvar drg_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int\"+checked_row);\n\t\tdrg_pmnt_diff_adj_int=encodeURIComponent(drg_pmnt_diff_adj_int1.value);\n\n\t\tvar spl_srv_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int\"+checked_row);\n\t\tspl_srv_pmnt_diff_adj_int=encodeURIComponent(spl_srv_pmnt_diff_adj_int1.value);\n\n\t\tvar restrict_check1=eval(\"parent.frames[1].document.forms[0].restrict_check\"+checked_row);\n\t\trestrict_check=restrict_check1.value;\n\n\t\tvar valid_payer_YN1=eval(\"parent.frames[1].document.forms[0].valid_payer_YN\"+checked_row);\n\t\tvalid_payer_YN=valid_payer_YN1.value;\n\n\t\tvar payer_suspended_YN1=eval(\"parent.frames[1].document.forms[0].payer_suspended_YN\"+checked_row);\n\t\tpayer_suspended_YN=payer_suspended_YN1.value;\n\n\t\tvar valid_policy_type_code_YN1=eval(\"parent.frames[1].document.forms[0].valid_policy_type_code_YN\"+checked_row);\n\t\tvalid_policy_type_code_YN=valid_policy_type_code_YN1.value;\n\n\t\tvar policy_suspended_YN1=eval(\"parent.frames[1].document.forms[0].policy_suspended_YN\"+checked_row);\n\t\tpolicy_suspended_YN=policy_suspended_YN1.value;\n\n\t\tvar cust_group_code1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_code\"+checked_row);\n\t\tcust_group_code=encodeURIComponent(cust_group_code1.value);\n\n\t\tvar cust_group_name1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_name\"+checked_row);\n\t\tcust_group_name=encodeURIComponent(cust_group_name1.value);\n\n\t\tvar cust_valid_from_date1=eval(\"parent.frames[1].document.forms[0].cust_valid_from_date\"+checked_row);\n\t\tcust_valid_from_date=encodeURIComponent(cust_valid_from_date1.value);\n\n\t\tvar cust_valid_to_date1=eval(\"parent.frames[1].document.forms[0].cust_valid_to_date\"+checked_row);\n\t\tcust_valid_to_date=encodeURIComponent(cust_valid_to_date1.value);\n\n\t\tvar rec_edited_YN=eval(\"parent.frames[1].document.forms[0].rec_edited_YN\"+checked_row);\n\t\trec_edited_YN=encodeURIComponent(rec_edited_YN.value);\t\t\n\n\t\tif(!(locale==\"en\"))\n\t\t{\n\t\t\tif(!(policy_start_date==\"\" || policy_start_date==\" \"))\n\t\t\t\tpolicy_start_date=convertDate(policy_start_date,\"DMY\",locale,\"en\");\n\t\t\n\t\t\tif(!(policy_exp_date==\"\" || policy_exp_date==\" \"))\n\t\t\t\tpolicy_exp_date=convertDate(policy_exp_date,\"DMY\",locale,\"en\");\n\n\t\t\tif(!(credit_auth_date==\"\" || credit_auth_date==\" \"))\n\t\t\t\tcredit_auth_date=convertDate(credit_auth_date,\"DMY\",locale,\"en\");\n\n\t\t\tif(!(policy_eff_frm_date==\"\" || policy_eff_frm_date==\" \"))\n\t\t\t\tpolicy_eff_frm_date=convertDate(policy_eff_frm_date,\"DMY\",locale,\"en\");\n\n\t\t\tif(!(policy_eff_to_date==\"\" || policy_eff_to_date==\" \"))\n\t\t\t\tpolicy_eff_to_date=convertDate(policy_eff_to_date,\"DMY\",locale,\"en\");\n\t\t}\n\t\t//Added By Vijay For MMS-QF-SCf-567\n\t\t\n\t\tif(site_spec==\"true\")\n\t\t{\n\t\t\t\n\t\tvar orgPolEffToDate=parent.frames[1].document.getElementById(\'tmp_pol_eff_to\'+checked_row).value;\n\t\t\t\n\t\tif(orgPolEffToDate==\"\"||orgPolEffToDate==\" \"||orgPolEffToDate==null||orgPolEffToDate==\"null\")\n\t\t\t{\n\t\t\talert(\' Expiry date is not available in the Policy setup\');\n\t\t\treturn false;\n\t\t\t}\n\t\t\t}\n\t\tvar policy_coverage_basis_ind1=eval(\"parent.frames[1].document.forms[0].policy_coverage_basis_ind\"+checked_row);\n\t\tpolicy_coverage_basis_ind=encodeURIComponent(policy_coverage_basis_ind1.value);\n\n\t\tvar retVal\t\t\t= new String();\n\t\t//var dialogTop\t\t\t= \"130\";\n\t\t//var dialogHeight\t\t= \"25\" ;\n\t\t/******************added for package billing************start*********/\n\t\tvar calling_module_id = document.forms[0].calling_module_id.value;\t\n\t\tvar package_enabled_yn = document.forms[0].package_enabled_yn.value;\t\n\t\tif(package_enabled_yn==null)  package_enabled_yn=\"N\";\n\t\t\n\t\tvar moduleIdValidation = checkModuleIdForPayerEligibility(calling_module_id);\n\t\tif(package_enabled_yn==\"Y\" && (calling_module_id==\"OP\" || calling_module_id==\"IP\" || moduleIdValidation == \"Y\"))\n\t\t dialogHeight\t\t= \"50\" ;\n\t/******************added for package billing************end*********/\n\t\t//var dialogWidth\t\t\t= \"55\" ;\n\t\n\t\tvar dialogTop\t\t\t= \"0vh\";\n\t\tvar dialogHeight\t\t= \"95vh\" ;\n\t\tvar dialogWidth\t\t\t= \"88vw\" ; \n\t\t\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar title=getLabel(\"eBL.MODIFY_PAYER.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\t\n\t\t//var calling_module_id = document.forms[0].calling_module_id.value;\t\n\t\t\n\t\tvar getString = document.forms[0].queryString.value;\n\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\tvar calling_module_id = document.forms[0].calling_module_id.value;\n\t\tvar patient_class = document.forms[0].p_patient_class.value;\n\t\tvar fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;\n\n\t\t//Added by Prithivi for MMS-DM-CRF-0085\n\t\tvar service_code = document.forms[0].service_code.value;\n\t\tvar clinic_code = document.forms[0].clinic_code.value;\n\n\t\t//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019\n\t\tvar nursing_unit_code = document.forms[0].nursing_unit_code.value;\n\n\t\tvar payerEligibilityParamSession=eval(\"parent.frames[1].document.forms[0].payerEligibilityParam\"+checked_row);\n\t\tpayerEligibilityParamSession=encodeURIComponent(payerEligibilityParamSession.value);\n\t\tvar responseCodeSession=eval(\"parent.frames[1].document.forms[0].responseCode\"+checked_row);\n\t\tresponseCodeSession=encodeURIComponent(responseCodeSession.value);\n\t\tvar responseCodeDescSes=eval(\"parent.frames[1].document.forms[0].responseCodeDesc\"+checked_row);\n\t\tresponseCodeDescSes=encodeURIComponent(responseCodeDescSes.value);\n\t\tvar statuDescriptionSession=eval(\"parent.frames[1].document.forms[0].statuDescription\"+checked_row);\n\t\tstatuDescriptionSession=encodeURIComponent(statuDescriptionSession.value);\n\t\tvar validityPeriodSession=eval(\"parent.frames[1].document.forms[0].validityPeriod\"+checked_row);\n\t\tvalidityPeriodSession=encodeURIComponent(validityPeriodSession.value);\n\t\tvar validityPeriodDescSes=eval(\"parent.frames[1].document.forms[0].validityPeriodDesc\"+checked_row);\n\t\tvalidityPeriodDescSes=encodeURIComponent(validityPeriodDescSes.value);\n\t\tvar eligibilityCodeSes=eval(\"parent.frames[1].document.forms[0].eligibilityCode\"+checked_row);\n\t\teligi";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block6_2 ="bilityCodeSes=encodeURIComponent(eligibilityCodeSes.value);\n\t\tvar transactionIdSes=eval(\"parent.frames[1].document.forms[0].transactionId\"+checked_row);\n\t\ttransactionIdSes=encodeURIComponent(transactionIdSes.value);\n\t\tvar responseDateTimeSes=eval(\"parent.frames[1].document.forms[0].responseDateTime\"+checked_row);\n\t\tresponseDateTimeSes=encodeURIComponent(responseDateTimeSes.value);\n\t\tvar mcn_for_policy=eval(\"parent.frames[1].document.forms[0].mcn_for_policy\"+checked_row);  //V220908\n\t\tif(mcn_for_policy != \"\")\n\t\tmcn_for_policy=encodeURIComponent(mcn_for_policy.value); //V220908\n\t\tvar reg_ref_id=eval(\"parent.frames[1].document.forms[0].reg_ref_id\"+checked_row);  //V230315\n\t\treg_ref_id=encodeURIComponent(reg_ref_id.value); //V230315 \n\t\t\n\t\tvar userId_for_priv=eval(\"parent.frames[1].document.forms[0].userId_for_priv\"+checked_row);  //V230707\n\t\tuserId_for_priv=encodeURIComponent(userId_for_priv.value); //V230707\n\t\t\n\t\tvar reasonCode_for_priv=eval(\"parent.frames[1].document.forms[0].reasonCode_for_priv\"+checked_row);  //V230707\n\t\treasonCode_for_priv=encodeURIComponent(reasonCode_for_priv.value); //V230707\n\t\t\n\t\tvar param = \"title=\"+title+\"&action=modify&locn=outside&blng_grp_code=\"+blng_grp_code+\"&payer_desc=\"+payer_desc+\"&cust_3=\"+cust_3+\"&ins_cust_group_code=\"+cust_group_code+\"&ins_cust_group_name=\"+cust_group_name+\"&priority=\"+priority+\"&policy_type_desc=\"+policy_type_desc+\"&policy_type_code=\"+policy_type_code+\"&policy_no=\"+policy_no+\"&policy_start_date=\"+policy_start_date+\"&policy_exp_date=\"+policy_exp_date+\"&credit_auth_ref=\"+credit_auth_ref+\"&credit_auth_date=\"+credit_auth_date+\"&credit_apprd_amt=\"+credit_apprd_amt+\"&credit_apprd_days=\"+credit_apprd_days+\"&policy_eff_frm_date=\"+policy_eff_frm_date+\"&policy_eff_to_date=\"+policy_eff_to_date+\"&adj_rule_ind=\"+adj_rule_ind+\"&adj_perc_amt_ind=\"+adj_perc_amt_ind+\"&adj_perc_amt_value=\"+adj_perc_amt_value+\"&pmnt_diff_adj_int=\"+pmnt_diff_adj_int+\"&drg_pmnt_diff_adj_int=\"+drg_pmnt_diff_adj_int+\"&spl_srv_pmnt_diff_adj_int=\"+spl_srv_pmnt_diff_adj_int+\"&restrict_check=\"+restrict_check+\"&valid_payer_YN=\"+valid_payer_YN+\"&valid_policy_type_code_YN=\"+valid_policy_type_code_YN+\"&policy_coverage_basis_ind=\"+policy_coverage_basis_ind+\"&policy_coverage_basis_gbl_ind=\"+policy_coverage_basis_gbl_ind+\"&totalRecords=\"+total_records+\"&total_keys=\"+total_keys+\"&max_priority_arr=\"+max_priority_arr+\"&min_priority_arr=\"+min_priority_arr+\"&priority_arr=\"+priority_arr+\"&encounter_date_time=\"+encounter_date_time+\"&cust_valid_from_date=\"+cust_valid_from_date+\"&cust_valid_to_date=\"+cust_valid_to_date+\"&checked_row=\"+checked_row+\"&rec_edited_YN=\"+rec_edited_YN+\"&package_enabled_yn=\"+package_enabled_yn+\"&patient_id=\"+patient_id+\"&calling_module_id=\"+calling_module_id+\"&patient_class=\"+patient_class+\"&fin_class_flag_YN=\"+fin_class_flag_YN+\"&clinic_code=\"+clinic_code+\"&payerElgParam=\"+payerEligibilityParamSession+\"&respCdSes=\"+responseCodeSession+\"&respCdDescSes=\"+responseCodeDescSes+\"&statDes=\"+statuDescriptionSession+\"&valPer=\"+validityPeriodSession+\"&valPerDesc=\"+validityPeriodDescSes+\"&elgCd=\"+eligibilityCodeSes+\"&transId=\"+transactionIdSes+\"&respDT=\"+responseDateTimeSes+\"&nursing_unit_code=\"+nursing_unit_code+\"&regRefId=\"+reg_ref_id+\"&mcn_for_policy=\"+mcn_for_policy+\"&userId_for_priv=\"+userId_for_priv+\"&reasonCode_for_priv=\"+reasonCode_for_priv;    //changed for package billing- added \'package_enabled_yn\'\n\t\tretVal=await parent.parent.window.showModalDialog(\"../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?\"+param,arguments,features);\n\t\t\n\t\tformObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\t\ttotal_records=formObj.total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\n\t\tif(retVal!=null)\n\t\t{\n\t\tvar arr=new Array();\n\t\tif(retVal == null) retVal=\'\';\n\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\t\t\t  \n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tformObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\t\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\t\tif(arr[22]==\"R\")\n\t\t\t\t{\n\t\t\t\t\tif(arr[31]==\"R\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_leg_disp\"+checked_row));\n\t\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"inline\";\n\t\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_val_disp\"+checked_row));\n\t\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"inline\";\n\n\t\t\t\t\t}\n\t\t\t\t\telse if(arr[31]==\"U\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_leg_disp\"+checked_row));\n\t\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\t\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_val_disp\"+checked_row));\n\t\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\n\t\t\t\t\t\tvar credit_apprd_amt_chk=eval(\"parent.frames[1].document.forms[0].credit_apprd_amt\"+checked_row);\n\t\t\t\t\t\tcredit_apprd_amt_chk.value=\"\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(arr[32]==\"R\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_leg_disp\"+checked_row));\n\t\t\t\t\t\tapprd_days_leg_disp1.style.display=\"inline\";\n\t\t\t\t\t\tvar apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_val_disp\"+checked_row));\n\t\t\t\t\t\tapprd_days_leg_disp1.style.display=\"inline\";\n\t\t\t\t\t}\n\t\t\t\t\telse if(arr[32]==\"U\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_leg_disp\"+checked_row));\n\t\t\t\t\t\tapprd_days_leg_disp1.style.display=\"none\";\n\t\t\t\t\t\tvar apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_val_disp\"+checked_row));\n\t\t\t\t\t\tapprd_days_leg_disp1.style.display=\"none\";\n\n\t\t\t\t\t\tvar credit_apprd_days_chk=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+checked_row);\n\t\t\t\t\t\tcredit_apprd_days_chk.value=\"\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(arr[22]==\"U\")\n\t\t\t\t{\n\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_leg_disp\"+checked_row));\n\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_val_disp\"+checked_row));\n\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_leg_disp\"+checked_row));\n\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_val_disp\"+checked_row));\n\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\n\t\t\t\t\tvar credit_apprd_amt_chk=eval(\"parent.frames[1].document.forms[0].credit_apprd_amt\"+checked_row);\n\t\t\t\t\tcredit_apprd_amt_chk.value=\"\";\n\t\t\t\t\tvar credit_apprd_days_chk=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+checked_row);\n\t\t\t\t\tcredit_apprd_days_chk.value=\"\";\n\t\t\t\t}\n\n\t\t\t\tsetTimeout(\'\',200);\n\n\t\t\t\tvar blng_grp_desc1=eval(\"parent.frames[1].document.forms[0].billing_group_desc\"+checked_row);\n\t\t\t\tblng_grp_desc1.value=decodeURIComponent(arr[0]);\n\t\t\t\t\n\t\t\t\tvar blng_grp_code1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+checked_row);\n\t\t\t\tblng_grp_code1.value=decodeURIComponent(arr[1]);\n\t\t\t\t\n\t\t\t\tvar payer_desc1=eval(\"parent.frames[1].document.forms[0].payer_desc\"+checked_row);\n\t\t\t\tpayer_desc1.value=decodeURIComponent(arr[2]);\n\t\t\t\t\n\t\t\t\tvar cust_31=eval(\"parent.frames[1].document.forms[0].cust_3\"+checked_row);\n\t\t\t\tcust_31.value=decodeURIComponent(arr[3]);\n\t\t\t\t\n\t\t\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+checked_row);\n\t\t\t\tpriority1.value=arr[4];\n\t\t\t\t\n\t\t\t\tvar policy_type_desc1=eval(\"parent.frames[1].document.forms[0].policy_type_desc\"+checked_row);\n\t\t\t\tpolicy_type_desc1.value=decodeURIComponent(arr[5]);\n\t\t\t\t\n\t\t\t\tvar policy_type_code1=eval(\"parent.frames[1].document.forms[0].policy_type_code\"+checked_row);\n\t\t\t\tpolicy_type_code1.value=decodeURIComponent(arr[6]);\n\t\t\t\t\n\t\t\t\tvar policy_no1=eval(\"parent.frames[1].document.forms[0].policy_no\"+checked_row);\n\t\t\t\tpolicy_no1.value=decodeURIComponent(arr[7]);\n\t\t\t\t\n\t\t\t\tvar policy_start_date1=eval(\"parent.frames[1].document.forms[0].policy_start_date\"+checked_row);\n\t\t\t\tvar policy_start_date_conv=arr[8];\n\t\t\t\tif(policy_start_date_conv==\"\" || policy_start_date_conv==\" \") policy_start_date_conv=\"\";\n\t\t\t\tif(policy_start_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_start_date_conv=convertDate(policy_start_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpolicy_start_date1.value=policy_start_date_conv;\n\t\t\t\t\n\t\t\t\tvar policy_exp_date1=eval(\"parent.frames[1].document.forms[0].policy_exp_date\"+checked_row);\n\t\t\t\tvar policy_exp_date_conv=arr[9];\n\t\t\t\tif(policy_exp_date_conv==\"\" || policy_exp_date_conv==\" \") policy_exp_date_conv=\"\";\n\t\t\t\tif(policy_exp_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_exp_date_conv=convertDate(policy_exp_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpolicy_exp_date1.value=policy_exp_date_conv;\n\n\t\t\t\tif(arr[33] == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tvar credit_auth_ref_val_disp1=eval(parent.frames[1].document.getElementById(\"credit_auth_val_disp\"+checked_row));\n\t\t\t\t\tcredit_auth_ref_val_disp1.style.display=\"inline\";\n\n\t\t\t\t\tvar credit_auth_ref1=eval(\"parent.frames[1].document.forms[0].credit_auth_ref\"+checked_row);\n\t\t\t\t\tcredit_auth_ref1.value=decodeURIComponent(arr[10]);\n\n\t\t\t\t\tif(credit_auth_ref1.value==\"\" || credit_auth_ref1.value==\" \") credit_auth_ref1.value=\"\";\n\n\t\t\t\t\tvar credit_auth_date_val_disp1=eval(parent.frames[1].document.getElementById(\"credit_auth_date_val_disp\"+checked_row));\n\t\t\t\t\tcredit_auth_date_val_disp1.style.display=\"inline\";\n\t\t\t\t\t\n\t\t\t\t\tvar credit_auth_date1=eval(\"parent.frames[1].document.forms[0].credit_auth_date\"+checked_row);\n\t\t\t\t\tvar credit_auth_date_conv=arr[11];\n\n\t\t\t\t\tif(credit_auth_date_conv==\"\" || credit_auth_date_conv==\" \") credit_auth_date_conv=\"\";\n\t\t\t\t\tif(credit_auth_date_conv!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tcredit_auth_date_conv=convertDate(credit_auth_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t\t}\n\t\t\t\t\tcredit_auth_date1.value=credit_auth_date_conv;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tvar credit_auth_ref_val_disp1=eval(parent.frames[1].document.getElementById(\"credit_auth_val_disp\"+checked_row));\n\t\t\t\t\tcredit_auth_ref_val_disp1.style.display=\"none\";\n\n\t\t\t\t\tvar credit_auth_ref1=eval(\"parent.frames[1].document.forms[0].credit_auth_ref\"+checked_row);\n\t\t\t\t\tcredit_auth_ref1.value= \"\";\n\t\t\t\t\t\n\t\t\t\t\tvar credit_auth_date_val_disp1=eval(parent.frames[1].document.getElementById(\"credit_auth_date_val_disp\"+checked_row));\n\t\t\t\t\tcredit_auth_date_val_disp1.style.display=\"none\";\n\n\t\t\t\t\tvar credit_auth_date1=eval(\"parent.frames[1].document.forms[0].credit_auth_date\"+checked_row);\n\t\t\t\t\tcredit_auth_date1.value= \"\";\n\t\t\t\t}\n\n\t\t\t\tvar cred_auth_req_yn1=eval(\"parent.frames[1].document.forms[0].cred_auth_req_yn\"+checked_row);\n\t\t\t\tcred_auth_req_yn1.value=arr[33];\n\n\t\t\t\tvar dflt_auth_ref_as_pol_no";
    private final static byte[]  _wl_block6_2Bytes = _getBytes( _wl_block6_2 );

    private final static java.lang.String  _wl_block6_3 ="_yn1=eval(\"parent.frames[1].document.forms[0].dflt_auth_ref_as_pol_no_yn\"+checked_row);\n\t\t\t\tdflt_auth_ref_as_pol_no_yn1.value=arr[34];\n\t\t\t\t\n\t\t\t\tvar credit_apprd_amt1=eval(\"parent.frames[1].document.forms[0].credit_apprd_amt\"+checked_row);\n\t\t\t\tvar temp_credit_apprd_amt=arr[12];\n\t\t\t\tif(temp_credit_apprd_amt==\" \") temp_credit_apprd_amt=\"\";\n\t\t\t\tcredit_apprd_amt1.value=temp_credit_apprd_amt;\n\t\t\t\t\n\t\t\t\tvar credit_apprd_days1=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+checked_row);\n\t\t\t\tvar temp_credit_apprd_days=arr[13];\n\t\t\t\tif(temp_credit_apprd_days==\" \") temp_credit_apprd_days=\"\";\n\t\t\t\tcredit_apprd_days1.value=temp_credit_apprd_days;\n\t\t\t\t\n\t\t\t\tvar policy_eff_frm_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_frm_date\"+checked_row);\n\t\t\t\tvar policy_eff_frm_date_conv=arr[14];\n\t\t\t\tif(policy_eff_frm_date_conv==\"\" || policy_eff_frm_date_conv==\" \") policy_eff_frm_date_conv=\"\";\n\t\t\t\tif(policy_eff_frm_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_eff_frm_date_conv=convertDate(policy_eff_frm_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpolicy_eff_frm_date1.value=policy_eff_frm_date_conv;\n\t\t\t\t\n\t\t\t\tvar policy_eff_to_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_to_date\"+checked_row);\n\t\t\t\tvar policy_eff_to_date_conv=arr[15];\n\t\t\t\tif(policy_eff_to_date_conv==\"\" || policy_eff_to_date_conv==\" \") policy_eff_to_date_conv=\"\";\n\t\t\t\tif(policy_eff_to_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_eff_to_date_conv=convertDate(policy_eff_to_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpolicy_eff_to_date1.value=policy_eff_to_date_conv;\n\t\t\t\t\n\t\t\t\tvar adj_rule_ind1=eval(\"parent.frames[1].document.forms[0].adj_rule_ind\"+checked_row);\n\t\t\t\tadj_rule_ind1.value=decodeURIComponent(arr[16]);\n\t\t\t\t\n\t\t\t\tvar adj_perc_amt_ind1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_ind\"+checked_row);\n\t\t\t\tadj_perc_amt_ind1.value=decodeURIComponent(arr[17]);\n\t\t\t\t\n\t\t\t\tvar adj_perc_amt_value1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_value\"+checked_row);\n\t\t\t\tadj_perc_amt_value1.value=decodeURIComponent(arr[18]);\n\t\t\t\t\n\t\t\t\tvar pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].pmnt_diff_adj_int\"+checked_row);\n\t\t\t\tpmnt_diff_adj_int1.value=decodeURIComponent(arr[19]);\n\t\t\t\t\n\t\t\t\tvar drg_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int\"+checked_row);\n\t\t\t\tdrg_pmnt_diff_adj_int1.value=decodeURIComponent(arr[20]);\n\t\t\t\t\n\t\t\t\tvar spl_srv_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int\"+checked_row);\n\t\t\t\tspl_srv_pmnt_diff_adj_int1.value=decodeURIComponent(arr[21]);\n\n\t\t\t\tvar restrict_check1=eval(\"parent.frames[1].document.forms[0].restrict_check\"+checked_row);\n\t\t\t\trestrict_check1.value=arr[22];\n\n\t\t\t\tvar apprd_amt_restrict_check1=eval(\"parent.frames[1].document.forms[0].apprd_amt_restrict_check\"+checked_row);\n\t\t\t\tapprd_amt_restrict_check1.value=arr[31];\n\n\t\t\t\tvar apprd_days_restrict_check1=eval(\"parent.frames[1].document.forms[0].apprd_days_restrict_check\"+checked_row);\n\t\t\t\tapprd_days_restrict_check1.value=arr[32];\n\n\t\t\t\tvar valid_payer_YN1=eval(\"parent.frames[1].document.forms[0].valid_payer_YN\"+checked_row);\n\t\t\t\tvalid_payer_YN1.value=arr[23];\n\n\t\t\t\tvar valid_policy_type_code_YN1=eval(\"parent.frames[1].document.forms[0].valid_policy_type_code_YN\"+checked_row);\n\t\t\t\tvalid_policy_type_code_YN1.value=arr[24];\n\n\t\t\t\tvar cust_group_code1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_code\"+checked_row);\n\t\t\t\tcust_group_code1.value=decodeURIComponent(arr[25]);\n\n\t\t\t\tvar cust_group_name1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_name\"+checked_row);\n\t\t\t\tcust_group_name1.value=decodeURIComponent(arr[37]);\t\t\t\t\n\n\t\t\t\tvar policy_coverage_basis_ind1=eval(\"parent.frames[1].document.forms[0].policy_coverage_basis_ind\"+checked_row);\n\t\t\t\tpolicy_coverage_basis_ind1.value=arr[26];\n\n\t\t\t\tvar cust_valid_from_date1=eval(\"parent.frames[1].document.forms[0].cust_valid_from_date\"+checked_row);\n\t\t\t\tcust_valid_from_date1.value=arr[35];\n\n\t\t\t\tvar cust_valid_to_date1=eval(\"parent.frames[1].document.forms[0].cust_valid_to_date\"+checked_row);\n\t\t\t\tcust_valid_to_date1.value=arr[36];\n\n\t\t\t\tvar pol_validity_chk_date=eval(\"parent.frames[1].document.forms[0].pol_validity_chk_date\"+checked_row);\n\t\t\t\tvar pol_validity_chk_date_conv = arr[38];\n\n\t\t\t\tif(pol_validity_chk_date_conv==\"\" || pol_validity_chk_date_conv==\" \") pol_validity_chk_date_conv=\"\";\n\n\t\t\t\tif(pol_validity_chk_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpol_validity_chk_date_conv=convertDate(pol_validity_chk_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpol_validity_chk_date.value=pol_validity_chk_date_conv;\n\n\t\t\t\tif(total_records==1)\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value=policy_coverage_basis_ind1.value;\n\t\t\t\t}\n\n\t\t\t\tparent.frames[1].policy_coverage_basis_ind();\n\n\t\t\t\tvar rec_edited_YN=eval(\"parent.frames[1].document.forms[0].rec_edited_YN\"+checked_row);\n\t\t\t\trec_edited_YN.value = arr[39];\n\t\t\t\t\n\t\t\t\tvar mcn_for_policy=eval(\"parent.frames[1].document.forms[0].mcn_for_policy\"+checked_row);  //V220908\n\t\t\t\tmcn_for_policy.value=decodeURIComponent(arr[51]);  //V220908\n\t\t\t\t\n\t\t\t\tvar reg_ref_id=eval(\"parent.frames[1].document.forms[0].reg_ref_id\"+checked_row);  //V230315\n\t\t\t\treg_ref_id.value=decodeURIComponent(arr[52]);  //V230315\n\t\t\t\t\n\t\t\t\tvar userId_for_priv=eval(\"parent.frames[1].document.forms[0].userId_for_priv\"+checked_row);  //V230707\n\t\t\t\tuserId_for_priv.value=decodeURIComponent(arr[53]);  //V230707\n\t\t\t\t\n\t\t\t\tvar reasonCode_for_priv=eval(\"parent.frames[1].document.forms[0].reasonCode_for_priv\"+checked_row);  //V230707\n\t\t\t\treasonCode_for_priv.value=decodeURIComponent(arr[54]);  //V230707\n\t\t\t\t\n                //Added by prithivi on 03/01/2017 for mms-qh-crf-0085 -- bupa insurance interface\n\t\t\t\tvar payerEligibilityParam=eval(\"parent.frames[1].document.forms[0].payerEligibilityParam\"+checked_row);\n\n\t\t\t\tvar responseCode=eval(\"parent.frames[1].document.forms[0].responseCode\"+checked_row);\n\t\t\t\tvar responseCodeDesc=eval(\"parent.frames[1].document.forms[0].responseCodeDesc\"+checked_row);\n\t\t\t\tvar statuDescription=eval(\"parent.frames[1].document.forms[0].statuDescription\"+checked_row);\n\t\t\t\tvar validityPeriod=eval(\"parent.frames[1].document.forms[0].validityPeriod\"+checked_row);\n\t\t\t\tvar validityPeriodDesc=eval(\"parent.frames[1].document.forms[0].validityPeriodDesc\"+checked_row);\n\t\t\t\tvar eligibilityCode=eval(\"parent.frames[1].document.forms[0].eligibilityCode\"+checked_row);\n\t\t\t\tvar transactionId=eval(\"parent.frames[1].document.forms[0].transactionId\"+checked_row);\n\t\t\t\tvar responseDateTime=eval(\"parent.frames[1].document.forms[0].responseDateTime\"+checked_row);\n\n\t\t\t\tvar arrLength = arr.length-15;  // over all arr length is 55  //V230707\n\t\t\t\t\t\t\t\t\n\t\t\t\tpayerEligibilityParam.value = decodeURIComponent(arr[arrLength]);\n\t\t\t\tresponseCode.value = decodeURIComponent(arr[arrLength+1]);\n\t\t\t\tresponseCodeDesc.value = decodeURIComponent(arr[arrLength+2]);\n\t\t\t\tstatuDescription.value = decodeURIComponent(arr[arrLength+3]);\n\t\t\t\tvalidityPeriod.value = decodeURIComponent(arr[arrLength+4]);\n\t\t\t\tvalidityPeriodDesc.value = decodeURIComponent(arr[arrLength+5]);\n\t\t\t\teligibilityCode.value = decodeURIComponent(arr[arrLength+6]);\n\t\t\t\ttransactionId.value = decodeURIComponent(arr[arrLength+7]);\n\t\t\t\tresponseDateTime.value = decodeURIComponent(arr[arrLength+8]);\t\t\t\t\n\t\t\t}\n\t\t}\n\t\t}\n\t\telse\n\t\t{\n//\t\t\talert(\"closed\");\n\t\t}\n\t}\n\tparent.frames[1].document.forms[0].checked_row.value=\"\";\n}\n\n\n// This Function can be used to remove the selected payer directly\nfunction removePayerNew()\n{\n\tvar checked_row=parent.frames[1].document.forms[0].checked_row.value;\n\t//164.1\n\tvar priority_form = eval(\"parent.frames[1].document.add_modify_pat_fin_det_insmain.priority\"+checked_row);\n\tvar priority=priority_form.value;\n\t//164.1\n\tvar locale=document.forms[0].locale.value;\n\tformObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\ttotal_records=formObj.total_records.value;\n\n\tvar getString=document.forms[0].queryString.value;\n\n\tvar prmy_blng_grp=parent.parent.parent.frames[0].document.forms[0].billing_group.value;\n\tvar ins_blng_grp_code_arr=new Array();\n\n\tfor(var i=0;i<total_records;i++)\n\t{\n\t\tvar ins_blng_grp_code1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+i);\n\t\tvar ins_blng_grp_code=ins_blng_grp_code1.value;\n\t\t\t\n\t\tins_blng_grp_code_arr[i]=ins_blng_grp_code;\n\t}\n\t\n\tvar count=0;\n\n\tfor(var i=0;i<ins_blng_grp_code_arr.length;i++)\n\t{\n\t\tif(ins_blng_grp_code_arr[i]==prmy_blng_grp) count++;\n\t}\n\n\tif(count == 1)\n\t{\n\t\tfor(var i=0;i<ins_blng_grp_code_arr.length;i++)\n\t\t{\n\t\t\tif(i == parseInt(checked_row))\n\t\t\t{\n\t\t\t\tif((ins_blng_grp_code_arr[i] == prmy_blng_grp))\n\t\t\t\t{\n\t\t\t\t\tcount=1;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tcount=0;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\t\n\tif(checked_row==\"\")\n\t{\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\telse\n\t{\n\t\tif(confirm(getMessage(\"BL9760\",\"BL\"))) //BL9760\n\t\t{\n\t\t\tif(count==1) \n\t\t\t{\n\t\t\t\tif(!confirm(getMessage(\"BL9828\",\"BL\")))\n\t\t\t\t{\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\ttotalRecords =eval(formObj.total_records.value);\n\t\t\tvar policy_no1=eval(\"parent.frames[1].document.forms[0].policy_no\"+checked_row);\n\t\t\tvar policy_no=encodeURIComponent(policy_no1.value);\n\n\t\t\t//Added priority against MMS-DM-CRF-0164.1_73081\n\t\t\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?remove_check=remove&\"+getString+\"&checked_row=\"+checked_row+\"&total_records=\"+totalRecords+\"&Mem_Priority=\"+priority+\"&policy_no=\"+policy_no; //Added policy_no for GHL-CRF-0550.1\n\n\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\t\t\t\n\t\t}\n\t}\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\ttemp.checked=false;\n\t}\n\tparent.frames[1].document.forms[0].checked_row.value=\"\";\t\n}\n\n\n//V210310 Starts\nfunction getAgeValidation()\n{\t\t\t\t\n\tvar moduleId=document.forms[0].calling_module_id.value;\n\tvar functionId=document.forms[0].function_id.value;\n\tvar patientId=document.forms[0].patient_id.value;\n\tvar facId=document.forms[0].facility_id.value\t\t\t\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\t\t\t\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\tvar temp_jsp=\"../../eBL/jsp/BLCommonAjax.jsp?functionMode=validateBillingGrp&ModuleId=\"+moduleId+\"&FunctionId=\"+functionId+\"&patientId=\"+patientId+\"&facId=\"+facId;\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar receivedText = trimString(xmlHttp.responseText);\n\tvar n1 = receivedText.indexOf(\"~\");\n\tvar res = receivedText.substr(n1+1);\n\treturn res;\n}\n//V210310 Ends\n\nasync function noninsblnggrplkup(clng_evnt)\n{\t\t\n\tvar target\t\t\t= document.forms[0].non_ins_billing_group_desc;\t\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( target.value == \"\")\n\t";
    private final static byte[]  _wl_block6_3Bytes = _getBytes( _wl_block6_3 );

    private final static java.lang.String  _wl_block6_4 ="\t{\n\t\t\tdocument.forms[0].non_ins_billing_group_desc.value = \"\";\n\t\t\tdocument.forms[0].non_insur_blng_grp.value = \"\";\n\t\t\tparent.parent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar billinggroup    = document.forms[0].non_insur_blng_grp.value;\n\tvar retVal\t\t\t= new String();\t\n\t\n\tvar dialogTop\t\t\t= \"0\";\n\tvar dialogHeight\t\t= \"70vh\" ;\n\tvar dialogWidth\t\t\t= \"50vw\" ;\n\t//var features\t\t\t= \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\n\tvar sql1\t\t\t\t= \"\";\t\n\n\tvar cash_leg=getLabel(\"eBL.CASH.label\",\"BL\");\n\tcash_leg=encodeURIComponent(cash_leg);\n\tvar credit_leg=getLabel(\"eBL.CREDIT.label\",\"BL\");\n\tcredit_leg=encodeURIComponent(credit_leg);\n\tvar sponsor_leg=getLabel(\"eBL.SPONSOR.label\",\"BL\");\n\tsponsor_leg=encodeURIComponent(sponsor_leg);\n\tvar ins_leg=getLabel(\"Common.Insurance.label\",\"common\");\n\tins_leg=encodeURIComponent(ins_leg);\n\n\tvar title=getLabel(\"eBL.NON_INS_BILLING_GROUP.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"10%,20%,50%,10%,5%,5%,0%,0%\");   \n\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tdesc=encodeURIComponent(desc);\n\tvar expnote=getLabel(\"eBL.EXPLANATORY_NOTE.label\",\"BL\");\n\texpnote=encodeURIComponent(expnote);\n\n\tvar capt_ref_src_dtl=getLabel(\"eBL.CAPTURE_REF_SOURCE_DTL.label\",\"BL\");\n\tcapt_ref_src_dtl=encodeURIComponent(capt_ref_src_dtl);\n\tvar ref_source_main_mand_yn=getLabel(\"eBL.PRMY_REF_SRC_MAND.label\",\"BL\");\n\tref_source_main_mand_yn=encodeURIComponent(ref_source_main_mand_yn);\n\tvar ref_source_sub_mand_yn=getLabel(\"eBL.SEC_REF_SRC_MAND.label\",\"BL\");\n\tref_source_sub_mand_yn=encodeURIComponent(ref_source_sub_mand_yn);\n\tvar cust_curr_code=getLabel(\"eBL.CURR_CODE.label\",\"BL\");\n\tcust_curr_code=encodeURIComponent(cust_curr_code);\n\tvar curr_desc=getLabel(\"eBL.CURR_DESC.label\",\"BL\");\n\tcurr_desc=encodeURIComponent(curr_desc);\n\n\tvar column_descriptions = code+\",\"+desc+\",\"+expnote+\',\'+capt_ref_src_dtl+\",\"+ref_source_main_mand_yn+\",\"+ref_source_sub_mand_yn+\",\"+cust_curr_code+\",\"+curr_desc;\n\n\tvar message = \'\';\t\t\n\n\tvar strCitizenYn = document.forms[0].CitizenYn.value;\n\n\tvar strModuleId = document.forms[0].calling_module_id.value;\n\n\tvar locale = document.forms[0].locale.value;\n\n\tvar ref_src_code_YN=\"N\";\n\tvar pmry_ref_src_mand_YN=\"N\";\n\tvar sec_ref_src_mand_YN=\"N\";\n\tvar currency_code_for_bg = \"\";\n\tvar currency_desc_for_bg = \"\";\n\n\tsql = \"called_for=NONINSBGLKUP&locale=\"+locale+\"&module_id=\"+strModuleId+\"&citizen_yn=\"+strCitizenYn;\n\n\t/* Added V20180709-Aravindh/GHL-CRF-0427/new variable fin_auth_user_id */\n\tvar fin_auth_user_id = parent.parent.parent.frames[0].document.forms[0].fin_auth_user_id.value;\n\t//V210310 Starts \n\tvar ageVal=\"~N\";\n\tvar ageSiteSpec= document.forms[0].siteSpecAgeVal.value;\n\tif(ageSiteSpec==\"Y\"){\t\t\n\t\tvar res1 =getAgeValidation();\n\t\tres1 = res1.split(\"~\");\n\t\tif(res1[0]==\"S\"){\n\t\t\tageVal= res1[1]+\"~Y\";\n\t\t}\n\t}\n\t//V210310 Ends\n\t/* Added V20180709-Aravindh/GHL-CRF-0427/One new parameter fin_auth_user_id in below param */\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(target.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYNNNNN&fin_auth_user_id=\"+fin_auth_user_id+\"&ageVal=\"+ageVal;\n\tretVal=await top.window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\n\tvar arr=new Array();\t\t\n\n\tif(retVal == null) retVal=\'\';\n\n\tif (retVal != null || retVal!=\"\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\t\t\t   \n\n\t\t\tdocument.forms[0].non_ins_billing_group_desc.value=arr[1];\n\t\t\tdocument.forms[0].non_insur_blng_grp.value=arr[0];\n\n\t\t\tref_src_code_YN=arr[3];\n\t\t\tpmry_ref_src_mand_YN = arr[4];\n\t\t\tsec_ref_src_mand_YN = arr[5];\n\n\t\t\tdocument.forms[0].currency_code_for_bg.value=arr[6];\n\t\t\tdocument.forms[0].currency_desc_for_bg.value=arr[7];\n\n\t\t\tdocument.forms[0].blnggrpappyn.value = \"Y\";\n\t\t\tdocument.forms[0].BlngGrpStatus.value = \"\";\n\t\t\tdocument.forms[0].blnggrpcatgappyn.value = \"Y\";\n\n\t\t\tcallNonInsurance(document.forms[0].non_insur_blng_grp);\n\n\t\t\tif(ref_src_code_YN==\"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_main_leg_disp\').style.display=\"inline\";\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_main_val_disp\').style.display=\"inline\";\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_code.value=\"\";\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_desc.value=\"\";\n\t\t\t\tif(pmry_ref_src_mand_YN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_main_mand_disp\').style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_main_mand_disp\').style.display=\"none\";\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_sub_leg_disp\').style.display=\"inline\";\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_sub_val_disp\').style.display=\"inline\";\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_sub_code\').value=\"\";\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_sub_desc\').value=\"\";\n\t\t\t\tif(sec_ref_src_mand_YN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_sub_mand_disp\').style.display=\"inline\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_sub_mand_disp\').style.display=\"none\";\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.forms[0].non_ins_ref_src_capture_YN.value=\"Y\";\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\t\tdocument.forms[0].non_ins_ref_src_sub_mand_YN.value=sec_ref_src_mand_YN;\n\t\t\t}\n\t\t\telse if(ref_src_code_YN==\"N\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_main_leg_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_main_val_disp\').style.display=\"none\";\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_code.value=\"\";\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_desc.value=\"\";\n\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_sub_leg_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_code_sub_val_disp\').style.display=\"none\";\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_sub_code\').value=\"\";\n\t\t\t\tdocument.getElementById(\'non_ins_ref_src_sub_desc\').value=\"\";\n\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').alt=\"\";\n\n\t\t\t\tdocument.forms[0].non_ins_ref_src_capture_YN.value=\"N\";\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\t\tdocument.forms[0].non_ins_ref_src_sub_mand_YN.value=sec_ref_src_mand_YN;\n\t\t\t}\n\t\t\tcurr_code();\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttarget.focus();\n\t\t}\n\t}\n}\n\nasync function getNonInsBlngGrpSearch()\n{\n\tvar billing_group=document.forms[0].non_insur_blng_grp.value;\t\t\n\t\n\tif(billing_group==\"select\") billing_group=\"\";\t\t\n\n\tif(billing_group == \"\")\n\t{\n\t\talert(getMessage(\"BL9106\",\"BL\"));\n\t\treturn;\n\t}\n\t\n\tif((billing_group!=\"\"))\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"200px\" ;\n\t\tvar dialogWidth\t= \"300px\" ;\n\t\tvar dialogTop = \"\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\n\t\tvar url = \"../../eBL/jsp/BLBillingGrpDetFrame.jsp?billing_group=\t\"+billing_group;\n\t\tretVal = await window.showModalDialog(url,arguments,features);\n\t}\t\t\n}\n\nasync function showMultiBlngGrp()\n{\n\tvar policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;\t\n\t\n\tvar formObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\tvar total_records=formObj.total_records.value;\n\t\n\tvar priority_arr=new Array();\n\n\tfor(var i=0;i<total_records;i++)\n\t{\n\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+i);\n\t\tvar priority=priority1.value;\n\t\n\t\tpriority_arr[i]=priority;\n\t}\n\t\n\tvar max_priority=\"\";\n\tvar priortiy_var1=\"\";\n\tvar priortiy_var2=\"\";\n\tvar j=1;\n\t\n\tfor(var i=0;i<priority_arr.length;i++)\n\t{\n\t\tif(parseInt(j) <= priority_arr.length)\n\t\t{\n\t\t\tif(parseInt(i)==0)\n\t\t\t\tpriortiy_var1=priority_arr[i];\n\n\t\t\tif(parseInt(priority_arr.length)==1)\n\t\t\t\tpriortiy_var2=priority_arr[i];\n\t\t\telse\n\t\t\t\tpriortiy_var2=priority_arr[j];\n\n\t\t\tif(priortiy_var2==null)\n\t\t\t\tpriortiy_var2=priortiy_var1;\n\n\t\t\tif(parseInt(priortiy_var1) > parseInt(priortiy_var2))\n\t\t\t\tmax_priority=priortiy_var1;\n\t\t\telse\n\t\t\t\tmax_priority=priortiy_var2;\n\n\t\t\tpriortiy_var1=max_priority;\n\t\t\tj++;\n\t\t}\n\t}\n\n\tif(max_priority == \"\") max_priority=\"0\";\n\n\tparent.frames[1].document.forms[0].target = \"InsValidationFrame\";\n\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=add_more_bg\";\n\tparent.frames[1].document.forms[0].submit();\n\n\tparent.frames[1].document.forms[0].target = \"\";\n\n\tvar retVal\t\t\t= new String();\n/* \tvar dialogTop\t\t\t= \"\";\n\tvar dialogHeight\t\t= \"30\" ;\n\tvar dialogWidth\t\t\t= \"60\" ; */\n\tvar dialogTop\t\t\t= \"\";\n\tvar dialogHeight\t\t= \"95vh\" ;\n\tvar dialogWidth\t\t\t= \"100vw\" ; \n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\t\t\n\tvar title=getLabel(\"eBL.ADD_MORE_SECONDARY_BILLING_GROUPS.label\",\"BL\");\n\n\ttitle=encodeURIComponent(title);\n\tvar queryString=document.forms[0].queryString.value;\n\tformObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\tvar total_records=formObj.total_records.value;\n\tvar primary_blng_grp=\"\";\n\t\n\tprimary_blng_grp=parent.frames[1].document.forms[0].blng_grp_values.value;\n\n\t/* Added V20180709-Aravindh/GHL-CRF-0427/new variable fin_auth_user_id */\n\tvar fin_auth_user_id = parent.parent.parent.frames[0].document.forms[0].fin_auth_user_id.value;\n\n\t/* Added V20180709-Aravindh/GHL-CRF-0427/One new parameter fin_auth_user_id in below param */\n\tvar param = \"title=\"+title+\"&primary_blng_grp=\"+primary_blng_grp+\"&policy_coverage_basis_gbl_ind_from_main=\"+policy_coverage_basis_gbl_ind+\"&max_priority=\"+max_priority+\"&\"+queryString+\"&fin_auth_user_id=\"+fin_auth";
    private final static byte[]  _wl_block6_4Bytes = _getBytes( _wl_block6_4 );

    private final static java.lang.String  _wl_block6_5 ="_user_id;\n\tvar showModalFrame = top.window.document.getElementById(\'dialog-body\').contentWindow.frames[0];\n\tretVal= await showModalFrame.window.showModalDialog(\"../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpMain.jsp?\"+param,arguments,features);\n\t\n\t\n\tif(\tretVal!=null)\n\t{\n\t\tvar ret_val=retVal;\n\t\tif(ret_val==\"accept\")\n\t\t{\t\n\t\t\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?accept_check=\"+ret_val+\"&total_records=\"+total_records+\"&\"+queryString;\n\n\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t}\n\n\t}\n\telse\n\t{\n\t\t//alert(\"closed\");\n\t}\n}\n\nfunction refsrclkup(ref_code,ref_desc,called_frm,clng_evnt)\n{\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( ref_desc.value == \"\")\n\t\t{\t\n\t\t\tref_code.value = \"\";\n\t\t\tref_desc.value = \"\";\n\t\t\tif(called_frm == \"M\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t\telse if (called_frm == \"S\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar locale=document.forms[0].locale.value;\n\tvar billing_group=document.forms[0].billing_group.value;\n\n\tvar retVal\t\t\t= new String();\t\t\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"60\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\t\t\n\t\t\n\tvar title=getLabel(\"Common.referralsource.label\",\"common\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,20%,20%,30%,10%\");               \n\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar short_desc=getLabel(\"Common.shortdescription.label\",\"common\");\n\tshort_desc=encodeURIComponent(short_desc);\n\tvar long_desc=getLabel(\"Common.longdescription.label\",\"common\");\n\tlong_desc=encodeURIComponent(long_desc);\n\tvar long_name=getLabel(\"Common.longname.label\",\"common\");\n\tlong_name=encodeURIComponent(long_name);\n\tvar org_type=getLabel(\"Common.OrganisationType.label\",\"common\");\n\torg_type=encodeURIComponent(org_type);\n\tvar column_descriptions = code+\",\"+short_desc+\",\"+long_desc+\",\"+long_name+\",\"+org_type;\n\n\tvar gov_leg = getLabel(\"eBL.GOVT_REFERRAL.label\",\"BL\");\n\tgov_leg=encodeURIComponent(gov_leg);\n\n\tvar pvt_leg = getLabel(\"eBL.PVT_REFERRAL.label\",\"BL\");\n\tpvt_leg=encodeURIComponent(pvt_leg);\n\n\tvar message = \'\';\t\t\n\tif (billing_group.length == 0) return;\n\n\tvar sql=\"called_for=REFSRCLKUP&locale=\"+locale+\"&episode_type=\"+episode_type;\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(ref_desc.value)+\"&srch_by_clmn_index=3\"+\"&col_show_hide=YYYYY\";\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\n\tvar arr=new Array();\t\t\n\tif(retVal == null) retVal=\'\';\t\n\t\n\tif (retVal != null || retVal != \"\")\n\t{\t\n\t\tvar retVal=unescape(retVal);\t\t\t\t\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\t\n\t\t\tvar non_ins_ref_src_lng_name = arr[3];\n\n\t\t\tif(called_frm == \'M\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_code.value=arr[0];\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_desc.value=arr[2];\n\n\t\t\t\tif(non_ins_ref_src_lng_name != \"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').style.visibility=\"visible\";\n\t\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').alt=arr[3];\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(called_frm == \'S\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].non_ins_ref_src_sub_code.value=arr[0];\n\t\t\t\tdocument.forms[0].non_ins_ref_src_sub_desc.value=arr[2];\n\n\t\t\t\tif(non_ins_ref_src_lng_name != \"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').style.visibility=\"visible\";\n\t\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').alt=arr[3];\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\t\n\t\telse\n\t\t{\n\t\t\tif(called_frm == \'M\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_code.value=\"\";\n\t\t\t\tdocument.forms[0].non_ins_ref_src_main_desc.value=\"\";\n\n\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'non_ins_pmy_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t\tif(called_frm == \'S\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].non_ins_ref_src_sub_code.value=\"\";\n\t\t\t\tdocument.forms[0].non_ins_ref_src_sub_desc.value=\"\";\n\n\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').style.visibility=\"hidden\";\n\t\t\t\tdocument.getElementById(\'non_ins_sec_ref_src_lng_name\').alt=\"\";\n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(called_frm == \'M\')\n\t\t{\n\t\t\tdocument.forms[0].non_ins_ref_src_main_code.value=\"\";\n\t\t\tdocument.forms[0].non_ins_ref_src_main_desc.value=\"\";\n\t\t}\n\t\tif(called_frm == \'S\')\n\t\t{\n\t\t\tdocument.forms[0].non_ins_ref_src_sub_code.value=\"\";\n\t\t\tdocument.forms[0].non_ins_ref_src_sub_desc.value=\"\";\n\t\t}\n\t}\n}\n\nfunction curr_code()\n{\n\tvar currency_desc_for_bg = document.forms[0].currency_desc_for_bg.value;\n\n\tif(currency_desc_for_bg != \"\")\n\t{\n\t\tdocument.getElementById(\'bg_curr_desc_disp\').style.display=\"inline\";\n\t\tdocument.getElementById(\'bg_curr_desc\').innerText=currency_desc_for_bg;\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'bg_curr_desc_disp\').style.display=\"none\";\n\t\tdocument.getElementById(\'bg_curr_desc\').innerText=\"\";\n\t}\n}\n</script>\n\n";
    private final static byte[]  _wl_block6_5Bytes = _getBytes( _wl_block6_5 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/Hashtable.js\"></script>\n\t<script language=\'javascript\' src=\'../../eXH/js/ExternalApplication.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\'disableAllElements();curr_code(); disable();\' >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t<body onLoad=\'curr_code();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"curr_code();\" >\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<form name=\'add_modify_pat_fin_det_insbut\' id=\'add_modify_pat_fin_det_insbut\'>\n<table cellpadding=0 cellspacing=1 border=0 width=\"100%\" align=\'center\' border=1>\n<tr>\n\t<td>\n\t\t<input align=left type=\"button\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" class=\"button\" onClick=\"showMultiBlngGrp()\" >\n\t</td>\n\n\t<td>\n\t\n\t\t<input align=right type=\"button\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" class=\"button\" onClick=\"addPayer()\" >\n\t\t<input align=right type=\"button\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" class=\"button\" onClick=\"modifyPayer()\">\n\t\t<input align=right type=\"button\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" class=\"button\" onClick=\"removePayerNew()\">\n\t\t\t\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<input align=right type=\"button\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" class=\"button\" onClick=\"dataForImage_ghl()\">\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" class=\"button\" onClick=\"dataForImage()\">\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<!--\t<a href=\"javascript:dataForImage();\">image upload</a>-->\n   </td>\t\n</tr>\n</table>\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=center>\n<tr>\n\t<td width=\"25%\" class=\'label\'><a href=\"javascript:getNonInsBlngGrpSearch();\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a>&nbsp;&nbsp;<div id=\"bg_curr_desc_disp\" style=\"display:inline\"><Font color=\'red\'><b id=\"bg_curr_desc\"></b></font></div></td>\t\n\t\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<script>alert(getMessage(\"BL6372\",\"BL\"));</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<td width=\"50%\" class=\'fields\'><input type=\'text\' name=\"non_ins_billing_group_desc\" id=\"non_ins_billing_group_desc\" maxlength=\'40\' size=\'40\' tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onBlur=\"return noninsblnggrplkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"noninsblnggrpbut\" id=\"noninsblnggrpbut\" value=\'?\'  onClick=\"return noninsblnggrplkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t<input type= hidden name=\"non_insur_blng_grp\" id=\"non_insur_blng_grp\"  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n<td width=\"50%\" class=\'fields\'><input type=\'text\' name=\"non_ins_billing_group_desc\" id=\"non_ins_billing_group_desc\" maxlength=\'40\' size=\'40\' tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onBlur=\"return noninsblnggrplkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"noninsblnggrpbut\" id=\"noninsblnggrpbut\" value=\'?\'  onClick=\"return noninsblnggrplkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n<input type= hidden name=\"non_insur_blng_grp\" id=\"non_insur_blng_grp\"  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<td width=\"25%\" class=\'fields\'><input type=\'text\' name=\"non_ins_billing_group_desc\" id=\"non_ins_billing_group_desc\" maxlength=\'40\' size=\'40\' tabindex=\'0\' value=\'\' onBlur=\"return noninsblnggrplkup(\'B\')\"><input type=\'button\' class=\'button\' name=\"noninsblnggrpbut\" id=\"noninsblnggrpbut\" value=\'?\'  onClick=\"return noninsblnggrplkup(\'C\')\" tabindex=\'0\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t<input type= hidden name=\"non_insur_blng_grp\" id=\"non_insur_blng_grp\"  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<input type= \"hidden\" name=\"currency_code_for_bg\" id=\"currency_code_for_bg\"  value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type= \"hidden\" name=\"currency_desc_for_bg\" id=\"currency_desc_for_bg\"  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<td width=\"10%\" ></td>\n\t<td width=\"10%\" ></td>\n</tr>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n<input type=\'hidden\' name=\'non_ins_ref_src_capture_YN\' id=\'non_ins_ref_src_capture_YN\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'non_ins_ref_src_main_mand_YN\' id=\'non_ins_ref_src_main_mand_YN\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'non_ins_ref_src_sub_mand_YN\' id=\'non_ins_ref_src_sub_mand_YN\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<tr>\n\t\n\t<td width=\"25%\" class=\"Label\">\n\t\t<div id=\'non_ins_ref_src_code_main_leg_disp\' style=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t</div>\n\t</td>\n\n\t<td width=\"25%\" class=\"fields\">\n\t\t<div id=\'non_ins_ref_src_code_main_val_disp\' style=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t<input type=\'text\' name=\"non_ins_ref_src_main_desc\" id=\"non_ins_ref_src_main_desc\" maxlength=\'50\' size=\'25\' tabindex=\'0\'  value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onBlur=\"return refsrclkup(document.forms[0].non_ins_ref_src_main_code,document.forms[0].non_ins_ref_src_main_desc,\'M\',\'B\')\" >\n\t\t<input type=\'button\' class=\'button\' name=\"refsrcmainbut\" id=\"refsrcmainbut\" value=\'?\' onClick=\"return refsrclkup(document.forms[0].non_ins_ref_src_main_code,document.forms[0].non_ins_ref_src_main_desc,\'M\',\'C\')\" tabindex=\'0\'>\n\t\t<div id=\'non_ins_ref_src_code_main_mand_disp\' style=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<img src=\'../../eCommon/images/more.gif\' name=\"non_ins_pmy_ref_src_lng_name\" id=\"non_ins_pmy_ref_src_lng_name\" align=\'center\' style=\"visibility:hidden\">\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<img src=\'../../eCommon/images/more.gif\' name=\"non_ins_pmy_ref_src_lng_name\" id=\"non_ins_pmy_ref_src_lng_name\" align=\'center\' style=\"visibility:inline\" alt=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\t\t\t\t\t\n\t\t</div>\n\t</td>\n\t\n\t<td width=\"25%\" class=\"Label\">\n\t\t<div id=\'non_ins_ref_src_code_sub_leg_disp\' style=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t</div>\n\t</td>\n\t\n\t<td width=\"25%\" class=\"fields\">\n\t<div id=\'non_ins_ref_src_code_sub_val_disp\' style=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type=\'text\' name=\"non_ins_ref_src_sub_desc\" id=\"non_ins_ref_src_sub_desc\" maxlength=\'50\' size=\'25\' tabindex=\'0\'  value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" onBlur=\"return refsrclkup(document.forms[0].non_ins_ref_src_sub_code,document.forms[0].non_ins_ref_src_sub_desc,\'S\',\'B\')\">\n\t\t<input type=\'button\' class=\'button\' name=\"refsrcsubbut\" id=\"refsrcsubbut\" value=\'?\' onClick=\"return refsrclkup(document.forms[0].non_ins_ref_src_sub_code,document.forms[0].non_ins_ref_src_sub_desc,\'S\',\'C\')\" tabindex=\'0\'>\n\t\t<div id=\'non_ins_ref_src_code_sub_mand_disp\' style=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t<img src=\'../../eCommon/images/more.gif\' name=\"non_ins_sec_ref_src_lng_name\" id=\"non_ins_sec_ref_src_lng_name\" align=\'center\' style=\"visibility:hidden\">\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t<img src=\'../../eCommon/images/more.gif\' name=\"non_ins_sec_ref_src_lng_name\" id=\"non_ins_sec_ref_src_lng_name\" align=\'center\' style=\"visibility:inline\" alt=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\t\t\t\n\t\t</div>\n\t</td>\n</tr>\n\t<input type=\'hidden\' name=\'non_ins_ref_src_main_code\' id=\'non_ins_ref_src_main_code\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\'hidden\' name=\'non_ins_ref_src_sub_code\' id=\'non_ins_ref_src_sub_code\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t</table>\n\n\t<input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' id=\'setlmt_ind\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\t\n\t<input type=\'hidden\' name=\'ins_auth_flag\' id=\'ins_auth_flag\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\'hidden\' name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t<input type=\'hidden\' name=\"bl_data_from_repos_yn\" id=\"bl_data_from_repos_yn\" value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\t\n\t<input type=\'hidden\' name=\"items_disabled\" id=\"items_disabled\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\t\n\t<input type=\'hidden\' name=\"calling_module_id\" id=\"calling_module_id\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\t\n\t<input type=\'hidden\' name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\t\n\t<input type=\'hidden\' name=\"operation_fun\" id=\"operation_fun\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\t\n\t<input type=\'hidden\' name=\"operation_mode\" id=\"operation_mode\" value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\t\n\t<input type=\'hidden\' name=\'CitizenYn\' id=\'CitizenYn\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t<input type=\'hidden\' name=\'blnggrpappyn\' id=\'blnggrpappyn\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\t\t\n\t<input type=\'hidden\' name=\'blnggrpcatgappyn\' id=\'blnggrpcatgappyn\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t<input type=\'hidden\' name=\'BlngGrpStatus\' id=\'BlngGrpStatus\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t<input type=\'hidden\' name=\'mpolicy_type\' id=\'mpolicy_type\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t<input type=\'hidden\' name=\"queryString\" id=\"queryString\"  value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\'hidden\' name=\"billing_group\" id=\"billing_group\"  value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\'hidden\' name=\"p_patient_class\" id=\"p_patient_class\"  value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t<input type=\'hidden\' name=\"facility_id\" id=\"facility_id\"  value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t<input type=\'hidden\' name=\"episode_type\" id=\"episode_type\"  value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\n\t<input type=\'hidden\' name=\'fin_class_flag_YN\' id=\'fin_class_flag_YN\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t<input type=\'hidden\' name=\'autoFinChk\' id=\'autoFinChk\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t<input type=\'hidden\' name=\'class_code\' id=\'class_code\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t<input type=\'hidden\' name=\'package_enabled_yn\' id=\'package_enabled_yn\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t<!-- //Added by prithivi on 11/12/2016 for mms-qh-crf-0085-bupa insurance -->\n\t<input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n\t<input type=\'hidden\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' >\n\t<input type=\'hidden\' name=\'siteSpecAgeVal\' id=\'siteSpecAgeVal\' id=\'siteSpecAgeVal\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"><!-- Added Against V210310-->\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n<script>noninsblnggrplkup(\'C\');</script>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

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
 1           V210310            12033       AMS-CRF-00249            Ram kumar S
 2			 V220908						TH-KW-CRF-0093 			Namrata Charate
 3			 V230315						MMS-DM-CRF-0209.5		Namrata Charate
 4			 V230707						AAKH-CRF-0142.1			Namrata Charate
*/ 
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
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	//ResultSet rs4				= null;
	ResultSet rs5				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	boolean siteSpecUploadDocAll = false;//GHL-CRF-0550
	boolean siteSpecAgeValidation=false;// Added against V210310
	String payerGrpBySetup =  request.getParameter("payerGrpBySetup");
	String locale			= (String)session.getAttribute("LOCALE");

	try
	{
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
		siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
		//V210310 Starts 
		String siteSpecAgeVal ="";
		try
		{	
			siteSpecAgeValidation = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AGE_GRP_VAL_FOR_BLNG_GRP");
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in Non Ins Billing Grp site specific Age Validation "+e);
		}
		if(siteSpecAgeValidation){
			siteSpecAgeVal="Y";
		}
		else{
			siteSpecAgeVal="N";
		}
		System.err.println("siteSpecAgeVal Non Ins Billing Grp "+siteSpecAgeVal);
		//V210310 Ends
		String package_enabled_yn="N";//added for package Billing
		String nd_settlement_ind ="";
		String nd_adm_rec_flag ="", ins_auth_flag="";
		String mpolicy_type="" ;
		String mnon_insur_blng_grp="";
		String mcredit_auth_ref="", mcredit_auth_date="", mapp_days="",mapp_amount="",meff_frm_date="";	

		String facility_id = (String)httpSession.getValue("facility_id");
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";	
		String billing_group="";

		String cash_leg ="", credit_leg ="", sponsor_leg ="", ins_leg ="";

		String rtn_non_ins_blng_grp="";
		String non_ins_billing_group_desc="";
		String rtn_non_ins_ref_src_main_code = "";
		String rtn_non_ins_ref_src_main_desc = "";
		String ref_non_ins_src_main_lng_name = "";
		String rtn_non_ins_ref_src_sub_code = "";
		String rtn_non_ins_ref_src_sub_desc = "";
		String ref_non_ins_src_sub_lng_name = "";
		String queryString=(request.getQueryString());
		String p_patient_class=request.getParameter("patient_class");
		String episode_type="";

		//Added by prithivi on 11/12/2016 for MMS-qh-crf-0085 - bupa insurance interface
		String service_code=request.getParameter("service_code");
		String fin_class_flag_YN="N",autoFinChk="N",class_code="",class_blng_grp_id="";

		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

		cash_leg = (String) bl_labels.getString("eBL.CASH.label");
		if(cash_leg == null) cash_leg="";
		credit_leg = (String) bl_labels.getString("eBL.CREDIT.label");
		if(credit_leg == null) credit_leg="";
		sponsor_leg = (String) bl_labels.getString("eBL.SPONSOR.label");
		if(sponsor_leg == null) sponsor_leg="";
		ins_leg = (String) common_labels.getString("Common.Insurance.label");
		if(ins_leg == null) ins_leg="";

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="";

		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";

		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}

		package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";	

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				billing_group=((String)bl_data.get("blng_grp")).trim();
				rtn_non_ins_blng_grp=((String)bl_data.get("non_ins_blng_grp")).trim();

				rtn_non_ins_ref_src_main_code = ((String)bl_data.get("non_ins_ref_src_main_code")).trim();
				if(rtn_non_ins_ref_src_main_code == null) rtn_non_ins_ref_src_main_code="";

				rtn_non_ins_ref_src_main_desc = ((String)bl_data.get("non_ins_ref_src_main_desc")).trim();
				if(rtn_non_ins_ref_src_main_desc == null) rtn_non_ins_ref_src_main_desc="";

				rtn_non_ins_ref_src_sub_code = ((String)bl_data.get("non_ins_ref_src_sub_code")).trim();
				if(rtn_non_ins_ref_src_sub_code == null) rtn_non_ins_ref_src_sub_code="";

				rtn_non_ins_ref_src_sub_desc = ((String)bl_data.get("non_ins_ref_src_sub_desc")).trim();
				if(rtn_non_ins_ref_src_sub_desc == null) rtn_non_ins_ref_src_sub_desc="";
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");		
		}
		
		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}

		String strdfltbgyn = "N";
		String srtencdfltbgyn="N";
		String bl_future_admn_YN="";

		String strBlngGrpAppYN= "Y";
		String strBlngGrpStatus="";
		String strCategory = "";
		String strBlngGrpCatgAppYN = "Y";		

		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		String clinic_code = request.getParameter("clinic_code");
		String visit_type_code = request.getParameter("visit_type_code");
		String strshowHideBlngClass = request.getParameter("show_hide_blng_class");

		//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
		String nursing_unit_code=request.getParameter("nursing_unit_code");

		String l_credit_doc_ref_desc = "";
		String l_credit_doc_ref_start_date = "";
		String l_credit_doc_ref_date =  "";
		String l_cust_code = "";
		String l_slmt_ind = "";
		String l_adm_rec_flag = "";

		String str_blng_grp_id = "";
		String str_short_desc = "";	
		String str_currency_code_for_bg = "",str_currency_desc_for_bg="";

		String patient_id = request.getParameter("patient_id");		
		if (patient_id == null ) patient_id = "";

		String strCitizenYn = "N";		
		String nationalityyn = "";

		strCitizenYn = request.getParameter("CitizenYn");
		if(strCitizenYn == null) strCitizenYn="N";

		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

		if ( strdfltbgyn == null) strdfltbgyn = "N";
		if ( srtencdfltbgyn == null) srtencdfltbgyn="N";

		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}

		bl_future_admn_YN=request.getParameter("bl_future_admn_YN");
		if(bl_future_admn_YN==null) bl_future_admn_YN="N";
		
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
		if(rs5 != null ) rs5.close();
		pstmt.close();

		if (l_credit_doc_ref_desc == null) l_credit_doc_ref_desc = "";
		if (l_credit_doc_ref_start_date == null) l_credit_doc_ref_start_date = "";
		if (l_credit_doc_ref_date == null) l_credit_doc_ref_date = "";
		if (l_cust_code == null) l_cust_code = "";
		if (l_slmt_ind == null) l_slmt_ind = "";
		if (l_adm_rec_flag == null) l_adm_rec_flag = "";	

		if (strshowHideBlngClass == null) strshowHideBlngClass = "";

		String strCreditDoc_YN="N";

		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");
		if(strModuleId==null || strModuleId.equals("")) strModuleId="";
		String str_function_id = request.getParameter("calling_function_id");
		if(str_function_id == null) str_function_id="";
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
		if (str_function_id ==null)
		{
			str_function_id = "";		
		}	

		
		if(bl_future_admn_YN.equals("Y") && ((strModuleId.equals("IP") || strModuleId.equals("DC")) && str_function_id.equals("ADMISSION")))
		{	
			strdfltbgyn="Y";
		}

		if (strRepositoryYN.equals("Y") && strModuleId.equals("MP"))
		{

			String strTempFunId = request.getParameter("id_fun");
			if (strTempFunId== null)
			{
				strExtSettlType = request.getParameter("cash_set_type1");	
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

		if(p_patient_class ==null || (p_patient_class.equals("")))
		{
			if(strModuleId.equals("MP")) p_patient_class="XT";
			else if(strModuleId.equals("EM")) p_patient_class="EM";
			else if(strModuleId.equals("OP")) p_patient_class="OP";
			else if(strModuleId.equals("IP")) p_patient_class="IP";
			else if(strModuleId.equals("DC")) p_patient_class="DC";
		}

		if(strModuleId.equals("MP")) episode_type="R";
		else if(strModuleId.equals("AE")) episode_type="E";
		else if(strModuleId.equals("OP")) episode_type="O";
		else if(strModuleId.equals("IP")) episode_type="I";
		else if(strModuleId.equals("DC")) episode_type="D";

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			mnon_insur_blng_grp = rtn_non_ins_blng_grp;
			if ( mnon_insur_blng_grp == null ) mnon_insur_blng_grp = "";

			clinic_code			= request.getParameter("clinic_code");
			if ( clinic_code == null ) clinic_code = "";

			//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
			nursing_unit_code			= request.getParameter("nursing_unit_code");
			if ( nursing_unit_code == null ) nursing_unit_code = "";

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

		//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
		if((nursing_unit_code==null) || (nursing_unit_code.equals("null"))) nursing_unit_code="";

		String sql="select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N') from bl_blng_grp where blng_grp_id = ? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,billing_group);
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
		if(rs != null ) rs.close();
		pstmt.close();

		if(nd_settlement_ind==null)nd_settlement_ind="";
		if(nd_adm_rec_flag==null)nd_adm_rec_flag="";	
		

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

            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);
            _bw.write(_wl_block6_2Bytes, _wl_block6_2);
            _bw.write(_wl_block6_3Bytes, _wl_block6_3);
            _bw.write(_wl_block6_4Bytes, _wl_block6_4);
            _bw.write(_wl_block6_5Bytes, _wl_block6_5);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
	{
		if(!("Y").equalsIgnoreCase(payerGrpBySetup))
		{

            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	else{
		
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	}
	else
	{

            _bw.write(_wl_block11Bytes, _wl_block11);

	}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_MORE_SECONDARY_BILLING_GROUPS.label","bl_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_MORE_PAYERS.label","bl_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.MODIFY_PAYER.label","bl_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.REMOVE_PAYER.label","bl_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);

	if(siteSpecUploadDocAll) {

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.UploadDocuments.label","bl_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
}	else{
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.UploadImages.label","bl_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
}	
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

		String str_package_yn = "";
		pstmt = con.prepareStatement( "select blng_grp_id, short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C', ? , 'C0', ? ,'C1', ? ,'C2', ? ,'R', ? ,'R0', ? ,'R1', ? ,'R2', ? ,'X1', ? ,'X2', ? )||')' SHORT_DESC ,DECODE(?,'MP',ref_yn,'AE',ae_yn,'OP',op_yn,'IP',ip_yn,'DC',dy_yn)episode_type_app_yn, status , category,NVL(PACKAGE_YN,'N') PACKAGE_YN from bl_blng_grp_lang_vw where language_id= ? and (( status is null and settlement_ind || adm_rec_flag != 'X2' and ((?='MP' and ref_yn = 'Y' and ref_valid_for_regn_yn = 'Y') or (?='AE' and ae_yn = 'Y') or (?='OP' and op_yn = 'Y') or (?='IP' and ip_yn = 'Y') or (?='DC' and dy_yn = 'Y')) and (NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED'))) and (blng_grp_id = ? and NVL(?,'N') = 'Y')) order  by short_desc" ) ;
		
		pstmt.setString(1,cash_leg);
		pstmt.setString(2,cash_leg);
		pstmt.setString(3,cash_leg);
		pstmt.setString(4,cash_leg);
		pstmt.setString(5,credit_leg);
		pstmt.setString(6,credit_leg);
		pstmt.setString(7,credit_leg);
		pstmt.setString(8,credit_leg);
		pstmt.setString(9,sponsor_leg);
		pstmt.setString(10,ins_leg);
		pstmt.setString(11,strModuleId);
		pstmt.setString(12,locale);
		pstmt.setString(13,strModuleId);
		pstmt.setString(14,strModuleId);
		pstmt.setString(15,strModuleId);
		pstmt.setString(16,strModuleId);
		pstmt.setString(17,strModuleId);
		pstmt.setString(18,strCitizenYn);
		pstmt.setString(19,mnon_insur_blng_grp);
		pstmt.setString(20,strdfltbgyn);
		
		rs = pstmt.executeQuery();
		
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				String non_blng_grp_id = rs.getString( "blng_grp_id" ) ;
				String short_desc = rs.getString( "short_desc" ) ;
				str_package_yn = rs.getString( "PACKAGE_YN" ) ;

				if((mnon_insur_blng_grp.equals(non_blng_grp_id)) && ((strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP"))))||strModuleId.equals("MP")))
				{
						str_blng_grp_id = non_blng_grp_id;
						str_short_desc = short_desc;

						strBlngGrpAppYN = rs.getString("episode_type_app_yn");
						if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
						strBlngGrpAppYN = "N";	

						strBlngGrpStatus = rs.getString("status");
						if(strBlngGrpStatus == null ||strBlngGrpAppYN.equals("null")) 
						strBlngGrpStatus="";

						strCategory = rs.getString("category");
						if(strCategory == null ||strBlngGrpAppYN.equals("null") || strCategory.equals("")) 
						strCategory="UNRESTRICTED";		

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
			}
		}
		if(rs != null ) rs.close();
		pstmt.close() ;
		
		/*Karthik adds his change - starts here*/
		boolean nonInsuranceBlngGroupformDB=false;
		String non_ins_blng_grp_id =null;
		if(str_blng_grp_id==null || str_blng_grp_id.equals("")) //non_blng_grp_id is also placed in same string, so checking whether non insurance Billing Group exists
		{
			pstmt = con.prepareStatement("select NON_INS_BLNG_GRP_ID, short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','Cash', 'C0','Cash','C1','Cash','C2','Cash','R', 'Credit','R0', 'Credit','R1', 'Credit','R2', 'Credit','X1', 'Sponsor','X2','Insurance')||')' SHORT_DESC ,DECODE('OP','MP',ref_yn,'AE',ae_yn,'OP',op_yn,'IP',ip_yn,'DC',dy_yn)episode_type_app_yn, status , category,NVL(PACKAGE_YN,'N') PACKAGE_YN from BL_BLNG_GRP where BLNG_GRP_ID= ? ");
			pstmt.setString(1,billing_group);
			rs = pstmt.executeQuery();
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					non_ins_blng_grp_id = rs.getString( "NON_INS_BLNG_GRP_ID" ) ;
					String short_desc = rs.getString( "short_desc" ) ;
					str_package_yn = rs.getString( "PACKAGE_YN" ) ;
					
					non_ins_blng_grp_id = (non_ins_blng_grp_id==null?"":non_ins_blng_grp_id);

					if( ( (strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP")))) ||strModuleId.equals("MP")) )
					{
							str_blng_grp_id = non_ins_blng_grp_id;
							str_short_desc = short_desc;

							strBlngGrpAppYN = rs.getString("episode_type_app_yn");
							if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
							strBlngGrpAppYN = "N";	

							strBlngGrpStatus = rs.getString("status");
							if(strBlngGrpStatus == null ||strBlngGrpAppYN.equals("null")) 
							strBlngGrpStatus="";

							strCategory = rs.getString("category");
							if(strCategory == null ||strBlngGrpAppYN.equals("null") || strCategory.equals("")) 
							strCategory="UNRESTRICTED";		

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
							nonInsuranceBlngGroupformDB=true;
					}					
				}
			}
		if(rs != null )   rs.close();
		if(pstmt != null) pstmt.close();
		}
		/*Karthik adds his change - ends here*/

		if( !("".equals(str_blng_grp_id)) )
		{
			String currency_desc_for_bg_qry="Select CURRENCY_CODE,CURRENCY_DESC from bl_blng_grp_lang_vw where blng_grp_id='"+str_blng_grp_id+"' and language_id='"+locale+"'";
			pstmt = con.prepareStatement( currency_desc_for_bg_qry );
			rs = pstmt.executeQuery();

			if( rs != null )
			{
				while( rs.next() ) 
				{
					str_currency_code_for_bg = rs.getString(1);
					str_currency_desc_for_bg = rs.getString(2);
				}
				if(str_currency_code_for_bg == null) str_currency_code_for_bg="";
				if(str_currency_desc_for_bg == null) str_currency_desc_for_bg="";

				if (rs != null) rs.close();
					pstmt.close();	
			}	
		}
		if(str_package_yn.equals("Y"))
		{
			str_blng_grp_id = "" ;
			str_short_desc = "" ;

            _bw.write(_wl_block22Bytes, _wl_block22);

		}

	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			String sql_non_ins="select short_DESC||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC from bl_blng_grp_lang_vw where BLNG_GRP_ID='"+str_blng_grp_id+"' and language_id='"+locale+"'";
			pstmt = con.prepareStatement(sql_non_ins);
			rs = pstmt.executeQuery();
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					non_ins_billing_group_desc = rs.getString( "short_desc" ) ;
				}
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(non_ins_billing_group_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(str_blng_grp_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

		}
		else if(nonInsuranceBlngGroupformDB){ // Karthik added for Defaulting non insurance blng group - starts

		String sql_non_ins="select short_DESC||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC from bl_blng_grp_lang_vw where BLNG_GRP_ID='"+str_blng_grp_id+"' and language_id='"+locale+"'";
		pstmt = con.prepareStatement(sql_non_ins);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				non_ins_billing_group_desc = rs.getString( "short_desc" ) ;
			}
		}
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(non_ins_billing_group_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_blng_grp_id));
            _bw.write(_wl_block28Bytes, _wl_block28);

	} // Karthik added for Defaulting non insurance blng group - ends
	else
	{
	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(str_blng_grp_id));
            _bw.write(_wl_block28Bytes, _wl_block28);

	}
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str_currency_code_for_bg));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(str_currency_desc_for_bg));
            _bw.write(_wl_block32Bytes, _wl_block32);

	String non_ins_ref_src_capture_YN="N";
	String non_ins_ref_src_main_mand_YN="N";
	String non_ins_ref_src_sub_mand_YN="N";
	String non_ins_ref_src_code_disp="";
	String non_ins_ref_src_code_main_mand_disp ="";
	String non_ins_ref_src_code_sub_mand_disp = "";
	String non_ins_ref_src_code_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N'),nvl(REF_SOURCE_MAIN_MAND_YN,'N'),nvl(REF_SOURCE_SUB_MAND_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+rtn_non_ins_blng_grp+"'";
	
	try
	{
		pstmt = con.prepareStatement(non_ins_ref_src_code_qry);
		rs2 = pstmt.executeQuery();
		if( rs2 != null ) 
		{	
			while( rs2.next() )
			{  
				non_ins_ref_src_capture_YN = rs2.getString(1);
				non_ins_ref_src_main_mand_YN = rs2.getString(2);
				non_ins_ref_src_sub_mand_YN = rs2.getString(3);
			}
		}
		if (rs2 != null) rs2.close();
		pstmt.close();	
	}
	catch(Exception e)
	{
		System.err.println("Exception in ref_src_code_qry:"+e);
		e.printStackTrace();
	}
		
	if(non_ins_ref_src_capture_YN.equals("Y"))
	{
		non_ins_ref_src_code_disp="display:inline";
		if(non_ins_ref_src_main_mand_YN.equals("Y"))
		{
			non_ins_ref_src_code_main_mand_disp = "display:inline";
		}
		else
		{
			non_ins_ref_src_code_main_mand_disp = "display:none";
		}
		if(non_ins_ref_src_sub_mand_YN.equals("Y"))
		{
			non_ins_ref_src_code_sub_mand_disp = "display:inline";
		}
		else
		{
			non_ins_ref_src_code_sub_mand_disp = "display:none";
		}
	}
	else if(non_ins_ref_src_capture_YN.equals("N"))
	{
		non_ins_ref_src_code_disp="display:none";
		non_ins_ref_src_code_main_mand_disp = "display:none";
		non_ins_ref_src_code_sub_mand_disp = "display:none";
	}
	else
	{
		non_ins_ref_src_code_disp="display:none";
		non_ins_ref_src_code_main_mand_disp = "display:none";
		non_ins_ref_src_code_sub_mand_disp = "display:none";
	}

	if(!rtn_non_ins_ref_src_main_code.equals(""))
	{
		CallableStatement call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
		call.registerOutParameter(1,java.sql.Types.VARCHAR);

		call.setString(2,rtn_non_ins_ref_src_main_code);
		call.setString(3,locale);
		call.setString(4,"3");

		call.execute();							
		ref_non_ins_src_main_lng_name = call.getString(1);				
		call.close();
		if ( ref_non_ins_src_main_lng_name == null ) ref_non_ins_src_main_lng_name = "";
	}
	else
	{
		ref_non_ins_src_main_lng_name="";
	}

	if(!rtn_non_ins_ref_src_sub_code.equals(""))
	{
		CallableStatement call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
		call.registerOutParameter(1,java.sql.Types.VARCHAR);

		call.setString(2,rtn_non_ins_ref_src_sub_code);
		call.setString(3,locale);
		call.setString(4,"3");

		call.execute();							
		ref_non_ins_src_sub_lng_name = call.getString(1);				
		call.close();
		if ( ref_non_ins_src_sub_lng_name == null ) ref_non_ins_src_sub_lng_name = "";
	}
	else
	{
		ref_non_ins_src_sub_lng_name="";
	}

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(non_ins_ref_src_capture_YN));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(non_ins_ref_src_main_mand_YN));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(non_ins_ref_src_sub_mand_YN));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(non_ins_ref_src_code_disp));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(non_ins_ref_src_code_disp));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rtn_non_ins_ref_src_main_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(non_ins_ref_src_code_main_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

		if(ref_non_ins_src_main_lng_name.equals(""))
		{
	
            _bw.write(_wl_block42Bytes, _wl_block42);

		}
		else
		{
	
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ref_non_ins_src_main_lng_name));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
	
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(non_ins_ref_src_code_disp));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(non_ins_ref_src_code_disp));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(rtn_non_ins_ref_src_sub_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(non_ins_ref_src_code_sub_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

		if(ref_non_ins_src_sub_lng_name.equals(""))
		{
	
            _bw.write(_wl_block48Bytes, _wl_block48);

		}
		else
		{
	
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ref_non_ins_src_sub_lng_name));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
	
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rtn_non_ins_ref_src_main_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rtn_non_ins_ref_src_sub_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nd_settlement_ind));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(ins_auth_flag));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strCreditDoc_YN));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strRepositoryYN));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strItemsDisabled));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(str_function_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(billing_mode));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strCitizenYn));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strBlngGrpAppYN));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(strBlngGrpCatgAppYN));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strBlngGrpStatus));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(mpolicy_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(fin_class_flag_YN));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(autoFinChk));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(package_enabled_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(siteSpecAgeVal));
            _bw.write(_wl_block82Bytes, _wl_block82);
if(nonInsuranceBlngGroupformDB && !(non_ins_blng_grp_id==null) && non_ins_blng_grp_id.length() >0 ){  // Karthik added for Defaulting non insurance blng group 
            _bw.write(_wl_block83Bytes, _wl_block83);
} 
            _bw.write(_wl_block84Bytes, _wl_block84);

	}
	catch(Exception e)
	{ 
		out.println(e);
		e.printStackTrace();
	}
	finally
	{	
		if(stmt != null)  stmt.close();
		ConnectionManager.returnConnection(con, request);
	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NON_INS_BILLING_GROUP.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
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
}
