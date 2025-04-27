package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __changepatientheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ChangePatientHeader.jsp", 1727677783713L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Latest Modified Date : 9/17/2005 9:58 AM -->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n\t\t<Script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n\t\t\n\t\t\n\t\t<script language=\'javascript\'>\n\t\t\tvar currentTab = new String();\n\t\t\tcurrentTab = \"demogrp_tab\";\n\t\t\tvar previousTab = new String();\n\t\t\tpreviousTab = \"demogrp_tab\"; \t\t\n\t\t\t\n\t\t\n\t\tasync function capturePhoto() \n\t\t{\n\t\t    var\turl     = \"../../eCommon/jsp/photo_capture.jsp?file=\"+document.getElementById(\"patient_id\").value+\'.jpg\' ;\n\t\t\t//var dialogHeight    = \"19\" ;\n\t\t    //var dialogWidth = \"23\" ;\n\t\t\t\tvar dialogHeight= \"400px\" ; //added by vijayan\n\t\t\t\t///var dialogTop = \"10px\" ;\n\t\t\t\tvar dialogWidth\t= \"700px\" ;\n\t\t    var arguments   = \"\" ;\n\t\t    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; status=no;\";\n\t\t    var reportURL   = await window.showModalDialog( url, arguments, features ) ;\n\t\t}\n\t\t\n\t\tasync function getFinDtl(qryStr)\n\t\t{\n\t\t    var retVal;\n/*\t\t    var dialogHeight= \"24\";\n\t\t\tvar\tdialogWidth = \"49\";\n\t\t    var dialogTop = \"160\";\n\t\t\t*/\n\t\t\t\n\t\t\t/*\n\t\t\tvar dialogHeight= \"41\";\n\t\t\tvar dialogWidth = \"65\";\n\t\t\tvar dialogTop\t= \"85\";\n\t\t\t*/\n\t\t\t\n\t\t\tvar dialogTop   = \"10px\";\n\t\t    var dialogHeight= \"400px\" ;\n\t\t    var dialogWidth = \"700px\" ;\n\n\t\t    var center = \"1\";                                                         \n\t\t    var status=\"no\";\n\t\t    var features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t    var arguments   = \"\" ;\n   \n\t\t    var url = \"../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?\"+qryStr;\n\t\t    retVal = await window.showModalDialog(url,arguments,features);\n\t\t\n\t\t\tif(retVal == null) retVal = \"\";\n\t\t\n\t\t\treturn retVal;\n        }\n\t\t\n\t\tfunction chkOnSub()\n\t\t{\n\n\t\t\tvar pat_ser_code = \"\";\n\t\t\tif(parent.frames[1].document.getElementById(\"pat_ser_grp_code\")) {\n\t\t\t\tpat_ser_code = parent.frames[1].document.getElementById(\"pat_ser_grp_code\").value;\t\t\t\n\t\t\t}\n\t\t\t//alert(\'pat_ser_code\'+pat_ser_code);\n\n\t\t\tif(pat_ser_code == \"\") {\n\t\t\t\tvar err = getMessage(\"CAN_NOT_BE_BLANK\",\'COMMON\');\n\t\t\t\terr = err.replace(\'$\',getLabel(\'eMP.PatientSeries.label\',\'MP\'));\n\t\t\t\talert(err);\n\t\t\t\treturn;\n\t\t\t}\n\n\t\t\t/*\n\t\t\tif(pat_ser_code == \"\") {\n\t\t\t\talert(\"Patient Series can not be blank\");\n\t\t\t\treturn;\n\t\t\t} \n\t\t\t*/\t\n\n\t\t\tvar package_flag\t= \"N\";\n\t\t    var ins_auth_flag\t= \"N\";\n\t\t    var upd_pat_flag\t= \"N\";\n\t\t    var patient_id\t\t= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\tif(parent.frames[1].document.forms[0].mother_patient_id)\n\t\t\t{\n\t\t\tvar mother_patient_id=parent.frames[1].document.forms[0].mother_patient_id.value;\n\n\t\t\tif(mother_patient_id != \'\') patient_id = mother_patient_id;\n\t\t\t}\n\t\n\t\t\tvar show_hide_blng_class\t= \"SHOW\";\n\t\t    var billing_group\t\t\t= parent.frames[1].document.forms[0].billing_group;\n\t\t\t\n\t\t    var billing_mode\t\t\t= parent.frames[1].document.forms[0].billing_mode;\n\n\t\t\tvar bl_data_from_repos_yn = \"N\";\n\t\t\tvar data_source_id = parent.frames[1].document.forms[0].change_data_source;\n\t\t\n\t\t\tif(data_source_id.value != \'\' && billing_group.value != \'\')\n\t\t\t{\n\t\t\t\tbl_data_from_repos_yn = \"Y\";\n\t\t\t}\n\t\t\n\t\t\tif(billing_group.value != \'\') billing_mode.value = \"Modify\";\n\t\t\t\n\t\t\tvar operation = parent.frames[1].document.forms[0].bl_operation.value;\n\t\t\t\n\t\t\tif(billing_mode.value==\"Modify\") operation=\"Update\";\n\t\t\t\n\t\t\tif(operation==\'Insert\')\n\t\t\t{\n\t\t\t\toperation=\'\';\n\t\t\t\tbilling_mode.value = \'\';\n\t\t\t}\n\t\t\n\t\t\n\t\t\tvar calling_module_id\t   = \"MP\";\n\t\t\tvar calling_function_id\t   = \"CHG_PAT_DTLS\";\n\t\t\t//var calling_function_id\t   = parent.frames[1].document.forms[0].function_id.value;\n\n\t\t\t//alert(\'calling_function_id-->\'+calling_function_id);\n\n\t\t\t//end of Addition\n\t\t\n\t\t\tvar episode=\"\";\n\t\t\tvar record=\"\";\n\t\t\t\n\t\t\tvar qryStr = \"operation=\"+operation+\"&upd_pat_flag=\"+upd_pat_flag+\"&patient_id=\"+patient_id+\"&show_hide_blng_class=\"+show_hide_blng_class+\"&billing_mode=\"+billing_mode.value;\n\t\t\t\n\t\t\t\t\t\n\t\t\tqryStr += \"&calling_module_id=\"+calling_module_id+\"&calling_function_id=\"+calling_function_id;\n\t\t\tqryStr += \"&bl_data_from_repos_yn=\"+bl_data_from_repos_yn+\"&data_source_id=\"+data_source_id.value;\n\t\t\t\n\t\t\t/* Start of modifications for billing enhancement on 8th Jan 04 --------------- */\n\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t/*End of modifications for billing enhancement on 8th Jan 04 --------------- */\n\t\t\n\t\t\tvar nationality_yn = \"N\";\n\t\t\tparent.frames[1].document.forms[0].dflt_nat_id_chk_val.value = parent.frames[1].document.forms[0].nationality_code.value;\n\t\t\t\n\t\t\tif(parent.frames[1].document.forms[0].nationality_code.value == \tparent.frames[1].document.forms[0].dflt_nationality_code.value)\n\t\t\t{\n\t\t\t\tnationality_yn = \"Y\";\n\t\t\t}\n\t\t\telse \n\t\t\t{\n\t\t\t\tnationality_yn = \"N\";\n\t\t\t}\n\t\t\n\t\t\tqryStr+=\"&nationality_yn=\"+nationality_yn;\n\t\t\tqryStr+=\"&patient_class=XT&pat_ser_code=\"+pat_ser_code;\n\t\t   var returnArray = new Array();\n\t  \n\t\t\treturnArray = getFinDtl(qryStr);\n\n\t\t\t//tab_click(previousTab);\n\n\t\t\tparent.patient_main.invokeTab(\'demogrp_tab\');\n\n\t\t\tif(returnArray.length>0)\n\t\t\t{\n\t\t\t\tbilling_group.value         = returnArray[0];\n\t\t\t\t/*billing_class.value         = returnArray[1];\n\t\t\t\temployer_code.value         = returnArray[2];    \n\t\t\t\tcash_set_type1.value        = returnArray[3];\n\t\t\t\tcash_insmt_ref1.value       = returnArray[4];\n\t\t\t\tcash_insmt_date1.value      = returnArray[5];\n\t\t\t\tcash_insmt_rmks1.value      = returnArray[6];\n\t\t\t\tcust_1.value                = returnArray[7];\n\t\t\t\tcredit_doc_ref1.value       = returnArray[8];\n\t\t\t\tcredit_doc_date1.value      = returnArray[9];\n\t\t\t\tcust_2.value                = returnArray[10];\n\t\t\t\tcredit_doc_ref2.value       = returnArray[11];\n\t\t\t\tcredit_doc_date2.value      = returnArray[12];\n\t\t\t\tcust_3.value                = returnArray[13];\n\t\t\t\tpolicy_type.value           = returnArray[14];\n\t\t\t\tpolicy_no.value             = returnArray[15];\n\t\t\t\tpolicy_expiry_date.value    = returnArray[16];\n\t\t\t\tnon_insur_blng_grp.value    = returnArray[17];\n\t\t\t\tcash_set_type2.value        = returnArray[18];\n\t\t\t\tcash_insmt_ref2.value       = returnArray[19];\n\t\t\t\tcash_insmt_date2.value      = returnArray[20];\n\t\t\t\tcash_insmt_rmks2.value      = returnArray[21];\n\t\t\t\tcust_4.value                = returnArray[22];\n\t\t\t\tcredit_doc_ref3.value       = returnArray[23];\n\t\t\t\tcredit_doc_date3.value      = returnArray[24];\n\t\t\t\tsetlmt_ind.value            = returnArray[25];\n\t\t\t\tupd_fin_dtls.value          = returnArray[26];\n\t\t\t\tcredit_auth_ref.value       = returnArray[27];\n\t\t\t\tcredit_auth_date.value      = returnArray[28];\n\t\t\t\tapp_days.value              = returnArray[29];\n\t\t\t\tapp_amount.value            = returnArray[30];\n\t\t\t\tannual_income.value\t\t\t= returnArray[31];\n\t\t\t\tfamily_asset.value\t\t\t= returnArray[32];\n\t\t\t\tno_of_dependants.value\t\t= returnArray[33];\n\t\t\t\tresp_for_payment.value\t\t= returnArray[34];\n\t\t\t\tcredit_doc_reqd_yn1.value\t= returnArray[35];\n\t\t\t\tcredit_doc_reqd_yn2.value\t= returnArray[36];\n\t\t\t\teff_frm_date.value          = returnArray[37];\n\t\t\t\tremarks.value               = returnArray[38];*/\n\n\t\t\t\t/* Start of modifications for billing enhancement on 8th Jan 04 ---------------\n\t\t\t\tcred_start_dt1.value = returnArray[40];\n\t\t\t\tcred_start_dt2.value = returnArray[41];\n\t\t\t\tcred_start_dt3.value = returnArray[42];\n\t\t\n\t\t\t\tparent.frames[1].document.forms[0].gl_holder_name.value = returnArray[43];\n\t\t\t\tparent.frames[1].document.forms[0].gl_holder_reln.value = returnArray[44]; */\n\n\t\t\t\t/*End of modifications for billing enhancement on 8th Jan 04 --------------- */\n\n\t\t\t\tbilling_mode.value          = \"Modify\"\n\t\t\t\tparent.frames[1].document.forms[0].bl_success.value = \"Y\";\n\t\t\t} else {\n\t\t\t\tparent.frames[1].document.forms[0].bl_success.value = \"N\";\n\t\t\t\treturn false;\n\t\t\t}\t\t\t\n\t\t}\n\t\t/*function chkOnSub()\n\t\t{\n\t\t\tvar package_flag\t= \"N\";\n\t\t    var ins_auth_flag\t= \"N\";\n\t\t    var upd_pat_flag\t= \"N\";\n\t\t    var patient_id\t\t= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\";\n\t\t\tvar mother_patient_id=parent.frames[1].document.forms[0].mother_patient_id.value;\n\n\t\t\tif(mother_patient_id != \'\') patient_id = mother_patient_id;\n\t\n\t\t\tvar show_hide_blng_class\t= \"SHOW\";\n\t\t    var billing_group\t\t\t= parent.frames[1].document.forms[0].billing_group;\n\t\t\tvar\tbilling_class\t\t\t= parent.frames[1].document.forms[0].billing_class;\n\t\t    var employer_code\t\t\t= parent.frames[1].document.forms[0].employer_code;\n\t\t    var cash_set_type1\t\t\t= parent.frames[1].document.forms[0].cash_set_type1;\n\t\t    var cash_insmt_ref1\t\t\t= parent.frames[1].document.forms[0].cash_insmt_ref1;\n\t\t    var cash_insmt_date1\t\t= parent.frames[1].document.forms[0].cash_insmt_date1;\n\t\t    var cash_insmt_rmks1\t\t= parent.frames[1].document.forms[0].cash_insmt_rmks1;\n\t\t    var cust_1\t\t\t\t\t= parent.frames[1].document.forms[0].cust_1;\n\t\t    var credit_doc_ref1\t\t\t= parent.frames[1].document.forms[0].credit_doc_ref1;\n\t\t    var credit_doc_date1\t\t= parent.frames[1].document.forms[0].credit_doc_date1;\n\t\t    var cust_2\t\t\t\t\t= parent.frames[1].document.forms[0].cust_2;\n\t\t    var credit_doc_ref2\t\t\t= parent.frames[1].document.forms[0].credit_doc_ref2;\n\t\t    var credit_doc_date2\t\t= parent.frames[1].document.forms[0].credit_doc_date2;\n\t\t    var cust_3\t\t\t\t\t= parent.frames[1].document.forms[0].cust_3;\n\t\t    var policy_type\t\t\t\t= parent.frames[1].document.forms[0].policy_type;\n\t\t    var policy_no\t\t\t\t= parent.frames[1].document.forms[0].policy_no;\n\t\t    var policy_expiry_date\t\t= parent.frames[1].document.forms[0].policy_expiry_date;\n\t\t    var non_insur_blng_grp\t\t= parent.frames[1].document.forms[0].non_insur_blng_grp;\n\t\t    var cash_set_type2\t\t\t= parent.frames[1].document.forms[0].cash_set_type2;\n\t\t    var cash_insmt_ref2\t\t\t= parent.frames[1].document.forms[0].cash_insmt_ref2;\n\t\t    var cash_insmt_date2\t\t= parent.frames[1].document.forms[0].cash_insmt_date2;\n\t\t    var cash_insmt_rmks2\t\t= parent.frames[1].document.forms[0].cash_insmt_rmks2;\n\t\t    var cust_4\t\t\t\t\t= parent.frames[1].document.forms[0].cust_4;\n\t\t    var credit_doc_ref3\t\t\t= parent.frames[1].document.forms[0].credit_doc_ref3;\n\t\t    var credit_doc_date3\t\t= parent.frames[1].document.forms[0].credit_doc_date3;\n\t\t    var setlmt_ind\t\t\t\t= parent.frames[1].document.forms[0].setlmt_ind;\n\t\t    var upd_fin_dtls\t\t\t= parent.frames[1].document.forms[0].upd_fin_dtls;\n\t\t    var credit_auth_ref\t\t\t= parent.frames[1].document.forms[0].credit_auth_ref;\n\t\t    var credit_auth_date\t\t= parent.frames[1].document.forms[0].credit_auth_date;\n\t\t    var app_days\t\t\t\t= parent.frames[1].document.forms[0].app_days;\n\t\t    var app_amount\t\t\t\t= parent.frames[1].document.forms[0].app_amount;\n\t\t    var eff_frm_date\t\t\t= parent.frames[1].document.forms[0].eff_frm_date;\n\t\t    var remarks\t\t\t\t\t= parent.frames[1].document.forms[0].remarks;\n\t\t    var billing_mode\t\t\t= parent.frames[1].document.forms[0].billing_mode;\n\n\t\t\t// Start of modifications for billing enhancement on 8th Jan 04 ---------------  \n\t\t\n\t\t\tvar cred_start_dt1   = \'\';\n\t\t\tvar cred_start_dt2   = \'\'; \n\t\t\tvar cred_start_dt3   = \'\'; \n\n\t\t\tif(parent.frames[1].document.forms[0].cred_start_dt1)\n\t\t\t{\n\t\t\t\tcred_start_dt1    = parent.frames[1].document.forms[0].cred_start_dt1;\n\t\t\t}\n\t\t\tif(cred_start_dt1.value==\'\')\n\t\t\t{\n\t\t\t\tif(parent.frames[1].document.forms[0].cred_start_date)\n\t\t\t\t{\n\t\t\t\tcred_start_dt1\t  = parent.frames[1].document.forms[0].cred_start_date;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(parent.frames[1].document.forms[0].cred_start_dt2)\n\t\t\t{\n\t\t\t\tcred_start_dt2    = parent.frames[1].document.forms[0].cred_start_dt2;\n\t\t\t}\n\t\t\tif(parent.frames[1].document.forms[0].cred_start_dt3)\n\t\t\t{\n\t\t\t\tcred_start_dt3    = parent.frames[1].document.forms[0].cred_start_dt3;\n\t\t\t}\n\n\t\t\t// end of modifications for billing enhancement on 8th Jan 04--------------- \n\n\t\t\tvar bl_data_from_repos_yn = \"N\";\n\t\t\tvar data_source_id = parent.frames[1].document.forms[0].change_data_source;\n\t\t\n\t\t\tif(data_source_id.value != \'\' && billing_group.value != \'\')\n\t\t\t{\n\t\t\t\tbl_data_from_repos_yn = \"Y\";\n\t\t\t}\n\t\t\n\t\t\tif(billing_group.value != \'\') billing_mode.value = \"Modify\";\n\t\t\t\n\t\t\tvar operation = parent.frames[1].document.forms[0].bl_operation.value;\n\t\t\t\n\t\t\tif(billing_mode.value==\"Modify\") operation=\"Update\";\n\t\t\t\n\t\t\tif(operation==\'Insert\')\n\t\t\t{\n\t\t\t\toperation=\'\';\n\t\t\t\tbilling_mode.value = \'\';\n\t\t\t}\n\t\t\n\t\t\tparent.frames[1].document.forms[0].bl_success.value = \"N\";\n\t\t\n\t\t\t//Added for Billing Enhancements\n\t\t\tvar health_card_expired_yn = parent.frames[1].document.forms[0].health_card_expired_yn;\n\t\t\tvar annual_income          = parent.frames[1].document.forms[0].annual_income;\n\t\t\tvar family_asset           = parent.frames[1].document.forms[0].family_asset;\n\t\t\tvar no_of_dependants       = parent.frames[1].document.forms[0].no_of_dependants;\n\t\t\tvar resp_for_payment       = parent.frames[1].document.forms[0].resp_for_payment;\n\t\t\tvar credit_doc_reqd_yn1    = parent.frames[1].document.forms[0].credit_doc_reqd_yn1;\n\t\t\tvar credit_doc_reqd_yn2    = parent.frames[1].document.forms[0].credit_doc_reqd_yn2;\n\t\t\tvar calling_module_id\t   = \"MP\";\n\t\t\tvar calling_function_id\t   = \"CHG_PAT_DTLS\";\n\n\t\t\t//end of Addition\n\t\t\n\t\t\tvar episode=\"\";\n\t\t\tvar record=\"\";\n\t\t\t\n\t\t\tvar qryStr = \"operation=\"+operation+\"&package_flag=\"+package_flag+\"&ins_auth_flag=\"+ins_auth_flag+\"&upd_pat_flag=\"+upd_pat_flag+\"&patient_id=\"+patient_id+\"&show_hide_blng_class=\"+show_hide_blng_class+\"&billing_mode=\"+billing_mode.value+\"&billing_group=\"+billing_group.value+\"&billing_class=\"+billing_class.value+\"&employer_code=\"+employer_code.value+\"&cash_set_type1=\"+cash_set_type1.value+\"&cash_insmt_ref1=\"+cash_insmt_ref1.value+\"&cash_insmt_date1=\"+cash_insmt_date1.value;\n\t\t\tqryStr += \"&cash_insmt_rmks1=\"+cash_insmt_rmks1.value+\"&cust_1=\"+cust_1.value+\"&credit_doc_ref1=\"+credit_doc_ref1.value+\"&credit_doc_date1=\"+credit_doc_date1.value+\"&cust_2=\"+cust_2.value;\n\t\t\tqryStr += \"&credit_doc_ref2=\"+credit_doc_ref2.value+\"&credit_doc_date2=\"+credit_doc_date2.value+\"&cust_3=\"+cust_3.value+\"&policy_type=\"+escape(policy_type.value);\n\t\t\tqryStr += \"&policy_no=\"+policy_no.value+\"&policy_expiry_date=\"+policy_expiry_date.value+\"&non_insur_blng_grp=\"+non_insur_blng_grp.value+\"&cash_set_type2=\"+cash_set_type2.value;\n\t\t\tqryStr += \"&calling_module_id=\"+calling_module_id+\"&calling_function_id=\"+calling_function_id;\n\t\t\tqryStr += \"&cash_insmt_ref2=\"+cash_insmt_ref2.value+\"&cash_insmt_date2=\"+cash_insmt_date2.value+\"&cash_insmt_rmks2=\"+cash_insmt_rmks2.value+\"&cust_4=\"+cust_4.value+\"&credit_doc_ref3=\"+credit_doc_ref3.value+\"&credit_doc_date3=\"+credit_doc_date3.value+\"&setlmt_ind=\"+setlmt_ind.value+\"&credit_auth_ref=\"+credit_auth_ref.value+\"&credit_auth_date=\"+credit_auth_date.value+\"&app_days=\"+app_days.value+\"&app_amount=\"+app_amount.value+\"&annual_income=\"+annual_income.value+\"&family_asset=\"+family_asset.value+\"&no_of_dependants=\"+no_of_dependants.value+\"&resp_for_payment=\"+resp_for_payment.value+\"&credit_doc_reqd_yn1=\"+credit_doc_reqd_yn1.value+\"&credit_doc_reqd_yn2=\"+credit_doc_reqd_yn2.value+\"&bl_data_from_repos_yn=\"+bl_data_from_repos_yn+\"&data_source_id=\"+data_source_id.value+\"&eff_frm_date=\"+eff_frm_date.value+\"&remarks=\"+remarks.value+\"&episode=\"+episode+\"&record=\"+record;\n\t\t\t\n\t\t\t// Start of modifications for billing enhancement on 8th Jan 04 --------------- \n\t\t\t\n\t\t\tif(cred_start_dt1.value != null)\n\t\t\t\tqryStr+=\"&credit_doc_start_date1=\"+cred_start_dt1.value;\n\t\t\tif(cred_start_dt2.value != null)\n\t\t\t\tqryStr+=\"&credit_doc_start_date2=\"+cred_start_dt2.value;\n\t\t\tif(cred_start_dt3.value != null)\n\t\t\t\tqryStr+=\"&credit_doc_start_date3=\"+cred_start_dt3.value;\n\t\t\t\n\t\t\tqryStr+=\"&gl_holder_name=\"+parent.frames[1].document.forms[0].gl_holder_name.value;\n\t\t\tqryStr+=\"&pat_reln_with_gl_holder=\"+parent.frames[1].document.forms[0].gl_holder_reln.value;\n\t\t\n\t\t\t//End of modifications for billing enhancement on 8th Jan 04 --------------- \n\t\t\n\t\t\tvar nationality_yn = \"N\";\n\t\t\tparent.frames[1].document.forms[0].dflt_nat_id_chk_val.value = parent.frames[1].document.forms[0].nationality_code.value;\n\t\t\t\n\t\t\tif(parent.frames[1].document.forms[0].nationality_code.value == \tparent.frames[1].document.forms[0].dflt_nationality_code.value)\n\t\t\t{\n\t\t\t\tnationality_yn = \"Y\";\n\t\t\t}\n\t\t\telse \n\t\t\t{\n\t\t\t\tnationality_yn = \"N\";\n\t\t\t}\n\t\t\n\t\t\tqryStr+=\"&nationality_yn=\"+nationality_yn;\n\t\t\tqryStr+=\"&patient_class=\'XT\'\";\n\t\t   var returnArray = new Array();\n\t  \n\t\t\treturnArray = getFinDtl(qryStr);\n\n\t\t\ttab_click(previousTab);\n\t\t\tif(returnArray.length>0)\n\t\t\t{\n\t\t\t\tbilling_group.value         = returnArray[0];\n\t\t\t\tbilling_class.value         = returnArray[1];\n\t\t\t\temployer_code.value         = returnArray[2];    \n\t\t\t\tcash_set_type1.value        = returnArray[3];\n\t\t\t\tcash_insmt_ref1.value       = returnArray[4];\n\t\t\t\tcash_insmt_date1.value      = returnArray[5];\n\t\t\t\tcash_insmt_rmks1.value      = returnArray[6];\n\t\t\t\tcust_1.value                = returnArray[7];\n\t\t\t\tcredit_doc_ref1.value       = returnArray[8];\n\t\t\t\tcredit_doc_date1.value      = returnArray[9];\n\t\t\t\tcust_2.value                = returnArray[10];\n\t\t\t\tcredit_doc_ref2.value       = returnArray[11];\n\t\t\t\tcredit_doc_date2.value      = returnArray[12];\n\t\t\t\tcust_3.value                = returnArray[13];\n\t\t\t\tpolicy_type.value           = returnArray[14];\n\t\t\t\tpolicy_no.value             = returnArray[15];\n\t\t\t\tpolicy_expiry_date.value    = returnArray[16];\n\t\t\t\tnon_insur_blng_grp.value    = returnArray[17];\n\t\t\t\tcash_set_type2.value        = returnArray[18];\n\t\t\t\tcash_insmt_ref2.value       = returnArray[19];\n\t\t\t\tcash_insmt_date2.value      = returnArray[20];\n\t\t\t\tcash_insmt_rmks2.value      = returnArray[21];\n\t\t\t\tcust_4.value                = returnArray[22];\n\t\t\t\tcredit_doc_ref3.value       = returnArray[23];\n\t\t\t\tcredit_doc_date3.value      = returnArray[24];\n\t\t\t\tsetlmt_ind.value            = returnArray[25];\n\t\t\t\tupd_fin_dtls.value          = returnArray[26];\n\t\t\t\tcredit_auth_ref.value       = returnArray[27];\n\t\t\t\tcredit_auth_date.value      = returnArray[28];\n\t\t\t\tapp_days.value              = returnArray[29];\n\t\t\t\tapp_amount.value            = returnArray[30];\n\t\t\t\tannual_income.value\t\t\t= returnArray[31];\n\t\t\t\tfamily_asset.value\t\t\t= returnArray[32];\n\t\t\t\tno_of_dependants.value\t\t= returnArray[33];\n\t\t\t\tresp_for_payment.value\t\t= returnArray[34];\n\t\t\t\tcredit_doc_reqd_yn1.value\t= returnArray[35];\n\t\t\t\tcredit_doc_reqd_yn2.value\t= returnArray[36];\n\t\t\t\teff_frm_date.value          = returnArray[37];\n\t\t\t\tremarks.value               = returnArray[38];\n\n\t\t\t\t// Start of modifications for billing enhancement on 8th Jan 04 --------------- \n\t\t\t\tcred_start_dt1.value = returnArray[40];\n\t\t\t\tcred_start_dt2.value = returnArray[41];\n\t\t\t\tcred_start_dt3.value = returnArray[42];\n\t\t\n\t\t\t\tparent.frames[1].document.forms[0].gl_holder_name.value = returnArray[43];\n\t\t\t\tparent.frames[1].document.forms[0].gl_holder_reln.value = returnArray[44];\n\n\t\t\t\t//End of modifications for billing enhancement on 8th Jan 04 --------------- \n\n\t";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="\t\t\tbilling_mode.value          = \"Modify\"\n\t\t\t\tparent.frames[1].document.forms[0].bl_success.value = \"Y\";\n\t\t\t}\n\t\t\telse return false;\n\t\t}*/\n\t</script>\n\n\n</head>\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onload=\"\">\n\t<table cellspacing=\'0\' cellpadding=\'0\' border=0 width=\'100%\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\'>\n\t\t\t<table name=\'patient_table\' id=\'patient_table\' width=\'100%\' border=\'0\'>\n\t\t\t    <tr>\n\t\t\t        <td class=\'label\' nowrap>";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 =" </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<td><input name=\'patient_name\' id=\'patient_name\' size=\'55\' maxlength=\'60\' disabled></td>\n\t\t\t\t    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n    <table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t<tr>\n\t<td width= \"100%\" class=\"white\">\n\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Demographic details\">\n\t\t\t\t<a onclick=\"invokeTab(\'demogrp_tab\')\" class=\"tabClicked\" id=\"demogrp_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"demogrp_tabspan\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t<a onclick=\"invokeTab(\'cmodeaddr_tab\')\" class=\"tabA\" id=\"cmodeaddr_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"cmodeaddr_tabspan\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t\n\t\t\t<li class=\"tablistitem\" title=\"Related Contact details\">\n\t\t\t\t<a onclick=\"invokeTab(\'rlcnts_tab\')\" class=\"tabA\" id=\"rlcnts_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"rlcnts_tabspan\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t\t<li class=\"tablistitem\" title=\"Patient Documents and Other details\">\n\t\t\t\t<a onclick=\"invokeTab(\'pat_docs_tab\')\" class=\"tabA\" id=\"pat_docs_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"pat_docs_tabspan\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" & ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\n\t\t    ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<li class=\"tablistitem\" title=\"Parent details\">\n\t\t\t\t<a onclick=\"invokeTab(\'parent_dtls\')\" class=\"tabA\" id=\"parent_dtls\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"parent_dtlsspan\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n            ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<li class=\"tablistitem\" title=\"Entered By\">\n\t\t\t\t<a onclick=\"invokeTab(\'add_mod_dtl\')\" class=\"tabA\" id=\"add_mod_dtl\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"add_mod_dtlspan\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n            ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<li class=\"tablistitem\" title=\"Who Done It\">\n\t\t\t\t<a onclick=\"invokeTab(\'add_mod_dtl\')\" class=\"tabA\" id=\"add_mod_dtl\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"add_mod_dtlspan\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Financial details\">\n\t\t\t\t<a onclick=\"invokeTab(\'findtl_tab\')\" class=\"tabA\" id=\"findtl_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"findtl_tabspan\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t\t</ul>\n\t<!-- The below line is required to change the select state of Demograph tab initially selected -->\n\t<script>prevTabObj=\'demogrp_tab\'</script>\n\n\t</td></tr></table>\n\t<input type=\'hidden\' name=\'language_direction\' id=\'language_direction\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con				= null;
	java.sql.Statement stmt		= null;
	java.sql.PreparedStatement pstmt = null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
    Boolean enteredByAppl = false;	// Added by shagar for ML-MMOH-CRF-1328
	con = ConnectionManager.getConnection(request);
	enteredByAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "ENTERED_BY"); // Added by shagar for ML-MMOH-CRF-1328
	String pat_name_as_multipart_yn = "";
	String names_in_oth_lang_yn		= "";
	String sql						= "";

	String patient		= request.getParameter("patient_id");
    String function_id	= request.getParameter("function_id") ;
	if(patient == null || patient.equals("null")) patient = "";
    if(function_id == null) function_id = "";

	String language_direction="";
	int count=0;
    
	try
	{

			/*---Starts----Following Code is to Check the Module with Billing Interface */
		String bl_install_yn=(String)session.getValue("mp_bl_oper_yn");    
		/*---Ends----Added on: 19-Jan-2002 by Prakash.S */

		stmt	= con.createStatement();
		sql	= "SELECT  patient_id_length,pat_name_as_multipart_yn, names_in_oth_lang_yn,(select count(*)  from sm_language where language_direction='R' and eff_status='E') total FROM mp_param";
		rs		= stmt.executeQuery(sql);
		rs.next();
		pat_name_as_multipart_yn = rs.getString(2);
		names_in_oth_lang_yn = rs.getString(3);
		count = rs.getInt("total");
		if(pstmt != null) pstmt.close();
		if(rs1 != null) rs1.close();	

		if ( count==1 ) {
			 language_direction = "R" ;
		}else{
			 language_direction = "L" ;
		}

	
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		            out.println("<td><input name='patient_id' id='patient_id' size=18  maxlength='"+ rs.getString(1) +"' disabled value=\""+request.getParameter("patient_id")+"\"><img src='../../eCommon/images/mandatory.gif'></img></td>");
					
            _bw.write(_wl_block11Bytes, _wl_block11);

						if(names_in_oth_lang_yn.equals("Y"))						
				        {
						    out.println( "<td><input name='patient_name_loc_lang' id='patient_name_loc_lang' size='55' maxlength='60' disabled");
							
							if(language_direction.equals("R"))
							{
							out.println("dir='RTL'" ) ;
							}
							
							out.println(" ></td>" ) ;
							out.println("<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value='' > ");						
		                }
						else
						{
							if(pat_name_as_multipart_yn.equals("N"))
							out.println("<script>document.getElementById('patient_name').size='60';</script>");
						}
					
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

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if(function_id.equals ("NEWBORN_REG"))
			{
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
if(enteredByAppl){ // Added by shagar for ML-MMOH-CRF-1328 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}else {
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block29Bytes, _wl_block29);

	if(rs != null) rs.close(); 
	if(stmt != null) stmt.close(); 
}
catch(Exception e)
{
    //out.println("Exception in main Catch"+e.getMessage());
	e.printStackTrace();
}
finally
{
    ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.demographicdetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactAddresses.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedcontacts.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documents.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.parentdetails.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EnteredBy.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.whodoneit.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
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
}
