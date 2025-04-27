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

public final class __addmodifypatfindetailsmultiblnggrpbutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsMultiBlngGrpButton.jsp", 1743663743446L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\n<head>\n\n<script>\nvar totalRecords=0;\nvar formObj=\"\";\nvar total_records=\"\";\nvar checked_row=\"\";\nvar blng_grp_code=\"\";\nvar blng_grp_desc=\"\";\nvar payer_desc=\"\";\nvar cust_3=\"\";\nvar priority=\"\";\nvar policy_type_desc=\"\";\nvar policy_type_code=\"\";\nvar policy_no=\"\";\nvar policy_start_date=\"\";\nvar policy_exp_date=\"\";\nvar credit_auth_ref=\"\";\nvar credit_auth_date=\"\";\nvar credit_apprd_amt=\"\";\nvar credit_apprd_days=\"\";\nvar policy_eff_frm_date=\"\";\nvar policy_eff_to_date=\"\";\t\nvar adj_rule_ind=\"\";;\nvar adj_perc_amt_ind=\"\";\nvar adj_perc_amt_value=\"\";\nvar pmnt_diff_adj_int=\"\";\nvar drg_pmnt_diff_adj_int=\"\";\nvar spl_srv_pmnt_diff_adj_int=\"\";\nvar restrict_check=\"\",apprd_amt_restrict_check=\"\",apprd_days_restrict_check=\"\";\nvar cred_auth_req_yn = \"\", dflt_auth_ref_as_pol_no_yn=\"\", cred_auth_mand_capt_yn=\"\";\nvar valid_payer_YN=\"\";\nvar valid_policy_type_code_YN=\"\";\nvar cust_group_code=\"\";\nvar cust_group_name = \"\";\nvar policy_coverage_basis_ind=\"\";\nvar cust_valid_from_date = \"\";\nvar cust_valid_to_date = \"\";\nvar pol_validity_chk_date=\"\";\n\nvar v_display_hide=\"\",v_display_hide_apprvd_amt=\"\",v_display_hide_apprvd_days=\"\";\nvar v_display_hide_cred_auth=\"\";\n\nvar mcn_for_policy=\"\"; //V232504\nvar reg_ref_id=\"\"; //V232504\n\n //Added by prithivi on 13/03/2017 for mms-qh-crf-0085 bupa insurance patient eligibility check\n\tvar payerEligibilityParam=\"\";\n\tvar responseCode=\"\";\n\tvar responseCodeDesc=\"\";\n\tvar statuDescription=\"\";\n\tvar validityPeriod=\"\";\n\tvar validityPeriodDesc=\"\";\n\tvar eligibilityCode=\"\";\n\tvar transactionId=\"\";\n\tvar responseDateTime=\"\";\n //above variables were added by prithivi on 13/03/2017 for mms-qh-crf-0085 bupa insurance patient eligibility check\n\nasync function addPayer()\n{\n\tvar package_enabled_yn = document.forms[0].package_enabled_yn.value;\t\n\n\tvar locale=document.forms[0].locale.value;\n\tvar retVal\t\t\t= new String();\n\n\tformObj = parent.frames[1].document.forms[0];\n\ttotal_records=formObj.total_records.value;\n\n\tvar encounter_date_time = document.forms[0].encounter_date_time.value;\n\n\tvar priority=\"\";\n\n\tvar max_priority=document.forms[0].max_priority.value;\n\n\tvar priority_arr=new Array();\n\n\tif(parseInt(total_records) != 0)\n\t{\n\t\tvar priority_var=\"\";\n\t\tfor(var i=0;i<total_records;i++)\n\t\t{\n\t\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+i);\n\t\t\tpriority_var=priority1.value;\n\t\t\t\n\t\t\tpriority_arr[i]=priority_var;\n\t\t}\n\t}\n\t\n\tvar priority=\"\";\n\tif(parseInt(total_records)==0)\n\t{\n\t\tpriority=parseInt(max_priority)+1;\n\t}\n\n\t/* var dialogTop\t\t\t= \"220\";\n//\tvar dialogHeight\t\t= \"22\" ;\n//\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar dialogHeight\t\t= \"25\" ;\n\tvar dialogWidth\t\t\t= \"55\" ; */\n\t\n\tvar dialogTop\t\t\t= \"5vh\";\n\tvar dialogHeight\t\t= \"92vh\" ;\n\tvar dialogWidth\t\t\t= \"90vw\" ; \n\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar title=getLabel(\"eBL.ADD_PAYER.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n//\tvar column_sizes = escape(\"10%,30%,60%\");\n//\tvar column_descriptions=\"\";\n\tvar calling_module_id = document.forms[0].calling_module_id.value;\t\n\tvar getString=document.forms[0].queryString.value;\n\tvar p_patient_class=document.forms[0].p_patient_class.value;\n\tvar billing_group=document.forms[0].billing_group.value;\n\n\tvar fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;\n\tvar autoFinChk = document.forms[0].autoFinChk.value;\n\tvar class_code = document.forms[0].class_code.value;\n\n\tformObj = parent.frames[1].document.forms[0];\n\ttotalRecords =eval(formObj.total_records.value);\n\n\tfor(var j=0;j<totalRecords;j++)\n\t{\n\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\ttemp.checked=false;\n\t}\n\n\tvar policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;\n\n\t//Commented by DhanasekarV against incident AAKH-SCF-0028   38536\ton 1/4/2014\n\n\t\n/*\tif(policy_coverage_basis_gbl_ind==\"P\")\n\t{\n\t\tif(totalRecords==1)\n\t\t{\n\t\t\talert(getMessage(\"BL9727\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t}\n\t*/\n\n\t//END\n\t\n\tparent.frames[1].document.forms[0].target = \"InsValidationFrame\";\n\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=add&locn=inside\";\n\tparent.frames[1].document.forms[0].submit();\n\n\tparent.frames[1].document.forms[0].target = \"\";\n\n\tvar param =\"&title=\"+title+\"&action=add&locn=inside\"+\"&patient_class=\"+p_patient_class+\"&billing_group=\"+billing_group+\"&calling_module_id=\"+calling_module_id+\"&policy_coverage_basis_gbl_ind=\"+policy_coverage_basis_gbl_ind+\"&totalRecords=\"+totalRecords+\"&priority_arr=\"+priority_arr+\"&priority=\"+priority+\"&max_priority=\"+max_priority+\"&encounter_date_time=\"+encounter_date_time+\"&fin_class_flag_YN=\"+fin_class_flag_YN+\"&autoFinChk=\"+autoFinChk+\"&class_code=\"+class_code+\"&package_enabled_yn=\"+package_enabled_yn;\n\t\n\tretVal=await parent.window.showModalDialog(\"../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?\"+param,arguments,features);\n\n\tvar count=0;\n\tvar classval=\"\";\n\tvar\tbilling_grp=\"\";\n\tif(retVal!=null)\n\t{\n\t\tformObj = parent.frames[1].document.forms[0];\n\t\ttotalRecords =eval(formObj.total_records.value);\n\t\tcount =totalRecords + 1; \n\t\tbilling_grp=document.forms[0].billing_group.value;\n\t\tvar arr=new Array();\n\t\tif(retVal == null) retVal=\'\';\n\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\t\t\t  \n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\t\tblng_grp_desc=decodeURIComponent(arr[0]);\n\t\t\t\tblng_grp_code=decodeURIComponent(arr[1]);\n\t\t\t\tpayer_desc=decodeURIComponent(arr[2]);\n\t\t\t\tcust_3=decodeURIComponent(arr[3]);\n\t\t\t\tpriority=arr[4];\n\t\t\t\tpolicy_type_desc=decodeURIComponent(arr[5]);\n\t\t\t\tpolicy_type_code=decodeURIComponent(arr[6]);\n\t\t\t\tpolicy_no=decodeURIComponent(arr[7]);\n\t\t\t\tpolicy_start_date=arr[8];\n\t\t\t\tpolicy_exp_date=arr[9];\n\t\t\t\tcredit_auth_ref=decodeURIComponent(arr[10]);\n\t\t\t\tif(credit_auth_ref == null || credit_auth_ref==\" \") credit_auth_ref=\"\";\n\t\t\t\tcredit_auth_date=arr[11];\n\t\t\t\tif(credit_auth_date == null || credit_auth_date==\" \") credit_auth_date=\"\";\n\t\t\t\tcred_auth_req_yn = arr[33];\n\t\t\t\tcred_auth_mand_capt_yn = arr[40];\n\t\t\t\tdflt_auth_ref_as_pol_no_yn=arr[34];\n\n\t\t\t\tvar temp_credit_apprd_amt=arr[12];\n\t\t\t\tif(temp_credit_apprd_amt==\" \") temp_credit_apprd_amt=\"\";\n\t\t\t\tcredit_apprd_amt=temp_credit_apprd_amt;\n\t\t\t\t\n\t\t\t\tvar temp_credit_apprd_days=arr[13];\n\t\t\t\tif(temp_credit_apprd_days==\" \") temp_credit_apprd_days=\"\";\n\t\t\t\tcredit_apprd_days=temp_credit_apprd_days;\n\t\t\t\t\n\t\t\t\tpolicy_eff_frm_date=arr[14];\n\t\t\t\t\n\t\t\t\tvar temp_policy_eff_to_date=arr[15];\n\t\t\t\tif(temp_policy_eff_to_date==\" \") temp_policy_eff_to_date=\"\";\n\t\t\t\tpolicy_eff_to_date=temp_policy_eff_to_date;\n\t\t\t\t\n\t\t\t\tadj_rule_ind=decodeURIComponent(arr[16]);\n\t\t\t\tadj_perc_amt_ind=decodeURIComponent(arr[17]);\n\t\t\t\tadj_perc_amt_value=decodeURIComponent(arr[18]);\n\t\t\t\tpmnt_diff_adj_int=decodeURIComponent(arr[19]);\n\t\t\t\tdrg_pmnt_diff_adj_int=decodeURIComponent(arr[20]);\n\t\t\t\tspl_srv_pmnt_diff_adj_int=decodeURIComponent(arr[21]);\n\t\t\t\trestrict_check=arr[22];\n\t\t\t\tapprd_amt_restrict_check=arr[31];\n\t\t\t\tapprd_days_restrict_check=arr[32];\n\t\t\t\tvalid_payer_YN=arr[23];\n\t\t\t\tvalid_policy_type_code_YN=arr[24];\n\t\t\t\tcust_group_code=decodeURIComponent(arr[25]);\n\t\t\t\tcust_group_name=decodeURIComponent(arr[37]);\n\t\t\t\tpolicy_coverage_basis_ind=arr[26];\n\n\t\t\t\tcust_valid_from_date = arr[35];\n\t\t\t\tcust_valid_to_date = arr[36];\n\n\t\t\t\tpol_validity_chk_date = arr[38];\n\n\t\t\t\tpayerEligibilityParam= decodeURIComponent(arr[41]);\n\t\t\t\tresponseCode= decodeURIComponent(arr[42]);\n\t\t\t\tresponseCodeDesc= decodeURIComponent(arr[43]);\n\t\t\t\tstatuDescription= decodeURIComponent(arr[44]);\n\t\t\t\tvalidityPeriod= decodeURIComponent(arr[45]);\n\t\t\t\tvalidityPeriodDesc= decodeURIComponent(arr[46]);\n\t\t\t\teligibilityCode= decodeURIComponent(arr[47]);\n\t\t\t\ttransactionId= decodeURIComponent(arr[48]);\n\t\t\t\tresponseDateTime= decodeURIComponent(arr[49]);\n\t\t\t\t\n\t\t\t\tmcn_for_policy=decodeURIComponent(arr[51]);     //V232504\n\t\t\t\treg_ref_id=decodeURIComponent(arr[52]);     //V232504\n\t\t\t\t\n\n\t\t\t\tif(locale!=\"en\")\n\t\t\t\t{\n\t\t\t\t\tif(policy_start_date!=\"\")\n\t\t\t\t\t\tpolicy_start_date=convertDate(policy_start_date,\"DMY\",\"en\",locale);\n\n\t\t\t\t\tif(policy_exp_date!=\"\")\n\t\t\t\t\t\tpolicy_exp_date=convertDate(policy_exp_date,\"DMY\",\"en\",locale);\n\t\t\t\t\t\n\t\t\t\t\tif(credit_auth_date!=\"\")\n\t\t\t\t\t\tcredit_auth_date=convertDate(credit_auth_date,\"DMY\",\"en\",locale);\n\t\t\t\t\t\n\t\t\t\t\tif(policy_eff_frm_date!=\"\")\n\t\t\t\t\t\tpolicy_eff_frm_date=convertDate(policy_eff_frm_date,\"DMY\",\"en\",locale);\n\t\t\t\t\t\n\t\t\t\t\tif(policy_eff_to_date!=\"\")\n\t\t\t\t\t\tpolicy_eff_to_date=convertDate(policy_eff_to_date,\"DMY\",\"en\",locale);\n\n\t\t\t\t\tif(pol_validity_chk_date!=\"\")\n\t\t\t\t\t\tpol_validity_chk_date=convertDate(pol_validity_chk_date,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tif(restrict_check==\"U\")\n\t\t{\n\t\t\tv_display_hide=\"display:none\";\n\t\t\tv_display_hide_apprvd_amt = \"display:none\";\n\t\t\tv_display_hide_apprvd_days = \"display:none\";\n\t\t}\n\t\telse if (restrict_check==\"R\")\n\t\t{\n\t\t\tif(apprd_amt_restrict_check == \"R\")\n\t\t\t{\n\t\t\t\tv_display_hide_apprvd_amt = \"display:inline\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tv_display_hide_apprvd_amt = \"display:none\";\n\t\t\t}\n\n\t\t\tif(apprd_days_restrict_check == \"R\")\n\t\t\t{\n\t\t\t\tv_display_hide_apprvd_days = \"display:inline\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tv_display_hide_apprvd_days = \"display:none\";\n\t\t\t}\n\t\t}\n\n\t\tif(cred_auth_req_yn == \"Y\")\n\t\t{\n\t\t\tv_display_hide_cred_auth = \"display:inline\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tv_display_hide_cred_auth = \"display:none\";\n\t\t}\n\n\t\tvar record_select=count;\n\t\tfor (var j=totalRecords;j<count;j++ )\n\t\t{\n//\t\t\tif(j!=0)\n//\t\t\t\tblng_grp_desc=\"\";\n\t\t\t\n\t\t\tif(j % 2 == 0 )\n\t\t\t{\n\t\t\t\tclassval\t=\t\"QRYEVEN\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tclassval\t=\t\"QRYODD\";\n\t\t\t}\n\n\t\t\tcurr_row\t=\tformObj.ins_data.insertRow();\n\t\t\tcurr_row.id= \"row\"+eval(totalRecords+1);\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[0].className\t= classval;\n\t\t\tcurr_row.cells[0].WIDTH\t= \"14%\";\n//\t\t\tcurr_row.cells(0).insertAdjacentHTML(\"BeforeEnd\", \"<input type=hidden name=\'blng_grp_code\"+j+\"\' id=\'blng_grp_code\"+j+\"\' value=\'\"+billing_grp+\"\'><a onClick=\'modify_remove_payer(\"+j+\");\'><u>\"+record_select+\"</u></a>\");\n\t\t\tcurr_row.cells[0].insertAdjacentHTML(\"beforeend\", \"<input type=hidden name=\'blng_grp_code\"+j+\"\' id=\'blng_grp_code\"+j+\"\' value=\\\"\"+blng_grp_code+\"\\\"><input type=hidden name=\'billing_group_desc\"+j+\"\' id=\'billing_group_desc\"+j+\"\' value=\\\"\"+blng_grp_desc+\"\\\"><input type=\'checkbox\' name=\'selected_row\"+j+\"\' id=\'selected_row\"+j+\"\' value=\'\"+j+\"\' onClick=\'selected(\"+j+\")\'>&nbsp;&nbsp;<input maxlength=\'15\' size=\'13\' type=text name=\'ins_cust_group_name\"+j+\"\' id=\'ins_cust_group_name\"+j+\"\'  value=\\\"\"+cust_group_name+\"\\\" onFocus=\'check(\"+j+\");\' readonly>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[1].className\t= classval;\n\t\t\tcurr_row.cells[1].WIDTH\t= \"12%\";\n\t\t\tcurr_row.cells[1].insertAdjacentHTML(\"beforeend\", \"<input maxlength=\'15\' size=\'13\' type=text name=\'payer_desc\"+j+\"";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="\' id=\'payer_desc\"+j+\"\'  value=\\\"\"+payer_desc+\"\\\" onFocus=\'check(\"+j+\");\' readonly><input type=hidden name=\'cust_3\"+j+\"\' id=\'cust_3\"+j+\"\' value=\\\"\"+cust_3+\"\\\"><input type=hidden name=\'ins_cust_group_code\"+j+\"\' id=\'ins_cust_group_code\"+j+\"\' value=\\\"\"+cust_group_code+\"\\\"><input type=hidden name=\'valid_payer_YN\"+j+\"\' id=\'valid_payer_YN\"+j+\"\' value=\\\"\"+valid_payer_YN+\"\\\"><input type=hidden name=\'cust_valid_from_date\"+j+\"\' id=\'cust_valid_from_date\"+j+\"\' value=\\\"\"+cust_valid_from_date+\"\\\"><input type=hidden name=\'cust_valid_to_date\"+j+\"\' id=\'cust_valid_to_date\"+j+\"\' value=\\\"\"+cust_valid_to_date+\"\\\">\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[2].className\t=classval;\n\t\t\tcurr_row.cells[2].WIDTH\t= \"7%\";\n\t\t\tcurr_row.cells[2].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'2\' size=\'3\' name=\'priority\"+j+\"\' id=\'priority\"+j+\"\' style=\'text-align:right\'  value=\'\"+priority+\"\' onFocus=\'check(\"+j+\");\' readonly>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[3].className\t=classval;\n\t\t\tcurr_row.cells[3].WIDTH\t= \"12%\";\n\t\t\tcurr_row.cells[3].insertAdjacentHTML(\"beforeend\", \"<input maxlength=\'15\' size=\'13\' type=text name=\'policy_type_desc\"+j+\"\' id=\'policy_type_desc\"+j+\"\'  value=\\\"\"+policy_type_desc+\"\\\" onFocus=\'check(\"+j+\");\' readonly><input type=hidden name=\'policy_type_code\"+j+\"\' id=\'policy_type_code\"+j+\"\' value=\\\"\"+policy_type_code+\"\\\"><input type=hidden name=\'valid_policy_type_code_YN\"+j+\"\' id=\'valid_policy_type_code_YN\"+j+\"\' value=\\\"\"+valid_policy_type_code_YN+\"\\\">\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[4].className\t= classval;\n\t\t\tcurr_row.cells[4].WIDTH\t= \"12%\";\n\t\t\tcurr_row.cells[4].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'30\' size=\'13\' name=\'policy_no\"+j+\"\' id=\'policy_no\"+j+\"\' \tstyle=\'text-align:right\'  value=\\\"\"+policy_no+\"\\\" onFocus=\'check(\"+j+\");\' readonly>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[5].className\t= classval;\n\t\t\tcurr_row.cells[5].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[5].insertAdjacentHTML(\"beforeend\",\"<input type=\'text\'  name=\'policy_start_date\"+j+\"\' id=\'policy_start_date\"+j+\"\' size=\'10\' maxlength=\'10\' value=\'\"+policy_start_date+\"\'  onFocus=\'check(\"+j+\");\' readonly>\");\n\t\t\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[6].className\t= classval;\n\t\t\tcurr_row.cells[6].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[6].insertAdjacentHTML(\"beforeend\",\"<input type=\'text\'  name=\'policy_exp_date\"+j+\"\' id=\'policy_exp_date\"+j+\"\' size=\'10\' maxlength=\'10\' \tvalue=\'\"+policy_exp_date+\"\'  onFocus=\'check(\"+j+\");\' readonly>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[7].className\t= classval;\n\t\t\tcurr_row.cells[7].WIDTH\t= \"12%\";\n\t\t\tcurr_row.cells[7].insertAdjacentHTML(\"beforeend\", \"<div id=\'credit_auth_val_disp\"+j+\"\' style=\"+v_display_hide_cred_auth+\" ><input type=\'text\' maxlength=\'20\' size=\'13\' name=\'credit_auth_ref\"+j+\"\' id=\'credit_auth_ref\"+j+\"\' style=\'text-align:right\'  value=\\\"\"+credit_auth_ref+\"\\\" onFocus=\'check(\"+j+\");\' readonly></div>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[8].className\t= classval;\n\t\t\tcurr_row.cells[8].WIDTH\t= \"11%\";\n\t\t\tcurr_row.cells[8].insertAdjacentHTML(\"beforeend\",\"<div id=\'credit_auth_date_val_disp\"+j+\"\' style=\"+v_display_hide_cred_auth+\" ><input type=\'text\'  name=\'credit_auth_date\"+j+\"\' id=\'credit_auth_date\"+j+\"\' size=\'10\' maxlength=\'10\' value=\'\"+credit_auth_date+\"\'  onFocus=\'check(\"+j+\");\' readonly></div>\");\n\n\t\t\tcurr_row\t=\tformObj.ins_data.insertRow();\n\t\t\tcurr_row.id= \"row\"+eval(totalRecords+1);\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[0].className\t= classval;\n\t\t\tcurr_row.cells[0].WIDTH\t= \"14%\";\n\t\t\tcurr_row.cells[0].insertAdjacentHTML(\"beforeend\", \"<b id=\'policy_coverage_basis_\"+j+\"\'></b>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[1].className\t= classval;\n\t\t\tcurr_row.cells[1].WIDTH\t= \"12%\";\n\t\t\tcurr_row.cells[1].insertAdjacentHTML(\"beforeend\", \"<div id=\'apprd_amt_leg_disp\"+j+\"\' style=\"+v_display_hide_apprvd_amt+\" >";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="</div>\");\n\t\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[2].className\t= classval;\n\t\t\tcurr_row.cells[2].WIDTH\t= \"7%\";\n\t\t\tcurr_row.cells[2].insertAdjacentHTML(\"beforeend\", \"<div id=\'apprd_amt_val_disp\"+j+\"\' style=\"+v_display_hide_apprvd_amt+\" ><input type=\'text\' maxlength=\'10\' size=\'7\' name=\'credit_apprd_amt\"+j+\"\' id=\'credit_apprd_amt\"+j+\"\' style=\'text-align:right\'  value=\'\"+credit_apprd_amt+\"\' onFocus=\'check(\"+j+\");\' readonly></div>\");\n\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[3].className\t= classval;\n\t\t\tcurr_row.cells[3].WIDTH\t= \"12%\";\n\t\t\tcurr_row.cells[3].insertAdjacentHTML(\"beforeend\", \"<div id=\'apprd_days_leg_disp\"+j+\"\' style=\"+v_display_hide_apprvd_days+\" >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</div>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[4].className\t= classval;\n\t\t\tcurr_row.cells[4].WIDTH\t= \"12%\";\n\t\t\tcurr_row.cells[4].insertAdjacentHTML(\"beforeend\", \"<div id=\'apprd_days_val_disp\"+j+\"\' style=\"+v_display_hide_apprvd_days+\" ><input type=\'text\' maxlength=\'4\' size=\'4\' name=\'credit_apprd_days\"+j+\"\' id=\'credit_apprd_days\"+j+\"\' style=\'text-align:right\'  value=\'\"+credit_apprd_days+\"\' onFocus=\'check(\"+j+\");\' readonly></div>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[5].className\t= classval;\n\t\t\tcurr_row.cells[5].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[5].insertAdjacentHTML(\"beforeend\", \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[6].className\t= classval;\n\t\t\tcurr_row.cells[6].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[6].insertAdjacentHTML(\"beforeend\",\"<input type=\'text\'  name=\'policy_eff_frm_date\"+j+\"\' id=\'policy_eff_frm_date\"+j+\"\' size=\'10\' maxlength=\'10\' value=\'\"+policy_eff_frm_date+\"\'  onFocus=\'check(\"+j+\");\' readonly>\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[7].className\t= classval;\n\t\t\tcurr_row.cells[7].WIDTH\t= \"12%\";\n\t\t\tcurr_row.cells[7].insertAdjacentHTML(\"beforeend\", \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10_0 ="\");\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[8].className\t= classval;\n\t\t\tcurr_row.cells[8].WIDTH\t= \"11%\";\n\t\t\tcurr_row.cells[8].insertAdjacentHTML(\"beforeend\",\"<input type=\'text\'  name=\'policy_eff_to_date\"+j+\"\' id=\'policy_eff_to_date\"+j+\"\' size=\'10\' maxlength=\'10\' value=\'\"+policy_eff_to_date+\"\' onFocus=\'check(\"+j+\");\' readonly><input type=hidden name=\'adj_rule_ind\"+j+\"\' id=\'adj_rule_ind\"+j+\"\' value=\\\"\"+adj_rule_ind+\"\\\"><input type=hidden name=\'adj_perc_amt_ind\"+j+\"\' id=\'adj_perc_amt_ind\"+j+\"\' value=\\\"\"+adj_perc_amt_ind+\"\\\"><input type=hidden name=\'adj_perc_amt_value\"+j+\"\' id=\'adj_perc_amt_value\"+j+\"\' value=\\\"\"+adj_perc_amt_value+\"\\\"><input type=hidden name=\'pmnt_diff_adj_int\"+j+\"\' id=\'pmnt_diff_adj_int\"+j+\"\' value=\\\"\"+pmnt_diff_adj_int+\"\\\"><input type=hidden name=\'drg_pmnt_diff_adj_int\"+j+\"\' id=\'drg_pmnt_diff_adj_int\"+j+\"\' value=\\\"\"+drg_pmnt_diff_adj_int+\"\\\"><input type=hidden name=\'spl_srv_pmnt_diff_adj_int\"+j+\"\' id=\'spl_srv_pmnt_diff_adj_int\"+j+\"\' value=\\\"\"+spl_srv_pmnt_diff_adj_int+\"\\\"><input type=hidden name=\'restrict_check\"+j+\"\' id=\'restrict_check\"+j+\"\' value=\\\"\"+restrict_check+\"\\\"><input type=hidden name=\'apprd_amt_restrict_check\"+j+\"\' id=\'apprd_amt_restrict_check\"+j+\"\' value=\\\"\"+apprd_amt_restrict_check+\"\\\"><input type=hidden name=\'apprd_days_restrict_check\"+j+\"\' id=\'apprd_days_restrict_check\"+j+\"\' value=\\\"\"+apprd_days_restrict_check+\"\\\"><input type=hidden name=\'policy_coverage_basis_ind\"+j+\"\' id=\'policy_coverage_basis_ind\"+j+\"\' value=\'\"+policy_coverage_basis_ind+\"\'><input type=hidden name=\'cred_auth_req_yn\"+j+\"\' id=\'cred_auth_req_yn\"+j+\"\' value=\'\"+cred_auth_req_yn+\"\'><input type=hidden name=\'cred_auth_mand_capt_yn\"+j+\"\' id=\'cred_auth_mand_capt_yn\"+j+\"\' value=\'\"+cred_auth_mand_capt_yn+\"\'><input type=hidden name=\'dflt_auth_ref_as_pol_no_yn\"+j+\"\' id=\'dflt_auth_ref_as_pol_no_yn\"+j+\"\' value=\'\"+dflt_auth_ref_as_pol_no_yn+\"\'><input type=hidden name=\'pol_validity_chk_date\"+j+\"\' id=\'pol_validity_chk_date\"+j+\"\' value=\'\"+pol_validity_chk_date+\"\'><input type=hidden name=\'rec_edited_YN\"+j+\"\' id=\'rec_edited_YN\"+j+\"\' value=\'Y\'><input type=hidden name=\'payer_suspended_YN\"+j+\"\' id=\'payer_suspended_YN\"+j+\"\' value=\'N\'><input type=hidden name=\'policy_suspended_YN\"+j+\"\' id=\'policy_suspended_YN\"+j+\"\' value=\'N\'>\");\n\n\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[9].className\t= classval;\n\t\t\tcurr_row.cells[9].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[9].insertAdjacentHTML(\"beforeend\",\"<input type=hidden name=\'payerEligibilityParam\"+j+\"\' id=\'payerEligibilityParam\"+j+\"\' value=\\\"\"+payerEligibilityParam+\"\\\"> <input type=hidden name=\'responseCode\"+j+\"\' id=\'responseCode\"+j+\"\' value=\\\"\"+responseCode+\"\\\"> <input type=hidden name=\'responseCodeDesc\"+j+\"\' id=\'responseCodeDesc\"+j+\"\' value=\\\"\"+responseCodeDesc+\"\\\"> <input type=hidden name=\'statuDescription\"+j+\"\' id=\'statuDescription\"+j+\"\' value=\\\"\"+statuDescription+\"\\\"> <input type=hidden name=\'validityPeriod\"+j+\"\' id=\'validityPeriod\"+j+\"\' value=\\\"\"+validityPeriod+\"\\\"> <input type=hidden name=\'validityPeriodDesc\"+j+\"\' id=\'validityPeriodDesc\"+j+\"\' value=\\\"\"+validityPeriodDesc+\"\\\"> <input type=hidden name=\'eligibilityCode\"+j+\"\' id=\'eligibilityCode\"+j+\"\' value=\\\"\"+eligibilityCode+\"\\\"> <input type=hidden name=\'transactionId\"+j+\"\' id=\'transactionId\"+j+\"\' value=\\\"\"+transactionId+\"\\\"> <input type=hidden name=\'responseDateTime\"+j+\"\' id=\'responseDateTime\"+j+\"\' value=\\\"\"+responseDateTime+\"\\\"> <input type=hidden name=\'mcn_for_policy\"+j+\"\' id=\'mcn_for_policy\"+j+\"\' value=\\\"\"+mcn_for_policy+\"\\\"> <input type=hidden name=\'reg_ref_id\"+j+\"\' id=\'reg_ref_id\"+j+\"\' value=\\\"\"+reg_ref_id+\"\\\">\"); //V232504\n\n\t\trecord_select++;\n\t\tv_display_hide=\"\";\n\t\tv_display_hide_apprvd_amt=\"\";\n\t\tv_display_hide_apprvd_days=\"\";\n//\t\tvar temp=eval(\'parent.frames[1].document.forms[0].ins_cust_group_name\'+j);\n//\t\tvar temp1=eval(\'parent.frames[1].document.forms[0].ins_cust_group_code\'+j);\n//\t\talert(temp.value);\n//\t\talert(temp1.value);\n\t\t}\n\t\tformObj.total_records.value=count;\n\t\tif(formObj.total_records.value==1)\n\t\t{\n\t\t\tparent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value=policy_coverage_basis_ind;\n\t\t}\n\t\tparent.frames[1].policy_coverage_basis_ind();\n\n//\t\talert(\"total records:\"+formObj.total_records.value);\n\t}\n\telse\n\t{\n//\t\talert(\"closed\");\n\t}\n}\n\nasync function modifyPayer()\n{\n\tvar package_enabled_yn = document.forms[0].package_enabled_yn.value;\t\n\tformObj = parent.frames[1].document.forms[0];\n\ttotal_records=formObj.total_records.value;\n\n\tvar policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;\n\n\tvar encounter_date_time = document.forms[0].encounter_date_time.value;\n\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\n\tvar max_priority=document.forms[0].max_priority.value;\n\n\tvar priority_arr=new Array();\n\t\n\tfor(var i=0;i<total_records;i++)\n\t{\n\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+i);\n\t\tvar priority=priority1.value;\n\t\t\t\n\t\tpriority_arr[i]=priority;\n\t}\n\n\tvar locale=document.forms[0].locale.value;\n\tchecked_row=parent.frames[1].document.forms[0].checked_row.value;\n\n\tif(checked_row==\"\")\n\t{\n//\t\talert(\"Select a row to modify\");\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\telse\n\t{\n\t\tparent.frames[1].document.forms[0].target = \"InsValidationFrame\";\n\t\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=modify&locn=inside&checked_row=\"+checked_row;\n\t\tparent.frames[1].document.forms[0].submit();\n\n\t\tparent.frames[1].document.forms[0].target = \"\";\n\n\t\tvar blng_grp_code1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+checked_row);\n\t\tblng_grp_code=encodeURIComponent(blng_grp_code1.value);\n\n\t\tvar payer_desc1=eval(\"parent.frames[1].document.forms[0].payer_desc\"+checked_row);\n\t\tpayer_desc=encodeURIComponent(payer_desc1.value);\n\n\t\tvar cust_31=eval(\"parent.frames[1].document.forms[0].cust_3\"+checked_row);\n\t\tcust_3=encodeURIComponent(cust_31.value);\n\n\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+checked_row);\n\t\tpriority=priority1.value;\n\n\t\tvar policy_type_desc1=eval(\"parent.frames[1].document.forms[0].policy_type_desc\"+checked_row);\n\t\tpolicy_type_desc=encodeURIComponent(policy_type_desc1.value);\n\n\t\tvar policy_type_code1=eval(\"parent.frames[1].document.forms[0].policy_type_code\"+checked_row);\n\t\tpolicy_type_code=encodeURIComponent(policy_type_code1.value);\n\n\t\tvar policy_no1=eval(\"parent.frames[1].document.forms[0].policy_no\"+checked_row);\n\t\tpolicy_no=encodeURIComponent(policy_no1.value);\n\n\t\tvar policy_start_date1=eval(\"parent.frames[1].document.forms[0].policy_start_date\"+checked_row);\n\t\tpolicy_start_date=policy_start_date1.value;\n\n\t\tvar policy_exp_date1=eval(\"parent.frames[1].document.forms[0].policy_exp_date\"+checked_row);\n\t\tpolicy_exp_date=policy_exp_date1.value;\n\n\t\tvar credit_auth_ref1=eval(\"parent.frames[1].document.forms[0].credit_auth_ref\"+checked_row);\n\t\tcredit_auth_ref=encodeURIComponent(credit_auth_ref1.value);\n\n\t\tvar credit_auth_date1=eval(\"parent.frames[1].document.forms[0].credit_auth_date\"+checked_row);\n\t\tcredit_auth_date=credit_auth_date1.value;\n\n\t\tvar credit_apprd_amt1=eval(\"parent.frames[1].document.forms[0].credit_apprd_amt\"+checked_row);\n\t\tcredit_apprd_amt=credit_apprd_amt1.value;\n\n\t\tvar credit_apprd_days1=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+checked_row);\n\t\tcredit_apprd_days=credit_apprd_days1.value;\n\n\t\tvar policy_eff_frm_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_frm_date\"+checked_row);\n\t\tpolicy_eff_frm_date=policy_eff_frm_date1.value;\n\n\t\tvar policy_eff_to_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_to_date\"+checked_row);\n\t\tpolicy_eff_to_date=policy_eff_to_date1.value;\n\n\t\tvar adj_rule_ind1=eval(\"parent.frames[1].document.forms[0].adj_rule_ind\"+checked_row);\n\t\tadj_rule_ind=encodeURIComponent(adj_rule_ind1.value);\n\n\t\tvar adj_perc_amt_ind1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_ind\"+checked_row);\n\t\tadj_perc_amt_ind=encodeURIComponent(adj_perc_amt_ind1.value);\n\n\t\tvar adj_perc_amt_value1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_value\"+checked_row);\n\t\tadj_perc_amt_value=encodeURIComponent(adj_perc_amt_value1.value);\n\n\t\tvar pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].pmnt_diff_adj_int\"+checked_row);\n\t\tpmnt_diff_adj_int=encodeURIComponent(pmnt_diff_adj_int1.value);\n\n\t\tvar drg_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int\"+checked_row);\n\t\tdrg_pmnt_diff_adj_int=encodeURIComponent(drg_pmnt_diff_adj_int1.value);\n\n\t\tvar spl_srv_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int\"+checked_row);\n\t\tspl_srv_pmnt_diff_adj_int=encodeURIComponent(spl_srv_pmnt_diff_adj_int1.value);\n\n\t\tvar restrict_check1=eval(\"parent.frames[1].document.forms[0].restrict_check\"+checked_row);\n\t\trestrict_check=restrict_check1.value;\n\t\t\n\t\tvar valid_payer_YN1=eval(\"parent.frames[1].document.forms[0].valid_payer_YN\"+checked_row);\n\t\tvalid_payer_YN=valid_payer_YN1.value;\n\n\t\tvar payer_suspended_YN1=eval(\"parent.frames[1].document.forms[0].payer_suspended_YN\"+checked_row);\n\t\tpayer_suspended_YN=payer_suspended_YN1.value;\n\n\t\tvar valid_policy_type_code_YN1=eval(\"parent.frames[1].document.forms[0].valid_policy_type_code_YN\"+checked_row);\n\t\tvalid_policy_type_code_YN=valid_policy_type_code_YN1.value;\n\n\t\tvar policy_suspended_YN1=eval(\"parent.frames[1].document.forms[0].policy_suspended_YN\"+checked_row);\n\t\tpolicy_suspended_YN=policy_suspended_YN1.value;\n\t\t\n\t\tvar cust_group_code1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_code\"+checked_row);\n\t\tcust_group_code=encodeURIComponent(cust_group_code1.value);\n\n\t\tvar cust_group_name1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_name\"+checked_row);\n\t\tcust_group_name=encodeURIComponent(cust_group_name1.value);\n\n\t\tvar cust_valid_from_date1=eval(\"parent.frames[1].document.forms[0].cust_valid_from_date\"+checked_row);\n\t\tcust_valid_from_date=encodeURIComponent(cust_valid_from_date1.value);\n\n\t\tvar cust_valid_to_date1=eval(\"parent.frames[1].document.forms[0].cust_valid_to_date\"+checked_row);\n\t\tcust_valid_to_date=encodeURIComponent(cust_valid_to_date1.value);\n\n\t\tif(!(locale==\"en\"))\n\t\t{\n\t\t\tif(!(policy_start_date==\"\" || policy_start_date==\" \"))\n\t\t\t\tpolicy_start_date=convertDate(policy_start_date,\"DMY\",locale,\"en\");\n\t\t\n\t\t\tif(!(policy_exp_date==\"\" || policy_exp_date==\" \"))\n\t\t\t\tpolicy_exp_date=convertDate(policy_exp_date,\"DMY\",locale,\"en\");\n\n\t\t\tif(!(credit_auth_date==\"\" || credit_auth_date==\" \"))\n\t\t\t\tcredit_auth_date=convertDate(credit_auth_date,\"DMY\",locale,\"en\");\n\n\t\t\tif(!(policy_eff_frm_date==\"\" || policy_eff_frm_date==\" \"))\n\t\t\t\tpolicy_eff_frm_date=convertDate(policy_eff_frm_date,\"DMY\",locale,\"en\");\n\n\t\t\tif(!(policy_eff_to_date==\"\" || policy_eff_to_d";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 ="ate==\" \"))\n\t\t\t\tpolicy_eff_to_date=convertDate(policy_eff_to_date,\"DMY\",locale,\"en\");\n\t\t}\n\n\t\tvar policy_coverage_basis_ind1=eval(\"parent.frames[1].document.forms[0].policy_coverage_basis_ind\"+checked_row);\n\t\tpolicy_coverage_basis_ind=encodeURIComponent(policy_coverage_basis_ind1.value);\n\n\t\tvar rec_edited_YN=eval(\"parent.frames[1].document.forms[0].rec_edited_YN\"+checked_row);\n\t\trec_edited_YN=rec_edited_YN.value;\n\n\t\t//V232504\n\t\tvar mcn_for_policy1 = eval(\"parent.frames[1].document.forms[0].mcn_for_policy\"+checked_row);  \n\t\tmcn_for_policy=mcn_for_policy1.value;\n\t\t//V232504\n\t\tvar reg_ref_id1 = eval(\"parent.frames[1].document.forms[0].reg_ref_id\"+checked_row);  \n\t\treg_ref_id=reg_ref_id1.value;\n\n\t\tvar retVal\t\t\t= new String();\n\n\t\t/* var dialogTop\t\t\t= \"220\";\n\t\tvar dialogHeight\t\t= \"25\" ;\n\t\tvar dialogWidth\t\t\t= \"55\" ; */\n\t\t\n\t\tvar dialogTop\t\t\t= \"0vh\";\n\t\tvar dialogHeight\t\t= \"92vh\" ;\n\t\tvar dialogWidth\t\t\t= \"90vw\" ; \n\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar title=getLabel(\"eBL.MODIFY_PAYER.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar calling_module_id = document.forms[0].calling_module_id.value;\t\n\t\tvar getString=document.forms[0].queryString.value;\n\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\tvar calling_module_id = document.forms[0].calling_module_id.value;\n\t\tvar patient_class = document.forms[0].p_patient_class.value;\n\t\tvar fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;\n\n\n\t\tvar payerEligibilityParamSession=eval(\"parent.frames[1].document.forms[0].payerEligibilityParam\"+checked_row);\n\t\tpayerEligibilityParamSession=encodeURIComponent(payerEligibilityParamSession.value);\n\t\tvar responseCodeSession=eval(\"parent.frames[1].document.forms[0].responseCode\"+checked_row);\n\t\tresponseCodeSession=encodeURIComponent(responseCodeSession.value);\n\t\tvar responseCodeDescSes=eval(\"parent.frames[1].document.forms[0].responseCodeDesc\"+checked_row);\n\t\tresponseCodeDescSes=encodeURIComponent(responseCodeDescSes.value);\n\t\tvar statuDescriptionSession=eval(\"parent.frames[1].document.forms[0].statuDescription\"+checked_row);\n\t\tstatuDescriptionSession=encodeURIComponent(statuDescriptionSession.value);\n\t\tvar validityPeriodSession=eval(\"parent.frames[1].document.forms[0].validityPeriod\"+checked_row);\n\t\tvalidityPeriodSession=encodeURIComponent(validityPeriodSession.value);\n\t\tvar validityPeriodDescSes=eval(\"parent.frames[1].document.forms[0].validityPeriodDesc\"+checked_row);\n\t\tvalidityPeriodDescSes=encodeURIComponent(validityPeriodDescSes.value);\n\t\tvar eligibilityCodeSes=eval(\"parent.frames[1].document.forms[0].eligibilityCode\"+checked_row);\n\t\teligibilityCodeSes=encodeURIComponent(eligibilityCodeSes.value);\n\t\tvar transactionIdSes=eval(\"parent.frames[1].document.forms[0].transactionId\"+checked_row);\n\t\ttransactionIdSes=encodeURIComponent(transactionIdSes.value);\n\t\tvar responseDateTimeSes=eval(\"parent.frames[1].document.forms[0].responseDateTime\"+checked_row);\n\t\tresponseDateTimeSes=encodeURIComponent(responseDateTimeSes.value);\n\t\t\t\n\t\tvar param = \"&title=\"+title+\"&action=modify&locn=inside&blng_grp_code=\"+blng_grp_code+\"&payer_desc=\"+payer_desc+\"&cust_3=\"+cust_3+\"&ins_cust_group_code=\"+cust_group_code+\"&ins_cust_group_name=\"+cust_group_name+\"&priority=\"+priority+\"&policy_type_desc=\"+policy_type_desc+\"&policy_type_code=\"+policy_type_code+\"&policy_no=\"+policy_no+\"&policy_start_date=\"+policy_start_date+\"&policy_exp_date=\"+policy_exp_date+\"&credit_auth_ref=\"+credit_auth_ref+\"&credit_auth_date=\"+credit_auth_date+\"&credit_apprd_amt=\"+credit_apprd_amt+\"&credit_apprd_days=\"+credit_apprd_days+\"&policy_eff_frm_date=\"+policy_eff_frm_date+\"&policy_eff_to_date=\"+policy_eff_to_date+\"&adj_rule_ind=\"+adj_rule_ind+\"&adj_perc_amt_ind=\"+adj_perc_amt_ind+\"&adj_perc_amt_value=\"+adj_perc_amt_value+\"&pmnt_diff_adj_int=\"+pmnt_diff_adj_int+\"&drg_pmnt_diff_adj_int=\"+drg_pmnt_diff_adj_int+\"&spl_srv_pmnt_diff_adj_int=\"+spl_srv_pmnt_diff_adj_int+\"&restrict_check=\"+restrict_check+\"&valid_payer_YN=\"+valid_payer_YN+\"&valid_policy_type_code_YN=\"+valid_policy_type_code_YN+\"&policy_coverage_basis_ind=\"+policy_coverage_basis_ind+\"&policy_coverage_basis_gbl_ind=\"+policy_coverage_basis_gbl_ind+\"&totalRecords=\"+total_records+\"&priority_arr=\"+priority_arr+\"&encounter_date_time=\"+encounter_date_time+\"&cust_valid_from_date=\"+cust_valid_from_date+\"&cust_valid_to_date=\"+cust_valid_to_date+\"&checked_row=\"+checked_row+\"&rec_edited_YN=\"+rec_edited_YN+\"&patient_id=\"+patient_id+\"&calling_module_id=\"+calling_module_id+\"&patient_class=\"+patient_class+\"&fin_class_flag_YN=\"+fin_class_flag_YN+\"&payerElgParam=\"+payerEligibilityParamSession+\"&respCdSes=\"+responseCodeSession+\"&respCdDescSes=\"+responseCodeDescSes+\"&statDes=\"+statuDescriptionSession+\"&valPer=\"+validityPeriodSession+\"&valPerDesc=\"+validityPeriodDescSes+\"&elgCd=\"+eligibilityCodeSes+\"&transId=\"+transactionIdSes+\"&respDT=\"+responseDateTimeSes+\"&package_enabled_yn=\"+package_enabled_yn+\"&reg_ref_id=\"+reg_ref_id+\"&mcn_for_policy=\"+mcn_for_policy; //V232504\n\n\t\tretVal= await parent.window.showModalDialog(\"../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?\"+param,arguments,features);\n\t\t\n\t\tformObj = parent.frames[1].document.forms[0];\n\t\ttotal_records=formObj.total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\n//\t\tformObj.selected_row.checked=false;\n\t\tif(retVal!=null)\n\t\t{\n\t\tvar arr=new Array();\n\t\tif(retVal == null) retVal=\'\';\n\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\t\t\t  \n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n//\t\t\t\tformObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;\n\t\t\t\tarr=retVal.split(\"^~^\");\t\n\n\t\t\t\tif(arr[22]==\"R\")\n\t\t\t\t{\n\t\t\t\t\tif(arr[31]==\"R\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_leg_disp\"+checked_row));\n\t\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"inline\";\n\t\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_val_disp\"+checked_row));\n\t\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"inline\";\n\n\t\t\t\t\t}\n\t\t\t\t\telse if(arr[31]==\"U\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_leg_disp\"+checked_row));\n\t\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\t\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_val_disp\"+checked_row));\n\t\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\n\t\t\t\t\t\tvar credit_apprd_amt_chk=eval(\"parent.frames[1].document.forms[0].credit_apprd_amt\"+checked_row);\n\t\t\t\t\t\tcredit_apprd_amt_chk.value=\"\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(arr[32]==\"R\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_leg_disp\"+checked_row));\n\t\t\t\t\t\tapprd_days_leg_disp1.style.display=\"inline\";\n\t\t\t\t\t\tvar apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_val_disp\"+checked_row));\n\t\t\t\t\t\tapprd_days_leg_disp1.style.display=\"inline\";\n\t\t\t\t\t}\n\t\t\t\t\telse if(arr[32]==\"U\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_leg_disp\"+checked_row));\n\t\t\t\t\t\tapprd_days_leg_disp1.style.display=\"none\";\n\t\t\t\t\t\tvar apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_val_disp\"+checked_row));\n\t\t\t\t\t\tapprd_days_leg_disp1.style.display=\"none\";\n\n\t\t\t\t\t\tvar credit_apprd_days_chk=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+checked_row);\n\t\t\t\t\t\tcredit_apprd_days_chk.value=\"\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(arr[22]==\"U\")\n\t\t\t\t{\n\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_leg_disp\"+checked_row));\n\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_amt_val_disp\"+checked_row));\n\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_leg_disp\"+checked_row));\n\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\t\t\t\t\tvar apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById(\"apprd_days_val_disp\"+checked_row));\n\t\t\t\t\tapprd_amt_leg_disp1.style.display=\"none\";\n\n\t\t\t\t\tvar credit_apprd_amt_chk=eval(\"parent.frames[1].document.forms[0].credit_apprd_amt\"+checked_row);\n\t\t\t\t\tcredit_apprd_amt_chk.value=\"\";\n\t\t\t\t\tvar credit_apprd_days_chk=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+checked_row);\n\t\t\t\t\tcredit_apprd_days_chk.value=\"\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tvar blng_grp_desc1=eval(\"parent.frames[1].document.forms[0].billing_group_desc\"+checked_row);\n\t\t\t\tblng_grp_desc1.value=decodeURIComponent(arr[0]);\n\t\t\t\t\n\t\t\t\tvar blng_grp_code1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+checked_row);\n\t\t\t\tblng_grp_code1.value=decodeURIComponent(arr[1]);\n\t\t\t\t\n\t\t\t\tvar payer_desc1=eval(\"parent.frames[1].document.forms[0].payer_desc\"+checked_row);\n\t\t\t\tpayer_desc1.value=decodeURIComponent(arr[2]);\n\t\t\t\t\n\t\t\t\tvar cust_31=eval(\"parent.frames[1].document.forms[0].cust_3\"+checked_row);\n\t\t\t\tcust_31.value=decodeURIComponent(arr[3]);\n\t\t\t\t\n\t\t\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+checked_row);\n\t\t\t\tpriority1.value=arr[4];\n\t\t\t\t\n\t\t\t\tvar policy_type_desc1=eval(\"parent.frames[1].document.forms[0].policy_type_desc\"+checked_row);\n\t\t\t\tpolicy_type_desc1.value=decodeURIComponent(arr[5]);\n\t\t\t\t\n\t\t\t\tvar policy_type_code1=eval(\"parent.frames[1].document.forms[0].policy_type_code\"+checked_row);\n\t\t\t\tpolicy_type_code1.value=decodeURIComponent(arr[6]);\n\t\t\t\t\n\t\t\t\tvar policy_no1=eval(\"parent.frames[1].document.forms[0].policy_no\"+checked_row);\n\t\t\t\tpolicy_no1.value=arr[7];\n\t\t\t\t\n\t\t\t\tvar policy_start_date1=eval(\"parent.frames[1].document.forms[0].policy_start_date\"+checked_row);\n\t\t\t\tvar policy_start_date_conv=arr[8];\n\t\t\t\tif(policy_start_date_conv==\"\" || policy_start_date_conv==\" \") policy_start_date_conv=\"\";\n\t\t\t\tif(policy_start_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_start_date_conv=convertDate(policy_start_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpolicy_start_date1.value=policy_start_date_conv;\n\t\t\t\t\n\t\t\t\tvar policy_exp_date1=eval(\"parent.frames[1].document.forms[0].policy_exp_date\"+checked_row);\n\t\t\t\tvar policy_exp_date_conv=arr[9];\n\t\t\t\tif(policy_exp_date_conv==\"\" || policy_exp_date_conv==\" \") policy_exp_date_conv=\"\";\n\t\t\t\tif(policy_exp_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_exp_date_conv=convertDate(policy_exp_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpolicy_exp_date1.value=policy_exp_date_conv;\n\n\t\t\t\tif(arr[33] == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tvar credit_auth_ref_val_disp1=eval(parent.frames[1].document.getElementById(\"credit_auth_val_disp\"+checked_row));\n\t\t\t\t\tcredit_auth_ref_val_disp1.style.display=\"inline\";\n\n\t\t\t\t\tvar credit_auth_ref1=eval(\"parent.frames[1].document.forms[0].credit_a";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block10_2 ="uth_ref\"+checked_row);\n\t\t\t\t\tcredit_auth_ref1.value=decodeURIComponent(arr[10]);\n\n\t\t\t\t\tvar credit_auth_date_val_disp1=eval(parent.frames[1].document.getElementById(\"credit_auth_date_val_disp\"+checked_row));\n\t\t\t\t\tcredit_auth_date_val_disp1.style.display=\"inline\";\n\t\t\t\t\t\n\t\t\t\t\tvar credit_auth_date1=eval(\"parent.frames[1].document.forms[0].credit_auth_date\"+checked_row);\n\t\t\t\t\tvar credit_auth_date_conv=arr[11];\n\n\t\t\t\t\tif(credit_auth_date_conv==\"\" || credit_auth_date_conv==\" \") credit_auth_date_conv=\"\";\n\t\t\t\t\tif(credit_auth_date_conv!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tcredit_auth_date_conv=convertDate(credit_auth_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t\t}\n\t\t\t\t\tcredit_auth_date1.value=credit_auth_date_conv;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tvar credit_auth_ref_val_disp1=eval(parent.frames[1].document.getElementById(\"credit_auth_val_disp\"+checked_row));\n\t\t\t\t\tcredit_auth_ref_val_disp1.style.display=\"none\";\n\n\t\t\t\t\tvar credit_auth_ref1=eval(\"parent.frames[1].document.forms[0].credit_auth_ref\"+checked_row);\n\t\t\t\t\tcredit_auth_ref1.value= \"\";\n\t\t\t\t\t\n\t\t\t\t\tvar credit_auth_date_val_disp1=eval(parent.frames[1].document.getElementById(\"credit_auth_date_val_disp\"+checked_row));\n\t\t\t\t\tcredit_auth_date_val_disp1.style.display=\"none\";\n\n\t\t\t\t\tvar credit_auth_date1=eval(\"parent.frames[1].document.forms[0].credit_auth_date\"+checked_row);\n\t\t\t\t\tcredit_auth_date1.value= \"\";\n\t\t\t\t}\n\n\t\t\t\tvar cred_auth_req_yn1=eval(\"parent.frames[1].document.forms[0].cred_auth_req_yn\"+checked_row);\n\t\t\t\tcred_auth_req_yn1.value=arr[33];\n\n\t\t\t\tvar cred_auth_mand_capt_yn1=eval(\"parent.frames[1].document.forms[0].cred_auth_mand_capt_yn\"+checked_row);\n\t\t\t\tcred_auth_mand_capt_yn1.value=arr[40];\t\t\t\t\n\n\t\t\t\tvar dflt_auth_ref_as_pol_no_yn1=eval(\"parent.frames[1].document.forms[0].dflt_auth_ref_as_pol_no_yn\"+checked_row);\n\t\t\t\tdflt_auth_ref_as_pol_no_yn1.value=arr[34];\n\t\t\t\t\n\t\t\t\tvar credit_apprd_amt1=eval(\"parent.frames[1].document.forms[0].credit_apprd_amt\"+checked_row);\n\t\t\t\tvar temp_credit_apprd_amt=arr[12];\n\t\t\t\tif(temp_credit_apprd_amt==\" \") temp_credit_apprd_amt=\"\";\n\t\t\t\tcredit_apprd_amt1.value=temp_credit_apprd_amt;\n\t\t\t\t\n\t\t\t\tvar credit_apprd_days1=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+checked_row);\n\t\t\t\tvar temp_credit_apprd_days=arr[13];\n\t\t\t\tif(temp_credit_apprd_days==\" \") temp_credit_apprd_days=\"\";\n\t\t\t\tcredit_apprd_days1.value=temp_credit_apprd_days;\n\t\t\t\t\n\t\t\t\tvar policy_eff_frm_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_frm_date\"+checked_row);\n\t\t\t\tvar policy_eff_frm_date_conv=arr[14];\n\t\t\t\tif(policy_eff_frm_date_conv==\"\" || policy_eff_frm_date_conv==\" \") policy_eff_frm_date_conv=\"\";\n\t\t\t\tif(policy_eff_frm_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_eff_frm_date_conv=convertDate(policy_eff_frm_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpolicy_eff_frm_date1.value=policy_eff_frm_date_conv;\n\t\t\t\t\n\t\t\t\tvar policy_eff_to_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_to_date\"+checked_row);\n\t\t\t\tvar policy_eff_to_date_conv=arr[15];\n\t\t\t\tif(policy_eff_to_date_conv==\"\" || policy_eff_to_date_conv==\" \") policy_eff_to_date_conv=\"\";\n\t\t\t\tif(policy_eff_to_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_eff_to_date_conv=convertDate(policy_eff_to_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpolicy_eff_to_date1.value=policy_eff_to_date_conv;\n\t\t\t\t\n\t\t\t\tvar adj_rule_ind1=eval(\"parent.frames[1].document.forms[0].adj_rule_ind\"+checked_row);\n\t\t\t\tadj_rule_ind1.value=decodeURIComponent(arr[16]);\n\t\t\t\t\n\t\t\t\tvar adj_perc_amt_ind1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_ind\"+checked_row);\n\t\t\t\tadj_perc_amt_ind1.value=decodeURIComponent(arr[17]);\n\t\t\t\t\n\t\t\t\tvar adj_perc_amt_value1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_value\"+checked_row);\n\t\t\t\tadj_perc_amt_value1.value=decodeURIComponent(arr[18]);\n\t\t\t\t\n\t\t\t\tvar pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].pmnt_diff_adj_int\"+checked_row);\n\t\t\t\tpmnt_diff_adj_int1.value=decodeURIComponent(arr[19]);\n\t\t\t\t\n\t\t\t\tvar drg_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int\"+checked_row);\n\t\t\t\tdrg_pmnt_diff_adj_int1.value=decodeURIComponent(arr[20]);\n\t\t\t\t\n\t\t\t\tvar spl_srv_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int\"+checked_row);\n\t\t\t\tspl_srv_pmnt_diff_adj_int1.value=decodeURIComponent(arr[21]);\n\t\t\t\t\n\t\t\t\tvar restrict_check1=eval(\"parent.frames[1].document.forms[0].restrict_check\"+checked_row);\n\t\t\t\trestrict_check1.value=arr[22];\n\n\t\t\t\tvar apprd_amt_restrict_check1=eval(\"parent.frames[1].document.forms[0].apprd_amt_restrict_check\"+checked_row);\n\t\t\t\tapprd_amt_restrict_check1.value=arr[31];\n\n\t\t\t\tvar apprd_days_restrict_check1=eval(\"parent.frames[1].document.forms[0].apprd_days_restrict_check\"+checked_row);\n\t\t\t\tapprd_days_restrict_check1.value=arr[32];\n\n\t\t\t\tvar valid_payer_YN1=eval(\"parent.frames[1].document.forms[0].valid_payer_YN\"+checked_row);\n\t\t\t\tvalid_payer_YN1.value=arr[23];\n\n\t\t\t\tvar valid_policy_type_code_YN1=eval(\"parent.frames[1].document.forms[0].valid_policy_type_code_YN\"+checked_row);\n\t\t\t\tvalid_policy_type_code_YN1.value=arr[24];\n\n\t\t\t\tvar cust_group_code1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_code\"+checked_row);\n\t\t\t\tcust_group_code1.value=decodeURIComponent(arr[25]);\n\n\t\t\t\tvar cust_group_name1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_name\"+checked_row);\n\t\t\t\tcust_group_name1.value=decodeURIComponent(arr[37]);\n\n\t\t\t\tvar policy_coverage_basis_ind1=eval(\"parent.frames[1].document.forms[0].policy_coverage_basis_ind\"+checked_row);\n\t\t\t\tpolicy_coverage_basis_ind1.value=arr[26];\n\n\t\t\t\tvar cust_valid_from_date1=eval(\"parent.frames[1].document.forms[0].cust_valid_from_date\"+checked_row);\n\t\t\t\tcust_valid_from_date1.value=arr[35];\n\n\t\t\t\tvar cust_valid_to_date1=eval(\"parent.frames[1].document.forms[0].cust_valid_to_date\"+checked_row);\n\t\t\t\tcust_valid_to_date1.value=arr[36];\n\n\t\t\t\tvar pol_validity_chk_date=eval(\"parent.frames[1].document.forms[0].pol_validity_chk_date\"+checked_row);\n\t\t\t\tvar pol_validity_chk_date_conv = arr[38];\n\n\t\t\t\tif(pol_validity_chk_date_conv==\"\" || pol_validity_chk_date_conv==\" \") pol_validity_chk_date_conv=\"\";\n\n\t\t\t\tif(pol_validity_chk_date_conv!=\"\")\n\t\t\t\t{\n\t\t\t\t\tpol_validity_chk_date_conv=convertDate(pol_validity_chk_date_conv,\"DMY\",\"en\",locale);\n\t\t\t\t}\n\t\t\t\tpol_validity_chk_date.value=pol_validity_chk_date_conv;\n\n\t\t\t\tif(total_records==1)\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value=policy_coverage_basis_ind1.value;\n\t\t\t\t}\n\n\t\t\t\tparent.frames[1].policy_coverage_basis_ind();\n\n\t\t\t\tvar rec_edited_YN=eval(\"parent.frames[1].document.forms[0].rec_edited_YN\"+checked_row);\n\t\t\t\trec_edited_YN.value = arr[39];\n\t\t\t\t\n\t\t\t\tvar mcn_for_policy=eval(\"parent.frames[1].document.forms[0].mcn_for_policy\"+checked_row);  //V232504\n\t\t\t\tmcn_for_policy.value=decodeURIComponent(arr[51]);  //V232504\n\t\t\t\t\n\t\t\t\tvar reg_ref_id=eval(\"parent.frames[1].document.forms[0].reg_ref_id\"+checked_row);  //V232504\n\t\t\t\treg_ref_id.value=decodeURIComponent(arr[52]);  //V232504\n\t\t\t\t\n\n\n\t\t\t\t//Added by prithivi on 03/01/2017 for mms-qh-crf-0085 -- bupa insurance interface\n\t\t\t\tvar payerEligibilityParam=eval(\"parent.frames[1].document.forms[0].payerEligibilityParam\"+checked_row);\n\n\t\t\t\tvar responseCode=eval(\"parent.frames[1].document.forms[0].responseCode\"+checked_row);\n\t\t\t\tvar responseCodeDesc=eval(\"parent.frames[1].document.forms[0].responseCodeDesc\"+checked_row);\n\t\t\t\tvar statuDescription=eval(\"parent.frames[1].document.forms[0].statuDescription\"+checked_row);\n\t\t\t\tvar validityPeriod=eval(\"parent.frames[1].document.forms[0].validityPeriod\"+checked_row);\n\t\t\t\tvar validityPeriodDesc=eval(\"parent.frames[1].document.forms[0].validityPeriodDesc\"+checked_row);\n\t\t\t\tvar eligibilityCode=eval(\"parent.frames[1].document.forms[0].eligibilityCode\"+checked_row);\n\t\t\t\tvar transactionId=eval(\"parent.frames[1].document.forms[0].transactionId\"+checked_row);\n\t\t\t\tvar responseDateTime=eval(\"parent.frames[1].document.forms[0].responseDateTime\"+checked_row);\n\n\t\t\t\tvar arrLength = arr.length-10;  // over all arr length is 51\n\t\t\t\tpayerEligibilityParam.value = decodeURIComponent(arr[arrLength]);\n\t\t\t\tresponseCode.value = decodeURIComponent(arr[arrLength+1]);\n\t\t\t\tresponseCodeDesc.value = decodeURIComponent(arr[arrLength+2]);\n\t\t\t\tstatuDescription.value = decodeURIComponent(arr[arrLength+3]);\n\t\t\t\tvalidityPeriod.value = decodeURIComponent(arr[arrLength+4]);\n\t\t\t\tvalidityPeriodDesc.value = decodeURIComponent(arr[arrLength+5]);\n\t\t\t\teligibilityCode.value = decodeURIComponent(arr[arrLength+6]);\n\t\t\t\ttransactionId.value = decodeURIComponent(arr[arrLength+7]);\n\t\t\t\tresponseDateTime.value = decodeURIComponent(arr[arrLength+8]);\n\n\t\t\t}\n\t\t}\n\t\t}\n\t\telse\n\t\t{\n//\t\t\talert(\"closed\");\n\t\t}\n\t}\n\tparent.frames[1].document.forms[0].checked_row.value=\"\";\n}\n\n/*\nfunction removePayer()\n{\n\tformObj = parent.frames[1].document.forms[0];\n\ttotal_records=formObj.total_records.value;\n\n\tvar policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;\n\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\n\tvar locale=document.forms[0].locale.value;\n\tvar checked_row=parent.frames[1].document.forms[0].checked_row.value;\n\tif(checked_row==\"\")\n\t{\n//\t\talert(\"Select a row to remove\");\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\telse\n\t{\n\t\tvar blng_grp_code1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+checked_row);\n\t\tblng_grp_code=encodeURIComponent(blng_grp_code1.value);\n\n\t\tvar payer_desc1=eval(\"parent.frames[1].document.forms[0].payer_desc\"+checked_row);\n\t\tpayer_desc=encodeURIComponent(payer_desc1.value);\n\n\t\tvar cust_31=eval(\"parent.frames[1].document.forms[0].cust_3\"+checked_row);\n\t\tcust_3=encodeURIComponent(cust_31.value);\n\n\t\tvar priority1=eval(\"parent.frames[1].document.forms[0].priority\"+checked_row);\n\t\tpriority=priority1.value;\n\n\t\tvar policy_type_desc1=eval(\"parent.frames[1].document.forms[0].policy_type_desc\"+checked_row);\n\t\tpolicy_type_desc=encodeURIComponent(policy_type_desc1.value);\n\n\t\tvar policy_type_code1=eval(\"parent.frames[1].document.forms[0].policy_type_code\"+checked_row);\n\t\tpolicy_type_code=policy_type_code1.value;\n\n\t\tvar policy_no1=eval(\"parent.frames[1].document.forms[0].policy_no\"+checked_row);\n\t\tpolicy_no=encodeURIComponent(policy_no1.value);\n\n\t\tvar policy_start_date1=eval(\"parent.frames[1].document.forms[0].policy_start_date\"+checked_row);\n\t\tpolicy_start_date=policy_start_date1.value;\n\n\t\tvar policy_exp_date1=eval(\"parent.frames[1].document.forms[0].policy_exp_date\"+checked_row);\n\t\tpolicy_exp_date=policy_exp_date1.value;\n\n\t\tvar credit_auth_ref1=eval(\"parent.frames[1].document.forms[0].credit_auth_ref\"+checked_row);\n\t\tcredit_auth_ref=encodeURIComponent(credit_auth_ref1.value);\n\n\t\tvar credit_auth_date1=eval(\"parent.frames[1].document.forms[0].credit_auth_date\"+checked_row);\n\t\tcredit_auth_date=credit_auth_date1.value;\n\n\t\tvar credit_apprd_amt1=eval(\"parent.frames[1";
    private final static byte[]  _wl_block10_2Bytes = _getBytes( _wl_block10_2 );

    private final static java.lang.String  _wl_block10_3 ="].document.forms[0].credit_apprd_amt\"+checked_row);\n\t\tcredit_apprd_amt=credit_apprd_amt1.value;\n\n\t\tvar credit_apprd_days1=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+checked_row);\n\t\tcredit_apprd_days=credit_apprd_days1.value;\n\n\t\tvar policy_eff_frm_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_frm_date\"+checked_row);\n\t\tpolicy_eff_frm_date=policy_eff_frm_date1.value;\n\n\t\tvar policy_eff_to_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_to_date\"+checked_row);\n\t\tpolicy_eff_to_date=policy_eff_to_date1.value;\n\n\t\tvar adj_rule_ind1=eval(\"parent.frames[1].document.forms[0].adj_rule_ind\"+checked_row);\n\t\tadj_rule_ind=adj_rule_ind1.value;\n\n\t\tvar adj_perc_amt_ind1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_ind\"+checked_row);\n\t\tadj_perc_amt_ind=adj_perc_amt_ind1.value;\n\n\t\tvar adj_perc_amt_value1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_value\"+checked_row);\n\t\tadj_perc_amt_value=adj_perc_amt_value1.value;\n\n\t\tvar pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].pmnt_diff_adj_int\"+checked_row);\n\t\tpmnt_diff_adj_int=pmnt_diff_adj_int1.value;\n\n\t\tvar drg_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int\"+checked_row);\n\t\tdrg_pmnt_diff_adj_int=drg_pmnt_diff_adj_int1.value;\n\n\t\tvar spl_srv_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int\"+checked_row);\n\t\tspl_srv_pmnt_diff_adj_int=spl_srv_pmnt_diff_adj_int1.value;\n\n\t\tvar restrict_check1=eval(\"parent.frames[1].document.forms[0].restrict_check\"+checked_row);\n\t\trestrict_check=restrict_check1.value;\n\n\t\tvar valid_payer_YN1=eval(\"parent.frames[1].document.forms[0].valid_payer_YN\"+checked_row);\n\t\tvalid_payer_YN=valid_payer_YN1.value;\n\n\t\tvar valid_policy_type_code_YN1=eval(\"parent.frames[1].document.forms[0].valid_policy_type_code_YN\"+checked_row);\n\t\tvalid_policy_type_code_YN=valid_policy_type_code_YN1.value;\n\n\t\tvar cust_group_code1=eval(\"parent.frames[1].document.forms[0].cust_group_code\"+checked_row);\n\t\tcust_group_code=encodeURIComponent(cust_group_code1.value);\n\n\t\tvar policy_coverage_basis_ind1=eval(\"parent.frames[1].document.forms[0].policy_coverage_basis_ind\"+checked_row);\n\t\tpolicy_coverage_basis_ind=policy_coverage_basis_ind1.value;\n\n\t\tif(!(locale==\"en\"))\n\t\t{\n\t\t\tif(!(policy_start_date==\"\" || policy_start_date==\" \"))\n\t\t\t\tpolicy_start_date=convertDate(policy_start_date,\"DMY\",locale,\"en\");\n\t\t\n\t\t\tif(!(policy_exp_date==\"\" || policy_exp_date==\" \"))\n\t\t\t\tpolicy_exp_date=convertDate(policy_exp_date,\"DMY\",locale,\"en\");\n\n\t\t\tif(!(credit_auth_date==\"\" || credit_auth_date==\" \"))\n\t\t\t\tcredit_auth_date=convertDate(credit_auth_date,\"DMY\",locale,\"en\");\n\n\t\t\tif(!(policy_eff_frm_date==\"\" || policy_eff_frm_date==\" \"))\n\t\t\t\tpolicy_eff_frm_date=convertDate(policy_eff_frm_date,\"DMY\",locale,\"en\");\n\n\t\t\tif(!(policy_eff_to_date==\"\" || policy_eff_to_date==\" \"))\n\t\t\t\tpolicy_eff_to_date=convertDate(policy_eff_to_date,\"DMY\",locale,\"en\");\n\t\t}\n\n\t\tvar retVal\t\t\t= new String();\n\n\t\tvar dialogTop\t\t\t= \"220\";\n\t\tvar dialogHeight\t\t= \"18\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar title=getLabel(\"eBL.REMOVE_PAYER.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\n\t\tvar calling_module_id = document.forms[0].calling_module_id.value;\t\n\t\tvar getString=document.forms[0].queryString.value;\n\t\tvar param = \"&title=\"+title+\"&action=remove&payer_desc=\"+payer_desc+\"&cust_3=\"+cust_3+\"&cust_group_code=\"+cust_group_code+\"&priority=\"+priority+\"&policy_type_desc=\"+policy_type_desc+\"&policy_type_code=\"+policy_type_code+\"&policy_no=\"+policy_no+\"&policy_start_date=\"+policy_start_date+\"&policy_exp_date=\"+policy_exp_date+\"&credit_auth_ref=\"+credit_auth_ref+\"&credit_auth_date=\"+credit_auth_date+\"&credit_apprd_amt=\"+credit_apprd_amt+\"&credit_apprd_days=\"+credit_apprd_days+\"&policy_eff_frm_date=\"+policy_eff_frm_date+\"&policy_eff_to_date=\"+policy_eff_to_date+\"&adj_rule_ind=\"+adj_rule_ind+\"&adj_perc_amt_ind=\"+adj_perc_amt_ind+\"&adj_perc_amt_value=\"+adj_perc_amt_value+\"&pmnt_diff_adj_int=\"+pmnt_diff_adj_int+\"&drg_pmnt_diff_adj_int=\"+drg_pmnt_diff_adj_int+\"&spl_srv_pmnt_diff_adj_int=\"+spl_srv_pmnt_diff_adj_int+\"&restrict_check=\"+restrict_check+\"&valid_payer_YN=\"+valid_payer_YN+\"&valid_policy_type_code_YN=\"+valid_policy_type_code_YN+\"&policy_coverage_basis_ind=\"+policy_coverage_basis_ind+\"&policy_coverage_basis_gbl_ind=\"+policy_coverage_basis_gbl_ind+\"&totalRecords=\"+total_records+\"&\"+getString;\n\t\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?\"+param,arguments,features);\n\n\t\tformObj = parent.frames[1].document.forms[0];\n\t\ttotal_records=formObj.total_records.value;\n\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\n\t\tif(\tretVal!=null)\n\t\t{\n\t\t\tvar ret_val=retVal;\n\t\t\tif(ret_val==\"remove\")\n\t\t\t{\t\n\t\t\t\t\ttotalRecords =eval(formObj.total_records.value);\n\n\t\t\t\t\tif(totalRecords==1)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value=\"\";\n\t\t\t\t\t}\n\t\t\t\t\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpBody.jsp?remove_check=remove&checked_row=\"+checked_row+\"&total_records=\"+totalRecords+\"&\"+getString;\n\n\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n//\t\t\talert(\"closed\");\n\t\t}\n\t}\n\tparent.frames[1].document.forms[0].checked_row.value=\"\";\n}\n*/\nfunction removePayerNew()\n{\n\tvar checked_row=parent.frames[1].document.forms[0].checked_row.value;\n\tvar locale=document.forms[0].locale.value;\n\tformObj = parent.frames[1].document.forms[0];\n\ttotal_records=formObj.total_records.value;\n\n\tvar getString=document.forms[0].queryString.value;\n\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\t\n\tif(checked_row==\"\")\n\t{\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\telse\n\t{\n\t\tif(confirm(getMessage(\"BL9760\",\"BL\"))) //BL9760\n\t\t{\n\t\t\ttotalRecords =eval(formObj.total_records.value);\n\t\t\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpBody.jsp?remove_check=remove&\"+getString+\"&checked_row=\"+checked_row+\"&total_records=\"+totalRecords;\n\n\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\t\t\t\n\t\t}\n\t}\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\ttemp.checked=false;\n\t}\n\tparent.frames[1].document.forms[0].checked_row.value=\"\";\n\t\n}\n\nfunction cancel()\n{\n\t//parent.window.close();\n\t\n\tif(top.window.document.getElementById(\'dialog-body\')) \n\t{\t\n\t\tvar showModalFrame = top.window.document.getElementById(\'dialog-body\').contentWindow;\n\t\tshowModalFrame.document.getElementById(\"dialog_tag\").close();\n\t}\n\telse\n\t{\n\t\tconst dialogTag = parent.document.getElementById(\"dialog_tag\"); \n\t    dialogTag.close(); \n\t}\n}\n\nfunction add_more_blng_grp()\n{\n\tvar locale=document.forms[0].locale.value;\n\tvar billing_group=parent.frames[1].document.forms[0].billing_group.value;\n\tvar primary_blng_grp=document.forms[0].primary_blng_grp.value;\n\tvar primary_blng_grp_arr=new Array();\n\tprimary_blng_grp_arr=primary_blng_grp.split(\"|\");\n\t\n\tfor (var i=0;i<primary_blng_grp_arr.length;i++)\n\t{\n\t\t    var blng_grp_val = primary_blng_grp_arr[i];\n\t\t\tif(blng_grp_val==billing_group)\n\t\t\t{\n//\t\t\t\talert(\"Billing Group is Duplicated\");\n\t\t\t\talert(getMessage(\"BL9577\",\"BL\"));\n\t\t\t\treturn false;\n\t\t\t}\n\t}\n\t\n\tvar total_records=parent.frames[1].document.forms[0].total_records.value;\n\tvar rtn_ins_blng_grp_desc=\"\";\n\tvar rtn_ins_blng_grp=\"\";\n\tvar rtn_ins_payer_desc=\"\";\n\tvar rtn_ins_cust_code=\"\";\n\tvar rtn_ins_cust_priority=\"\";\n\tvar rtn_ins_policy_type_desc=\"\";\n\tvar rtn_ins_policy_type_code=\"\";\n\tvar rtn_ins_policy_no=\"\";\n\tvar rtn_ins_policy_start_date=\"\";\n\tvar rtn_ins_policy_expiry_date=\"\";\n\tvar rtn_ins_credit_auth_ref=\"\";\n\tvar rtn_ins_credit_auth_date=\"\";\n\tvar rtn_ins_credit_approval_days=\"\";\n\tvar rtn_ins_credit_approval_amount=\"\";\n\tvar rtn_ins_policy_eff_from_date=\"\";\n\tvar rtn_ins_policy_eff_to_date=\"\";\n\tvar rtn_ins_adj_rule_ind=\"\";\n\tvar rtn_ins_adj_perc_amt_ind=\"\";\n\tvar rtn_ins_adj_perc_amt_value=\"\";\n\tvar rtn_ins_pmnt_diff_adj_int=\"\";\n\tvar rtn_ins_drg_pmnt_diff_adj_int=\"\";\n\tvar rtn_ins_spl_srv_pmnt_diff_adj_int=\"\";\n\tvar rtn_ins_restrict_check=\"\",rtn_ins_apprd_amt_restrict_check=\"\",rtn_ins_apprd_days_restrict_check=\"\";\n\tvar restrict_check=\"\",apprd_amt_restrict_check=\"\",apprd_days_restrict_check=\"\";\n\tvar rtn_ins_valid_payer_YN=\"\";\n\tvar rtn_ins_valid_policy_type_code_YN=\"\";\n\tvar rtn_ins_cust_group_code=\"\";\n\tvar rtn_ins_cust_group_name=\"\";\n\tvar rtn_ins_policy_coverage_basis_ind=\"\";\n\tvar policy_coverage_basis_gbl_ind=\"\";\n\tvar policy_coverage_basis_gbl_ind_from_main=\"\";\n\tvar rtn_ins_cred_auth_req_yn=\"\", rtn_ins_dflt_auth_ref_as_pol_no_yn=\"\",rtn_ins_cred_auth_mand_capt_yn=\"\";\n\tvar cred_auth_req_yn=\"\", dflt_auth_ref_as_pol_no_yn=\"\",cred_auth_mand_capt_yn=\"\";\n\n\tvar rtn_ref_src_main_code = \"\", rtn_ref_src_main_desc=\"\";\n\tvar rtn_ref_src_sub_code = \"\", rtn_ref_src_sub_desc=\"\";\n\tvar cap_ref_src_dtl_flag = \"N\";\n\tvar referral_source_main_mand_YN = \"N\";\n\tvar referral_source_sub_mand_YN = \"N\";\n\n\t//Added by prithivi on 13/03/2017 for mms-qh-crf-0085 bupa insurance patient eligibility check\n\t\n\tvar rtn_payerEligibilityParamSession=\"\";\n\tvar rtn_responseCode=\"\";\n\tvar rtn_responseCodeDesc=\"\";\n\tvar rtn_statuDescription=\"\";\n\tvar rtn_validityPeriod=\"\";\n\tvar rtn_validityPeriodDesc=\"\";\n\tvar rtn_eligibilityCode=\"\";\n\tvar rtn_transactionId=\"\";\n\tvar rtn_responseDateTime=\"\";\n\t//above variables were added by prithivi on 13/03/2017 for mms-qh-crf-0085 bupa insurance patient eligibility check\n\t\n\t//V232504\n\tvar rtn_mcn_for_policy=\"\";\n\tvar rtn_reg_ref_id=\"\";\n\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"BL9574\",\"BL\"));\n\t\treturn false;\n\t}\n\n\tcap_ref_src_dtl_flag = parent.parent.frames[0].document.forms[0].cap_ref_src_dtl_flag.value;\n\treferral_source_main_mand_YN = parent.parent.frames[0].document.forms[0].referral_source_main_mand_YN.value;\n\treferral_source_sub_mand_YN = parent.parent.frames[0].document.forms[0].referral_source_sub_mand_YN.value;\n\trtn_ref_src_main_code = parent.parent.frames[0].document.forms[0].referral_source_main_code.value;\n\trtn_ref_src_main_desc = parent.parent.frames[0].document.forms[0].referral_source_main_desc.value;\n\trtn_ref_src_sub_code = parent.parent.frames[0].document.forms[0].referral_source_sub_code.value;\n\trtn_ref_src_sub_desc = parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value;\n\n\tif(cap_ref_src_dtl_flag==\"Y\")\n\t{\n\t\tif(referral_source_main_mand_YN == \"Y\")\n\t\t{\n\t\t\tif((rtn_ref_src_main_code==\"\" || rtn_ref_src_main_code==null) || (rtn_ref_src_main_desc==\"\" || rtn_ref_src_main_desc==null))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9816\",\"BL\"));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\n\t\tif(referral_source_sub_ma";
    private final static byte[]  _wl_block10_3Bytes = _getBytes( _wl_block10_3 );

    private final static java.lang.String  _wl_block10_4 ="nd_YN == \"Y\")\n\t\t{\n\t\t\tif((rtn_ref_src_sub_code==\"\" || rtn_ref_src_sub_code==null) || (rtn_ref_src_sub_desc==\"\" || rtn_ref_src_sub_desc==null))\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9817\",\"BL\"));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\trtn_ref_src_main_code=\"\";\n\t\trtn_ref_src_main_desc=\"\";\n\t\trtn_ref_src_sub_code=\"\";\n\t\trtn_ref_src_sub_desc=\"\";\n\t}\n\n\tpolicy_coverage_basis_gbl_ind_from_main=document.forms[0].policy_coverage_basis_gbl_ind_from_main.value;\n\n\tpolicy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;\n\n\tif(policy_coverage_basis_gbl_ind_from_main==\"I\")\n\t{\n\t\tif(policy_coverage_basis_gbl_ind==\"P\")\n\t\t{\n\t\t\talert(getMessage(\"BL9729\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t}\n       var calling_module_id = parent.frames[1].document.forms[0].calling_module_id.value;\n\t   \n\t   var moduleIdValidation = checkModuleIdForPayerEligibility(calling_module_id);\n\t   \n\t   if(moduleIdValidation==\"Y\")\n\t\t{\n\t\t    var payerEligibility_check_arr=new Array();\n\t\t    var eligibilityCheck=false;\n\t\t    var alertMsgg=\"Payer Eligibility Check hasn\'t been done for the following                                     \\n\\n\";\n\t\t\t\n\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t{\n\t\t\t   var payerElgParam = eval(\"parent.frames[1].document.forms[0].payerEligibilityParam\"+i);\n\t\t\t   var ins_blng_grp_desc1_int2=eval(\"parent.frames[1].document.forms[0].ins_cust_group_name\"+i);\n\t\t\t   var blngGrpVal=ins_blng_grp_desc1_int2.value;\n\t\t\t   var ins_blng_grp_code12=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+i);\n\t\t\t   var ins_blng_grp_code2=ins_blng_grp_code12.value;\n\n\t\t\t    if(payerElgParam!=undefined)\n\t\t\t\t{\n\t\t\t\t   var payer_desc1_int=eval(\"parent.frames[1].document.forms[0].payer_desc\"+i);\n\t\t\t\t   var priority1_int=eval(\"parent.frames[1].document.forms[0].priority\"+i);\n\t\t\t\t   var policy_type_desc1_int=eval(\"parent.frames[1].document.forms[0].policy_type_desc\"+i);\n\t\t\t\t   \n\t\t\t\t   var payerElgParamValue=payerElgParam.value;\n\t\t\t\t   \n\t\t\t\t   var payerDescVal=payer_desc1_int.value;\n\t\t\t\t   var priorityVal=priority1_int.value;\n\t\t\t\t   var policyTypeVal=policy_type_desc1_int.value;\n\t\t\t\t\tif(payerElgParamValue == \"0\")\n\t\t\t\t\t{\n\t\t\t\t\t  eligibilityCheck=true;\n\t\t\t\t\t  alertMsgg=alertMsgg+\"Billing group: \"+blngGrpVal+\"      Payer: \"+payerDescVal+\"        Priority: \"+priorityVal+\"         Policy: \"+policyTypeVal+\"\\n\\n\";\n\t\t\t\t\t}\n\t\t\t\t\telse if(payerElgParamValue == \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar ins_cust_group_code_int = eval(\"parent.frames[1].document.forms[0].ins_cust_group_code\"+i);\n\t\t\t\t\t\tvar ins_cust_group_code_int_val = ins_cust_group_code_int.value;\n\n\t\t\t\t\t\tvar interfaceYNvalidate = checkCustomerGroupInterface(ins_cust_group_code_int_val);\n\t\t\t\t\t\t//alert(\"interfaceYNvalidate...\"+interfaceYNvalidate);\n\t\t\t\t\t\tif(interfaceYNvalidate ==\"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t  eligibilityCheck=true;\n\t\t\t\t\t\t  alertMsgg=alertMsgg+\"Billing group: \"+blngGrpVal+\"      Payer: \"+payerDescVal+\"        Priority: \"+priorityVal+\"         Policy: \"+policyTypeVal+\"\\n\\n\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t\tif(eligibilityCheck==true)\n\t\t\t{\n\t\t\t   alert(alertMsgg);\n\t\t\t   return false;\n\t\t\t}\n\t\t}\n\n\tfor(var i=0;i<total_records;i++)\n\t{\n\t\tvar rtn_ins_billing_group_desc1=eval(\"parent.frames[1].document.forms[0].billing_group_desc\"+i);\n\t\t\n\t\tif(rtn_ins_billing_group_desc1.value==null || rtn_ins_billing_group_desc1.value==\"\")\n\t\t{\n\t\t\trtn_ins_billing_group_desc1.value=\" \";\n\t\t}\n\t\trtn_ins_blng_grp_desc=rtn_ins_blng_grp_desc+rtn_ins_billing_group_desc1.value+\"|\";\n\n\t\tvar rtn_ins_blng_grp1=eval(\"parent.frames[1].document.forms[0].blng_grp_code\"+i);\n\t\tif(rtn_ins_blng_grp1.value==\"\" || rtn_ins_blng_grp1.value==null)\n\t\t{\n\t\t\trtn_ins_blng_grp1.value==\"\";\n\t\t}\n\t\trtn_ins_blng_grp=rtn_ins_blng_grp+rtn_ins_blng_grp1.value+\"|\";\n\n\t\tvar rtn_ins_payer_desc1=eval(\"parent.frames[1].document.forms[0].payer_desc\"+i);\n\t\tif(rtn_ins_payer_desc1.value==\"\" || rtn_ins_payer_desc1.value==null)\n\t\t{\n\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\trtn_ins_payer_desc=rtn_ins_payer_desc+rtn_ins_payer_desc1.value+\"|\";\n\n\t\tvar rtn_cust_31\t\t   = eval(\"parent.frames[1].document.forms[0].cust_3\"+i);\n\t\tif(rtn_cust_31.value==\"\" || rtn_cust_31.value==null)\n\t\t{\n\t\t\talert(getMessage(\"BL9532\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\trtn_ins_cust_code=rtn_ins_cust_code+rtn_cust_31.value+\"|\";\n\n\t\tvar rtn_priority1=eval(\"parent.frames[1].document.forms[0].priority\"+i);\n\t\tif(rtn_priority1.value==\"\" || rtn_priority1.value==null)\n\t\t{\n\t\t\talert(getMessage(\"BL9325\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\trtn_ins_cust_priority=rtn_ins_cust_priority+rtn_priority1.value+\"|\";\n\n\t\tvar rtn_policy_type_desc1=eval(\"parent.frames[1].document.forms[0].policy_type_desc\"+i);\n\t\tif(rtn_policy_type_desc1.value==\"\" || rtn_policy_type_desc1.value==null)\n\t\t{\n\t\t\talert(getMessage(\"BL9103\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\trtn_ins_policy_type_desc=rtn_ins_policy_type_desc+rtn_policy_type_desc1.value+\"|\";\n\n\t\tvar rtn_policy_type_code1=eval(\"parent.frames[1].document.forms[0].policy_type_code\"+i);\n\t\tif(rtn_policy_type_code1.value==\"\" || rtn_policy_type_code1.value==null)\n\t\t{\n\t\t\talert(getMessage(\"BL9103\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\trtn_ins_policy_type_code=rtn_ins_policy_type_code+rtn_policy_type_code1.value+\"|\";\n\t\t\t\n\t\tvar\trtn_policy_no1=eval(\"parent.frames[1].document.forms[0].policy_no\"+i);\n\t\tif(rtn_policy_no1.value==\"\" || rtn_policy_no1.value==null)\n\t\t{\n\t\t\trtn_policy_no1.value=\"\";\n\t\t\talert(getMessage(\"BL9104\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\trtn_ins_policy_no=rtn_ins_policy_no+rtn_policy_no1.value+\"|\";\n\n\t\tvar rtn_policy_start_date1=eval(\"parent.frames[1].document.forms[0].policy_start_date\"+i);\n\t\tvar rtn_ins_policy_start_date_temp=rtn_policy_start_date1.value;\n\t\tif(rtn_ins_policy_start_date_temp==null) rtn_ins_policy_start_date_temp=\"\";\n\t\tif(rtn_ins_policy_start_date_temp==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9324\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(rtn_ins_policy_start_date_temp!=\"\")\n\t\t{\n\t\t\trtn_ins_policy_start_date_temp=convertDate(rtn_ins_policy_start_date_temp,\"DMY\",locale,\"en\");\n\t\t}\n\t\trtn_ins_policy_start_date=rtn_ins_policy_start_date+rtn_ins_policy_start_date_temp+\"|\";\n\n\t\tvar rtn_policy_exp_date1=eval(\"parent.frames[1].document.forms[0].policy_exp_date\"+i);\n\t\tvar rtn_ins_policy_expiry_date_temp=rtn_policy_exp_date1.value;\n\t\tif(rtn_ins_policy_expiry_date_temp==null) rtn_ins_policy_expiry_date_temp=\"\";\n\t\tif(rtn_ins_policy_expiry_date_temp==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9105\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(rtn_ins_policy_expiry_date_temp!=\"\")\n\t\t{\n\t\t\trtn_ins_policy_expiry_date_temp=convertDate(rtn_ins_policy_expiry_date_temp,\'DMY\',locale,\"en\");\n\t\t}\n\t\trtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+rtn_ins_policy_expiry_date_temp+\"|\";\n\t\t\n\t\tvar rtn_ins_cred_auth_req_yn1 = eval(\"parent.frames[1].document.forms[0].cred_auth_req_yn\"+i);\n\t\tcred_auth_req_yn = rtn_ins_cred_auth_req_yn1.value;\n\t\trtn_ins_cred_auth_req_yn = rtn_ins_cred_auth_req_yn+cred_auth_req_yn+\"|\";\n\n\t\tvar rtn_ins_cred_auth_mand_capt_yn1 = eval(\"parent.frames[1].document.forms[0].cred_auth_mand_capt_yn\"+i);\n\t\tcred_auth_mand_capt_yn = rtn_ins_cred_auth_mand_capt_yn1.value;\n\t\trtn_ins_cred_auth_mand_capt_yn = rtn_ins_cred_auth_mand_capt_yn+cred_auth_mand_capt_yn+\"|\";\n\n\t\tvar rtn_ins_dflt_auth_ref_as_pol_no_yn1 = eval(\"parent.frames[1].document.forms[0].dflt_auth_ref_as_pol_no_yn\"+i);\n\t\tdflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn1.value;\n\n\t\trtn_ins_dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn+dflt_auth_ref_as_pol_no_yn+\"|\";\n\n\t\tif(cred_auth_req_yn ==\"Y\")\n\t\t{\n\t\t\tvar rtn_credit_auth_ref1 =eval(\"parent.frames[1].document.forms[0].credit_auth_ref\"+i);\n\t\t\tvar rtn_credit_auth_date1=eval(\"parent.frames[1].document.forms[0].credit_auth_date\"+i);\n\t\t\tvar rtn_ins_credit_auth_date_temp=rtn_credit_auth_date1.value;\n\t\t\tif(rtn_ins_credit_auth_date_temp==null) rtn_ins_credit_auth_date_temp=\"\";\n\n\t\t\tif(cred_auth_mand_capt_yn==\"Y\")\n\t\t\t{\n\t\t\t\tif(rtn_credit_auth_ref1.value==\"\" || rtn_credit_auth_ref1.value==null)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL8148\",\"BL\"));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\tif(rtn_ins_credit_auth_date_temp==\"\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9562\",\"BL\"));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\n\t\t\t\trtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+rtn_credit_auth_ref1.value+\"|\";\n\t\t\t\t\n\t\t\t\tif(rtn_ins_credit_auth_date_temp!=\"\")\n\t\t\t\t{\n\t\t\t\t\trtn_ins_credit_auth_date_temp=convertDate(rtn_ins_credit_auth_date_temp,\'DMY\',locale,\"en\");\n\t\t\t\t}\n\t\t\t\trtn_ins_credit_auth_date=rtn_ins_credit_auth_date+rtn_ins_credit_auth_date_temp+\"|\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(rtn_credit_auth_ref1.value==\"\" || rtn_credit_auth_ref1.value==null)\n\t\t\t\t{\n\t\t\t\t\trtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+\" \"+\"|\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\trtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+rtn_credit_auth_ref1.value+\"|\";\n\t\t\t\t}\n\n\t\t\t\tif(rtn_ins_credit_auth_date_temp!=\"\")\n\t\t\t\t{\n\t\t\t\t\trtn_ins_credit_auth_date_temp=convertDate(rtn_ins_credit_auth_date_temp,\'DMY\',locale,\"en\");\n\t\t\t\t\trtn_ins_credit_auth_date=rtn_ins_credit_auth_date+rtn_ins_credit_auth_date_temp+\"|\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\trtn_ins_credit_auth_date=rtn_ins_credit_auth_date+\" \"+\"|\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\trtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+\" \"+\"|\";\n\t\t\trtn_ins_credit_auth_date=rtn_ins_credit_auth_date+\" \"+\"|\";\n\t\t}\n\n\t\tvar rtn_restrict_check1=eval(\"parent.frames[1].document.forms[0].restrict_check\"+i);\n\t\trestrict_check=rtn_restrict_check1.value;\n\t\trtn_ins_restrict_check=rtn_ins_restrict_check+restrict_check+\"|\";\n\t\t\n\t\tvar apprd_amt_restrict_check1=eval(\"parent.frames[1].document.forms[0].apprd_amt_restrict_check\"+i);\n\t\tapprd_amt_restrict_check=apprd_amt_restrict_check1.value;\n\t\trtn_ins_apprd_amt_restrict_check=rtn_ins_apprd_amt_restrict_check+apprd_amt_restrict_check+\"|\";\n\t\t\n\t\tvar apprd_days_restrict_check1=eval(\"parent.frames[1].document.forms[0].apprd_days_restrict_check\"+i);\n\t\tapprd_days_restrict_check=apprd_days_restrict_check1.value;\n\t\trtn_ins_apprd_days_restrict_check=rtn_ins_apprd_days_restrict_check+apprd_days_restrict_check+\"|\";\n\t\t\n\t\tif(restrict_check==\"R\")\n\t\t{\n\t\t\tif(apprd_amt_restrict_check == \"R\")\n\t\t\t{\n\t\t\t\tvar rtn_credit_apprd_amt1=eval(\"parent.frames[1].document.forms[0].credit_apprd_amt\"+i);\n\t\t\t\tif(rtn_credit_apprd_amt1.value==\"\" || rtn_credit_apprd_amt1.value==null)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9564\",\"BL\"));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\trtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+rtn_credit_apprd_amt1.value+\"|\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\trtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+\" \"+\"|\";\n\t\t\t}\n\n\t\t\tif(apprd_days_restrict_check == \"R\")\n\t\t\t{\n\t\t\t\tvar rtn_credit_apprd_days1=eval(\"parent.frames[1].document.forms[0].credit_apprd_days\"+i);\n\t\t\t\tif(rtn_credit_apprd_days1.value==\"\" || rtn_credit_apprd_days1.value==null)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"BL9563\",\"BL\"));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\trtn_ins_credit_approval_days=rtn_ins_credit_approval_days+rtn_credit_apprd_days1.value+\"|\";\n\t\t\t}\n\t\t\telse\n\t\t\t{";
    private final static byte[]  _wl_block10_4Bytes = _getBytes( _wl_block10_4 );

    private final static java.lang.String  _wl_block10_5 ="\n\t\t\t\trtn_ins_credit_approval_days=rtn_ins_credit_approval_days+\" \"+\"|\";\n\t\t\t}\n\t\t}\n\t\telse if(restrict_check==\"U\")\n\t\t{\n\t\t\t\trtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+\" \"+\"|\";\n\t\t\t\trtn_ins_credit_approval_days=rtn_ins_credit_approval_days+\" \"+\"|\";\n\t\t}\n\n\t\tvar rtn_policy_eff_frm_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_frm_date\"+i);\n\t\tvar rtn_ins_policy_eff_from_date_temp=rtn_policy_eff_frm_date1.value;\n\t\tif(rtn_ins_policy_eff_from_date_temp==null) rtn_ins_policy_eff_from_date_temp=\"\";\n\t\tif(rtn_ins_policy_eff_from_date_temp==\"\" )\n\t\t{\n\t\t\talert(getMessage(\"BL9565\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(rtn_ins_policy_eff_from_date_temp!=\"\")\n\t\t{\n\t\t\trtn_ins_policy_eff_from_date_temp=convertDate(rtn_ins_policy_eff_from_date_temp,\'DMY\',locale,\"en\");\n\t\t}\n\t\trtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+rtn_ins_policy_eff_from_date_temp+\"|\";\n\n\t\tvar rtn_policy_eff_to_date1=eval(\"parent.frames[1].document.forms[0].policy_eff_to_date\"+i);\n\t\tvar rtn_ins_policy_eff_to_date_temp=rtn_policy_eff_to_date1.value;\n\t\tif(rtn_ins_policy_eff_to_date_temp==null) rtn_ins_policy_eff_to_date_temp=\"\";\n\t\tif(rtn_ins_policy_eff_to_date_temp==\"\" )\n\t\t{\n\t\t\trtn_ins_policy_eff_to_date_temp=\" \";\n\t\t}\n\t\tif(rtn_ins_policy_eff_to_date_temp!=\"\" && rtn_ins_policy_eff_to_date_temp!=\" \")\n\t\t{\n\t\t\trtn_ins_policy_eff_to_date_temp=convertDate(rtn_ins_policy_eff_to_date_temp,\'DMY\',locale,\"en\");\n\t\t}\n\t\trtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+rtn_ins_policy_eff_to_date_temp+\"|\";\n\n\t\tvar rtn_adj_rule_ind1=eval(\"parent.frames[1].document.forms[0].adj_rule_ind\"+i);\n\t\tvar adj_rule_ind1=rtn_adj_rule_ind1.value;\n\t\t\n\t\tif(adj_rule_ind1==null || adj_rule_ind1==\"\")\n\t\t{\n\t\t\tadj_rule_ind1=\" \";\n\t\t}\n\t\trtn_ins_adj_rule_ind=rtn_ins_adj_rule_ind+adj_rule_ind1+\"|\";\n\n\t\tvar rtn_adj_perc_amt_ind1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_ind\"+i);\n\t\tvar adj_perc_amt_ind1=rtn_adj_perc_amt_ind1.value;\n\t\tif(adj_perc_amt_ind1==null || adj_perc_amt_ind1==\"\")\n\t\t\t{\n\t\t\t\tadj_perc_amt_ind1=\" \";\n\t\t\t}\n\t\trtn_ins_adj_perc_amt_ind=rtn_ins_adj_perc_amt_ind+adj_perc_amt_ind1+\"|\";\n\t\t\t\n\t\tvar rtn_adj_perc_amt_value1=eval(\"parent.frames[1].document.forms[0].adj_perc_amt_value\"+i);\n\t\tvar adj_perc_amt_value1=rtn_adj_perc_amt_value1.value;\n\t\tif(adj_perc_amt_value1==null || adj_perc_amt_value1==\"\")\n\t\t{\n\t\t\tadj_perc_amt_value1=\" \";\n\t\t}\n\t\trtn_ins_adj_perc_amt_value=rtn_ins_adj_perc_amt_value+adj_perc_amt_value1+\"|\";\n\t\t\t\n\t\tvar rtn_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].pmnt_diff_adj_int\"+i);\n\t\tvar pmnt_diff_adj_int1=rtn_pmnt_diff_adj_int1.value;\n\t\tif(pmnt_diff_adj_int1==null || pmnt_diff_adj_int1==\"\")\n\t\t{\n\t\t\tpmnt_diff_adj_int1=\" \";\n\t\t}\n\t\trtn_ins_pmnt_diff_adj_int=rtn_ins_pmnt_diff_adj_int+pmnt_diff_adj_int1+\"|\";\n\n\t\tvar rtn_drg_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int\"+i);\n\t\tvar drg_pmnt_diff_adj_int1=rtn_drg_pmnt_diff_adj_int1.value;\n\t\tif(drg_pmnt_diff_adj_int1==null || drg_pmnt_diff_adj_int1==\"\")\n\t\t{\n\t\t\tdrg_pmnt_diff_adj_int1=\" \";\n\t\t}\n\t\trtn_ins_drg_pmnt_diff_adj_int=rtn_ins_drg_pmnt_diff_adj_int+drg_pmnt_diff_adj_int1+\"|\";\n\n\t\tvar rtn_spl_srv_pmnt_diff_adj_int1=eval(\"parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int\"+i);\n\t\tvar spl_srv_pmnt_diff_adj_int1=rtn_spl_srv_pmnt_diff_adj_int1.value;\n\t\tif(spl_srv_pmnt_diff_adj_int1==null || spl_srv_pmnt_diff_adj_int1==\"\")\n\t\t{\n\t\t\tspl_srv_pmnt_diff_adj_int1=\" \";\n\t\t}\n\t\trtn_ins_spl_srv_pmnt_diff_adj_int=rtn_ins_spl_srv_pmnt_diff_adj_int+spl_srv_pmnt_diff_adj_int1+\"|\";\n\n\t\tvar rtn_ins_valid_payer_YN1=eval(\"parent.frames[1].document.forms[0].valid_payer_YN\"+i);\n\t\tif(rtn_ins_valid_payer_YN1.value==\"N\")\n\t\t{\n\t\t\talert(getMessage(\"BL9588\",\"BL\")+\":\"+rtn_ins_payer_desc1.value);\n\t\t\treturn false;\n\t\t}\n\t\telse if(rtn_ins_valid_payer_YN1.value==\"Y\")\n\t\t{\n\t\t\tvar payer_suspended_YN1=eval(\"parent.frames[1].document.forms[0].payer_suspended_YN\"+i);\n\t\t\tif(payer_suspended_YN1.value==\"S\")\n\t\t\t{\n\t\t\t\tvar ins_payer_desc1=eval(\"parent.frames[1].document.forms[0].payer_desc\"+i);\n\t\t\t\talert(getMessage(\"BL7435\",\"BL\")+\":\"+rtn_ins_payer_desc1.value);\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\n\t\trtn_ins_valid_payer_YN=rtn_ins_valid_payer_YN+rtn_ins_valid_payer_YN1.value+\"|\";\n\n\t\tvar rtn_ins_valid_policy_type_code_YN1=eval(\"parent.frames[1].document.forms[0].valid_policy_type_code_YN\"+i);\n\t\tif(rtn_ins_valid_policy_type_code_YN1.value==\"N\")\n\t\t{\n\t\t\talert(getMessage(\"BL9589\",\"BL\")+\":\"+rtn_policy_type_desc1.value);\n\t\t\treturn false;\n\t\t}\n\t\telse if(rtn_ins_valid_policy_type_code_YN1.value==\"Y\")\n\t\t{\n\t\t\tvar policy_suspended_YN1=eval(\"parent.frames[1].document.forms[0].policy_suspended_YN\"+i);\n\n\t\t\tif(policy_suspended_YN1.value==\"S\")\n\t\t\t{\n\t\t\t\tvar policy_type_desc1=eval(\"parent.frames[1].document.forms[0].policy_type_desc\"+i);\n\t\t\t\talert(getMessage(\"BL7436\",\"BL\")+\":\"+rtn_policy_type_desc1.value);\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\n\t\trtn_ins_valid_policy_type_code_YN=rtn_ins_valid_policy_type_code_YN+rtn_ins_valid_policy_type_code_YN1.value+\"|\";\n\n\t\tvar rtn_ins_cust_group_code1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_code\"+i);\n\t\tif(rtn_ins_cust_group_code1.value==\"\" || rtn_ins_cust_group_code1.value==null)\n\t\t{\n\t\t\trtn_ins_cust_group_code1.value=\" \";\n\t\t}\n\t\trtn_ins_cust_group_code=rtn_ins_cust_group_code+rtn_ins_cust_group_code1.value+\"|\";\n\n\t\tvar rtn_ins_cust_group_name1=eval(\"parent.frames[1].document.forms[0].ins_cust_group_name\"+i);\n\t\tif(rtn_ins_cust_group_name1.value==\"\" || rtn_ins_cust_group_name1.value==null)\n\t\t{\n\t\t\trtn_ins_cust_group_name1.value=\" \";\n\t\t}\n\t\trtn_ins_cust_group_name=rtn_ins_cust_group_name+rtn_ins_cust_group_name1.value+\"|\";\n\n\t\tvar rtn_ins_policy_coverage_basis_ind1=eval(\"parent.frames[1].document.forms[0].policy_coverage_basis_ind\"+i);\n\t\tvar policy_coverage_basis_ind=rtn_ins_policy_coverage_basis_ind1.value;\n\n\t\tif(policy_coverage_basis_ind==null || policy_coverage_basis_ind==\"\")\n\t\t{\n\t\t\tpolicy_coverage_basis_ind=\" \";\n\t\t}\n\t\trtn_ins_policy_coverage_basis_ind=rtn_ins_policy_coverage_basis_ind+policy_coverage_basis_ind+\"|\";\n\n\t\t //Added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check\n\t\t\tvar payerEligibilityParamSession1=eval(\"parent.frames[1].document.forms[0].payerEligibilityParam\"+i);\n\t\t\t if(payerEligibilityParamSession1!=undefined)\n\t\t\t {\n               rtn_payerEligibilityParamSession=rtn_payerEligibilityParamSession+payerEligibilityParamSession1.value+\"|\";\n\t\t\t }\n\t\t\tvar responseCode1=eval(\"parent.frames[1].document.forms[0].responseCode\"+i);\n\t\t\tif(responseCode1!=undefined)\n\t\t\t {\n               rtn_responseCode=rtn_responseCode+responseCode1.value+\"|\";\n\t\t\t }\n\n\t\t\tvar responseCodeDesc1=eval(\"parent.frames[1].document.forms[0].responseCodeDesc\"+i);\n\t\t\tif(responseCodeDesc1!=undefined)\n\t\t\t {\n               rtn_responseCodeDesc=rtn_responseCodeDesc+responseCodeDesc1.value+\"|\";\n\t\t\t }\n\n\t\t\tvar statuDescription1=eval(\"parent.frames[1].document.forms[0].statuDescription\"+i);            \n\t\t\tif(statuDescription1!=undefined)\n\t\t\t {\n               rtn_statuDescription=rtn_statuDescription+statuDescription1.value+\"|\";\n\t\t\t }\n\n\t\t\tvar validityPeriod1=eval(\"parent.frames[1].document.forms[0].validityPeriod\"+i);\n\t\t\tif(validityPeriod1!=undefined)\n\t\t\t {\n               rtn_validityPeriod=rtn_validityPeriod+validityPeriod1.value+\"|\";\n\t\t\t }\n\n\t\t\tvar validityPeriodDesc1=eval(\"parent.frames[1].document.forms[0].validityPeriodDesc\"+i);            \n\t\t\tif(validityPeriodDesc1!=undefined)\n\t\t\t {\n               rtn_validityPeriodDesc=rtn_validityPeriodDesc+validityPeriodDesc1.value+\"|\";\n\t\t\t }\n\n\t\t\tvar eligibilityCode1=eval(\"parent.frames[1].document.forms[0].eligibilityCode\"+i);            \n\t\t\tif(eligibilityCode1!=undefined)\n\t\t\t {\n               rtn_eligibilityCode=rtn_eligibilityCode+eligibilityCode1.value+\"|\";\n\t\t\t }\n\n\t\t\tvar transactionId1=eval(\"parent.frames[1].document.forms[0].transactionId\"+i);            \n\t\t\tif(transactionId1!=undefined)\n\t\t\t {\n               rtn_transactionId=rtn_transactionId+transactionId1.value+\"|\";\n\t\t\t }\n\n\t\t\tvar responseDateTime1=eval(\"parent.frames[1].document.forms[0].responseDateTime\"+i);            \n\t\t\tif(responseDateTime1!=undefined)\n\t\t\t {\n               rtn_responseDateTime=rtn_responseDateTime+responseDateTime1.value+\"|\";\n\t\t\t }\n\n\t\t\t//above code was added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check\n\t\t\t\n\t\t\t//V232504\n\t\t\tvar mcn_for_policy_val=eval(\"parent.frames[1].document.forms[0].mcn_for_policy\"+i);            \n\t\t\tif(mcn_for_policy_val!=undefined)\n\t\t\t {\n               rtn_mcn_for_policy=rtn_mcn_for_policy+mcn_for_policy_val.value+\"|\";\n\t\t\t }\n\t\t\t\n\t\t\t//V232504\n\t\t\tvar reg_ref_id_val=eval(\"parent.frames[1].document.forms[0].reg_ref_id\"+i);            \n\t\t\tif(reg_ref_id_val!=undefined)\n\t\t\t {\n               rtn_reg_ref_id=rtn_reg_ref_id+reg_ref_id_val.value+\"|\";\n\t\t\t }\n\n\t}\n\n\tdocument.forms[0].total_records.value=total_records;\n\tdocument.forms[0].rtn_ins_blng_grp_desc.value=rtn_ins_blng_grp_desc;\n\tdocument.forms[0].rtn_ins_blng_grp.value=rtn_ins_blng_grp;\n\tdocument.forms[0].rtn_ins_payer_desc.value=rtn_ins_payer_desc;\n\tdocument.forms[0].rtn_ins_cust_code.value=rtn_ins_cust_code;\n\tdocument.forms[0].rtn_ins_cust_priority.value=rtn_ins_cust_priority;\n\tdocument.forms[0].rtn_ins_policy_type_desc.value=rtn_ins_policy_type_desc;\n\tdocument.forms[0].rtn_ins_policy_type_code.value=rtn_ins_policy_type_code;\n\tdocument.forms[0].rtn_ins_policy_no.value=rtn_ins_policy_no;\n\tdocument.forms[0].rtn_ins_policy_start_date.value=rtn_ins_policy_start_date;\n\tdocument.forms[0].rtn_ins_policy_expiry_date.value=rtn_ins_policy_expiry_date;\n\tdocument.forms[0].rtn_ins_credit_auth_ref.value=rtn_ins_credit_auth_ref;\n\tdocument.forms[0].rtn_ins_credit_auth_date.value=rtn_ins_credit_auth_date;\n\n\tdocument.forms[0].rtn_ins_cred_auth_req_yn.value=rtn_ins_cred_auth_req_yn;\n\n\tdocument.forms[0].rtn_ins_cred_auth_mand_capt_yn.value=rtn_ins_cred_auth_mand_capt_yn;\n\t\n\tdocument.forms[0].rtn_ins_dflt_auth_ref_as_pol_no_yn.value=rtn_ins_dflt_auth_ref_as_pol_no_yn;\n\n\tdocument.forms[0].rtn_ins_credit_approval_days.value=rtn_ins_credit_approval_days;\n\tdocument.forms[0].rtn_ins_credit_approval_amount.value=rtn_ins_credit_approval_amount;\n\tdocument.forms[0].rtn_ins_policy_eff_from_date.value=rtn_ins_policy_eff_from_date;\n\tdocument.forms[0].rtn_ins_policy_eff_to_date.value=rtn_ins_policy_eff_to_date;\n\tdocument.forms[0].rtn_ins_adj_rule_ind.value=rtn_ins_adj_rule_ind;\n\tdocument.forms[0].rtn_ins_adj_perc_amt_ind.value=rtn_ins_adj_perc_amt_ind;\n\tdocument.forms[0].rtn_ins_adj_perc_amt_value.value=rtn_ins_adj_perc_amt_value;\n\tdocument.forms[0].rtn_ins_pmnt_diff_adj_int.value=rtn_ins_pmnt_diff_adj_int;\tdocument.forms[0].rtn_ins_drg_pmnt_diff_adj_int.value=rtn_ins_drg_pmnt_diff_adj_int;\n\tdocument.forms[0].rtn_ins_spl_srv_pmnt_diff_adj_int.value=rtn_ins_spl_srv_pmnt_diff_adj_int;\n\tdocument.forms[0].rtn_ins_restrict_check.value=rtn_ins_restrict";
    private final static byte[]  _wl_block10_5Bytes = _getBytes( _wl_block10_5 );

    private final static java.lang.String  _wl_block10_6 ="_check;\n\tdocument.forms[0].rtn_ins_apprd_amt_restrict_check.value=rtn_ins_apprd_amt_restrict_check;\n\tdocument.forms[0].rtn_ins_apprd_days_restrict_check.value=rtn_ins_apprd_days_restrict_check;\n\tdocument.forms[0].rtn_ins_valid_payer_YN.value=rtn_ins_valid_payer_YN;\n\tdocument.forms[0].rtn_ins_valid_policy_type_code_YN.value=rtn_ins_valid_policy_type_code_YN;\n\tdocument.forms[0].rtn_ins_cust_group_code.value=rtn_ins_cust_group_code;\n\tdocument.forms[0].rtn_ins_cust_group_name.value=rtn_ins_cust_group_name;\n\tdocument.forms[0].rtn_ins_policy_coverage_basis_ind.value=rtn_ins_policy_coverage_basis_ind;\n\n\tdocument.forms[0].rtn_ref_src_main_code.value=rtn_ref_src_main_code;\n\tdocument.forms[0].rtn_ref_src_main_desc.value=rtn_ref_src_main_desc;\n\tdocument.forms[0].rtn_ref_src_sub_code.value=rtn_ref_src_sub_code;\n\tdocument.forms[0].rtn_ref_src_sub_desc.value=rtn_ref_src_sub_desc;\n\n\t//Added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check\n\t//AddModifyPatFinDetails.jsp\n\tdocument.forms[0].rtn_payerEligibilityParamSession.value=rtn_payerEligibilityParamSession;\n\tdocument.forms[0].rtn_responseCode.value=rtn_responseCode;\n\tdocument.forms[0].rtn_responseCodeDesc.value=rtn_responseCodeDesc;\n\tdocument.forms[0].rtn_statuDescription.value=rtn_statuDescription;\n\tdocument.forms[0].rtn_validityPeriod.value=rtn_validityPeriod;\n\tdocument.forms[0].rtn_validityPeriodDesc.value=rtn_validityPeriodDesc;\n\tdocument.forms[0].rtn_eligibilityCode.value=rtn_eligibilityCode;\n\tdocument.forms[0].rtn_transactionId.value=rtn_transactionId;\n\tdocument.forms[0].rtn_responseDateTime.value=rtn_responseDateTime;\n\t//above code was added by prithivi on 13/03/2017 for 0085 bupa insurance patient eligiblity check\n\t\n\t//V232504\n\tdocument.forms[0].rtn_mcn_for_policy.value=rtn_mcn_for_policy;\n\t//V232504\n\tdocument.forms[0].rtn_reg_ref_id.value=rtn_reg_ref_id;\n\t\n\t\n\tparent.window.returnValue = \"accept\";\n\tparent.frames[3].location.href=\'../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpSubmitValues.jsp\';\n\t\n\tvar showModalFrame = top.window.document.getElementById(\'dialog-body\').contentWindow;\t\n\tlet dialogBody = showModalFrame.document.getElementById(\'dialog-body\');\n\t\n    dialogBody.contentWindow.returnValue = \"accept\";\n\tconst dialogTag = showModalFrame.document.getElementById(\"dialog_tag\");  \n    dialogTag.close(); \n\n//\tparent.window.close();\n\t\n}\n</script>\n";
    private final static byte[]  _wl_block10_6Bytes = _getBytes( _wl_block10_6 );

    private final static java.lang.String  _wl_block11 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' type=\'text/css\'/></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../../eXH/js/ExternalApplication.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\n</head>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n<form name=\'\' id=\'\'>\n\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=\'center\' border=1>\n<tr  >\n\t\n\t<td>\n\t\t<input  type=\"button\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" class=\"button\" onClick=\"addPayer()\" >\n\t\t<input  type=\"button\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" class=\"button\" onClick=\"modifyPayer()\">\n\t\t<input  type=\"button\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" class=\"button\" onClick=\"removePayerNew()\">\n\n\n    </td>\n</tr>\n\n<tr>\n\t\n\t<td align=right>\n\t<input align=right type=\"button\" name=\"accept_button\" id=\"accept_button\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" class=\"button\" onClick=\'add_more_blng_grp()\' >\n\n\t<input align=right type=\"button\" name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" class=\"button\"  onClick=\'cancel()\' >\n\t</td>\n</tr>\n\n</table>\n\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'ins_auth_flag\' id=\'ins_auth_flag\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=hidden name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=hidden name=\"bl_data_from_repos_yn\" id=\"bl_data_from_repos_yn\" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\t\n<input type=hidden name=\"items_disabled\" id=\"items_disabled\" value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\t\n<input type=\'hidden\' name=\"calling_module_id\" id=\"calling_module_id\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\t\n<input type=hidden name=\"operation_fun\" id=\"operation_fun\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\t\n<input type=hidden name=\"operation_mode\" id=\"operation_mode\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\t\n<input type=\'hidden\' name=\'CitizenYn\' id=\'CitizenYn\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=hidden name=\'blnggrpappyn\' id=\'blnggrpappyn\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\t\t\n<input type=hidden name=\'blnggrpcatgappyn\' id=\'blnggrpcatgappyn\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=hidden name=\'BlngGrpStatus\' id=\'BlngGrpStatus\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=hidden name=\'mpolicy_type\' id=\'mpolicy_type\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type= hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type= hidden name=\"queryString\" id=\"queryString\"  value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type= hidden name=\"policy_coverage_basis_gbl_ind_from_main\" id=\"policy_coverage_basis_gbl_ind_from_main\"  value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\n<input type=\'hidden\' name=\'max_priority\' id=\'max_priority\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >\n\n<input type= hidden name=\"primary_blng_grp\" id=\"primary_blng_grp\"  value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type= hidden name=\"billing_group\" id=\"billing_group\"  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type= hidden name=\"p_patient_class\" id=\"p_patient_class\"  value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type= hidden name=\"facility_id\" id=\"facility_id\"  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\n<input type= hidden name=\"total_records\" id=\"total_records\" value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_blng_grp_desc\' id=\'rtn_ins_blng_grp_desc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_blng_grp\' id=\'rtn_ins_blng_grp\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_payer_desc\' id=\'rtn_ins_payer_desc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cust_code\' id=\'rtn_ins_cust_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cust_priority\' id=\'rtn_ins_cust_priority\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_type_desc\' id=\'rtn_ins_policy_type_desc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_type_code\' id=\'rtn_ins_policy_type_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_no\' id=\'rtn_ins_policy_no\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_start_date\' id=\'rtn_ins_policy_start_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_expiry_date\' id=\'rtn_ins_policy_expiry_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_credit_auth_ref\' id=\'rtn_ins_credit_auth_ref\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_credit_auth_date\' id=\'rtn_ins_credit_auth_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cred_auth_req_yn\' id=\'rtn_ins_cred_auth_req_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cred_auth_mand_capt_yn\' id=\'rtn_ins_cred_auth_mand_capt_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_dflt_auth_ref_as_pol_no_yn\' id=\'rtn_ins_dflt_auth_ref_as_pol_no_yn\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_credit_approval_days\' id=\'rtn_ins_credit_approval_days\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_credit_approval_amount\' id=\'rtn_ins_credit_approval_amount\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_eff_from_date\' id=\'rtn_ins_policy_eff_from_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_eff_to_date\' id=\'rtn_ins_policy_eff_to_date\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_adj_rule_ind\' id=\'rtn_ins_adj_rule_ind\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_adj_perc_amt_ind\' id=\'rtn_ins_adj_perc_amt_ind\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_adj_perc_amt_value\' id=\'rtn_ins_adj_perc_amt_value\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_pmnt_diff_adj_int\' id=\'rtn_ins_pmnt_diff_adj_int\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_drg_pmnt_diff_adj_int\' id=\'rtn_ins_drg_pmnt_diff_adj_int\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_spl_srv_pmnt_diff_adj_int\' id=\'rtn_ins_spl_srv_pmnt_diff_adj_int\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_restrict_check\' id=\'rtn_ins_restrict_check\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_apprd_amt_restrict_check\' id=\'rtn_ins_apprd_amt_restrict_check\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_apprd_days_restrict_check\' id=\'rtn_ins_apprd_days_restrict_check\' value=\"\">\n\n<input type=\'hidden\' name=\'rtn_ins_valid_payer_YN\' id=\'rtn_ins_valid_payer_YN\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_valid_policy_type_code_YN\' id=\'rtn_ins_valid_policy_type_code_YN\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cust_group_code\' id=\'rtn_ins_cust_group_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_cust_group_name\' id=\'rtn_ins_cust_group_name\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ins_policy_coverage_basis_ind\' id=\'rtn_ins_policy_coverage_basis_ind\' value=\"\">\n\n<input type=\'hidden\' name=\'rtn_ref_src_main_code\' id=\'rtn_ref_src_main_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_main_desc\' id=\'rtn_ref_src_main_desc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_sub_code\' id=\'rtn_ref_src_sub_code\' value=\"\">\n<input type=\'hidden\' name=\'rtn_ref_src_sub_desc\' id=\'rtn_ref_src_sub_desc\' value=\"\">\t\n\n<input type=\'hidden\' name=\'rtn_payerEligibilityParamSession\' id=\'rtn_payerEligibilityParamSession\' value=\"\">\n<input type=\'hidden\' name=\'rtn_responseCode\' id=\'rtn_responseCode\' value=\"\">\n<input type=\'hidden\' name=\'rtn_responseCodeDesc\' id=\'rtn_responseCodeDesc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_statuDescription\' id=\'rtn_statuDescription\' value=\"\">\n<input type=\'hidden\' name=\'rtn_validityPeriod\' id=\'rtn_validityPeriod\' value=\"\">\n<input type=\'hidden\' name=\'rtn_validityPeriodDesc\' id=\'rtn_validityPeriodDesc\' value=\"\">\n<input type=\'hidden\' name=\'rtn_eligibilityCode\' id=\'rtn_eligibilityCode\' value=\"\">\n<input type=\'hidden\' name=\'rtn_transactionId\' id=\'rtn_transactionId\' value=\"\">\n<input type=\'hidden\' name=\'rtn_responseDateTime\' id=\'rtn_responseDateTime\' value=\"\">\n\n<input type=\'hidden\' name=\'package_enabled_yn\' id=\'package_enabled_yn\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\n<input type=\'hidden\' name=\'encounter_date_time\' id=\'encounter_date_time\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\n<input type=\'hidden\' name=\'fin_class_flag_YN\' id=\'fin_class_flag_YN\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=\'hidden\' name=\'autoFinChk\' id=\'autoFinChk\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\' name=\'class_code\' id=\'class_code\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\n<input type=\'hidden\' name=\'rtn_mcn_for_policy\' id=\'rtn_mcn_for_policy\' value=\"\">  <!-- V232504 -->\n<input type=\'hidden\' name=\'rtn_reg_ref_id\' id=\'rtn_reg_ref_id\' value=\"\">  <!-- V232504 -->\n\n\n\n</form>\n</body>\n\n<script>\n\tparent.parent.frames[2].location.href=\"../../eCommon/html/blank.html\";\n</script>\n</html>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" \n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
Sr No        Version            Incident          SCF/CRF             Developer Name
1           V232504							SKR-SCF-1731-TF         Namrata Charate
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
	ResultSet rs4				= null;
	ResultSet rs5				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;

	String locale			= (String)session.getAttribute("LOCALE");

	try
	{
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
		//System.err.println("querstring  in grpbutton.jsp page:"+request.getQueryString());	
		String nd_settlement_ind ="", nd_adm_rec_flag ="",ins_auth_flag="";
		String package_enabled_yn="N";//added for package Billing
//Unused Var's

//		String slmt_type_code="", cash_slmt_flag="", cust_code1="";
//		String strSettlementDesc = "0";
//		String mcust_group_1="";

		String mcash_set_type1="", mcust_1="",  mcredit_doc_ref1="", mcredit_doc_date1="", mcredit_doc_start_date1="", mcust_2="";
		String mcredit_doc_ref2="", mcredit_doc_date2="",mcredit_doc_start_date2="", mcust_3="", mpolicy_type="", mpolicy_no="";
		String mpolicy_expiry_date="", mnon_insur_blng_grp="", sys_date="", sys_date_wht_sec="";
		String mcredit_auth_ref="", mcredit_auth_date="", mapp_days="",mapp_amount="",meff_frm_date="";	

		String fin_class_flag_YN="N",autoFinChk="N",class_code="",class_blng_grp_id="";

//		if( billing_group == null) billing_group="";
		String primary_blng_grp=request.getParameter("primary_blng_grp");
		if(primary_blng_grp == null) primary_blng_grp="";
		String facility_id = (String)httpSession.getValue("facility_id");
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";	
		String billing_group=request.getParameter("billing_group");
		if(billing_group == null) billing_group="";
		String rtn_non_ins_blng_grp="", encounter_date_time = ""; 
		String queryString=(request.getQueryString());
		String p_patient_class=request.getParameter("patient_class");
		String policy_coverage_basis_gbl_ind_from_main=request.getParameter("policy_coverage_basis_gbl_ind_from_main");
		if(policy_coverage_basis_gbl_ind_from_main==null) policy_coverage_basis_gbl_ind_from_main="";

		String str_max_priority=request.getParameter("max_priority");
		if(str_max_priority == null || str_max_priority.equals("")) str_max_priority="0";

		int max_priority=Integer.parseInt(str_max_priority);

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="";

		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";

//		System.out.println("encounter_date_time from Interface Module in MultiBlngGrpButton.jsp:"+encounter_date_time);		
/*
		if(((billing_mode.equals("Modify")) || (operation.equals("Update"))) &&(primary_blng_grp.equals("")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				billing_group=((String)bl_data.get("blng_grp")).trim();
				rtn_non_ins_blng_grp=((String)bl_data.get("non_ins_blng_grp")).trim();
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");		
		}
*/
		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}

		String strdfltbgyn = "N";
		String srtencdfltbgyn="N";
		String bl_future_admn_YN="";

		String strBlngGrpAppYN= "Y";
		String strBlngGrpStatus="";
		String strBlngGrpCatgAppYN = "Y";		

		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		String clinic_code = request.getParameter("clinic_code");
		String visit_type_code = request.getParameter("visit_type_code");
		String strshowHideBlngClass = request.getParameter("show_hide_blng_class");

		package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";

		String l_credit_doc_ref_desc = "";
		String l_credit_doc_ref_start_date = "";
		String l_credit_doc_ref_date =  "";
		String l_cust_code = "";
		String l_slmt_ind = "";
		String l_adm_rec_flag = "";

		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

//Unused Var's
/*
		String strCategory = "";
		String str_blng_grp_id = "";
		String str_short_desc = "";	

		String cust_code_1 = "";
		String short_name_1 = "";

		String cust_code_2 = "";
		String short_name_2 = "";
*/
		String patient_id = request.getParameter("patient_id");		
		if (patient_id == null ) patient_id = "";

		String strCitizenYn = "N";		
		String nationalityyn = "";

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs4 = stmt.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date = rs4.getString(1);
					sys_date_wht_sec = rs4.getString(2);
				}
			}
			if(rs4 != null) rs4.close();
			stmt.close();
/*
			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs4 = stmt.executeQuery(query_date) ;
			if( rs4 != null ) 
			{
				while( rs4.next() )
				{  
					sys_date_wht_sec = rs4.getString(1);
				}
			}
			if(rs4 !=null) rs4.close();
			stmt.close();
*/
		}
		catch(Exception e)
		{
			out.println("Exception in sysdate query :"+e);
		}

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

		if(!patient_id.equals(""))
		{
			String sqlCiti = "select citizen_yn from mp_patient where patient_id = ? ";
			pstmt = con.prepareStatement(sqlCiti);
			pstmt.setString(1,patient_id);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() )
				{  
					strCitizenYn = rs2.getString("citizen_yn");
				}
			}
			if(rs2 != null) rs2.close();
			pstmt.close();	
		}
/*
		String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg,nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N'),to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') last_enc_bg from bl_mp_param ";
		pstmt = con.prepareStatement(sql0);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{
			while( rs2.next() )
			{  
				strdfltbgyn = rs2.getString("bg");
				srtencdfltbgyn=rs2.getString("last_enc_bg");
				sys_date = rs2.getString(3);
				sys_date_wht_sec = rs2.getString(4);
			}
		}
		if(rs2 != null) rs2.close();
		pstmt.close();		

		if ( strdfltbgyn == null) strdfltbgyn = "N";
		if ( srtencdfltbgyn == null) srtencdfltbgyn="N";

		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;
*/
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
		if(rs5 != null) rs5.close();
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
		String strFunctionId=request.getParameter("calling_function_id");
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
		if(strFunctionId==null)
		{
			strFunctionId="";
		}
		
		if(bl_future_admn_YN.equals("Y") && ((strModuleId.equals("IP") || strModuleId.equals("DC")) && strFunctionId.equals("ADMISSION")))
		{	
			System.out.println("Inside the Future Admn Check in InsButton.jsp");
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

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{

			mcash_set_type1		= request.getParameter("cash_set_type1");
			if ( mcash_set_type1 == null ) mcash_set_type1 ="";			
			

			mcust_1				= request.getParameter("cust_1");
			if (mcust_1 == null) mcust_1 = "";
			

			mcredit_doc_ref1	= request.getParameter("credit_doc_ref1");
			if ( mcredit_doc_ref1 == null ) mcredit_doc_ref1 = "";	
			

			mcredit_doc_date1	= request.getParameter("credit_doc_date1");
			if ( mcredit_doc_date1 == null ) mcredit_doc_date1 ="";			


			mcredit_doc_start_date1	= request.getParameter("credit_doc_start_date1");
			if ( mcredit_doc_start_date1 == null ) mcredit_doc_start_date1 = "";

			

			mcust_2				= request.getParameter("cust_2");
			if ( mcust_2 == null ) mcust_2 = "";			

			mcredit_doc_ref2	= request.getParameter("credit_doc_ref2");
			if ( mcredit_doc_ref2 == null ) mcredit_doc_ref2 = "";

			mcredit_doc_date2	= request.getParameter("credit_doc_date2");
			if ( mcredit_doc_date2 == null ) mcredit_doc_date2 = "";
			

			mcredit_doc_start_date2	= request.getParameter("credit_doc_date0");
			if ( mcredit_doc_start_date2 == null ) mcredit_doc_start_date2 = "";
			if(mcredit_doc_start_date2.equals(""))
			{
			mcredit_doc_start_date2	= request.getParameter("credit_doc_start_date2");
			if ( mcredit_doc_start_date2 == null ) mcredit_doc_start_date2 = "";
			}
				
			
			mcust_3	= request.getParameter("cust_3");
			if ( mcust_3 == null ) mcust_3 = "";

			mpolicy_type		= request.getParameter("policy_type");
			if ( mpolicy_type == null ) mpolicy_type = "";
			

			mpolicy_no			= request.getParameter("policy_no");
			if ( mpolicy_no == null ) mpolicy_no ="";

			mpolicy_expiry_date = request.getParameter("policy_expiry_date");
			if ( mpolicy_expiry_date == null ) mpolicy_expiry_date = "";
			

//			mnon_insur_blng_grp = request.getParameter("non_insur_blng_grp");
			mnon_insur_blng_grp = rtn_non_ins_blng_grp;
			if ( mnon_insur_blng_grp == null ) mnon_insur_blng_grp = "";

			mcredit_auth_ref	= request.getParameter("credit_auth_ref");
			if ( mcredit_auth_ref == null ) mcredit_auth_ref = "";

			
			mcredit_auth_date	= request.getParameter("credit_auth_date");
			if ( mcredit_auth_date == null ) mcredit_auth_date = "";			

			mapp_days			= request.getParameter("app_days");
			if  ( mapp_days == null ) mapp_days = ""; 

			mapp_amount			= request.getParameter("app_amount");
			if ( mapp_amount == null ) mapp_amount = "";

			meff_frm_date		= request.getParameter("eff_frm_date");
			if ( meff_frm_date == null ) meff_frm_date = "";

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
		if(rs != null) rs.close();
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);
            _bw.write(_wl_block10_2Bytes, _wl_block10_2);
            _bw.write(_wl_block10_3Bytes, _wl_block10_3);
            _bw.write(_wl_block10_4Bytes, _wl_block10_4);
            _bw.write(_wl_block10_5Bytes, _wl_block10_5);
            _bw.write(_wl_block10_6Bytes, _wl_block10_6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);

if((billing_mode.equals("Modify")) || (operation.equals("Update")))
{

            _bw.write(_wl_block13Bytes, _wl_block13);

}
else
{

            _bw.write(_wl_block14Bytes, _wl_block14);

}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_MORE_PAYERS.label","bl_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.MODIFY_PAYER.label","bl_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.REMOVE_PAYER.label","bl_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ins_auth_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strCreditDoc_YN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strRepositoryYN));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strItemsDisabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(billing_mode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strCitizenYn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strBlngGrpAppYN));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strBlngGrpCatgAppYN));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strBlngGrpStatus));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mpolicy_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(policy_coverage_basis_gbl_ind_from_main));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(max_priority));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(primary_blng_grp));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(package_enabled_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounter_date_time));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fin_class_flag_YN));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(autoFinChk));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block48Bytes, _wl_block48);

	}
	catch(Exception e )
	{ 
		out.println(e);
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
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
}
