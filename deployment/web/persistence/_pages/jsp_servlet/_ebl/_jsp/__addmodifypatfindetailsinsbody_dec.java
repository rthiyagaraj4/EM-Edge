package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.google.gson.JsonObject;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import eBL.Common.*;
import com.ehis.util.*;
import java.text.*;
import eXH.InterfaceUtil;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetailsinsbody_dec extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsInsBody_Dec.jsp", 1744005966757L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script>\n/* karthik added the below function to provide the link for Policy Definition 38144\tMMS-QH-CRF-0082 - starts*/\n /*\nSr No        Version           Incident        SCF/CRF               Developer Name\n-----------------------------------------------------------------------------------\n1            V210629             19794        MMS-ME-SCF-0025-TF     Mohana priya K\n2\t\t\t V220908\t\t\t\t\t\t\tTH-KW-CRF-0093 \t\t\tNamrata Charate\n3\t\t\t V230315\t\t\t\t\t\t\tMMS-DM-CRF-0209.5\t\tNamrata Charate\n4\t\t\t V232504\t\t\t\t\t\t\tSKR-SCF-1731-TF         Namrata Charate\n5\t\t\t V230707\t\t\t\t\t\t\tAAKH-CRF-0142.1\t\t\tNamrata Charate\n*/\nasync function callPolicyDetails(count){\n\tvar dialogHeight= \"34\" ;\n\tvar dialogWidth\t= \"84\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status: \" + status + \"; scroll=auto; \";\n\tvar arguments\t= \"\" ;\t \n\t\n\tvar ins_cust_group_name = eval(\"document.add_modify_pat_fin_det_insmain.ins_cust_group_code\"+count);\n\tvar payerGroup=ins_cust_group_name.value;\n\tvar cust_3 = eval(\"document.add_modify_pat_fin_det_insmain.cust_3\"+count);\n\tvar payerCode=cust_3.value;\n\tvar policy_type_code = eval(\"document.add_modify_pat_fin_det_insmain.policy_type_code\"+count);\n\tvar policy=policy_type_code.value;\n\tvar policy_start_date = eval(\"document.add_modify_pat_fin_det_insmain.policy_start_date\"+count);\n\tvar startDate=policy_start_date.value;\n\tvar policy_exp_date = eval(\"document.add_modify_pat_fin_det_insmain.policy_exp_date\"+count);\n\tvar endDate=policy_exp_date.value;\n\tvar priority_form = eval(\"document.add_modify_pat_fin_det_insmain.priority\"+count);\n\tvar priority=priority_form.value;\n\tvar policy_no = eval(\"document.add_modify_pat_fin_det_insmain.policy_no\"+count);\n\tvar policyNo=policy_no.value;\n\tvar episodeType=document.add_modify_pat_fin_det_insmain.episode_type.value;\n\n\t// Patient Id Parameter is passed as null to get Policy Details, If patient_id,episode_id,visit_id,acctseq  is given then Encounter specific Policy Defn will be Loaded\n\tvar queryParams=\'mode=modify&patinetId=&payergroupCode=\'+ payerGroup  +\n\t\'&payerCode=\'+payerCode+\'&policyCode=\'+policy+\'&startDate=\'+startDate+\'&endDate=\'+endDate+\'&visitId=\'+\'&acctSeq=&priority=\'+priority+\n\t\'&policyNo=\'+policyNo+\'&episodeType=\'+episodeType+\'&episodeId=\'+\'&auth=N\';\n\t\t\n\tvar retVal =await window.showModalDialog(\'../../eBL/jsp/RcrdApprovalPolicyDefinitionMainFrame.jsp?\'+queryParams,arguments,features);\n}\n/* karthik added the below function to provide the link for Policy Definition 38144\tMMS-QH-CRF-0082 - ends*/\n</script>\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<STYLE TYPE=\"text/CSS\">\n\n.BACKGROUND {\n  BACKGROUND-COLOR: RED;\n}\n/* This style is used for locking the table\'s heading  */\ndiv#tbl-container {\nwidth: 1020px;\nheight: 234px;\noverflow: auto;\n}\nthead td, thead td.locked\t{\nposition:relative;\n}\nthead td {\ntop: expression(document.getElementById(\"tbl-container\").scrollTop-2); \nz-index: 20;\n}\n</STYLE>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/AddModifyPatFinDetails.js\"></script>\n<script language=\"javascript\" src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\n//Added By Vijay for MMS-QF-SCf-567\n$(document).ready(function()\n\t\t{\t\t\n\t\t\tvar totRec=$(\'#totRec\').val();\n\t\t\tvar msg=\'\';\n\t\t\t\n\t\t\tvar siteSpec=$(\'#siteSpec\').val();\n\t\t\tif(siteSpec==\"true\"){\n\t\t\tfor(var i=0;i<totRec;i++)\n\t\t\t\t{\n\t\t\t\t\tvar tmp_pol_eff_to=$(\'#tmp_pol_eff_to\'+i).val();\n\t\t\t\t\tif(tmp_pol_eff_to==null||tmp_pol_eff_to==\'null\')\n\t\t\t\t\ttmp_pol_eff_to=\'\';\n\t\t\t\t\tif(tmp_pol_eff_to==\'\')\n\t\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t\tmsg+=\"message\";\n\t\t\t\t\t\t//alert(\'Expiry date for\' +payerGrp+ \'is not available in the Policy setup\');\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\n\t\t\tif(msg!=\'\'){alert(\'Expiry date is not available in the Policy setup\');}\n\t\t\t}\n\t\t\t\n\t\t\t});\n</script>\n\n\n<script>\n\n\nfunction check(i)\n{\n\tdocument.add_modify_pat_fin_det_insmain.focussed_row.value=i;\n}\n\nfunction selected(i)\n{\n\tvar selected_row=eval(\"document.forms[0].selected_row\"+i);\n\tif(selected_row.checked==false)\n\t{\n\t\tselected_row.checked=false;\n\t\tdocument.add_modify_pat_fin_det_insmain.checked_row.value=\"\";\n\t}\n\telse\n\t{\n\t\tvar total_records=document.forms[0].total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"document.forms[0].selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\t\tselected_row.checked=true;\n\t\tdocument.add_modify_pat_fin_det_insmain.checked_row.value=i;\n\t}\n}\n\nfunction policy_coverage_basis_ind()\n{\n\tvar totalRecords=document.forms[0].total_records.value;\n\tif(totalRecords!=0)\n\t{\n\t\tfor(var i=0;i<totalRecords;i++)\n\t\t{\n\t\t\tvar valid_payer_YN=eval(\"document.forms[0].valid_payer_YN\"+i);\n\t\t\tvar valid_policy_type_code_YN=eval(\"document.forms[0].valid_policy_type_code_YN\"+i);\n\n\t\t\tif(valid_payer_YN.value == \"Y\" && valid_policy_type_code_YN.value == \"Y\")\n\t\t\t{\n\t\t\t\tvar policy_cov_basis_ind=eval(document.getElementById(\"policy_coverage_basis_\"+i));\n\t\t\t\tvar policy_cov_basis_ind_val=eval(\"document.forms[0].policy_coverage_basis_ind\"+i);\n\t\t\t\tif(policy_cov_basis_ind_val.value==\"P\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_cov_basis_ind.innerText=getLabel(\"eBL.PATIENT_BASED.label\",\"BL\");\n\t\t\t\t}\n\t\t\t\telse if(policy_cov_basis_ind_val.value==\"I\")\n\t\t\t\t{\n\t\t\t\t\tpolicy_cov_basis_ind.innerText=getLabel(\"eBL.PAYER_BASED.label\",\"BL\");\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction ref_src_check()\n{\n\tvar refresh_check=document.forms[0].refresh_check.value;\n\tvar total_records=document.forms[0].total_records.value;\n\tvar valid_pkg_for_pat_bg_avail_YN = document.forms[0].valid_pkg_for_pat_bg_avail_YN.value;\n\tvar patient_id = document.forms[0].patient_id.value;\n\n\tif(refresh_check==\"Y\")\n\t{\n\t\tvar cap_ref_src_dtl_flag=document.forms[0].cap_ref_src_dtl_flag.value;\n\t\tvar pmry_ref_src_mand_YN=document.forms[0].referral_source_main_mand_YN.value;\n\t\tvar sec_ref_src_mand_YN=document.forms[0].referral_source_sub_mand_YN.value;\n\t\tvar pr_payer_employer_id_mand_YN = document.forms[0].pr_payer_employer_id_mand_YN.value;\n\t\tvar capture_employer_id_yn = parent.parent.parent.frames[0].document.forms[0].capture_employer_id_yn.value;\n\n\t\tif(cap_ref_src_dtl_flag==\"Y\")\n\t\t{\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_main_leg_disp\").style.display=\"inline\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_main_val_disp\").style.display=\"inline\";\n\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value=\"\";\n\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value=\"\";\n\t\t\tif(pmry_ref_src_mand_YN == \"Y\")\n\t\t\t{\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_main_mand_disp\").style.display=\"inline\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_main_mand_disp\").style.display=\"none\";\n\t\t\t}\n\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_sub_leg_disp\").style.display=\"inline\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_sub_val_disp\").style.display=\"inline\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"referral_source_sub_code\").value=\"\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"referral_source_sub_desc\").value=\"\";\n\t\t\tif(sec_ref_src_mand_YN == \"Y\")\n\t\t\t{\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_sub_mand_disp\").style.display=\"inline\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_sub_mand_disp\").style.display=\"none\";\n\t\t\t}\n\n\t\t\tparent.parent.parent.frames[0].document.forms[0].cap_ref_src_dtl_flag.value=\"Y\";\n\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;\n\t\t\tif(total_records > 0)\n\t\t\t{\n\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t{\n\t\t\t\t\tvar temp_blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\tif(temp_blng_grp_code1.value == parent.parent.parent.frames[0].document.forms[0].billing_group.value)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar ref_src_main_code1=eval(\"document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"referral_source_main_code\").value=ref_src_main_code1.value;\n\n\t\t\t\t\t\tvar ref_src_main_desc1=eval(\"document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"referral_source_main_desc\").value=ref_src_main_desc1.value;\n\n\t\t\t\t\t\tvar ref_src_sub_code1=eval(\"document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"referral_source_sub_code\").value=ref_src_sub_code1.value;\n\n\t\t\t\t\t\tvar ref_src_sub_desc1=eval(\"document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"referral_source_sub_desc\").value=ref_src_sub_desc1.value;\n\n\t\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(document.getElementById(\"pmy_ref_src_lng_name_\"+i));\n\n\t\t\t\t\t\t\tif(pmy_ref_src_lng_name.alt != \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"visible\";\n\t\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").alt=pmy_ref_src_lng_name.alt;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").alt=\"\";\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\tvar sec_ref_src_lng_name = document.getElementById(\"sec_ref_src_lng_name_\"+i);\n\n\t\t\t\t\t\t\tif(sec_ref_src_lng_name.alt != \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").style.visibility=\"visible\";\n\t\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").alt=sec_ref_src_lng_name.alt;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").alt=\"\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse if(cap_ref_src_dtl_flag==\"N\")\n\t\t{\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_main_leg_disp\").style.display=\"none\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_main_val_disp\").style.display=\"none\";\n\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value=\"\";\n\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value=\"\";\n\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_sub_leg_disp\").style.display=\"none\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"ref_src_code_sub_val_disp\").style.display=\"none\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"referral_source_sub_code\").value=\"\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"referral_source_sub_desc\").value=\"\";\n\n\t\t\tparent.parent.parent.frames[0].document.forms[0].cap_ref_src_dtl_flag.value=\"N\";\n\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;\n\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;\n\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").alt=\"\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").alt=\"\";\n\t\t}\n\t\t\n\t\tif(capture_employer_id_yn == \'Y\')\n\t\t{\n\t\t\tif(document.forms[0].pr_payer_employer_id_mand_YN.value == \'Y\')\n\t\t\t{\n\t\t\t\tparent.parent.parent.frames[0].document.forms[0].PAYER_EMP_ID_MAND_YN.value = \"Y\";\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"emp_id_mand_YN_disp\").style.display=\'inline\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.parent.parent.frames[0].document.forms[0].PAYER_EMP_ID_MAND_YN.value = \"N\";\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"emp_id_mand_YN_disp\").style.display=\'none\';\n\t\t\t\tparent.parent.parent.frames[0].document.forms[0].employer_code.value=\"\";\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.parent.parent.frames[0].document.forms[0].PAYER_EMP_ID_MAND_YN.value = \"N\";\n\t\t\tparent.parent.parent.frames[0].document.forms[0].employer_code.value=\"\";\n\t\t\tparent.parent.parent.frames[0].document.getElementById(\"emp_id_mand_YN_disp\").style.display=\'none\';\n\t\t}\n\t\tif(patient_id !=\"\")\n\t\t{\n\t\t\tif(valid_pkg_for_pat_bg_avail_YN == \"Y\")\n\t\t\t{\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"vw_pkg_dtl_disp\").style.display=\'inline\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"vw_pkg_dtl_disp\").style.display=\'none\';\n\t\t\t}\n\t\t}\n\t\t// This line of code is added for avoiding the refresh flag\'s value to be carried forward for other flags like add,accept so that duplication of records doesnt occur\n\t\tdocument.forms[0].refresh_check.value=\"N\";\n\t\t/* *************************** *********************** */\n\t}\n\tvar count = 0;\n\tif(refresh_check!=\"Y\")\n\t{\n\t\tif(total_records >0)\n\t\t{\n\t\t\tfor(var i=0;i<total_records;i+";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="+)\n\t\t\t{\n\t\t\t\tvar temp_blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\tif(temp_blng_grp_code1.value == parent.parent.parent.frames[0].document.forms[0].billing_group.value)\n\t\t\t\t{\n\t\t\t\t\tcount++;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tif(count == 1)\n\t\t{\n\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t{\n\t\t\t\tvar temp_blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\n\t\t\t\tif(temp_blng_grp_code1.value == parent.parent.parent.frames[0].document.forms[0].billing_group.value)\n\t\t\t\t{\n\t\t\t\t\tvar ref_src_main_code1=eval(\"document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\tref_src_main_code1.value=parent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value;\n\n\t\t\t\t\tvar ref_src_main_desc1=eval(\"document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\tref_src_main_desc1.value=parent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value;\n\n\t\t\t\t\tvar ref_src_sub_code1=eval(\"document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\tref_src_sub_code1.value=parent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value;\n\n\t\t\t\t\tvar ref_src_sub_desc1=eval(\"document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\tref_src_sub_desc1.value=parent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value;\n\n\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar pmy_ref_src_lng_name_hdr = parent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").alt;\n\n\t\t\t\t\t\tif(pmy_ref_src_lng_name_hdr != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = document.getElementById(\"pmy_ref_src_lng_name_\"+i);\n\n\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"visible\";\n\t\t\t\t\t\t\tpmy_ref_src_lng_name.alt=pmy_ref_src_lng_name_hdr;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(document.getElementById(\"pmy_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tvar sec_ref_src_lng_name_hdr = parent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").alt;\n\n\t\t\t\t\t\tif(sec_ref_src_lng_name_hdr != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(document.getElementById(\"sec_ref_src_lng_name_\"+i));\n\n\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"visible\";\n\t\t\t\t\t\t\tsec_ref_src_lng_name.alt=sec_ref_src_lng_name_hdr;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(document.getElementById(\"sec_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\t\n}\n\nfunction refsrclkup(cur_rec_blng_grp,sel_frm_prmy_sec,ref_desc,clng_evnt)\n{\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar locale=document.forms[0].locale.value;\n\tvar main_blng_grp=parent.parent.parent.frames[0].document.forms[0].billing_group.value;\n\tvar total_records = document.forms[0].total_records.value;\n\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif(ref_desc.value == \"\")\n\t\t{\n\t\t\tif(sel_frm_prmy_sec == \'M\')\n\t\t\t{\n\t\t\t\tif(total_records >0)\n\t\t\t\t{\n\t\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\t\tvar blng_grp_code=blng_grp_code1.value;\n\t\t\t\t\t\tif(cur_rec_blng_grp.value == blng_grp_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ref_src_main_code1=eval(\"document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\t\t\tref_src_main_code1.value=\"\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar ref_src_main_desc1=eval(\"document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\t\t\tref_src_main_desc1.value=\"\";\n\n\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(document.getElementById(\"pmy_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(main_blng_grp == cur_rec_blng_grp.value)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value=\"\";\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value=\"\";\n\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").alt=\"\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tif(sel_frm_prmy_sec == \'S\')\n\t\t\t{\n\t\t\t\tif(total_records >0)\n\t\t\t\t{\n\t\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\t\tvar blng_grp_code=blng_grp_code1.value;\n\n\t\t\t\t\t\tif(cur_rec_blng_grp.value == blng_grp_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ref_src_sub_code1=eval(\"document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\t\t\tref_src_sub_code1.value=\"\";\n\n\t\t\t\t\t\t\tvar ref_src_sub_desc1=eval(\"document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\t\t\tref_src_sub_desc1.value=\"\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(document.getElementById(\"sec_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(main_blng_grp == cur_rec_blng_grp.value)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value=\"\";\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value=\"\";\n\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").alt=\"\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\treturn;\n\t\t}\n\t}\n\n\tvar retVal\t\t\t= new String();\t\t\n\tvar dialogTop\t\t\t= \"130\";\n\tvar dialogHeight\t\t= \"32\" ;\n\tvar dialogWidth\t\t\t= \"50\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar sql\t\t\t\t\t= \"\";\t\t\n\t\t\n\tvar title=getLabel(\"Common.referralsource.label\",\"common\");\n\ttitle=encodeURIComponent(title);\n\tvar column_sizes = escape(\"20%,20%,20%,30%,10%\");               \n\n\tvar code=getLabel(\"Common.code.label\",\"common\");\n\tcode=encodeURIComponent(code);\n\tvar short_desc=getLabel(\"Common.shortdescription.label\",\"common\");\n\tshort_desc=encodeURIComponent(short_desc);\n\tvar long_desc=getLabel(\"Common.longdescription.label\",\"common\");\n\tlong_desc=encodeURIComponent(long_desc);\n\tvar long_name=getLabel(\"Common.longname.label\",\"common\");\n\tlong_name=encodeURIComponent(long_name);\n\tvar org_type=getLabel(\"Common.OrganisationType.label\",\"common\");\n\torg_type=encodeURIComponent(org_type);\n\tvar column_descriptions = code+\",\"+short_desc+\",\"+long_desc+\",\"+long_name+\",\"+org_type;\n\n\tvar gov_leg = getLabel(\"eBL.GOVT_REFERRAL.label\",\"BL\");\n\tgov_leg=encodeURIComponent(gov_leg);\n\n\tvar pvt_leg = getLabel(\"eBL.PVT_REFERRAL.label\",\"BL\");\n\tpvt_leg=encodeURIComponent(pvt_leg);\n\n\tvar message = \'\';\n\t\t\n\tif (cur_rec_blng_grp.length == 0) return;\n\n\tvar sql=\"called_for=REFSRCLKUP&locale=\"+locale+\"&episode_type=\"+episode_type;\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(ref_desc.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YYYYY\";\n\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\n\t\n\tvar arr=new Array();\t\t\t\t\t\n\n\tif(retVal == null) retVal=\'\';\t\n\t\n\tif (retVal != null || retVal != \"\")\n\t{\t\n\t\tvar retVal=unescape(retVal);\t\t\t\t\n\n\t\tif(retVal != null && retVal.length>0)\n\t\t{\n\t\t\tarr=retVal.split(\"^~^\");\t\t\t\t   \n\n\t\t\tif(sel_frm_prmy_sec == \'M\')\n\t\t\t{\n\t\t\t\tif(total_records >0)\n\t\t\t\t{\n\t\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\t\tvar blng_grp_code=blng_grp_code1.value;\n\n\t\t\t\t\t\tif(cur_rec_blng_grp.value == blng_grp_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ref_src_main_code1=eval(\"document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\t\t\tref_src_main_code1.value=arr[0];\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar ref_src_main_desc1=eval(\"document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\t\t\tref_src_main_desc1.value=arr[2];\n\n\t\t\t\t\t\t\tvar ref_src_lng_name = arr[3];\n\n\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif(ref_src_lng_name != \"\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(document.getElementById(\"pmy_ref_src_lng_name_\"+i));\n\n\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"visible\";\n\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.alt=arr[3];\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(document.getElementById(\"pmy_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(main_blng_grp == cur_rec_blng_grp.value)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value=arr[0];\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value=arr[2];\n\n\t\t\t\t\t\tif(ref_src_lng_name != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"visible\";\n\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").alt=arr[3];\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").alt=\"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tif(sel_frm_prmy_sec == \'S\')\n\t\t\t{\n\t\t\t\tif(total_records >0)\n\t\t\t\t{\n\t\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\t\tvar blng_grp_code=blng_grp_code1.value;\n\n\t\t\t\t\t\tif(cur_rec_blng_grp.value == blng_grp_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ref_src_sub_code1=eval(\"document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\t\t\tref_src_sub_code1.value=arr[0];\n\n\t\t\t\t\t\t\tvar ref_src_sub_desc1=eval(\"document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\t\t\tref_src_sub_desc1.value=arr[2];\n\n\t\t\t\t\t\t\tvar ref_src_lng_name = arr[3];\n\n\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif(ref_src_lng_name != \"\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(document.getElementById(\"sec_ref_src_lng_name_\"+i));\n\n\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"visible\";\n\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.alt=arr[3];\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(document.getElementById(\"sec_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(main_blng_grp == cur_rec_blng_grp.value)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value=arr[0];\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value=arr[2];\n\n\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block8_2 ="ref_src_lng_name != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").style.visibility=\"visible\";\n\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").alt=arr[3];\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").alt=\"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\t\n\t\telse\n\t\t{\n\t\t\tif(sel_frm_prmy_sec == \'M\')\n\t\t\t{\n\t\t\t\tif(total_records >0)\n\t\t\t\t{\n\t\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\t\tvar blng_grp_code=blng_grp_code1.value;\n\t\t\t\t\t\tif(cur_rec_blng_grp.value == blng_grp_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ref_src_main_code1=eval(\"document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\t\t\tref_src_main_code1.value=\"\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar ref_src_main_desc1=eval(\"document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\t\t\tref_src_main_desc1.value=\"\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(document.getElementById(\"pmy_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(main_blng_grp == cur_rec_blng_grp.value)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value=\"\";\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value=\"\";\n\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").alt=\"\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tif(sel_frm_prmy_sec == \'S\')\n\t\t\t{\n\t\t\t\tif(total_records >0)\n\t\t\t\t{\n\t\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\t\tvar blng_grp_code=blng_grp_code1.value;\n\n\t\t\t\t\t\tif(cur_rec_blng_grp.value == blng_grp_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ref_src_sub_code1=eval(\"document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\t\t\tref_src_sub_code1.value=\"\";\n\n\t\t\t\t\t\t\tvar ref_src_sub_desc1=eval(\"document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\t\t\tref_src_sub_desc1.value=\"\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(document.getElementById(\"sec_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(main_blng_grp == cur_rec_blng_grp.value)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value=\"\";\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value=\"\";\n\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").alt=\"\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(sel_frm_prmy_sec == \'M\')\n\t\t{\n\t\t\tif(total_records >0)\n\t\t\t{\n\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t{\n\t\t\t\t\tvar blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\tvar blng_grp_code=blng_grp_code1.value;\n\t\t\t\t\tif(cur_rec_blng_grp.value == blng_grp_code)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar ref_src_main_code1=eval(\"document.forms[0].referral_source_main_code\"+i);\n\t\t\t\t\t\tref_src_main_code1.value=\"\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar ref_src_main_desc1=eval(\"document.forms[0].referral_source_main_desc\"+i);\n\t\t\t\t\t\tref_src_main_desc1.value=\"\";\n\n\t\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar pmy_ref_src_lng_name = eval(document.getElementById(\"pmy_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\tpmy_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(main_blng_grp == cur_rec_blng_grp.value)\n\t\t\t\t{\n\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_code.value=\"\";\n\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_main_desc.value=\"\";\n\n\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"pmy_ref_src_lng_name\").alt=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tif(sel_frm_prmy_sec == \'S\')\n\t\t{\n\t\t\tif(total_records >0)\n\t\t\t{\n\t\t\t\tfor(var i=0;i<total_records;i++)\n\t\t\t\t{\n\t\t\t\t\tvar blng_grp_code1=eval(\"document.forms[0].blng_grp_code\"+i);\n\t\t\t\t\tvar blng_grp_code=blng_grp_code1.value;\n\n\t\t\t\t\tif(cur_rec_blng_grp.value == blng_grp_code)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar ref_src_sub_code1=eval(\"document.forms[0].referral_source_sub_code\"+i);\n\t\t\t\t\t\tref_src_sub_code1.value=\"\";\n\n\t\t\t\t\t\tvar ref_src_sub_desc1=eval(\"document.forms[0].referral_source_sub_desc\"+i);\n\t\t\t\t\t\tref_src_sub_desc1.value=\"\";\n\n\t\t\t\t\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\n\t\t\t\t\t\tif(blng_grp_visible.value == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar sec_ref_src_lng_name = eval(document.getElementById(\"sec_ref_src_lng_name_\"+i));\n\t\t\t\t\t\t\tsec_ref_src_lng_name.style.visibility=\"hidden\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(main_blng_grp == cur_rec_blng_grp.value)\n\t\t\t\t{\n\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_code.value=\"\";\n\t\t\t\t\tparent.parent.parent.frames[0].document.forms[0].referral_source_sub_desc.value=\"\";\n\n\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").style.visibility=\"hidden\";\n\t\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"sec_ref_src_lng_name\").alt=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction dflt_pol_validity_date()\n{\n\tvar locale=document.forms[0].locale.value;\n\tvar module_id = document.forms[0].calling_module_id.value;\n\tvar total_records= document.forms[0].total_records.value;\n\n\tif(module_id != \'MP\')\n\t{\n\t\tfor(var i=0;i<total_records;i++)\n\t\t{\n\t\t\tvar policy_eff_frm_date = eval(\"document.forms[0].policy_eff_frm_date\"+i);\n\t\t\tvar credit_apprd_days = eval(\"document.forms[0].credit_apprd_days\"+i);\n\t\t\tvar apprd_days_restrict_check = eval(\"document.forms[0].apprd_days_restrict_check\"+i);\n\t\t\tvar pol_validity_chk_date = eval(\"document.forms[0].pol_validity_chk_date\"+i);\n\n\t\t\tif(policy_eff_frm_date.value != \"\" && credit_apprd_days.value != \"\" && apprd_days_restrict_check.value==\'R\')\n\t\t\t{\n\t\t\t\tvar pol_validity_chk_date_val = plusDate(policy_eff_frm_date.value,\'DMY\',locale,eval(credit_apprd_days.value)-1,\'d\');\n\n\t\t\t\tpol_validity_chk_date.value=pol_validity_chk_date_val;\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction curr_code()\n{\n\tvar total_records = document.forms[0].total_records.value;\n\n\tfor(var i=0;i<total_records;i++)\n\t{\n\t\tvar currency_desc_for_bg = eval(\"document.forms[0].currency_desc_for_bg\"+i);\n\t\tcurrency_desc_for_bg = currency_desc_for_bg.value;\n\n\t\tvar blng_grp_visible = eval(\"document.forms[0].blng_grp_visible\"+i);\n\t\tblng_grp_visible = blng_grp_visible.value;\n\n\t\tif(blng_grp_visible == \'Y\')\n\t\t{\n\t\t\tif(currency_desc_for_bg != \"\")\n\t\t\t{\n\t\t\t\tvar bg_curr_desc_disp = eval(document.getElementById(\"bg_curr_desc_disp\"+i));\n\t\t\t\tbg_curr_desc_disp.style.display=\"inline\";\n\n\t\t\t\tvar bg_curr_desc = eval(document.getElementById(\"bg_curr_desc\"+i));\n\t\t\t\tbg_curr_desc.innerText=currency_desc_for_bg;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar bg_curr_desc_disp = eval(document.getElementById(\"bg_curr_desc_disp\"+i));\n\t\t\t\tbg_curr_desc_disp.style.display=\"none\";\n\n\t\t\t\tvar bg_curr_desc = eval(document.getElementById(\"bg_curr_desc\"+i));\n\t\t\t\tbg_curr_desc.innerText=\"\";\n\t\t\t}\n\t\t}\n\t}\n}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block8_2Bytes = _getBytes( _wl_block8_2 );

    private final static java.lang.String  _wl_block9 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\'disableAllElements();policy_coverage_basis_ind();ref_src_check();dflt_pol_validity_date();curr_code();disable();\' >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t<body onLoad=\'policy_coverage_basis_ind();ref_src_check();dflt_pol_validity_date();curr_code();disable();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\'policy_coverage_basis_ind();ref_src_check();dflt_pol_validity_date();curr_code();disable();\' >\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<form name=\'add_modify_pat_fin_det_insmain\' id=\'add_modify_pat_fin_det_insmain\' method=\'post\' >\n<div id=\'tbl-container\'>\n<table cellpadding=3 cellspacing=0  width=\"100%\" align=\'left\' id=\'ins_data\' border=1>\n<thead>\n<tr><td class=\'COLUMNHEADER\' colspan=\'9\' align=\'left\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td></tr>\n<tr>\n\t<td class=\'COLUMNHEADER\' width=\'14%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'12%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'7%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'14%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'11%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t</tr>\n</thead>\n<tbody>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n<tr>\n<td class=\'PATIENTLINECOLOR\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;&nbsp;<div id=\"bg_curr_desc_disp";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" style=\"display:inline\"><Font color=\'red\'><b id=\"bg_curr_desc";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></b></font></div></td>\n<td class=\'PATIENTLINECOLOR\' colspan=2><input type=\'text\' readonly name=\"billing_group_desc";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"billing_group_desc";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" maxlength=\'30\' size=\'25\' tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\'hidden\' name=\'blng_grp_visible";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'blng_grp_visible";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\"Y\">\n<td  class=\'PATIENTLINECOLOR\'>\n\t\t\t<div id=\'ref_src_code_main_leg_disp";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' style=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t</div>\n</td>\n<td class=\'PATIENTLINECOLOR\' colspan=2>\n\t\t<div id=\'ref_src_code_main_val_disp";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'text\' name=\"referral_source_main_desc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"referral_source_main_desc";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" maxlength=\'50\' size=\'24\' tabindex=\'0\'  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onBlur=\"return refsrclkup(document.forms[0].blng_grp_code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =",\'M\',referral_source_main_desc";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =",\'B\')\">\n\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcmainbut";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"refsrcmainbut";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" value=\'?\' onClick=\"return refsrclkup(document.forms[0].blng_grp_code";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =",\'C\')\" tabindex=\'0\'>\n\t\t\t<div id=\'ref_src_code_main_mand_disp\' style=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"pmy_ref_src_lng_name_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"pmy_ref_src_lng_name_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" align=\'center\' style=\"visibility:hidden\">\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" align=\'center\' style=\"visibility:inline\" alt=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\t\n\t\t</div>\n</td>\n<td class=\'PATIENTLINECOLOR\'>\n\t\t<div id=\'ref_src_code_sub_leg_disp";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t</div>\n</td>\n<td class=\'PATIENTLINECOLOR\' colspan=2>\n\t\t<div id=\'ref_src_code_sub_val_disp";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\'text\' name=\"referral_source_sub_desc";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"referral_source_sub_desc";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =",\'S\',referral_source_sub_desc";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =",\'B\')\" >\n\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcsubbut";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"refsrcsubbut";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =",\'C\')\" tabindex=\'0\'>\n\t\t\t<div id=\'ref_src_code_sub_mand_disp\' style=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"sec_ref_src_lng_name_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"sec_ref_src_lng_name_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\n\t\t</div>\n</td>\n</tr>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n<input type=\'hidden\' name=\'billing_group_desc";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'billing_group_desc";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' value=\"N\">\n<input type=\'hidden\' name=\'referral_source_main_desc";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'referral_source_main_desc";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<input type=\'hidden\' name=\'referral_source_sub_desc";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'referral_source_sub_desc";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n<tr id=row";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =">\n<input type= \"hidden\" name=\"payerEligibilityParam";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"payerEligibilityParam";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"  value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<input type= \"hidden\" name=\"responseCode";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"responseCode";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type= \"hidden\" name=\"responseCodeDesc";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"responseCodeDesc";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<input type= \"hidden\" name=\"statuDescription";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"statuDescription";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n<input type= \"hidden\" name=\"validityPeriod";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"validityPeriod";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n<input type= \"hidden\" name=\"validityPeriodDesc";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"validityPeriodDesc";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n<input type= \"hidden\" name=\"eligibilityCode";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"eligibilityCode";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n<input type= \"hidden\" name=\"transactionId";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"transactionId";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n<input type= \"hidden\" name=\"responseDateTime";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"responseDateTime";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n<input type= \"hidden\" name=\"currency_code_for_bg";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"currency_code_for_bg";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n<input type= \"hidden\" name=\"currency_desc_for_bg";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"currency_desc_for_bg";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n<input type=\'hidden\' name=\'blng_grp_code";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' id=\'blng_grp_code";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n<input type=\'hidden\' name=\'referral_source_main_code";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' id=\'referral_source_main_code";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<input type=\'hidden\' name=\'referral_source_sub_code";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' id=\'referral_source_sub_code";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n<input type=\'hidden\' name=\'referral_source_capture_YN";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' id=\'referral_source_capture_YN";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\'hidden\' name=\'referral_source_main_mand_YN";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' id=\'referral_source_main_mand_YN";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type=\'hidden\' name=\'referral_source_sub_mand_YN";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' id=\'referral_source_sub_mand_YN";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n<td class=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" width=\'14%\'><input type=\"checkbox\" name=\'selected_row";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' id=\'selected_row";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' onClick=\"selected(";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =")\" >&nbsp;&nbsp;<input maxlength=\'15\' size=\'12\' type=text name=\'ins_cust_group_name";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'ins_cust_group_name";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'  value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" onFocus=\'check(";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =");\'  readonly></td>\n<td class=";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" width=\'12%\' ><input maxlength=\'40\' size=\'13\' type=text name=\'payer_desc";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' id=\'payer_desc";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =");\' readonly>\n<input type=\'hidden\' name=\'cust_3";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' id=\'cust_3";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n<input type=\'hidden\' name=\'ins_cust_group_code";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' id=\'ins_cust_group_code";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n<input type=\'hidden\' name=\'valid_payer_YN";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' id=\'valid_payer_YN";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n<input type=\'hidden\' name=\'payer_suspended_YN";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' id=\'payer_suspended_YN";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n<input type=\'hidden\' name=\'cust_valid_from_date";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' id=\'cust_valid_from_date";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n<input type=\'hidden\' name=\'cust_valid_to_date";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' id=\'cust_valid_to_date";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n<td class=";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" width=\'7%\'><input type=\"text\" maxlength=\'2\' size=\"3\" name=\'priority";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' id=\'priority";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' style=\'text-align:right\'  value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =");\' readonly></td>\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =" width=\'12%\' ><input maxlength=\'40\' size=\'13\' type=text name=\'policy_type_desc";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' id=\'policy_type_desc";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =");\' readonly>\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n<a name=\'\' href=\"#\" onClick=\"callPolicyDetails(";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =")\">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->\n";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\t\n\t</td>\n<input type=hidden name=\'policy_type_code";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' id=\'policy_type_code";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n<input type=\'hidden\' name=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' id=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n<input type=\'hidden\' name=\'policy_suspended_YN";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' id=\'policy_suspended_YN";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =" width=\'12%\'><input type=\"text\" maxlength=\'30\' size=\"13\" name=\'policy_no";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' id=\'policy_no";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'   value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =");\'  readonly></td>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" width=\'10%\' ><input type=\'text\'  name=\'policy_start_date";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' id=\'policy_start_date";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\' size=\'10\' maxlength=\'10\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"  onFocus=\'check(";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =");\' readonly></td>\n<td class=";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =" width=\'10%\'><input type=\'text\'  name=\'policy_exp_date";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\' id=\'policy_exp_date";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" width=\'12%\'><div id=\"credit_auth_val_disp";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" style=";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =" ><input type=\"text\" maxlength=\'20\' size=\"13\" name=\'credit_auth_ref";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' id=\'credit_auth_ref";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 =");\' readonly></div></td>\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =" width=\'11%\'><div id=\"credit_auth_date_val_disp";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =" ><input type=\'text\'  name=\'credit_auth_date";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' id=\'credit_auth_date";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =");\' readonly></div></td>\n</tr>\n<tr id=row";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =">\n<td class=";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" width=\'14%\'><b id=\"policy_coverage_basis_";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\"></b></td>\n<td class=";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" width=\'12%\' ><div id=\"apprd_amt_leg_disp";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =" >";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</div></td>\n<td class=";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =" width=\'7%\'><div id=\"apprd_amt_val_disp";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" ><input type=\"text\" maxlength=\'10\' size=\"7\" name=\'credit_apprd_amt";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' id=\'credit_apprd_amt";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =");\' readonly></div></td>\n<td  class=";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =" width=\'12%\'><div id=\"apprd_days_leg_disp";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =" width=\'12%\'><div id=\"apprd_days_val_disp";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" ><input type=\"text\" maxlength=\'4\' size=\"4\" name=\'credit_apprd_days";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' id=\'credit_apprd_days";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =");\' readonly></div></td>\n<td class=";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" width=\'10%\' >";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td>\n<td class=";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 =" width=\'10%\'><input type=\'text\'  name=\'policy_eff_frm_date";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\' id=\'policy_eff_frm_date";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =");\' readonly>\n<td class=";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" width=\'12%\' >";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</td>\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 =" width=\'11%\'><input type=\'text\'  name=\'policy_eff_to_date";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' id=\'policy_eff_to_date";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 =");\' ></td>\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n</tr>\n<input type=hidden name=\'adj_rule_ind";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' id=\'adj_rule_ind";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n<input type=hidden name=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\' id=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n<input type=hidden name=\'adj_perc_amt_value";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\' id=\'adj_perc_amt_value";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n<input type=hidden name=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' id=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n<input type=hidden name=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\' id=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n<input type=hidden name=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\' id=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n<input type=hidden name=\'restrict_check";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\' id=\'restrict_check";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'>\n<input type=hidden name=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' id=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n<input type=hidden name=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\' id=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\'>\n<input type=hidden name=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\' id=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\'>\n<input type=hidden name=\'cred_auth_req_yn";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\' id=\'cred_auth_req_yn";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n<input type=hidden name=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\' id=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n<input type=hidden name=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\' id=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n<input type=hidden name=\'pol_validity_chk_date";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\' id=\'pol_validity_chk_date";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n<input type=hidden name=\'rec_edited_YN";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\' id=\'rec_edited_YN";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n<input type=hidden name=\"totRec\" id=\"totRec\" id=\"totRec\" value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n<input type=hidden name=\'tmp_pol_eff_to";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\' id=\'tmp_pol_eff_to";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">  <!-- Added By Vijay for MMS-QF-SCf-567 -->\n<input type=hidden name=\'mcn_for_policy";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\' id=\'mcn_for_policy";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'   value=\"\">  \n<input type=hidden name=\'reg_ref_id";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\' id=\'reg_ref_id";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'   value=\"\">   <!-- V230315 -->\n<input type=hidden name=\"userId_for_priv";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" id=\"userId_for_priv";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\" value=\"\" />  <!-- V230707 -->\n<input type=hidden name=\"reasonCode_for_priv";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" id=\"reasonCode_for_priv";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" value=\"\" />  <!-- V230707 -->\n";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'  value=\"\" onFocus=\'check(";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\' value=\"\">\n<input type=\'hidden\' name=\'ins_cust_group_code";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\' value=\"\">\n<input type=\'hidden\' name=\'valid_payer_YN";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\' value=\"N\">\n<input type=\'hidden\' name=\'payer_suspended_YN";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\' value=\"\">\n<input type=\'hidden\' name=\'cust_valid_from_date";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\' value=\"\">\n<input type=\'hidden\' name=\'cust_valid_to_date";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\' value=\"\">\n<td class=";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\' style=\'text-align:right\'  value=\'\' onFocus=\'check(";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\t<a name=\'\' href=\"#\" onClick=\"callPolicyDetails(";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\t\n</td>\n<input type=\'hidden\' name=\'policy_type_code";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\' value=\"\">\n<input type=\'hidden\' name=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\' value=\"N\">\n<input type=\'hidden\' name=\'policy_suspended_YN";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'   value=\"\" onFocus=\'check(";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\' size=\'10\' maxlength=\'10\' value=\"\"  onFocus=\'check(";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\' style=\'text-align:right\'  value=\"\" onFocus=\'check(";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 =" width=\'11%\'><input type=\'text\' id=\'policy_eff_to_date";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\' name=\'policy_eff_to_date";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 =");\' readonly></td>\n</tr>\n<input type=hidden name=\'adj_rule_ind";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\' value=\"\">\n<input type=hidden name=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\' value=\"\">\n<input type=hidden name=\'adj_perc_amt_value";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\' value=\"\">\n<input type=hidden name=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\' value=\"\">\n<input type=hidden name=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\' value=\"\">\n<input type=hidden name=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\' value=\"\">\n<input type=hidden name=\'restrict_check";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\' value=\'U\'>\n<input type=hidden name=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\' value=\'U\'>\n<input type=hidden name=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\' value=\'U\'>\n<input type=hidden name=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\' value=\'\'>\n<input type=hidden name=\'cred_auth_req_yn";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\' value=\"N\">\n<input type=hidden name=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\' value=\"N\">\n<input type=hidden name=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\' value=\"N\">\n<input type=hidden name=\'pol_validity_chk_date";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\' value=\"\">\n<input type=hidden name=\'rec_edited_YN";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\' value=\"N\">\n<input type=hidden name=\'mcn_for_policy";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\'   value=\"\">  <!--  V230315 -->\n<input type=hidden name=\"totRec\" id=\"totRec\" value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">  <!-- Added By Vijay for MMS-QF-SCf-567 -->\n<input type=hidden name=\"userId_for_priv";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n<tr>\n<td class=\'PATIENTLINECOLOR\'>";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\"></b></font></div></td>\n<td class=\'PATIENTLINECOLOR\' colspan=2 ><input type=\'text\' readonly name=\"billing_group_desc";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\"></td>\n<input type=\'hidden\' name=\'blng_grp_visible";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 =",\'S\',referral_source_main_desc";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 =",\'B\')\">\n\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcsubbut";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\'>\n<input type=\'hidden\' name=\'payer_suspended_YN";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\t\n</td>\n<input type=hidden name=\'policy_type_code";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\'   value=\'";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\' onFocus=\'check(";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\'  onFocus=\'check(";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 =");\' readonly></div></td>\n</tr>\n";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\' style=\'text-align:right\'  value=\'";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\">\n<input type=hidden name=\'mcn_for_policy";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\">  \n<input type=hidden name=\'reg_ref_id";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\">  <!--  V230315 -->\n<input type=hidden name=\'tmp_pol_eff_to";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">  <!--  V232704 -->\n<input type=hidden name=\"userId_for_priv";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\" value=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\" />  <!-- V230707 -->\n<input type=hidden name=\"reasonCode_for_priv";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\" />  <!-- V230707 -->\n";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n<tr>\n<td class=\'PATIENTLINECOLOR\' >";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\' value=\"Y\">\n<td  class=\'PATIENTLINECOLOR\' >\n\t\t\t<div id=\'ref_src_code_main_leg_disp";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 =">\n<input type= \"hidden\" name=\"currency_code_for_bg";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\">\n<input type=\'hidden\' name=\'payerEligibilityParam";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\' id=\'payerEligibilityParam";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\">\n<input type=\'hidden\' name=\'responseCode";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\' id=\'responseCode";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\">\n<input type=\'hidden\' name=\'responseCodeDesc";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\' id=\'responseCodeDesc";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\">\n<input type=\'hidden\' name=\'statuDescription";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\' id=\'statuDescription";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n<input type=\'hidden\' name=\'validityPeriod";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\' id=\'validityPeriod";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\">\n<input type=\'hidden\' name=\'validityPeriodDesc";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\' id=\'validityPeriodDesc";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\">\n<input type=\'hidden\' name=\'eligibilityCode";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\' id=\'eligibilityCode";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\n<input type=\'hidden\' name=\'transactionId";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\' id=\'transactionId";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\">\n<input type=\'hidden\' name=\'responseDateTime";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\' id=\'responseDateTime";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 =")\">&nbsp;&nbsp;<input maxlength=\'15\' size=\'12\' type=text name=\'ins_cust_group_name";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 =");\'  readonly></td>\n<input type=\'hidden\' name=\'cust_3";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 =");\'  readonly></td> \n<td class=";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 =");\'  readonly>\n";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\" >\n<input type=\'hidden\' name=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\'>\n<input type=\'hidden\' name=\'policy_suspended_YN";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 =");\'  readonly></div></td>\n";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\' readonly></div></td>\n</tr>\n";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 =">";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 =");\'  readonly></div></td>\n<td  class=";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\t\n<td class=";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\' readonly></td>\n";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\' readonly></td>\n</tr>\n<input type=hidden name=\'adj_rule_ind";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\">   <!-- V230315 -->\n<input type=\"hidden\" name=\"tmp_pol_eff_to";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\" id=\"tmp_pol_eff_to";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\">  <!--  Added By Vijay for MMS-QF-SCf-567-->\n<input type=hidden name=\"userId_for_priv";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\n\t<input type=\"hidden\" name=\"totRec\" id=\"totRec\" id=\"totRec\"  value=\"";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\"> <!-- Added By Vijay For MMS-QF-SCf-567  -->\n";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\">   <!-- V230315 -->\n<input type=hidden name=\"tmp_pol_eff_to";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\">  <!--  Added By Vijay for MMS-QF-SCf-567-->\n<input type=hidden name=\"totRec\" id=\"totRec\" id=\"totRec\"  value=\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\"><!-- Added By Vijay For MMS-QF-SCf-567  -->\n<input type=hidden name=\"userId_for_priv";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n<tr>\n\t<td class=\'PATIENTLINECOLOR\'>";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\"></b></font></div></td>\n\t<td class=\'PATIENTLINECOLOR\' colspan=2><input type=\'text\' readonly name=\"billing_group_desc";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\' value=\"Y\">\n\t<td  class=\'PATIENTLINECOLOR\'>\n\t\t\t<div id=\'ref_src_code_main_leg_disp";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\n\t\t\t</div>\n\t</td>\n\t<td class=\'PATIENTLINECOLOR\' colspan=2>\n\t\t<div id=\'ref_src_code_main_val_disp";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\t\n\t\t</div>\n\t</td>\n\t<td class=\'PATIENTLINECOLOR\'>\n\t\t<div id=\'ref_src_code_sub_leg_disp";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\n\t\t</div>\n\t</td>\n\t<td class=\'PATIENTLINECOLOR\' colspan=2>\n\t\t<div id=\'ref_src_code_sub_val_disp";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\t\n\t\t</div>\n\t</td>\n</tr>\n\n";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\" >\n<input type=\'hidden\' name=\'policy_suspended_YN";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" readonly></div></td>\n</tr>\n";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\" readonly></td>\n";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\" readonly></td>\n</tr>\n<input type=hidden name=\'tmp_pol_eff_to";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\'>\n<input type=hidden name=\'adj_rule_ind";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\">\n<input type=hidden name=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\">\n<input type=hidden name=\'cred_auth_req_yn";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">  <!--  V230315 -->\n<input type=hidden name=\"userId_for_priv";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\t\n</td><input type=hidden name=\'policy_type_code";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\' value=\"\"><input type=\'hidden\' name=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\' value=\"N\">\n<td class=";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 =");\' readonly></td>\n</tr>\n<input type=hidden name=\'tmp_pol_eff_to";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\' value=\'\'>\n<input type=hidden name=\'adj_rule_ind";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\'   value=\"\"> \n<input type=hidden name=\'reg_ref_id";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\'   value=\"\">   <!--  V230315 -->\n \n<input type=hidden name=\"userId_for_priv";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\" value=\"\" />  <!-- V230707 -->\n\n";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\n\t\n";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\n\t";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 =" \n\t\t\t\t\n";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\n</tbody>\n</table>\n</div>\n<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\"";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\">\n<input type=\'hidden\' name=\'isExtnJSPLoaded\' id=\'isExtnJSPLoaded\' value=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\">\n<input type=\'hidden\' name=\'focussed_row\' id=\'focussed_row\' value=\'\' >\n<input type=\'hidden\' name=\'checked_row\' id=\'checked_row\' value=\'\' >\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\">\n<input type=\'hidden\' name=\'ins_auth_flag\' id=\'ins_auth_flag\' value=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\">\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\">\n<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\"";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\">\n<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'4\'>\n<input type=\'hidden\' name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\">\n<input type=\'hidden\' name=\"bl_data_from_repos_yn\" id=\"bl_data_from_repos_yn\" value=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\">\t\n<input type=\'hidden\' name=\"items_disabled\" id=\"items_disabled\" value=\"";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\">\t\n<input type=\'hidden\' name=\"calling_module_id\" id=\"calling_module_id\" value=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\">\t\n<input type=\'hidden\' name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\">\t\n<input type=\'hidden\' name=\"operation_fun\" id=\"operation_fun\" value=\"";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\">\t\n<input type=\'hidden\' name=\"operation_mode\" id=\"operation_mode\" value=\"";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\">\t\n<input type=\'hidden\' name=\'CitizenYn\' id=\'CitizenYn\' value=\"";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\">\n<input type=\'hidden\' name=\'blnggrpappyn\' id=\'blnggrpappyn\' value=\"";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\">\t\t\n<input type=\'hidden\' name=\'blnggrpcatgappyn\' id=\'blnggrpcatgappyn\' value=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\">\n<input type=\'hidden\' name=\'BlngGrpStatus\' id=\'BlngGrpStatus\' value=\"";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\">\n<input type=\'hidden\' name=\'mpolicy_type\' id=\'mpolicy_type\' value=\"";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\">\n<input type=\'hidden\' name=\"locale\" id=\"locale\"  value=\"";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\">\n<input type=\'hidden\' name=\"p_patient_class\" id=\"p_patient_class\"  value=\"";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\">\n<input type=\'hidden\' name=\"episode_type\" id=\"episode_type\"  value=\"";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\'   value=\"";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\">\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'   value=\"";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\">\n<input type=\'hidden\' name=\"queryString\" id=\"queryString\"  value=\"";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\">\n<input type=\'hidden\' name=\"blng_grp_values\" id=\"blng_grp_values\"  value=\"";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\">\n<input type=\'hidden\' name=\'cap_ref_src_dtl_flag\' id=\'cap_ref_src_dtl_flag\' value=\"";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\">\n<input type=\'hidden\' name=\'referral_source_main_mand_YN\' id=\'referral_source_main_mand_YN\' value=\'";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\'>\n<input type=\'hidden\' name=\'referral_source_sub_mand_YN\' id=\'referral_source_sub_mand_YN\' value=\'";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\'>\n<input type=\'hidden\' name=\'pr_payer_employer_id_mand_YN\' id=\'pr_payer_employer_id_mand_YN\' value=\'";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\'>\n<input type=\'hidden\' name=\'refresh_check\' id=\'refresh_check\' value=\'";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\'>\n<input type=\"hidden\" name=\"policy_coverage_basis_gbl_ind\" id=\"policy_coverage_basis_gbl_ind\" value=\"";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\" >\n<input type=\"hidden\" name=\"valid_pkg_for_pat_bg_avail_YN\" id=\"valid_pkg_for_pat_bg_avail_YN\" value=\"";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\" >\n<input type=\'hidden\' name=\'fin_class_flag_YN\' id=\'fin_class_flag_YN\' value=\'";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\'>\n<input type=\'hidden\' name=\'autoFinChk\' id=\'autoFinChk\' value=\'";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\'>\n<input type=\'hidden\' name=\'class_code\' id=\'class_code\' value=\'";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\'>\n<input type=\'hidden\' name=\'retVal\' id=\'retVal\' value=\'\'>\n<input type=hidden name=\"siteSpec\" id=\"siteSpec\" value=\"";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\"> \n<input type=hidden name=\"siteSpecPolApprv\" id=\"siteSpecPolApprv\" value=\"";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\" /> \n";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\n<script>\n\tparent.frames[2].location.href=\"../../eBL/jsp/AddModifyPatFinDetailsInsButton.jsp?&";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\";\t\n</script>\n";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\n\t<input type= hidden name=\"billing_group\" id=\"billing_group\"  value=\"";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\n<script>\n\tparent.parent.frames[1].location.href=\"../../eBL/jsp/AddModifyPatFinDetails7.jsp?";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\n<script>\n\tparent.parent.frames[1].location.href=\"../../eBL/jsp/AddModifyPatFinDetails4.jsp?";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\n<script>\nvar isExtnJSPLoaded = document.forms[0].isExtnJSPLoaded.value;\nif(isExtnJSPLoaded == \"Y\"){\n\tvar totRec = document.forms[0].totRec.value;\n\tdocument.forms[0].total_records.value = totRec;\n}\n\t\n</script>\n";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );
	
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


private String FinDtlsQueryFormation(String payerList,String facility_id,String billing_group,String p_patient_class){
	String sql_default = "";
		
	ArrayList<String> arPayerList=new ArrayList<String>();
	String queryFramed="";

	StringTokenizer stTilt=new StringTokenizer(payerList,"~");
	
	while(stTilt.hasMoreTokens()){
		arPayerList.add(stTilt.nextToken());
	}

	for(int pc=0;pc<arPayerList.size();pc++){	
		
		if(pc!=0)  queryFramed+=" OR "; 	
		
		StringTokenizer stPipe=new StringTokenizer(arPayerList.get(pc),"|");
		while(stPipe.hasMoreTokens()){
			queryFramed+= " (a.blng_grp_id = '"+stPipe.nextToken()+"'"+
	                      " AND a.cust_group_code = '"+stPipe.nextToken()+"'"+
	                      " AND a.cust_code = '"+stPipe.nextToken()+"'"+
	                      " AND a.policy_type_code = '"+stPipe.nextToken()+"'"+
	                      " ) ";
			if(stPipe.hasMoreTokens()){
				stPipe.nextToken();
			}
			
		}
	}	
	sql_default="SELECT DISTINCT a.cust_code cust_code, NULL cust_short_name, "+
            "a.policy_type_code policy_type_code, NULL policy_short_desc, "+
            "a.priority_no priority_no, a.adj_rule_ind adj_rule_ind, "+
            "a.adj_perc_amt_ind adj_perc_amt_ind, "+
            "a.adj_perc_amt_value adj_perc_amt_value, "+
            "a.pmnt_diff_adj_int pmnt_diff_adj_int, "+
            "a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int, "+
            "a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, "+
            "a.cust_group_code cust_group_code, d.policy_coverage_basis, "+
            "NULL short_desc,e.INTERFACE_YN, D.POLICY_EFF_TO "+ //Added by shikha on 01-06-2020
       "FROM bl_payers_priority_by_bg a, "+
            "bl_ins_policy_types b, "+
            "ar_customer c, "+
            "bl_ins_policy_type_hdr d, "+
            "ar_cust_group e, "+
            "bl_cust_by_cust_group f "+
      "WHERE a.operating_facility_id = '"+facility_id+"' "+
        "AND a.blng_grp_id = '"+billing_group+"' "+
        "AND a.patient_class = '"+p_patient_class+"' "+
        "AND c.acc_entity_code = e.acc_entity_code "+
        "AND e.acc_entity_code = f.acc_entity_code "+
        "AND a.operating_facility_id = b.operating_facility_id "+
        "AND a.operating_facility_id = d.operating_facility_id "+
        "AND (a.cust_code = d.cust_code OR d.cust_code = '**') "+
        "AND (c.cust_code = a.cust_code OR a.cust_code = '**') "+
        "AND c.cust_code = f.cust_code "+
        "AND a.cust_group_code = f.cust_group_code "+
        "AND a.cust_group_code = d.cust_group_code "+
        "AND d.cust_group_code = e.cust_group_code "+
        "AND a.policy_type_code = b.policy_type_code "+
        "AND a.policy_type_code = d.policy_type_code "+
        "AND(  "+
        queryFramed +
        ")  ORDER BY a.priority_no ";
	
	return sql_default;
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
            _bw.write(_wl_block1Bytes, _wl_block1);

		String bean_id1		=	"";
	String bean_name1	=	"";
	String policy_no=request.getParameter("policy_no");
	boolean siteSpecUploadDocAll = false;
	String isExtnJSPLoaded = "N";
	HashMap 	blInsuranceImageList	=	null;
	BLInsuranceImageBean blInsuranceImageBean 	= 	null;
	BLInsuranceImage	blInsuranceImage = null;	
	int index1=0;
	bean_id1	= 	"bl_blinsuranceimagebean" ;
	bean_name1	= 	"eBL.BLInsuranceImageBean";
	Connection con1		= null;
	blInsuranceImageList	=	new HashMap();
	blInsuranceImageBean = 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id1, bean_name1, request );
	con1	=	ConnectionManager.getConnection(request);
	siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con1, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
	if(siteSpecUploadDocAll)
	{
		blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 
		Object ob[] =(blInsuranceImageList.keySet()).toArray();
		Arrays.sort(ob); //Added V190612 DHANANAJAY/IN70646
		for(index1=0;index1<ob.length;index1++)
		{
			String arr1 = ob[index1].toString();
			String[] val1 = arr1.split("_");
			if(val1[0].equals(policy_no))
			{
			blInsuranceImageList.remove(arr1);
			}
		}
	}
	Boolean Site_spec=false;
	String siteSpecMemberID ="";
	Connection conn = null; 
	Connection conNew = null;
	PreparedStatement pstmtNew = null ;
	ResultSet rsNew = null;
	try
	{
		conn = ConnectionManager.getConnection();	
		Site_spec = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","MEMBERSHIP_ID_MANDATORY");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	if(Site_spec){
		siteSpecMemberID="Y";
	}
	else{
		siteSpecMemberID="N";
	}
	if(siteSpecMemberID.equals("Y"))
	{
		String New_slmt_ind = "";
		String BillingNewGroup=request.getParameter("billing_group");
		conNew = ConnectionManager.getConnection();
		String Set_Indicator_query="select settlement_ind from bl_blng_grp where blng_grp_id = ? ";
		pstmtNew = conNew.prepareStatement(Set_Indicator_query);
		pstmtNew.setString(1,BillingNewGroup);
		rsNew = pstmtNew.executeQuery() ;
		if( rsNew != null ) 
		{
			while( rsNew.next() )
			{  
				New_slmt_ind = rsNew.getString("settlement_ind");
			}
		}
		if (rsNew != null) rsNew.close();
		pstmtNew.close();
		
		String priority_MemberId=request.getParameter("Mem_Priority");
		String totalrecords=request.getParameter("total_records");
		if(totalrecords==null) totalrecords="";//GHL-CRF-0550.1
		if(totalrecords == null){
			System.err.println("total_records retrived null");	
		}
		else if(totalrecords.equals("0")){
			HashMap<String,String>  MembershipIdRemove=(HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION"); 
			MembershipIdRemove.remove(priority_MemberId);
		}	
		if(New_slmt_ind.equals("X")){
		try{
			HashMap<String,String> claimCreditMap=(HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION");
			String claim_code="";
			String credit_authorisation_by="";
			String membershipId="";
			String claimCredit="";
			String priority=request.getParameter("priority");
			if(claimCreditMap!=null){
				claimCredit=claimCreditMap.get(priority);	
				if(claimCredit!=null){		
					String[] arrClaimCredit= claimCredit.split("~");
					HashMap RemoveMember	= (HashMap)session.getAttribute("financial_details"); 
					String MemberNumber=(String) RemoveMember.get("membership_number");
					String curMemberId=arrClaimCredit[2];
					
					String NewFin_Dlts="";
					String [] Memberarr=MemberNumber.split("\\|");
					for(int iMem=0;iMem<Memberarr.length;iMem++){
						if(!Memberarr[iMem].equals(curMemberId)){
							NewFin_Dlts=NewFin_Dlts+curMemberId+"|";
						}
					}
					RemoveMember.put("membership_number",NewFin_Dlts);
					session.setAttribute("financial_details",(HashMap)RemoveMember);			
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}
	JsonObject objFromBean = null;
	AddModifyPatFinDetailsBean addModifyBean = new AddModifyPatFinDetailsBean();
	Connection con				= null;
 	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rs4				= null;
	ResultSet rs5				= null;
	String payerGrpBySetup = "";
	String strChargeLogicYN = "";
	String orgPolEffToDate=""; // Added By Vijay for MMS-QF-SCF-567
	String sql="";
	String locale			= (String)session.getAttribute("LOCALE");

		request.setCharacterEncoding("UTF-8");
		/************** package Billing Changes ********start************/
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
			String facility_id = (String)httpSession.getValue("facility_id");
			String bean_id		= "PkgApprovalBean" ;
		String bean_name	= "eBL.PkgApprovalBean";
		PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
		String package_enabled_yn = "N";		
		package_enabled_yn = bean.getBlPkgYN(facility_id);	
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";
		/************** package Billing Changes ********end************/	
		String queryString=(request.getQueryString());
		
		String DFLT_POLICY_DEF_IN_VIS_REG_YN=null;
		objFromBean = addModifyBean.getDfltPlcyAndPyrGrpSetup(con, facility_id);
		DFLT_POLICY_DEF_IN_VIS_REG_YN = objFromBean.get("dfltPolicyDefInVisRegnYn").getAsString();
		payerGrpBySetup = objFromBean.get("payerGrpBySetup").getAsString();
		strChargeLogicYN = objFromBean.get("strChargeLogicYN").getAsString();
		objFromBean = null;	
		String calling_function_id="";
		String checked_row="";
		String record_count="";
		int total_records=0;
		int selected_index=0;	
		String new_blng_grp_name="";
		String existing_blng_grp_name="";
		String billing_group_desc="";
		String blng_grp_values="";
		String restrict_check="", apprd_amt_restrict_check = "", apprd_days_restrict_check = "";
		String valid_payer_YN="";
		String valid_policy_type_code_YN="";
		String cust_group_code="", cust_group_name = "";
		String policy_coverage_basis_gbl_ind="";
		String policy_coverage_basis_ind="";
		String str_currency_code_for_bg="", str_currency_desc_for_bg="";
		String policy_start_date_conv="";
		String policy_exp_date_conv="";
		String credit_auth_date_conv="";
		String policy_eff_frm_date_conv="";
		String policy_eff_to_date_conv="";
		String policy_eff_to_date_Org=""; //Added By Vijay for MMS-QF-SCf-567
		String pol_validity_chk_date="";
		String v_display_hide="",v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
		String cred_auth_req_yn="N",dflt_auth_ref_as_pol_no_yn="N",v_display_hide_cred_auth="";
		String fin_dtls_updated_YN="N", fin_class_dtls_updated_YN="N";
		String encounter_date_time = "", encounter_date_aft_trunc="", encounter_date="";
		String cust_valid_from_date = "" ,cust_valid_to_date = "";
		String referral_source_code_flag="N";
		String referral_source_main_mand_YN="N";
		String referral_source_sub_mand_YN="N";
		String pr_payer_employer_id_mand_YN = "N";
		String blng_grp_code_for_pkg_use="", str_valid_pkg_for_pat_bg_avail_YN="N";
		String fin_class_flag_YN="N",autoFinChk="N",class_code = "",class_blng_grp_id="";
		String def_req_pol_date_avail_YN = "N";
		String payer_suspended_YN = "N", policy_suspended_YN = "N";
		String rec_edited_YN="N", cred_auth_mand_capt_yn="N";
		ArrayList new_records_array=null;
		ArrayList existing_records_array=new ArrayList();
		ArrayList existing_records_array1=new ArrayList();
		calling_function_id = request.getParameter("calling_function_id");
		if(calling_function_id == null) calling_function_id="";
		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";	
		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
		if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";//muthu - 32139
		String refresh_check=request.getParameter("refresh_check");
		if(refresh_check==null) refresh_check="N";
		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";
		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";
		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="N";
		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";	
		Boolean siteSpec=false;
		Boolean siteSpecPolApprv = false; //Added V190517-Aravindh/NMC-JD-CRF-0010
		try
		{
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DONT_DFLT_POL_EXP_DAYS_CONFIG");
			String polApprvSql = "select NVL(enable_policy_approval_yn,'N') enable_policy_approval_yn from bl_parameters where operating_facility_id = '"+facility_id+"'";
			pstmt = con.prepareStatement(polApprvSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String enablePolicyApprvl = rs.getString("enable_policy_approval_yn");
				if("Y".equals(enablePolicyApprvl)) {
					siteSpecPolApprv = true;
				}
			}
			rs.close();
			if(pstmt != null) pstmt.close();	
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		if(refresh_check.equals("Y"))
		{
			String priority_1_blng_grp_code="";
			int priority_1_blng_grp_index=0;
			record_count=request.getParameter("total_records");
			if(record_count==null) record_count="";
			total_records=Integer.parseInt(record_count);
			for(int i=0;i<total_records;i++)
			{
				String temp_blng_grp_code=request.getParameter("blng_grp_code"+i);
				String temp_priority=request.getParameter("priority"+i);
				if(temp_priority.equals("1"))
				{
					priority_1_blng_grp_code=temp_blng_grp_code;
					blng_grp_code_for_pkg_use = temp_blng_grp_code;
				}
			}
			for(int i=0;i<total_records;i++)
			{
				policy_start_date_conv=request.getParameter("policy_start_date"+i);
					if(policy_start_date_conv==null) policy_start_date_conv="";	
				policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
					if(policy_exp_date_conv==null) policy_exp_date_conv="";
				credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
					if(credit_auth_date_conv==null) credit_auth_date_conv="";
				policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
					if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
				policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
					if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
				if(!locale.equals("en"))
				{
					if(!policy_start_date_conv.equals(""))
						policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
					if(!policy_exp_date_conv.equals(""))
						policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
					if(!credit_auth_date_conv.equals(""))
						credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
					if(!policy_eff_frm_date_conv.equals(""))	
						policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");
					if(!policy_eff_to_date_conv.equals(""))
						policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
				}
			//	String[] records=new String[53];  //V232504
				String[] records=new String[55];  //V230707
				billing_group_desc=request.getParameter("billing_group_desc"+i);
				if(billing_group_desc==null) billing_group_desc="";
				records[0]=billing_group_desc;
				records[1]=request.getParameter("blng_grp_code"+i);
				existing_blng_grp_name=records[1];
				records[2]=request.getParameter("payer_desc"+i);
				records[3]=request.getParameter("cust_3"+i);
				records[4]=request.getParameter("priority"+i);
				records[5]=request.getParameter("policy_type_desc"+i);
				records[6]=request.getParameter("policy_type_code"+i);
				records[7]=request.getParameter("policy_no"+i);
				records[8]=policy_start_date_conv;
				records[9]=policy_exp_date_conv;
				records[10]=request.getParameter("credit_auth_ref"+i);
				records[11]=credit_auth_date_conv;
				records[12]=request.getParameter("credit_apprd_amt"+i);
				records[13]=request.getParameter("credit_apprd_days"+i);
				records[14]=policy_eff_frm_date_conv;
				records[15]=policy_eff_to_date_conv;
				records[16]=request.getParameter("adj_rule_ind"+i);
				records[17]=request.getParameter("adj_perc_amt_ind"+i);
				records[18]=request.getParameter("adj_perc_amt_value"+i);
				records[19]=request.getParameter("pmnt_diff_adj_int"+i);
				records[20]=request.getParameter("drg_pmnt_diff_adj_int"+i);
				records[21]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
				records[22]=request.getParameter("restrict_check"+i);
				records[23]=request.getParameter("valid_payer_YN"+i);
				records[24]=request.getParameter("valid_policy_type_code_YN"+i);
				records[25]=request.getParameter("ins_cust_group_code"+i);
				records[26]=request.getParameter("policy_coverage_basis_ind"+i);
				records[27]=request.getParameter("referral_source_main_code"+i);
				records[28]=request.getParameter("referral_source_main_desc"+i);
				records[29]=request.getParameter("referral_source_sub_code"+i);
				records[30]=request.getParameter("referral_source_sub_desc"+i);
				records[31]=request.getParameter("apprd_amt_restrict_check"+i);
				records[32]=request.getParameter("apprd_days_restrict_check"+i);
				records[33]=request.getParameter("cred_auth_req_yn"+i);
				records[34]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
				records[35]=request.getParameter("cust_valid_from_date"+i);
				records[36]=request.getParameter("cust_valid_to_date"+i);
				records[37]=request.getParameter("ins_cust_group_name"+i);
				records[39]=request.getParameter("rec_edited_YN"+i);
				records[40]=request.getParameter("cred_auth_mand_capt_yn"+i);
                records[41]=request.getParameter("payerEligibilityParam"+i);
				records[42]=request.getParameter("responseCode"+i);
				records[43]=request.getParameter("responseCodeDesc"+i);
				records[44]=request.getParameter("statuDescription"+i);
				records[45]=request.getParameter("validityPeriod"+i);
				records[46]=request.getParameter("validityPeriodDesc"+i);
				records[47]=request.getParameter("eligibilityCode"+i);
				records[48]=request.getParameter("transactionId"+i);
				records[49]=request.getParameter("responseDateTime"+i);
				records[51]=request.getParameter("mcn_for_policy"+i); //V232504
				records[52]=request.getParameter("reg_ref_id"+i); //V232504
				records[53]="";  //V230707
				records[54]="";  //V230707
				if(records[1].equals(priority_1_blng_grp_code))
				{
					existing_records_array.add(priority_1_blng_grp_index,records);
					priority_1_blng_grp_index++;
				}	
				else
					existing_records_array.add(records);
			}
			objFromBean = addModifyBean.getRefSourceFlagsForP1(priority_1_blng_grp_code, con);
			referral_source_code_flag= objFromBean.get("referral_source_code_flag").getAsString();
			referral_source_main_mand_YN = objFromBean.get("referral_source_main_mand_YN").getAsString();
			referral_source_sub_mand_YN = objFromBean.get("referral_source_sub_mand_YN").getAsString();
			pr_payer_employer_id_mand_YN = objFromBean.get("pr_payer_employer_id_mand_YN").getAsString();
		}
		String accept_check=request.getParameter("accept_check");
		if(accept_check==null) accept_check="";
		if(accept_check.equals("accept") )
		{
			HashMap new_blng_grp_records=(HashMap)session.getAttribute("new_blng_grp_records");
			new_blng_grp_name=(String)session.getAttribute("new_blng_grp_name");
			new_records_array=(ArrayList)new_blng_grp_records.get(new_blng_grp_name);
			record_count=request.getParameter("total_records");
			if(record_count==null) record_count="";
			total_records=Integer.parseInt(record_count);
			for(int i=0;i<total_records;i++)
			{
				policy_start_date_conv=request.getParameter("policy_start_date"+i);
					if(policy_start_date_conv==null) policy_start_date_conv="";
				policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
					if(policy_exp_date_conv==null) policy_exp_date_conv="";
				credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
					if(credit_auth_date_conv==null) credit_auth_date_conv="";
				policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
					if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
				policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
					if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
				if(!locale.equals("en"))
				{
					if(!policy_start_date_conv.equals(""))
						policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
					if(!policy_exp_date_conv.equals(""))
						policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
					if(!credit_auth_date_conv.equals(""))
						credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
					if(!policy_eff_frm_date_conv.equals(""))
						policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");
					if(!policy_eff_to_date_conv.equals(""))
						policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
				}
			//	String[] records=new String[53]; //V232504
				String[] records=new String[55]; //V230707
				billing_group_desc=request.getParameter("billing_group_desc"+i);
				if(billing_group_desc==null) billing_group_desc="";
				records[0]=billing_group_desc;
				records[1]=request.getParameter("blng_grp_code"+i);
				existing_blng_grp_name=records[1];
				records[2]=request.getParameter("payer_desc"+i);
				records[3]=request.getParameter("cust_3"+i);
				records[4]=request.getParameter("priority"+i);
				records[5]=request.getParameter("policy_type_desc"+i);
				records[6]=request.getParameter("policy_type_code"+i);
				records[7]=request.getParameter("policy_no"+i);
				records[8]=policy_start_date_conv;
				records[9]=policy_exp_date_conv;
				records[10]=request.getParameter("credit_auth_ref"+i);
				records[11]=credit_auth_date_conv;
				records[12]=request.getParameter("credit_apprd_amt"+i);
				records[13]=request.getParameter("credit_apprd_days"+i);
				records[14]=policy_eff_frm_date_conv;
				records[15]=policy_eff_to_date_conv;
				records[16]=request.getParameter("adj_rule_ind"+i);
				records[17]=request.getParameter("adj_perc_amt_ind"+i);
				records[18]=request.getParameter("adj_perc_amt_value"+i);
				records[19]=request.getParameter("pmnt_diff_adj_int"+i);
				records[20]=request.getParameter("drg_pmnt_diff_adj_int"+i);
				records[21]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
				records[22]=request.getParameter("restrict_check"+i);
				records[23]=request.getParameter("valid_payer_YN"+i);
				records[24]=request.getParameter("valid_policy_type_code_YN"+i);
				records[25]=request.getParameter("ins_cust_group_code"+i);
				records[26]=request.getParameter("policy_coverage_basis_ind"+i);
				records[27]=request.getParameter("referral_source_main_code"+i);
				records[28]=request.getParameter("referral_source_main_desc"+i);
				records[29]=request.getParameter("referral_source_sub_code"+i);
				records[30]=request.getParameter("referral_source_sub_desc"+i);
				
				records[31]=request.getParameter("apprd_amt_restrict_check"+i);
				records[32]=request.getParameter("apprd_days_restrict_check"+i);
				records[33]=request.getParameter("cred_auth_req_yn"+i);
				records[34]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
				records[35]=request.getParameter("cust_valid_from_date"+i);
				records[36]=request.getParameter("cust_valid_to_date"+i);
				records[37]=request.getParameter("ins_cust_group_name"+i);
				records[39]="Y";
				records[40]=request.getParameter("cred_auth_mand_capt_yn"+i);
				records[41]=request.getParameter("payerEligibilityParam"+i);
				records[42]=request.getParameter("responseCode"+i);
				records[43]=request.getParameter("responseCodeDesc"+i);
				records[44]=request.getParameter("statuDescription"+i);
				records[45]=request.getParameter("validityPeriod"+i);
				records[46]=request.getParameter("validityPeriodDesc"+i);
				records[47]=request.getParameter("eligibilityCode"+i);
				records[48]=request.getParameter("transactionId"+i);
				records[49]=request.getParameter("responseDateTime"+i);	
				records[50]=policy_eff_to_date_conv;//Added V180806-Aravindh/ARYU-SCF-0113
				records[51]=request.getParameter("mcn_for_policy"+i);  //V232504					
				records[52]=request.getParameter("reg_ref_id"+i);  //V232504
				records[53]="";  //V230707
				records[54]="";  //V230707
				existing_records_array.add(records);
			}
		//	String[] output3=new String[53];  //V232504
			String[] output3=new String[55];  //V230707
			System.err.println("new_records_array size is: "+new_records_array.size());
			for(int j=0;j<new_records_array.size();j++)
			{	
				output3=(String[])new_records_array.get(j);
				existing_records_array.add(output3);
			}
		}
		String remove_check=request.getParameter("remove_check");	
		if(remove_check==null) remove_check="";
		if(checked_row==null) checked_row="";
		if(remove_check.equals("remove"))
		{
			record_count=request.getParameter("total_records");
			if(record_count==null) record_count="0";
			total_records=Integer.parseInt(record_count);
			checked_row=request.getParameter("checked_row");
			if(checked_row==null) checked_row="0";
			selected_index=Integer.parseInt(checked_row);
			for(int i=0;i<total_records;i++)
			{
				if(!(i==selected_index))
				{
					policy_start_date_conv=request.getParameter("policy_start_date"+i);
					if(policy_start_date_conv==null) policy_start_date_conv="";
					policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
						if(policy_exp_date_conv==null) policy_exp_date_conv="";
					credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
						if(credit_auth_date_conv==null) credit_auth_date_conv="";
					policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
						if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
					policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
						if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
						policy_eff_to_date_Org=request.getParameter("tmp_pol_eff_to"+i);	
						if(policy_eff_to_date_Org==null) policy_eff_to_date_Org=""; 
					if(!locale.equals("en"))
					{
						if(!policy_start_date_conv.equals(""))
							policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
						if(!policy_exp_date_conv.equals(""))
							policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
						if(!credit_auth_date_conv.equals(""))
							credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
						if(!policy_eff_frm_date_conv.equals(""))
							policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");
						if(!policy_eff_to_date_conv.equals(""))
							policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
					}
					String[] records=new String[55];  //V230707
					billing_group_desc=request.getParameter("billing_group_desc"+i);
					if(billing_group_desc==null) billing_group_desc="";
					records[0]=billing_group_desc;
					records[1]=request.getParameter("blng_grp_code"+i);
					existing_blng_grp_name=records[1];
					records[2]=request.getParameter("payer_desc"+i);
					records[3]=request.getParameter("cust_3"+i);
					records[4]=request.getParameter("priority"+i);
					records[5]=request.getParameter("policy_type_desc"+i);
					records[6]=request.getParameter("policy_type_code"+i);
					records[7]=request.getParameter("policy_no"+i);
					records[8]=policy_start_date_conv;
					records[9]=policy_exp_date_conv;
					records[10]=request.getParameter("credit_auth_ref"+i);
					records[11]=credit_auth_date_conv;
					records[12]=request.getParameter("credit_apprd_amt"+i);
					records[13]=request.getParameter("credit_apprd_days"+i);
					records[14]=policy_eff_frm_date_conv;
					records[15]=policy_eff_to_date_conv;
					records[16]=request.getParameter("adj_rule_ind"+i);
					records[17]=request.getParameter("adj_perc_amt_ind"+i);
					records[18]=request.getParameter("adj_perc_amt_value"+i);
					records[19]=request.getParameter("pmnt_diff_adj_int"+i);
					records[20]=request.getParameter("drg_pmnt_diff_adj_int"+i);
					records[21]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
					records[22]=request.getParameter("restrict_check"+i);
					records[23]=request.getParameter("valid_payer_YN"+i);
					records[24]=request.getParameter("valid_policy_type_code_YN"+i);
					records[25]=request.getParameter("ins_cust_group_code"+i);
					records[26]=request.getParameter("policy_coverage_basis_ind"+i);
					records[27]=request.getParameter("referral_source_main_code"+i);
					records[28]=request.getParameter("referral_source_main_desc"+i);
					records[29]=request.getParameter("referral_source_sub_code"+i);
					records[30]=request.getParameter("referral_source_sub_desc"+i);
					records[31]=request.getParameter("apprd_amt_restrict_check"+i);
					records[32]=request.getParameter("apprd_days_restrict_check"+i);
					records[33]=request.getParameter("cred_auth_req_yn"+i);
					records[34]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
					records[35]=request.getParameter("cust_valid_from_date"+i);
					records[36]=request.getParameter("cust_valid_to_date"+i);
					records[37]=request.getParameter("ins_cust_group_name"+i);
					records[39]=request.getParameter("rec_edited_YN"+i);
					records[40]=request.getParameter("cred_auth_mand_capt_yn"+i);
					records[41]=request.getParameter("payerEligibilityParam"+i);
					records[42]=request.getParameter("responseCode"+i);
					records[43]=request.getParameter("responseCodeDesc"+i);
					records[44]=request.getParameter("statuDescription"+i);
					records[45]=request.getParameter("validityPeriod"+i);
					records[46]=request.getParameter("validityPeriodDesc"+i);
					records[47]=request.getParameter("eligibilityCode"+i);
					records[48]=request.getParameter("transactionId"+i);
					records[49]=request.getParameter("responseDateTime"+i);
					records[50]=policy_eff_to_date_Org;	//Added By Vijay for MMS-QF-SCf-567
					records[51]=request.getParameter("mcn_for_policy"+i);  //V220908					
					records[52]=request.getParameter("reg_ref_id"+i);  //V230315
					records[53]=request.getParameter("userId_for_priv"+i);  //V230707
					records[54]=request.getParameter("reasonCode_for_priv"+i);  //V230707						
					existing_records_array.add(records);
				}else{
								/***************Package Billing Changes ***********start***************/
				if(package_enabled_yn.equals("Y")){
					String mapKey=request.getParameter("blng_grp_code"+i)+"~~"+request.getParameter("ins_cust_group_code"+i)+"~~"+request.getParameter("cust_3"+i)+"~~"+request.getParameter("priority"+i)+"~~"+request.getParameter("policy_type_code"+i)+"~~"+request.getParameter("policy_no"+i)+"~~"+request.getParameter("policy_eff_frm_date"+i);
					HashMap payerDtls=(HashMap)bean.getPayerDtls();
					if(payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(mapKey))
						payerDtls.remove(mapKey);
					bean.setPayerDtls(payerDtls);
					bean.setDetails(new ArrayList());	
					}
					/***************Package Billing Changes ***********end***************/
				}
			}
		}
		String add_check=request.getParameter("add_check");
		if(add_check==null) add_check="";
		if(add_check.equals("add"))
		{
			String ins_parameters=request.getParameter("retVal");
			if(ins_parameters==null || ins_parameters.equals("")) ins_parameters="";
			ins_parameters = java.net.URLDecoder.decode(ins_parameters,"UTF-8");
			StringTokenizer st=new StringTokenizer(ins_parameters,"^~^");
			String blng_grp_desc="";
			String[] records=new String[55];   //V230707
			int j=0;
			while(st.hasMoreTokens())
			{
				try{
					records[j]=st.nextToken();
					if(records[j].equals(" ")) records[j]="";
					j++;
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			String blng_grp_code=records[1];
			objFromBean=addModifyBean.getblngGrpDesc(blng_grp_code,locale,con);
			blng_grp_desc=objFromBean.get("blng_grp_desc").getAsString();
			records[0]=blng_grp_desc;
			record_count=request.getParameter("total_records");
			if(record_count==null) record_count="";
			total_records=Integer.parseInt(record_count);
			String check_rec_avail="N";
			if(total_records >0)
			{
				for(int i=0;i<total_records;i++)
				{
					String temp_blng_grp_code=request.getParameter("blng_grp_code"+i);
					if(blng_grp_code.equals(temp_blng_grp_code))
					{
						records[27]=request.getParameter("referral_source_main_code"+i);
						records[28]=request.getParameter("referral_source_main_desc"+i);
						records[29]=request.getParameter("referral_source_sub_code"+i);
						records[30]=request.getParameter("referral_source_sub_desc"+i);
						check_rec_avail="Y";
					}
				}
			}
			else
			{
				records[27]="";
				records[28]="";
				records[29]="";
				records[30]="";
			}

			if(check_rec_avail.equals("N"))
			{
				records[27]="";
				records[28]="";
				records[29]="";
				records[30]="";
			}
			for(int i=0;i<total_records;i++)
			{
				policy_start_date_conv=request.getParameter("policy_start_date"+i);
				if(policy_start_date_conv==null) policy_start_date_conv="";
				policy_exp_date_conv=request.getParameter("policy_exp_date"+i);
				if(policy_exp_date_conv==null) policy_exp_date_conv="";
				credit_auth_date_conv=request.getParameter("credit_auth_date"+i);
				if(credit_auth_date_conv==null) credit_auth_date_conv="";
				policy_eff_frm_date_conv=request.getParameter("policy_eff_frm_date"+i);
				if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
				policy_eff_to_date_conv=request.getParameter("policy_eff_to_date"+i);
				if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
				if(!locale.equals("en"))
				{
					if(!policy_start_date_conv.equals(""))
						policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY",locale,"en");
					if(!policy_exp_date_conv.equals(""))
						policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY",locale,"en");
					if(!credit_auth_date_conv.equals(""))
						credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY",locale,"en");
					if(!policy_eff_frm_date_conv.equals(""))
						policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY",locale,"en");
					if(!policy_eff_to_date_conv.equals(""))
						policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY",locale,"en");
				}
				String[] existing_records=new String[55];   //V230707
				billing_group_desc=request.getParameter("billing_group_desc"+i);
				if(billing_group_desc==null) billing_group_desc="";
				existing_records[0]=billing_group_desc;
				existing_records[1]=request.getParameter("blng_grp_code"+i);
				existing_blng_grp_name=records[1];
				existing_records[2]=request.getParameter("payer_desc"+i);
				existing_records[3]=request.getParameter("cust_3"+i);
				existing_records[4]=request.getParameter("priority"+i);
				existing_records[5]=request.getParameter("policy_type_desc"+i);
				existing_records[6]=request.getParameter("policy_type_code"+i);
				existing_records[7]=request.getParameter("policy_no"+i);
				existing_records[8]=policy_start_date_conv;
				existing_records[9]=policy_exp_date_conv;
				existing_records[10]=request.getParameter("credit_auth_ref"+i);
				existing_records[11]=credit_auth_date_conv;
				existing_records[12]=request.getParameter("credit_apprd_amt"+i);
				existing_records[13]=request.getParameter("credit_apprd_days"+i);
				existing_records[14]=policy_eff_frm_date_conv;
				existing_records[15]=policy_eff_to_date_conv;
				existing_records[16]=request.getParameter("adj_rule_ind"+i);
				existing_records[17]=request.getParameter("adj_perc_amt_ind"+i);
				existing_records[18]=request.getParameter("adj_perc_amt_value"+i);
				existing_records[19]=request.getParameter("pmnt_diff_adj_int"+i);
				existing_records[20]=request.getParameter("drg_pmnt_diff_adj_int"+i);
				existing_records[21]=request.getParameter("spl_srv_pmnt_diff_adj_int"+i);
				existing_records[22]=request.getParameter("restrict_check"+i);
				existing_records[23]=request.getParameter("valid_payer_YN"+i);
				existing_records[24]=request.getParameter("valid_policy_type_code_YN"+i);
				existing_records[25]=request.getParameter("ins_cust_group_code"+i);
				existing_records[26]=request.getParameter("policy_coverage_basis_ind"+i);
				existing_records[27]=request.getParameter("referral_source_main_code"+i);
				existing_records[28]=request.getParameter("referral_source_main_desc"+i);
				existing_records[29]=request.getParameter("referral_source_sub_code"+i);
				existing_records[30]=request.getParameter("referral_source_sub_desc"+i);
				existing_records[31]=request.getParameter("apprd_amt_restrict_check"+i);
				existing_records[32]=request.getParameter("apprd_days_restrict_check"+i);
				existing_records[33]=request.getParameter("cred_auth_req_yn"+i);
				existing_records[34]=request.getParameter("dflt_auth_ref_as_pol_no_yn"+i);
				existing_records[35]=request.getParameter("cust_valid_from_date"+i);
				existing_records[36]=request.getParameter("cust_valid_to_date"+i);
				existing_records[37]=request.getParameter("ins_cust_group_name"+i);
				existing_records[39]=request.getParameter("rec_edited_YN"+i);
				existing_records[40]=request.getParameter("cred_auth_mand_capt_yn"+i);
				existing_records[41]=request.getParameter("payerEligibilityParam"+i);
				System.err.println("payerEligibilityParam is: "+existing_records[41]);
				existing_records[42]=request.getParameter("responseCode"+i);
				existing_records[43]=request.getParameter("responseCodeDesc"+i);
				existing_records[44]=request.getParameter("statuDescription"+i);
				existing_records[45]=request.getParameter("validityPeriod"+i);
				existing_records[46]=request.getParameter("validityPeriodDesc"+i);
				existing_records[47]=request.getParameter("eligibilityCode"+i);
				existing_records[48]=request.getParameter("transactionId"+i);
				existing_records[49]=request.getParameter("responseDateTime"+i);
				existing_records[50]=request.getParameter("tmp_pol_eff_to"+i);
				existing_records[51]=request.getParameter("mcn_for_policy"+i);  //V220908
				existing_records[52]=request.getParameter("reg_ref_id"+i);  //V230315
				existing_records[53]=request.getParameter("userId_for_priv"+i);  //V230707
				existing_records[54]=request.getParameter("reasonCode_for_priv"+i);  //V230707	
				existing_records_array1.add(existing_records);
			}
			String desc="";
			int count = 0;
			boolean flag = false;
			int size=existing_records_array1.size();
			for (int k=0;k<existing_records_array1.size();k++)
			{
				String[] record1 = (String[]) existing_records_array1.get(k);
				desc = record1[0];

				if(desc.equals(records[0]))
				{
					count++;
				}
				if(count > 0 && !desc.equals(records[0]))
				{
					count = k;
					flag = true;
					break;
				}
			}
			if(flag)
			{
				existing_records_array1.add(count,records);
			}
			else
			{
				count = size;
				existing_records_array1.add(count++,records);
			}
			int count1=0;
			for (int k=0;k<existing_records_array1.size();k++)
			{
				String[] record1 = (String[]) existing_records_array1.get(k);
				String blng_grp_id=record1[1];
				if(blng_grp_id.equals(request.getParameter("billing_group")))
				{
					existing_records_array.add(count1,record1);
					count1++;
				}
				else
				{
					existing_records_array.add(record1);
				}
			}
		}
		String patient_id = request.getParameter("patient_id");		
		if (patient_id == null ) patient_id = "";
		int totalRecords=0;
		String nd_settlement_ind ="";
		String nd_adm_rec_flag ="";
		String ins_auth_flag="";
		String cust_4="", cash_set_type2="", cash_insmt_ref1="";
		String rtn_ins_blng_grp="",rtn_ins_cust_group_code="",rtn_ins_cust_code="", rtn_ins_cust_priority="",rtn_ins_policy_type_code="", rtn_ins_policy_no="", rtn_mcn_for_policy="", rtn_reg_ref_id="";
		String rtn_ins_policy_start_date="",rtn_ins_policy_expiry_date="",rtn_ins_credit_auth_ref="",rtn_ins_credit_auth_date="";
		String rtn_ins_credit_approval_days="",rtn_ins_credit_approval_amount="";
		String rtn_ins_policy_eff_from_date="",rtn_ins_policy_eff_to_date="";
		String rtn_ins_adj_rule_ind="",rtn_ins_adj_perc_amt_ind="",rtn_ins_adj_perc_amt_value="";
		String rtn_ins_pmnt_diff_adj_int="",rtn_ins_drg_pmnt_diff_adj_int="",rtn_ins_spl_srv_pmnt_diff_adj_int="";
		String rtn_ins_ref_src_main_code ="", rtn_ins_ref_src_main_desc="",rtn_ins_ref_src_sub_code="",rtn_ins_ref_src_sub_desc="";
		String rtn_ins_restrict_check = "", rtn_ins_apprd_amt_restrict_check = "", rtn_ins_apprd_days_restrict_check= "";
		String rtn_ins_cred_auth_req_yn="", rtn_ins_dflt_auth_ref_as_pol_no_yn ="", rtn_ins_cred_auth_mand_capt_yn ="";
		String rtn_payerEligibilityParamSession ="", rtn_responseCode="",rtn_responseCodeDesc="",rtn_statuDescription="";
		String rtn_validityPeriod ="", rtn_validityPeriodDesc="",rtn_eligibilityCode="",rtn_transactionId="",rtn_responseDateTime="";
		String rtn_userId_for_priv ="",rtn_reasonCode_for_priv ="";  //V230707	
		int j=0;
		StringTokenizer token_seperator=null;
		ArrayList mins_blng_grp=new ArrayList();
		ArrayList mcust_group_3=new ArrayList();
		ArrayList mcust_group_desc=new ArrayList();
		ArrayList mpayer_desc=new ArrayList();
		ArrayList mcust_3=new ArrayList();
		ArrayList mins_cust_priority=new ArrayList();
		ArrayList mpolicy_no=new ArrayList();
		ArrayList mpolicy_type_code=new ArrayList();
		ArrayList mpolicy_type_desc=new ArrayList();
		ArrayList mpolicy_start_date=new ArrayList();
		ArrayList mpolicy_expiry_date=new ArrayList();
		ArrayList mcredit_auth_ref=new ArrayList();
		ArrayList mcredit_auth_date=new ArrayList();
		ArrayList mcred_auth_req_yn=new ArrayList();
		ArrayList mcred_auth_mand_capt_yn=new ArrayList();
		ArrayList mdflt_auth_ref_as_pol_no_yn=new ArrayList();
		ArrayList mcredit_apprd_days=new ArrayList();
		ArrayList mcredit_apprd_amt=new ArrayList();
		ArrayList mpolicy_eff_frm_date=new ArrayList();
		ArrayList mpolicy_eff_to_date=new ArrayList();
		ArrayList m_mcn_for_policy=new ArrayList();  //V220908
		ArrayList m_reg_ref_id = new ArrayList();  //V230315
		ArrayList muserId_for_priv=new ArrayList();  //V230707
		ArrayList mreasonCode_for_priv=new ArrayList();  //V230707
		ArrayList madj_rule_ind=new ArrayList();
		ArrayList madj_perc_amt_ind=new ArrayList();
		ArrayList madj_perc_amt_value=new ArrayList();
		ArrayList mpmnt_diff_adj_int=new ArrayList();
		ArrayList mdrg_pmnt_diff_adj_int=new ArrayList();
		ArrayList mspl_srv_pmnt_diff_adj_int=new ArrayList();
		ArrayList mref_ins_src_main_code=new ArrayList();
		ArrayList mref_ins_src_main_desc=new ArrayList();
		ArrayList mref_ins_src_sub_code=new ArrayList();
		ArrayList mref_ins_src_sub_desc=new ArrayList();
		ArrayList mrestrict_check=new ArrayList();
		ArrayList mapprd_amt_restrict_check=new ArrayList();
		ArrayList mapprd_days_restrict_check=new ArrayList();
		ArrayList mins_payerEligibilityParamSession=new ArrayList();
		ArrayList mins_responseCode=new ArrayList();
		ArrayList mins_responseCodeDesc=new ArrayList();
		ArrayList mins_statuDescription=new ArrayList();
		ArrayList mins_validityPeriod=new ArrayList();
		ArrayList mins_validityPeriodDesc=new ArrayList();
		ArrayList mins_eligibilityCode=new ArrayList();
		ArrayList mins_transactionId=new ArrayList();
		ArrayList mins_responseDateTime=new ArrayList();
		String  mnon_insur_blng_grp="", sys_date="",billing_group="";
		String rtn_slmt_type_code="";String rtn_non_ins_blng_grp="";
		String ref_src_main_lng_name = "";
		String ref_src_sub_lng_name = "";
		String strModuleId = "";
		strModuleId=request.getParameter("calling_module_id");
		if(strModuleId==null || strModuleId.equals("")) strModuleId="";
		String str_function_id = request.getParameter("calling_function_id");
		if(str_function_id == null) str_function_id="";
		String p_patient_class  = request.getParameter("patient_class");
		if(p_patient_class ==null || (p_patient_class.equals("")))
		{
			if(strModuleId.equals("MP")) p_patient_class="XT";
			else if(strModuleId.equals("AE")) p_patient_class="EM";
			else if(strModuleId.equals("OP")) p_patient_class="OP";
			else if(strModuleId.equals("IP")) p_patient_class="IP";
			else if(strModuleId.equals("DC")) p_patient_class="DC";
		}
		String episode_type="";
		if(strModuleId.equals("MP")) episode_type="R";
		else if(strModuleId.equals("AE")) episode_type="E";
		else if(strModuleId.equals("OP")) episode_type="O";
		else if(strModuleId.equals("IP")) episode_type="I";
		else if(strModuleId.equals("DC")) episode_type="D";
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";		
		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}
		if(((billing_mode.equals("Modify")) || (operation.equals("Update"))) && !(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				billing_group=(String)bl_data.get("blng_grp");
				rtn_ins_blng_grp=(String)bl_data.get("ins_blng_grp");
				rtn_slmt_type_code=(String)bl_data.get("slmt_type_code");
				rtn_ins_cust_group_code = (String)bl_data.get("ins_cust_group_code");
				rtn_ins_cust_code=(String)bl_data.get("ins_cust_code");
				rtn_ins_cust_priority=(String)bl_data.get("ins_cust_priority");
				rtn_ins_policy_type_code=(String)bl_data.get("ins_policy_type_code");
				rtn_ins_policy_no=(String)bl_data.get("ins_policy_no");
				rtn_ins_policy_start_date=(String)bl_data.get("ins_policy_start_date");
				rtn_ins_policy_expiry_date=(String)bl_data.get("ins_policy_expiry_date");
				rtn_ins_credit_auth_ref=(String)bl_data.get("ins_credit_auth_ref");
				rtn_ins_credit_auth_date=(String)bl_data.get("ins_credit_auth_date");
				rtn_ins_cred_auth_req_yn=(String)bl_data.get("ins_cred_auth_req_yn");
				rtn_ins_cred_auth_mand_capt_yn=(String)bl_data.get("ins_cred_auth_mand_capt_yn");
				rtn_ins_dflt_auth_ref_as_pol_no_yn=(String)bl_data.get("ins_dflt_auth_ref_as_pol_no_yn");
				rtn_ins_credit_approval_days=(String)bl_data.get("ins_credit_approval_days");
				rtn_ins_credit_approval_amount=(String)bl_data.get("ins_credit_approval_amount");
				rtn_ins_policy_eff_from_date=(String)bl_data.get("ins_policy_eff_from_date");
				rtn_ins_policy_eff_to_date=(String)bl_data.get("ins_policy_eff_to_date");
				rtn_mcn_for_policy=(String)bl_data.get("mcn_for_policy"); //V220908
				if(rtn_mcn_for_policy == null) rtn_mcn_for_policy="";
				rtn_reg_ref_id=(String)bl_data.get("reg_ref_id"); //V230315
				if(rtn_reg_ref_id == null) rtn_reg_ref_id="";
				rtn_userId_for_priv = ((String)bl_data.get("userId_for_priv"));   //V230707
				if(rtn_userId_for_priv == null) rtn_userId_for_priv="";
				rtn_reasonCode_for_priv = ((String)bl_data.get("reasonCode_for_priv"));   //V230707
				if(rtn_reasonCode_for_priv == null) rtn_reasonCode_for_priv="";
				rtn_ins_adj_rule_ind=(String)bl_data.get("ins_adj_rule_ind");
				rtn_ins_adj_perc_amt_ind=(String)bl_data.get("ins_adj_perc_amt_ind");
				rtn_ins_adj_perc_amt_value=(String)bl_data.get("ins_adj_perc_amt_value");
				rtn_ins_pmnt_diff_adj_int=(String)bl_data.get("ins_pmnt_diff_adj_int");
				rtn_ins_drg_pmnt_diff_adj_int=(String)bl_data.get("ins_drg_pmnt_diff_adj_int");
				rtn_ins_spl_srv_pmnt_diff_adj_int=(String)bl_data.get("ins_spl_srv_pmnt_diff_adj_int");
				rtn_ins_ref_src_main_code =(String)bl_data.get("ins_ref_src_main_code");
				if(rtn_ins_ref_src_main_code == null) rtn_ins_ref_src_main_code="";
				rtn_ins_ref_src_main_desc=(String)bl_data.get("ins_ref_src_main_desc");
				if(rtn_ins_ref_src_main_desc == null) rtn_ins_ref_src_main_desc="";
				rtn_ins_ref_src_sub_code=(String)bl_data.get("ins_ref_src_sub_code");
				if(rtn_ins_ref_src_sub_code == null) rtn_ins_ref_src_sub_code="";
				rtn_ins_ref_src_sub_desc=(String)bl_data.get("ins_ref_src_sub_desc");
				if(rtn_ins_ref_src_sub_desc == null) rtn_ins_ref_src_sub_desc="";
				rtn_ins_restrict_check=(String)bl_data.get("ins_restrict_check");
				if(rtn_ins_restrict_check == null) rtn_ins_restrict_check="";
				rtn_ins_apprd_amt_restrict_check=(String)bl_data.get("ins_apprd_amt_restrict_check");
				if(rtn_ins_apprd_amt_restrict_check == null) rtn_ins_apprd_amt_restrict_check="";
				rtn_ins_apprd_days_restrict_check=(String)bl_data.get("ins_apprd_days_restrict_check");
				if(rtn_ins_apprd_days_restrict_check == null) rtn_ins_apprd_days_restrict_check="";
				fin_dtls_updated_YN=(String)bl_data.get("fin_dtls_updated_YN");
				if(fin_dtls_updated_YN==null) fin_dtls_updated_YN="N";
				fin_class_dtls_updated_YN=(String)bl_data.get("fin_class_dtls_updated_YN");
				if(fin_class_dtls_updated_YN==null) fin_class_dtls_updated_YN="N";
				rtn_payerEligibilityParamSession=(String)bl_data.get("rtn_payerEligibilityParamSession");
				if(rtn_payerEligibilityParamSession == null) rtn_payerEligibilityParamSession="";
				rtn_responseCode=(String)bl_data.get("rtn_responseCode");
				if(rtn_responseCode == null) rtn_responseCode="";
				rtn_responseCodeDesc=(String)bl_data.get("rtn_responseCodeDesc");
				if(rtn_responseCodeDesc == null) rtn_responseCodeDesc="";
				rtn_statuDescription=(String)bl_data.get("rtn_statuDescription");
				if(rtn_statuDescription == null) rtn_statuDescription="";
				rtn_validityPeriod=(String)bl_data.get("rtn_validityPeriod");
				if(rtn_validityPeriod == null) rtn_validityPeriod="";
				rtn_validityPeriodDesc=(String)bl_data.get("rtn_validityPeriodDesc");
				if(rtn_validityPeriodDesc == null) rtn_validityPeriodDesc="";
				rtn_eligibilityCode=(String)bl_data.get("rtn_eligibilityCode");
				if(rtn_eligibilityCode == null) rtn_eligibilityCode="";
				rtn_transactionId=(String)bl_data.get("rtn_transactionId");
				if(rtn_transactionId == null) rtn_transactionId="";
				rtn_responseDateTime=(String)bl_data.get("rtn_responseDateTime");
				if(rtn_responseDateTime == null) rtn_responseDateTime="";
				cust_4=((String)bl_data.get("non_ins_cust_code")).trim();
				if(cust_4 == null) cust_4="";
				cash_set_type2=((String)bl_data.get("non_ins_slmt_type_code")).trim();
				if(cash_set_type2 == null) cash_set_type2="";
				cash_insmt_ref1=((String)bl_data.get("inst_ref")).trim();
				if(cash_insmt_ref1 == null) cash_insmt_ref1="";
				
				
				
				if(session.getAttribute("CLAIM_CREDIT_MAP_SESSION")==null){
				HashMap<String,String> claimCreditMapFromBean=new HashMap<String,String>();				
				claimCreditMapFromBean=addModifyBean.claimCreditMap(rtn_ins_cust_priority, rtn_ins_cust_group_code, rtn_ins_cust_code, rtn_ins_policy_start_date, rtn_ins_policy_expiry_date, rtn_ins_policy_eff_from_date, rtn_ins_policy_no, patient_id, con);
				session.setAttribute("CLAIM_CREDIT_MAP_SESSION", claimCreditMapFromBean);
			}
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");	
			if( billing_group == null) billing_group="";
		}

		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}
		ArrayList<String> defaultLoadedBillingGroupInfo=new ArrayList<String>();
		String strDefaultInfo="";
		if(session.getAttribute("BL_DEFAULT_LOADED_BLNG_GROUP_INFO")==null){
			
			StringTokenizer stCustGrpTok=new StringTokenizer(rtn_ins_cust_group_code,"|");
			StringTokenizer stCustCodeTok=new StringTokenizer(rtn_ins_cust_code,"|");
			StringTokenizer stCustPlcyTok=new StringTokenizer(rtn_ins_policy_type_code,"|");			
			while(stCustGrpTok.hasMoreTokens()){
				strDefaultInfo = stCustGrpTok.nextToken()+"|"+stCustCodeTok.nextToken()+"|"+stCustPlcyTok.nextToken();
				defaultLoadedBillingGroupInfo.add(strDefaultInfo);
			}			
			session.setAttribute("BL_DEFAULT_LOADED_BLNG_GROUP_INFO",defaultLoadedBillingGroupInfo);	
			
		}						
		try
		{
			String sql_trunc_time="select to_char((to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy') from dual";
			
			pstmt = con.prepareStatement(sql_trunc_time);
			pstmt.setString(1,encounter_date_time);
			
			rs = pstmt.executeQuery() ;
		if( rs!= null ) 
		{
			while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
					encounter_date_time = rs.getString(1);//muthu - 32139 
					sys_date = rs.getString(2);
				}				
			}
			if (rs != null)   rs.close();
		if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(encounter_date_aft_trunc == null) encounter_date_aft_trunc="";
		
		if(refresh_check.equals("Y"))
		{
			if(!blng_grp_code_for_pkg_use.equals("") && !patient_id.equals(""))
			{
				
				str_valid_pkg_for_pat_bg_avail_YN=addModifyBean.getPackageBlngGrpYn(facility_id, patient_id, episode_type, calling_function_id, blng_grp_code_for_pkg_use, encounter_date_aft_trunc, con);
			}
		}
		String strBlngGrpAppYN= "Y";
		String strBlngGrpStatus="";
		String strBlngGrpCatgAppYN = "Y";		
		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		String clinic_code = request.getParameter("clinic_code");
		String visit_type_code = request.getParameter("visit_type_code");
		String strshowHideBlngClass = request.getParameter("show_hide_blng_class");
		String l_credit_doc_ref_desc = "";
		String l_credit_doc_ref_start_date = "";
		String l_credit_doc_ref_date =  "";
		String l_cust_code = "";
		String l_slmt_ind = "";
		String l_adm_rec_flag = "";
		String strCitizenYn = "N";		
		String nationalityyn = "";
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
		if(pstmt != null) pstmt.close();
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
		strModuleId = request.getParameter("calling_module_id");
		String strExtSettlType ="";
		String strSettlTypeOverride ="";		
		nationalityyn = request.getParameter("nationality_yn");		
	    if (nationalityyn == null) nationalityyn = "";	
		if (strModuleId.equals("MP"))
		{
			strCitizenYn = nationalityyn;
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
			}
		}

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			int rec_aval_check = 0;
		
			token_seperator=new StringTokenizer(rtn_ins_blng_grp,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_blng_grp.add(j,s1);
				j++;
			}
			token_seperator=new StringTokenizer(rtn_ins_cust_group_code,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String short_name="";
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("")  || s1.equals(" ")) s1="";
				mcust_group_3.add(j,s1);
				if(!s1.equals(""))
				{
					String payer_group_sql="select SHORT_DESC short_name from ar_cust_group_lang_vw where cust_group_code='"+s1+"' and language_id='"+locale+"'";
					rec_aval_check = 0;
					pstmt = con.prepareStatement(payer_group_sql);
					rs = pstmt.executeQuery() ;
					if( rs != null) 
					{
						while( rs.next() ) 
						{
							short_name=(String)rs.getString("short_name");
							if(short_name==null || short_name.equals("")) short_name="";
							mcust_group_desc.add(j,short_name);
							rec_aval_check++;
						}
						if(rec_aval_check==0)
						{
							mcust_group_desc.add(j,short_name);
						}
					}
					else
					{
						mcust_group_desc.add(j,"");
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
				else
				{
					mcust_group_desc.add(j,short_name);
				}
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_cust_code,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String short_name="";
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("")  || s1.equals(" ")) s1="";
				mcust_3.add(j,s1);
				if(!s1.equals(""))
				{
					String payer_sql="select short_name from ar_customer_lang_vw where cust_code='"+s1+"' and language_id='"+locale+"' 	";
					rec_aval_check = 0;

					pstmt = con.prepareStatement(payer_sql);
					rs = pstmt.executeQuery() ;
					if( rs != null) 
					{
						while( rs.next() ) 
						{
							short_name=(String)rs.getString("short_name");
							if(short_name==null || short_name.equals("")) short_name="";
							mpayer_desc.add(j,short_name);
							rec_aval_check++;
						}
						if(rec_aval_check==0)
						{
							mpayer_desc.add(j,short_name);
						}
					}
					else
					{
						mpayer_desc.add(j,"");
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
				else
				{
					mpayer_desc.add(j,short_name);
				}
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_cust_priority,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				mins_cust_priority.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_type_code,"|");//rtn_ins_cust_priority
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String short_desc="";
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_type_code.add(j,s1);

				if(!s1.equals(""))
				{
					String policy_type_desc_sql="select short_desc from bl_ins_policy_types_lang_vw where language_id='"+locale+"'  and  policy_type_code='"+s1+"'"; 
					rec_aval_check = 0;

					pstmt = con.prepareStatement(policy_type_desc_sql);
					rs = pstmt.executeQuery() ;
					if( rs != null ) 
					{
						while( rs.next() ) 
						{
							short_desc=(String)rs.getString("short_desc");
							if(short_desc==null || short_desc.equals("")) short_desc="";
							mpolicy_type_desc.add(j,short_desc);
							rec_aval_check++;
						}
						if(rec_aval_check==0)
						{
							mpolicy_type_desc.add(j,short_desc);
						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
				else
				{
					mpolicy_type_desc.add(j,short_desc);
				}
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_no,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_no.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_start_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_start_date.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_expiry_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_expiry_date.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			mnon_insur_blng_grp = rtn_non_ins_blng_grp;//rtn_non_ins_blng_grp 
			if ( mnon_insur_blng_grp == null ) mnon_insur_blng_grp = "";

			token_seperator=new StringTokenizer(rtn_ins_credit_auth_ref,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mcredit_auth_ref.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_credit_auth_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mcredit_auth_date.add(j,s1);				 //rtn_ins_cust_priority
				
				j++;
			}
			
			token_seperator=new StringTokenizer(rtn_mcn_for_policy,"|");  //V220908
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				m_mcn_for_policy.add(j,s1);				 //rtn_mcn_for_policy
				j++;
			}
			
			token_seperator=new StringTokenizer(rtn_reg_ref_id,"|");  //V230315
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				m_reg_ref_id.add(j,s1);				 //reg_ref_id
				j++;
			}  
			//V230315
		
			token_seperator=new StringTokenizer(rtn_ins_cred_auth_req_yn,"|");
			j=0;
			
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="N";
				mcred_auth_req_yn.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_cred_auth_mand_capt_yn,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="N";
				mcred_auth_mand_capt_yn.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}


			token_seperator=new StringTokenizer(rtn_ins_dflt_auth_ref_as_pol_no_yn,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="N";
				mdflt_auth_ref_as_pol_no_yn.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}
			token_seperator=new StringTokenizer(rtn_ins_credit_approval_days,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mcredit_apprd_days.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_credit_approval_amount,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mcredit_apprd_amt.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_policy_eff_from_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_eff_frm_date.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}
			token_seperator=new StringTokenizer(rtn_ins_policy_eff_to_date,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpolicy_eff_to_date.add(j,s1);				 //rtn_ins_cust_priority
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_adj_rule_ind,"|");
			j=0;
			madj_rule_ind.add(j,"");
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				madj_rule_ind.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_adj_perc_amt_ind,"|");
			j=0;
			madj_perc_amt_ind.add(j,"");
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				madj_perc_amt_ind.add(j,s1);
				j++;
			}
			
			token_seperator=new StringTokenizer(rtn_ins_adj_perc_amt_value,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				madj_perc_amt_value.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_pmnt_diff_adj_int,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mpmnt_diff_adj_int.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_drg_pmnt_diff_adj_int,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mdrg_pmnt_diff_adj_int.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_spl_srv_pmnt_diff_adj_int,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mspl_srv_pmnt_diff_adj_int.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_ref_src_main_code,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mref_ins_src_main_code.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_ref_src_main_desc,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mref_ins_src_main_desc.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_ref_src_sub_code,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mref_ins_src_sub_code.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_ref_src_sub_desc,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mref_ins_src_sub_desc.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_restrict_check,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mrestrict_check.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_apprd_amt_restrict_check,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mapprd_amt_restrict_check.add(j,s1);				 
				j++;
			}

			token_seperator=new StringTokenizer(rtn_ins_apprd_days_restrict_check,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mapprd_days_restrict_check.add(j,s1);				 
				j++;
			}
          
		token_seperator=new StringTokenizer(rtn_payerEligibilityParamSession,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_payerEligibilityParamSession.add(j,s1);				 
				j++;
			}
		if(mins_payerEligibilityParamSession.size()==0)
         mins_payerEligibilityParamSession=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_responseCode,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_responseCode.add(j,s1);				 
				j++;
			}
			if(mins_responseCode.size()==0)
            mins_responseCode=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

			
		token_seperator=new StringTokenizer(rtn_responseCodeDesc,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_responseCodeDesc.add(j,s1);				 
				j++;
			}
			if(mins_responseCodeDesc.size()==0)
            mins_responseCodeDesc=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_statuDescription,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_statuDescription.add(j,s1);				 
				j++;
			}
			if(mins_statuDescription.size()==0)
         mins_statuDescription=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_validityPeriod,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_validityPeriod.add(j,s1);				 
				j++;
			}
			if(mins_validityPeriod.size()==0)
         mins_validityPeriod=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_validityPeriodDesc,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_validityPeriodDesc.add(j,s1);				 
				j++;
			}
			if(mins_validityPeriodDesc.size()==0)
         mins_validityPeriodDesc=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_eligibilityCode,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_eligibilityCode.add(j,s1);				 
				j++;
			}
			if(mins_eligibilityCode.size()==0)
         mins_eligibilityCode=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_transactionId,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_transactionId.add(j,s1);				 
				j++;
			}
			if(mins_transactionId.size()==0)
            mins_transactionId=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());

		token_seperator=new StringTokenizer(rtn_responseDateTime,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mins_responseDateTime.add(j,s1);				 
				j++;
			}
			if(mins_responseDateTime.size()==0)
            mins_responseDateTime=AddModifyPatFinDetailsBean.getListWithEmptyValues(mcust_3.size());
		
		//V230707
		token_seperator=new StringTokenizer(rtn_userId_for_priv,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				muserId_for_priv.add(j,s1);				 
				j++;
			}
			
		//V230707
		token_seperator=new StringTokenizer(rtn_reasonCode_for_priv,"|");
			j=0;
			while(token_seperator.hasMoreTokens())
			{
				String s1=(String)token_seperator.nextToken();
				if(s1==null || s1.equals("") || s1.equals(" ")) s1="";
				mreasonCode_for_priv.add(j,s1);				 
				j++;
			}
			
			clinic_code			= request.getParameter("clinic_code");
			if ( clinic_code == null ) clinic_code = "";

			visit_type_code		= request.getParameter("visit_type_code");
			if ( visit_type_code == null ) visit_type_code = "";
			
		}
		if((clinic_code==null) || (clinic_code.equals("null"))) clinic_code="";
		if((visit_type_code==null) || (visit_type_code.equals("null"))) visit_type_code="";
		objFromBean=addModifyBean.getSettlementIndAdmRec(operation, billing_mode, billing_group, con);
		nd_settlement_ind=objFromBean.get("nd_settlement_ind").getAsString();
		nd_adm_rec_flag=objFromBean.get("nd_adm_rec_flag").getAsString();
		strCreditDoc_YN=objFromBean.get("strCreditDoc_YN").getAsString();
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

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            _bw.write(_wl_block8_2Bytes, _wl_block8_2);

if(((billing_mode.equals("Modify")) || (operation.equals("Update"))) && !(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y")))
{
if(!("Y").equalsIgnoreCase(payerGrpBySetup))
	{

            _bw.write(_wl_block9Bytes, _wl_block9);

	}else{
		
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
}else{

            _bw.write(_wl_block11Bytes, _wl_block11);

}

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
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

	String query_default = null;
	ResultSet rs_dflt_ld = null;
	PreparedStatement pstmt_dflt_ld = null;	
	String classval="";
	if((((billing_mode.equals("Modify")) || (operation.equals("Update"))) && fin_dtls_updated_YN.equals("N") && fin_class_dtls_updated_YN.equals("N")) && !(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y")))
	{
		int total_Records=mpolicy_type_code.size();
		totalRecords=0;
		String desc = "";
		String tempDesc = "";
        String payerEligibilityParam="9";
		int priority_count=0;
		if(strModuleId.equalsIgnoreCase("IP") || strModuleId.equalsIgnoreCase("DC")){ 	  
			query_default="select  TO_CHAR(POLICY_EFF_FROM, 'DD/MM/YYYY'),TO_CHAR(POLICY_EFF_TO, 'DD/MM/YYYY'),IP_APPROVED_NO_OF_DAYS,IP_APPROVED_AMT_LIMIT,TO_CHAR(SYSDATE, 'DD/MM/YYYY'),addl_days_policy_expdt from bl_ins_policy_type_hdr where (cust_code = ?  or cust_code = '**') and POLICY_TYPE_CODE=? and rownum=1   order by cust_code desc ";//V210629
		}else if(strModuleId.equalsIgnoreCase("OP") || strModuleId.equalsIgnoreCase("AE")) {	 
			query_default="SELECT TO_CHAR (policy_eff_from, 'DD/MM/YYYY'),TO_CHAR (policy_eff_to, 'DD/MM/YYYY'), op_approved_no_of_days,op_approved_amt_limit, TO_CHAR (SYSDATE, 'DD/MM/YYYY'), addl_days_policy_expdt FROM bl_ins_policy_type_hdr WHERE (cust_code = ?  or cust_code = '**') AND policy_type_code = ? and rownum=1   order by cust_code desc ";//V210629
		}else if(strModuleId.equals("MP")) {
			query_default="select  TO_CHAR(POLICY_EFF_FROM, 'DD/MM/YYYY'),TO_CHAR(POLICY_EFF_TO, 'DD/MM/YYYY'),EX_APPROVED_NO_OF_DAYS,EX_APPROVED_AMT_LIMIT,TO_CHAR(SYSDATE, 'DD/MM/YYYY'),addl_days_policy_expdt from bl_ins_policy_type_hdr where (cust_code = ?  or cust_code = '**')  and POLICY_TYPE_CODE=? and rownum=1   order by cust_code desc ";//V210629
		}
		pstmt_dflt_ld = con.prepareStatement(query_default);
		for(int i=0;i<total_Records;i++)
	    {		
			if(DFLT_POLICY_DEF_IN_VIS_REG_YN.equalsIgnoreCase("Y")){
			pstmt_dflt_ld.setString(1,mcust_3.get(i).toString());
			pstmt_dflt_ld.setString(2,mpolicy_type_code.get(i).toString());
			rs_dflt_ld = pstmt_dflt_ld.executeQuery() ;
			if( rs_dflt_ld != null ) 
			{	
				while( rs_dflt_ld.next() )
				{  
					String tmp_pol_start_date= rs_dflt_ld.getString(1)==null?"":rs_dflt_ld.getString(1);
					String tmp_pol_exp_date= rs_dflt_ld.getString(2)==null?"":rs_dflt_ld.getString(2);
					String tmp_pol_appd_days= rs_dflt_ld.getString(3)==null?"":rs_dflt_ld.getString(3);
					String tmp_pol_appd_amt= rs_dflt_ld.getString(4)==null?"":rs_dflt_ld.getString(4);
					String tmp_pol_eff_from= rs_dflt_ld.getString(5)==null?"":rs_dflt_ld.getString(5);
					String tmp_pol_exp_days= rs_dflt_ld.getString(6)==null?"":rs_dflt_ld.getString(6);
					String tmp_pol_eff_to=(String)mpolicy_eff_to_date.get(i);
					orgPolEffToDate=tmp_pol_eff_to; //Added By Vijay for MMS-QF-SCf-567
					if(tmp_pol_exp_date.equals("") && !tmp_pol_exp_days.equals("") && !tmp_pol_start_date.equals("")){//if (policy END == null && expiry_days ! =null)		policyend  =	policy start  + expirydays;
						Calendar cal = Calendar.getInstance();
					    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	    
					    Timestamp ts_from = new Timestamp(sdf.parse(tmp_pol_start_date).getTime());
						cal.setTime(ts_from);
						cal.add(Calendar.DATE, Integer.parseInt(tmp_pol_exp_days)-1);
						tmp_pol_exp_date=sdf.format(cal.getTime());
					}
					if(!tmp_pol_appd_days.equals("") && !tmp_pol_eff_from.equals("")){ //if (approval_days ! =null)		effectivtodate =	effectivfromdate  + approval_days;
						Calendar cal = Calendar.getInstance();
					    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	    
					    Timestamp ts_from = new Timestamp(sdf.parse(tmp_pol_eff_from).getTime());
						cal.setTime(ts_from);
						cal.add(Calendar.DATE, Integer.parseInt(tmp_pol_appd_days)-1);
						tmp_pol_eff_to=sdf.format(cal.getTime());		
					}else if(!tmp_pol_exp_days.equals("") && !tmp_pol_eff_from.equals("")){ //	if (expiry_days ! =null)		effectivtodate =	effectivfromdate  + expirydays;
						Calendar cal = Calendar.getInstance();
					    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	    
					    Timestamp ts_from = new Timestamp(sdf.parse(tmp_pol_eff_from).getTime());
						cal.setTime(ts_from);
						cal.add(Calendar.DATE, Integer.parseInt(tmp_pol_exp_days)-1);
						tmp_pol_eff_to=sdf.format(cal.getTime());	
					}
					if(tmp_pol_eff_to.equals("") && !tmp_pol_exp_date.equals(""))				
					{
						tmp_pol_eff_to=tmp_pol_exp_date;
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						java.util.Date date_pol_eff_to = sdf.parse(tmp_pol_eff_to);
			     		java.util.Date date_pol_eff_from = sdf.parse(tmp_pol_eff_from);
			     		
		        		long diff = date_pol_eff_to.getTime() - date_pol_eff_from.getTime();
		    			long diffDays =  ( diff / (24 * 60 * 60 * 1000) ) + 1 ; // 1 day added for inclusive purpose
		    			tmp_pol_appd_days=""+diffDays;	
					}					
					else					
					if(!tmp_pol_eff_to.equals("") && !tmp_pol_exp_date.equals("")){
		    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    		java.util.Date date_pol_eff_to = sdf.parse(tmp_pol_eff_to);
		     		java.util.Date date_pol_eff_from = sdf.parse(tmp_pol_eff_from);
		    		java.util.Date date_pol_exp_date = sdf.parse(tmp_pol_exp_date);
		        	if(date_pol_eff_to.compareTo(date_pol_exp_date)>0){  //if(effective date   > policy end date)
		        		tmp_pol_eff_to=tmp_pol_exp_date;
		        		date_pol_eff_to = sdf.parse(tmp_pol_eff_to);        		
		        		long diff = date_pol_eff_to.getTime() - date_pol_eff_from.getTime();
		    			long diffDays =  ( diff / (24 * 60 * 60 * 1000) ) + 1 ; // 1 day added for inclusive purpose
		    			tmp_pol_appd_days=""+diffDays;
		        	}
					}
					mpolicy_start_date.set(i,tmp_pol_start_date );
					mpolicy_expiry_date.set(i,tmp_pol_exp_date );
					mcredit_apprd_days.set(i,tmp_pol_appd_days );
					mcredit_apprd_amt.set(i,tmp_pol_appd_amt );
					mpolicy_eff_frm_date.set(i,tmp_pol_eff_from );
					mpolicy_eff_to_date.set(i,tmp_pol_eff_to );
				}
			}
			}		
		String billingGroupId = (String)mins_blng_grp.get(i);
		bean.setDBApprvlsToBean(facility_id,episode_type,patient_id,(String)mins_blng_grp.get(i),(String)mcust_group_3.get(i),(String)mcust_3.get(i),(String)mins_cust_priority.get(i),(String)mpolicy_type_code.get(i),(String)mpolicy_no.get(i),(String)mpolicy_eff_frm_date.get(i),(String)mcredit_auth_ref.get(i),(String)mcredit_auth_date.get(i),(String)mcredit_apprd_amt.get(i),(String)mcredit_apprd_days.get(i));//added for package billing
		try
		{
			String sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+mpolicy_type_code.get(i)+"' AND a.CUST_CODE = '"+mcust_3.get(i)+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code AND a.CUST_GROUP_CODE = '"+mcust_group_3.get(i)+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;
			String empty_sql_check="N";
			if( rs!= null ) 
			{
				empty_sql_check="Y";
				while( rs.next() )
				{  
					policy_coverage_basis_ind = rs.getString(1);
					empty_sql_check="N";
				}
			}
			if(rs != null) rs.close();
			stmt.close();
			if(empty_sql_check.equals("Y"))
			{
				sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE 	a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+mpolicy_type_code.get(i)+"' AND a.CUST_GROUP_CODE = '"+mcust_group_3.get(i)+"' AND a.CUST_CODE = '**' and b.cust_group_code = a.cust_group_code";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;
				if( rs!= null ) 
				{
					while( rs.next() )
					{  
						policy_coverage_basis_ind = rs.getString(1);
					}
				}
				if(rs != null) rs.close();
				stmt.close();
			}
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";
		if(i==0)
		{
			policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
		}
		if(i % 2 == 0 )
		{
			classval	=	"QRYEVEN";
		}
		else
		{
			classval	=	"QRYODD";
		}
		priority_count++;
		String blng_grp_code=(String)mins_blng_grp.get(i);
		String blng_grp_long_desc="";
		objFromBean=addModifyBean.getblngGrpDesc(blng_grp_code,locale,con);
		blng_grp_long_desc=objFromBean.get("blng_grp_desc").getAsString();
		str_currency_code_for_bg=objFromBean.get("str_currency_code_for_bg").getAsString();
		str_currency_desc_for_bg=objFromBean.get("str_currency_desc_for_bg").getAsString();
		desc=(String)mins_blng_grp.get(i);
		String referral_source_capture_YN="N";
		String ref_src_main_mand_YN="N";
		String ref_src_sub_mand_YN="N";
		String ref_src_code_disp="";
		String ref_src_code_main_mand_disp ="";
		String ref_src_code_sub_mand_disp = "";
		String blngGrpCode=(String)mins_blng_grp.get(i);
		objFromBean=addModifyBean.getRefSourceFlagsForP1(blngGrpCode,con);
		referral_source_capture_YN=objFromBean.get("referral_source_code_flag").getAsString();
		ref_src_main_mand_YN=objFromBean.get("referral_source_main_mand_YN").getAsString();
		ref_src_sub_mand_YN=objFromBean.get("referral_source_sub_mand_YN").getAsString();
		if(referral_source_capture_YN.equals("Y"))
		{
			ref_src_code_disp="display:inline";
			if(ref_src_main_mand_YN.equals("Y"))
			{
				ref_src_code_main_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_main_mand_disp = "display:none";
			}
			if(ref_src_sub_mand_YN.equals("Y"))
			{
				ref_src_code_sub_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_sub_mand_disp = "display:none";
			}
		}
		else if(referral_source_capture_YN.equals("N"))
		{
			ref_src_code_disp="display:none";
			ref_src_code_main_mand_disp = "display:none";
			ref_src_code_sub_mand_disp = "display:none";
		}
		else
		{
			ref_src_code_disp="display:none";
		}
		if(!mref_ins_src_main_code.get(i).equals(""))
		{
			String refInsSrcMainCode=(String)mref_ins_src_main_code.get(i);
			ref_src_main_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,"3",con);
 	}
		else
		{
			ref_src_main_lng_name="";
		}
		if(!mref_ins_src_sub_code.get(i).equals(""))
		{
			String refInsSrcSubCode=(String)mref_ins_src_sub_code.get(i);
			ref_src_sub_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcSubCode, locale, "3", con); 
		}
		else
		{
			ref_src_sub_lng_name="";
		}
		try
		{
			String empty_sql_check="N";
		
			String custCode=(String)mcust_3.get(i);
			String custGrpCode=(String)mcust_group_3.get(i);
			
			objFromBean=addModifyBean.validPayerYN(strModuleId,custCode,custGrpCode,con);
			payer_suspended_YN=objFromBean.get("payer_suspended_YN").getAsString();
			cust_valid_from_date=objFromBean.get("cust_valid_from_date").getAsString();
			cust_valid_to_date=objFromBean.get("cust_valid_to_date").getAsString();
			empty_sql_check=objFromBean.get("empty_sql_check").getAsString();
			valid_payer_YN=objFromBean.get("valid_payer_YN").getAsString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			String empty_sql_check="N";
			String custCode=(String)mcust_3.get(i);
			String custGrpCode=(String)mcust_group_3.get(i);
			String policyTypeCode=(String)mpolicy_type_code.get(i);

			objFromBean=addModifyBean.getvalidPolicyTypeCodeYN(empty_sql_check,strModuleId, custCode, custGrpCode,policyTypeCode,locale,facility_id, con);			
			empty_sql_check=	objFromBean.get("empty_sql_check").getAsString();
			valid_policy_type_code_YN= objFromBean.get("valid_policy_type_code_YN").getAsString();
			policy_suspended_YN=	objFromBean.get("policy_suspended_YN").getAsString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{	

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mref_ins_src_main_desc.get(i)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ref_src_code_main_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

			if(ref_src_main_lng_name.equals(""))
			{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}
			else
			{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ref_src_main_lng_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

			}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mref_ins_src_sub_desc.get(i)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ref_src_code_sub_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

			if(ref_src_sub_lng_name.equals(""))
			{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}
			else
			{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ref_src_sub_lng_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
 
			}

            _bw.write(_wl_block57Bytes, _wl_block57);

		}
		else
		{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mref_ins_src_main_desc.get(i)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mref_ins_src_sub_desc.get(i)));
            _bw.write(_wl_block46Bytes, _wl_block46);

		}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_payerEligibilityParamSession.get(i)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_responseCode.get(i)));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_responseCodeDesc.get(i)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_statuDescription.get(i)));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_validityPeriod.get(i)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_validityPeriodDesc.get(i)));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_eligibilityCode.get(i)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_transactionId.get(i)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_responseDateTime.get(i)));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_currency_code_for_bg));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_currency_desc_for_bg));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mins_blng_grp.get(i)));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mref_ins_src_main_code.get(i)));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mref_ins_src_sub_code.get(i)));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(referral_source_capture_YN));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ref_src_main_mand_YN));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ref_src_sub_mand_YN));
            _bw.write(_wl_block46Bytes, _wl_block46);
	
		blng_grp_values=blng_grp_values+mins_blng_grp.get(i)+"|";
		if(valid_payer_YN.equals("Y") && valid_policy_type_code_YN.equals("Y"))
		{

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(mcust_group_desc.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(mpayer_desc.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mcust_3.get(i)));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mcust_group_3.get(i)));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(valid_payer_YN));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(mins_cust_priority.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";
	if((mrestrict_check.get(i)).equals("U"))
	{	
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if ((mrestrict_check.get(i)).equals("R"))
	{
		if((mapprd_amt_restrict_check.get(i)).equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if((mapprd_days_restrict_check.get(i)).equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(mpolicy_type_desc.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block132Bytes, _wl_block132);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mpolicy_type_code.get(i)));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(valid_policy_type_code_YN));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(policy_suspended_YN));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(mpolicy_no.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block144Bytes, _wl_block144);

	policy_start_date_conv=(String)mpolicy_start_date.get(i);	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	policy_exp_date_conv=(String)mpolicy_expiry_date.get(i);	
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	if(encounter_date_time==null) encounter_date_time="";
	try
	{
		String pocy_date_valid="SELECT addl_days_policy_expdt, to_char(to_date(?, 'dd/mm/yyyy HH24:MI') + nvl(addl_days_policy_expdt,0),'DD/MM/YYYY') sys1, to_char((to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys FROM bl_ins_policy_type_hdr WHERE OPERATING_FACILITY_ID= ? AND  cust_group_code = ? AND policy_type_code = ? AND (cust_code = ? OR (cust_code <> ? AND cust_code = '**')) AND def_req_policy_dates = 'Y'";
		
		def_req_pol_date_avail_YN = "N";
		
		pstmt = con.prepareStatement(pocy_date_valid) ;
		
		pstmt.setString(1,encounter_date_time);
		pstmt.setString(2,encounter_date_time);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,(String)mcust_group_3.get(i));
		pstmt.setString(5,(String)mpolicy_type_code.get(i));
		pstmt.setString(6,(String)mcust_3.get(i));
		pstmt.setString(7,(String)mcust_3.get(i));
		
		rs = pstmt.executeQuery();
		if( rs != null ) 
		{
			while(rs.next())
			{
				//addl_days_policy_expdt=rs.getString(1);
				policy_start_date_conv=rs.getString(3);
				if(policy_start_date_conv==null) policy_start_date_conv="";
				policy_exp_date_conv=rs.getString(2);
				if(policy_exp_date_conv==null) policy_exp_date_conv="";
				def_req_pol_date_avail_YN = "Y";
			}
		}
		else
		{
			def_req_pol_date_avail_YN="N";
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	policy_eff_frm_date_conv=(String)mpolicy_eff_frm_date.get(i);	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	policy_eff_to_date_conv=(String)mpolicy_eff_to_date.get(i);	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(def_req_pol_date_avail_YN.equals("Y"))
	{
		policy_eff_frm_date_conv=policy_start_date_conv;
		policy_eff_to_date_conv=policy_exp_date_conv;
	}
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}
	if(!policy_eff_frm_date_conv.equals(""))
	{
		policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

if(DFLT_POLICY_DEF_IN_VIS_REG_YN.equalsIgnoreCase("Y")){
			policy_start_date_conv=(String)mpolicy_start_date.get(i);	
			policy_exp_date_conv=(String)mpolicy_expiry_date.get(i);			
			policy_eff_frm_date_conv=(String)mpolicy_eff_frm_date.get(i);				
			policy_eff_to_date_conv=(String)mpolicy_eff_to_date.get(i);	
}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(policy_start_date_conv));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(policy_exp_date_conv));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

	if((mcred_auth_req_yn.get(i)).equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(mcredit_auth_ref.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block156Bytes, _wl_block156);

	credit_auth_date_conv=(String)mcredit_auth_date.get(i);	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(credit_auth_date_conv));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(mcredit_apprd_amt.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(mcredit_apprd_days.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(policy_eff_frm_date_conv));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);
 if(siteSpec){  
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(orgPolEffToDate));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block185Bytes, _wl_block185);
}else{ 											
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(policy_eff_to_date_conv));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block185Bytes, _wl_block185);
} 
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(madj_rule_ind.get(i)));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(madj_perc_amt_ind.get(i)));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(madj_perc_amt_value.get(i)));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mpmnt_diff_adj_int.get(i)));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mdrg_pmnt_diff_adj_int.get(i)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mspl_srv_pmnt_diff_adj_int.get(i)));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(mrestrict_check.get(i)));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(mapprd_amt_restrict_check.get(i)));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(mapprd_days_restrict_check.get(i)));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(policy_coverage_basis_ind));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mcred_auth_req_yn.get(i)));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mcred_auth_mand_capt_yn.get(i)));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mdflt_auth_ref_as_pol_no_yn.get(i)));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(pol_validity_chk_date));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(rec_edited_YN));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(total_Records));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(orgPolEffToDate));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block227Bytes, _wl_block227);
	
	totalRecords++;
	}
	else
	{
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

	v_display_hide_apprvd_amt="display:inline";
	v_display_hide_apprvd_days = "display:inline";

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block132Bytes, _wl_block132);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

	v_display_hide_cred_auth = "display:inline";

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(total_Records ));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(orgPolEffToDate));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block227Bytes, _wl_block227);

	totalRecords++;
	}
	}
	tempDesc=desc;
	}	
if(rs_dflt_ld !=null) rs_dflt_ld.close();
if(pstmt_dflt_ld !=null) pstmt_dflt_ld.close();		
}
else if((((billing_mode.equals("Modify")) || (operation.equals("Update"))) && (fin_dtls_updated_YN.equals("Y") || fin_class_dtls_updated_YN.equals("Y"))) && !(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y")))
{
	int total_Records=mpolicy_type_code.size();
	totalRecords=0;
	String desc = "";
	String tempDesc = "";
	String payerEligibilityParam = "9";	
	for(int i=0;i<total_Records;i++)
	{
		try
		{
			String sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+mpolicy_type_code.get(i)+"' AND a.CUST_CODE = '"+mcust_3.get(i)+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code AND a.CUST_GROUP_CODE = '"+mcust_group_3.get(i)+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;
			String empty_sql_check="N";
			if( rs!= null ) 
			{
				empty_sql_check="Y";
				while( rs.next() )
				{  
					policy_coverage_basis_ind = rs.getString(1);
					empty_sql_check="N";
				}
			}
			if(rs != null) rs.close();
			stmt.close();
			if(empty_sql_check.equals("Y"))
			{
				sql_policy_coverage_basis_ind="SELECT a.POLICY_COVERAGE_BASIS FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+mpolicy_type_code.get(i)+"' AND a.CUST_GROUP_CODE = '"+mcust_group_3.get(i)+"' AND a.CUST_CODE = '**' and b.cust_group_code = a.cust_group_code";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql_policy_coverage_basis_ind) ;
				if( rs!= null ) 
				{
					while( rs.next() )
					{  
						policy_coverage_basis_ind = rs.getString(1);
					}
				}
				if(rs != null) rs.close();
				stmt.close();
			}
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String billingGroupId = (String)mins_blng_grp.get(i);
		if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";
		if(i==0)
		{
			policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
		}
		if(i % 2 == 0 )
		{
			classval	=	"QRYEVEN";
		}
		else
		{
			classval	=	"QRYODD";
		}
		String blng_grp_long_desc="";
		desc=(String)mins_blng_grp.get(i);
		objFromBean=addModifyBean.getblngGrpDesc(desc, locale, con);
		blng_grp_long_desc=objFromBean.get("blng_grp_desc").getAsString();
		str_currency_code_for_bg=objFromBean.get("str_currency_code_for_bg").getAsString();
		str_currency_desc_for_bg=objFromBean.get("str_currency_desc_for_bg").getAsString();
		String referral_source_capture_YN="N";
		String ref_src_main_mand_YN="N";
		String ref_src_sub_mand_YN="N";
		String ref_src_code_disp="";
		String ref_src_code_main_mand_disp ="";
		String ref_src_code_sub_mand_disp = "";
		String blngGrpId= (String)mins_blng_grp.get(i);
		objFromBean=addModifyBean.getRefSourceFlagsForP1(blngGrpId, con);
		//Changed by prithivi for bupa interface
		//referral_source_capture_YN=objFromBean.get("referral_source_capture_YN").getAsString();
		referral_source_capture_YN=objFromBean.get("referral_source_code_flag").getAsString();
		ref_src_main_mand_YN=objFromBean.get("referral_source_main_mand_YN").getAsString();
		ref_src_sub_mand_YN=objFromBean.get("referral_source_sub_mand_YN").getAsString();	
		if(referral_source_capture_YN.equals("Y"))
		{
			ref_src_code_disp="display:inline";
			if(ref_src_main_mand_YN.equals("Y"))
			{
				ref_src_code_main_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_main_mand_disp = "display:none";
			}
			if(ref_src_sub_mand_YN.equals("Y"))
			{
				ref_src_code_sub_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_sub_mand_disp = "display:none";
			}
		}
		else if(referral_source_capture_YN.equals("N"))
		{
			ref_src_code_disp="display:none";
			ref_src_code_main_mand_disp = "display:none";
			ref_src_code_sub_mand_disp = "display:none";
		}
		else
		{
			ref_src_code_disp="display:none";
		}
		if(!mref_ins_src_main_code.get(i).equals(""))
		{
			String val="3";
			String refInsSrcMainCode=(String)mref_ins_src_main_code.get(i);
			ref_src_main_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);			
		}
		else
		{
			ref_src_main_lng_name="";
		}
		if(!mref_ins_src_sub_code.get(i).equals(""))
		{
			String val="3";
			String refInsSrcMainCode=(String)mref_ins_src_main_code.get(i);
			ref_src_sub_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);
		}
		else
		{
			ref_src_sub_lng_name="";
		}
		objFromBean = addModifyBean.validPayerYN(strModuleId, (String) mcust_3.get(i), (String) mcust_group_3.get(i), con);
		valid_payer_YN=objFromBean.get("valid_payer_YN").getAsString();
		cust_valid_from_date = objFromBean.get("cust_valid_from_date").getAsString();
		cust_valid_to_date = objFromBean.get("cust_valid_to_date").getAsString();
		payer_suspended_YN = objFromBean.get("payer_suspended_YN").getAsString();
		objFromBean = addModifyBean.getvalidPolicyTypeCodeYN("N", strModuleId, (String) mcust_3.get(i), (String) mcust_group_3.get(i), (String) mpolicy_type_code.get(i), locale, facility_id, con);
		valid_policy_type_code_YN= objFromBean.get("valid_policy_type_code_YN").getAsString();
		policy_suspended_YN=	objFromBean.get("policy_suspended_YN").getAsString();
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{

            _bw.write(_wl_block263Bytes, _wl_block263);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mref_ins_src_main_desc.get(i)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ref_src_code_main_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

			if(ref_src_main_lng_name.equals(""))
			{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}
			else
			{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ref_src_main_lng_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

			}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mref_ins_src_sub_desc.get(i)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ref_src_code_sub_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

			if(ref_src_sub_lng_name.equals(""))
			{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}
			else
			{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ref_src_sub_lng_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

			}

            _bw.write(_wl_block57Bytes, _wl_block57);

		}else{		

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mref_ins_src_main_desc.get(i)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mref_ins_src_sub_desc.get(i)));
            _bw.write(_wl_block46Bytes, _wl_block46);

		}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_payerEligibilityParamSession.get(i)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_responseCode.get(i)));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_responseCodeDesc.get(i)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_statuDescription.get(i)));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_validityPeriod.get(i)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_validityPeriodDesc.get(i)));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_eligibilityCode.get(i)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_transactionId.get(i)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mins_responseDateTime.get(i)));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_currency_code_for_bg));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_currency_desc_for_bg));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mins_blng_grp.get(i)));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mref_ins_src_main_code.get(i)));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mref_ins_src_sub_code.get(i)));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(referral_source_capture_YN));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ref_src_main_mand_YN));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ref_src_sub_mand_YN));
            _bw.write(_wl_block46Bytes, _wl_block46);

		blng_grp_values=blng_grp_values+mins_blng_grp.get(i)+"|";

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(mcust_group_desc.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(mpayer_desc.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mcust_3.get(i)));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mcust_group_3.get(i)));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(valid_payer_YN));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(mins_cust_priority.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(mpolicy_type_desc.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block132Bytes, _wl_block132);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mpolicy_type_code.get(i)));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(valid_policy_type_code_YN));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(policy_suspended_YN));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(mpolicy_no.get(i)));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block144Bytes, _wl_block144);

	policy_start_date_conv=(String)mpolicy_start_date.get(i);	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	policy_exp_date_conv=(String)mpolicy_expiry_date.get(i);	
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	try
	{
		String pocy_date_valid="SELECT addl_days_policy_expdt, to_char(to_date(?, 'dd/mm/yyyy HH24:MI') + nvl(addl_days_policy_expdt,0),'DD/MM/YYYY') sys1, to_char((to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') sys FROM bl_ins_policy_type_hdr WHERE OPERATING_FACILITY_ID= ? AND  cust_group_code = ?  AND policy_type_code = ? AND (cust_code = ? OR (cust_code <> ? AND cust_code = '**')) AND def_req_policy_dates = 'Y'";
		
		def_req_pol_date_avail_YN = "N";
		pstmt = con.prepareStatement(pocy_date_valid) ;
		
		pstmt.setString(1,encounter_date_time);
		pstmt.setString(2,encounter_date_time);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,(String)mcust_group_3.get(i));
		pstmt.setString(5,(String)mpolicy_type_code.get(i));
		pstmt.setString(6,(String)mcust_3.get(i));
		pstmt.setString(7,(String)mcust_3.get(i));
		
		rs = pstmt.executeQuery();
		if( rs != null ) 
		{
			while(rs.next())
			{
				//addl_days_policy_expdt=rs.getString(1);
				policy_start_date_conv=rs.getString(3);
				policy_exp_date_conv=rs.getString(2);
				def_req_pol_date_avail_YN = "Y";
			}
		}
		else
		{
			def_req_pol_date_avail_YN="N";
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	policy_eff_frm_date_conv=(String)mpolicy_eff_frm_date.get(i);	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	policy_eff_to_date_conv=(String)mpolicy_eff_to_date.get(i);	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(def_req_pol_date_avail_YN.equals("Y")) 
	{
		policy_eff_frm_date_conv=policy_start_date_conv;
		policy_eff_to_date_conv=policy_exp_date_conv;
	}
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}
	if(!policy_eff_frm_date_conv.equals(""))
	{
	policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
 
if(DFLT_POLICY_DEF_IN_VIS_REG_YN.equalsIgnoreCase("Y")){
			policy_start_date_conv=(String)mpolicy_start_date.get(i);	
			policy_exp_date_conv=(String)mpolicy_expiry_date.get(i);			
			policy_eff_frm_date_conv=(String)mpolicy_eff_frm_date.get(i);				
			policy_eff_to_date_conv=(String)mpolicy_eff_to_date.get(i);	
}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(policy_start_date_conv));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(policy_exp_date_conv));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

	if((mcred_auth_req_yn.get(i)).equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(mcredit_auth_ref.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block156Bytes, _wl_block156);

	credit_auth_date_conv=(String)mcredit_auth_date.get(i);	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(credit_auth_date_conv));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block274Bytes, _wl_block274);

	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";
	if((mrestrict_check.get(i)).equals("U"))
	{	
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if ((mrestrict_check.get(i)).equals("R"))
	{
		if((mapprd_amt_restrict_check.get(i)).equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if((mapprd_days_restrict_check.get(i)).equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(mcredit_apprd_amt.get(i)));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(mcredit_apprd_days.get(i)));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(policy_eff_frm_date_conv));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(policy_eff_to_date_conv));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(madj_rule_ind.get(i)));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(madj_perc_amt_ind.get(i)));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(madj_perc_amt_value.get(i)));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mpmnt_diff_adj_int.get(i)));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mdrg_pmnt_diff_adj_int.get(i)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mspl_srv_pmnt_diff_adj_int.get(i)));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(mrestrict_check.get(i)));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(mapprd_amt_restrict_check.get(i)));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(mapprd_days_restrict_check.get(i)));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(policy_coverage_basis_ind));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mcred_auth_req_yn.get(i)));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mcred_auth_mand_capt_yn.get(i)));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mdflt_auth_ref_as_pol_no_yn.get(i)));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(pol_validity_chk_date));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(rec_edited_YN));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(m_mcn_for_policy.get(i)));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(m_reg_ref_id.get(i)));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mpolicy_eff_to_date.get(i)));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(muserId_for_priv.get(i)));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(mreasonCode_for_priv.get(i)));
            _bw.write(_wl_block282Bytes, _wl_block282);
 
			tempDesc=desc;
			totalRecords++;
	}
}
else if(remove_check.equals("remove"))
{
	totalRecords=0;
	String desc = "";
	String tempDesc = "";
	String[] output1=new String[55]; //V230707
	for(int i=0;i<existing_records_array.size();i++)
	{
		output1=(String[])existing_records_array.get(i);
		policy_coverage_basis_ind=output1[26];	
		if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";
		if(i==0)
		{
			policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
		}
		if(i % 2 == 0 )
		{
			classval	=	"QRYEVEN";
		}
		else
		{
			classval	=	"QRYODD";
		}
		desc = output1[1];
		String referral_source_capture_YN="N";
		String ref_src_main_mand_YN="N";
		String ref_src_sub_mand_YN="N";
		String ref_src_code_disp="";
		String ref_src_code_main_mand_disp ="";
		String ref_src_code_sub_mand_disp = "";
		objFromBean = addModifyBean.getCustValidDates(output1[3], con);
		cust_valid_from_date = objFromBean.get("cust_valid_from_date").getAsString();
		cust_valid_to_date = objFromBean.get("cust_valid_to_date").getAsString();
		objFromBean = addModifyBean.getCurrencyCode(output1[1], locale, con);
		str_currency_code_for_bg= objFromBean.get("str_currency_code_for_bg").getAsString();
		str_currency_desc_for_bg= objFromBean.get("str_currency_desc_for_bg").getAsString();
		objFromBean = addModifyBean.getRefSourceFlagsForP1(output1[1], con);
		referral_source_capture_YN = objFromBean.get("referral_source_code_flag").getAsString();
		ref_src_main_mand_YN = objFromBean.get("referral_source_main_mand_YN").getAsString();
		ref_src_sub_mand_YN = objFromBean.get("referral_source_sub_mand_YN").getAsString();
		if(referral_source_capture_YN.equals("Y"))
		{
			ref_src_code_disp="display:inline";
			if(ref_src_main_mand_YN.equals("Y"))
			{
				ref_src_code_main_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_main_mand_disp = "display:none";
			}
			if(ref_src_sub_mand_YN.equals("Y"))
			{
				ref_src_code_sub_mand_disp = "display:inline";
			}
			else
			{
				ref_src_code_sub_mand_disp = "display:none";
			}
		}
		else if(referral_source_capture_YN.equals("N"))
		{
			ref_src_code_disp="display:none";
			ref_src_code_main_mand_disp = "display:none";
			ref_src_code_sub_mand_disp = "display:none";
		}
		else
		{
			ref_src_code_disp="display:none";
		}
		if(!output1[27].equals(""))
		{
			String val="3";
			String refInsSrcMainCode=(String)output1[27];
			ref_src_main_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);		
		}
		else
		{
			ref_src_main_lng_name="";
		}

		if(!output1[29].equals(""))
		{
			String refInsSrcMainCode=(String)output1[29];
			String val = "3";
			ref_src_sub_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);
		}
		else
		{
			ref_src_sub_lng_name="";
		}
		payer_suspended_YN = addModifyBean.payerSuspendedYn(strModuleId, output1[3], output1[25], con);
			String empty_sql_check="N";
			String custCde=(String)output1[3];
			String custGrpCde =(String)output1[25]; 
			String policyTypeCde=(String)output1[6];
			objFromBean=addModifyBean.getpolicySuspendedYN(empty_sql_check,strModuleId, custCde, custGrpCde,policyTypeCde,locale,facility_id, con);			
			empty_sql_check=	objFromBean.get("empty_sql_check").getAsString();
			policy_suspended_YN=	objFromBean.get("policy_suspended_YN").getAsString();		
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc))){

            _bw.write(_wl_block283Bytes, _wl_block283);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(output1[0]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(output1[28]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ref_src_code_main_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

			if(ref_src_main_lng_name.equals("")){

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}else{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ref_src_main_lng_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

			}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(output1[30]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ref_src_code_sub_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

			if(ref_src_sub_lng_name.equals("")){

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}else{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ref_src_sub_lng_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

			}

            _bw.write(_wl_block57Bytes, _wl_block57);

		}else{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[0]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[28]));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[30]));
            _bw.write(_wl_block46Bytes, _wl_block46);

		}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_currency_code_for_bg));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_currency_desc_for_bg));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[1]));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[27]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[29]));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(referral_source_capture_YN));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ref_src_main_mand_YN));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ref_src_sub_mand_YN));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[41]));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[42]));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[43]));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[44]));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[45]));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[46]));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[47]));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[48]));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[49]));
            _bw.write(_wl_block46Bytes, _wl_block46);

	blng_grp_values=blng_grp_values+output1[1]+"|";
	if(output1[23].equals("Y") && output1[24].equals("Y"))
	{

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(output1[37]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(output1[2]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[3]));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[25]));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(output1[23]));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(output1[4]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(output1[5]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block307Bytes, _wl_block307);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[6]));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(output1[24]));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(policy_suspended_YN));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[7]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block144Bytes, _wl_block144);

	policy_start_date_conv=(String)output1[8];	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(policy_start_date_conv));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

	policy_exp_date_conv=(String)output1[9];	 
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(policy_exp_date_conv));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block144Bytes, _wl_block144);

	if(output1[33].equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[10]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block310Bytes, _wl_block310);

	credit_auth_date_conv=(String)output1[11];	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(credit_auth_date_conv));
            _bw.write(_wl_block311Bytes, _wl_block311);

	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";
	if(output1[22].equals("U"))
	{
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if (output1[22].equals("R"))
	{
		if(output1[31].equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if(output1[32].equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block312Bytes, _wl_block312);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(output1[12]));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(output1[13]));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block310Bytes, _wl_block310);

	policy_eff_frm_date_conv=(String)output1[14];	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	if(!policy_eff_frm_date_conv.equals(""))
	{
		policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(policy_eff_frm_date_conv));
            _bw.write(_wl_block315Bytes, _wl_block315);

	policy_eff_to_date_conv=(String)output1[15];	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(policy_eff_to_date_conv));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[16]));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[17]));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[18]));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[19]));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[20]));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[21]));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(output1[22]));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(output1[31]));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(output1[32]));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(policy_coverage_basis_ind));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[33]));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[40]));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[34]));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(pol_validity_chk_date));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[39]));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[51]));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[52]));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(output1[50]));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(output1[53]));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(output1[54]));
            _bw.write(_wl_block282Bytes, _wl_block282);

		totalRecords++; 
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(existing_records_array.size()));
            _bw.write(_wl_block321Bytes, _wl_block321);
 }
	else
	{
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

		v_display_hide_apprvd_amt="display:inline";
		v_display_hide_apprvd_days = "display:inline";

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block132Bytes, _wl_block132);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

		v_display_hide_cred_auth = "display:inline";

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[51]));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[52]));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(output1[50]));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(existing_records_array.size()));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(output1[53]));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(output1[54]));
            _bw.write(_wl_block282Bytes, _wl_block282);

			totalRecords++;
		}
	}
	tempDesc=desc;
	}
}
else if(accept_check.equals("accept") || add_check.equals("add") || refresh_check.equals("Y"))
{
		totalRecords=0;
		String desc = "";
		String tempDesc = "";
		String[] output1=new String[55]; //V230707
		for(int i=0;i<existing_records_array.size();i++)
		{
			output1=(String[])existing_records_array.get(i);
			String OrgPolEffToDate = "";
			 try {
				OrgPolEffToDate=(String)output1[50];
			} catch(ArrayIndexOutOfBoundsException ex) {
				OrgPolEffToDate = "";
				ex.printStackTrace();
			}
			policy_coverage_basis_ind=output1[26];	
			if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";
			if(i==0)
			{
				policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
			}
			if(i % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}
			desc = output1[1];
			String referral_source_capture_YN="N";
			String ref_src_main_mand_YN="N";
			String ref_src_sub_mand_YN="N";
			String ref_src_code_disp="";
			String ref_src_code_main_mand_disp ="";
			String ref_src_code_sub_mand_disp = "";
			objFromBean = addModifyBean.getRefSourceFlagsForP1(output1[1], con);
			referral_source_capture_YN = objFromBean.get("referral_source_code_flag").getAsString();
			ref_src_main_mand_YN = objFromBean.get("referral_source_main_mand_YN").getAsString();
			ref_src_sub_mand_YN = objFromBean.get("referral_source_sub_mand_YN").getAsString();
			objFromBean = addModifyBean.getCustValidDates(output1[3], con);
			cust_valid_from_date = objFromBean.get("cust_valid_from_date").getAsString();
			cust_valid_to_date = objFromBean.get("cust_valid_to_date").getAsString();
			objFromBean = addModifyBean.getCurrencyCode(output1[1], locale, con);
			str_currency_code_for_bg = objFromBean.get("str_currency_code_for_bg").getAsString();
			str_currency_desc_for_bg = objFromBean.get("str_currency_desc_for_bg").getAsString();
			if(referral_source_capture_YN.equals("Y"))
			{
				ref_src_code_disp="display:inline";
				if(ref_src_main_mand_YN.equals("Y"))
				{
					ref_src_code_main_mand_disp = "display:inline";
				}
				else
				{
					ref_src_code_main_mand_disp = "display:none";
				}
				if(ref_src_sub_mand_YN.equals("Y"))
				{
					ref_src_code_sub_mand_disp = "display:inline";
				}
				else
				{
					ref_src_code_sub_mand_disp = "display:none";
				}
			}
			else if(referral_source_capture_YN.equals("N"))
			{
				ref_src_code_disp="display:none";
				ref_src_code_main_mand_disp = "display:none";
				ref_src_code_sub_mand_disp = "display:none";
			}
			else
			{
				ref_src_code_disp="display:none";
			}
			if(!output1[27].equals(""))
			{
				String val="3";
				String refInsSrcMainCode=(String)output1[27];
				ref_src_main_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);
			}
			else
			{
				ref_src_main_lng_name="";
			}

			if(!output1[29].equals(""))
			{
				String val="3";
				String refInsSrcMainCode=(String)output1[29];
				ref_src_sub_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);				
			}
			else
			{
				ref_src_sub_lng_name="";
			}
			String empty_sql_check = "N";
	 		String customerCode=(String)output1[3];
	 		String customerGroupCode=(String)output1[25];		
			objFromBean=addModifyBean.payerSuspendedYN(strModuleId, customerCode, customerGroupCode, con);
			empty_sql_check=objFromBean.get("empty_sql_check").getAsString();
			payer_suspended_YN=objFromBean.get("payer_suspended_YN").getAsString();
		objFromBean = addModifyBean.getvalidPolicyTypeCodeYN("N", strModuleId, output1[3], output1[25], output1[6], locale, facility_id, con);
		policy_suspended_YN = objFromBean.get("policy_suspended_YN").getAsString();		
	if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
	{

            _bw.write(_wl_block325Bytes, _wl_block325);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(output1[0]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(output1[28]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ref_src_code_main_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

			if(ref_src_main_lng_name.equals(""))
			{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}
			else
			{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ref_src_main_lng_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

			}

            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(output1[30]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ref_src_code_sub_mand_disp));
            _bw.write(_wl_block41Bytes, _wl_block41);

			if(ref_src_sub_lng_name.equals(""))
			{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}
			else
			{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ref_src_sub_lng_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

			}

            _bw.write(_wl_block331Bytes, _wl_block331);

	}
	else
	{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[0]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[28]));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[30]));
            _bw.write(_wl_block46Bytes, _wl_block46);

	}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_currency_code_for_bg));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(str_currency_desc_for_bg));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[1]));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[27]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[29]));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(referral_source_capture_YN));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ref_src_main_mand_YN));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ref_src_sub_mand_YN));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[41]));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[42]));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[43]));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[44]));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[45]));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[46]));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[47]));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[48]));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[49]));
            _bw.write(_wl_block46Bytes, _wl_block46);

	blng_grp_values=blng_grp_values+output1[1]+"|";
	if(output1[23].equals("Y") && output1[24].equals("Y"))
	{

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(output1[37]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(output1[2]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[3]));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[25]));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[23]));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(output1[4]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(output1[5]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block307Bytes, _wl_block307);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[6]));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[24]));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(policy_suspended_YN));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[7]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block144Bytes, _wl_block144);

	policy_start_date_conv=(String)output1[8];	
	if(policy_start_date_conv==null) policy_start_date_conv="";
	policy_start_date_conv=policy_start_date_conv.trim();
	if(!policy_start_date_conv.equals(""))
	{
		policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(policy_start_date_conv));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

	policy_exp_date_conv=(String)output1[9];	
	if(policy_exp_date_conv==null) policy_exp_date_conv="";
	policy_exp_date_conv=policy_exp_date_conv.trim();
	if(!policy_exp_date_conv.equals(""))
	{
		policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(policy_exp_date_conv));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block144Bytes, _wl_block144);

	if(output1[33].equals("Y"))
	{
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		v_display_hide_cred_auth = "display:none";
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[10]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block310Bytes, _wl_block310);

	credit_auth_date_conv=(String)output1[11];	
	if(credit_auth_date_conv==null) credit_auth_date_conv="";
	credit_auth_date_conv=credit_auth_date_conv.trim();
	if(!credit_auth_date_conv.equals(""))
	{
		credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(credit_auth_date_conv));
            _bw.write(_wl_block333Bytes, _wl_block333);
	
	v_display_hide="";
	v_display_hide_apprvd_amt="";
	v_display_hide_apprvd_days="";

	if(output1[22].equals("U"))
	{
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if (output1[22].equals("R"))
	{
		if(output1[31].equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if(output1[32].equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block312Bytes, _wl_block312);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(output1[12]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(output1[13]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block310Bytes, _wl_block310);

	policy_eff_frm_date_conv=(String)output1[14];	
	if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
	policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
	if(!policy_eff_frm_date_conv.equals(""))
	{
		policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(policy_eff_frm_date_conv));
            _bw.write(_wl_block334Bytes, _wl_block334);

	policy_eff_to_date_conv=(String)output1[15];	
	if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
	policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
	if(!policy_eff_to_date_conv.equals(""))
	{
		policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
	}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(policy_eff_to_date_conv));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(policy_eff_to_date_conv ));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[16]));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[17]));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[18]));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[19]));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[20]));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[21]));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[22]));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(output1[31]));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(output1[32]));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(policy_coverage_basis_ind));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[33]));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[40]));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[34]));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(pol_validity_chk_date));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(output1[39]));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[51]));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[52]));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(output1[53]));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(output1[54]));
            _bw.write(_wl_block282Bytes, _wl_block282);

		totalRecords++;
	}
	else
	{
		if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
		{

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

		v_display_hide_apprvd_amt="display:inline";
		v_display_hide_apprvd_days = "display:inline";

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block132Bytes, _wl_block132);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);

		v_display_hide_cred_auth = "display:inline";

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block347Bytes, _wl_block347);

			totalRecords++;
		}
	}
	tempDesc=desc;
	}
}
else
{
	isExtnJSPLoaded = "Y";
	
            _bw.write(_wl_block348Bytes, _wl_block348);
            {java.lang.String __page ="../../eBL/jsp/AddModifyPatFinDetailsInsBodyExtn1.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("billing_group"), weblogic.utils.StringUtils.valueOf(billing_group
                        )},{ weblogic.utils.StringUtils.valueOf("p_patient_class"), weblogic.utils.StringUtils.valueOf(p_patient_class
                        )},{ weblogic.utils.StringUtils.valueOf("class_code"), weblogic.utils.StringUtils.valueOf(class_code
                        )},{ weblogic.utils.StringUtils.valueOf("totalRecords"), weblogic.utils.StringUtils.valueOf(totalRecords
                        )},{ weblogic.utils.StringUtils.valueOf("strModuleId"), weblogic.utils.StringUtils.valueOf(strModuleId
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf(episode_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block350Bytes, _wl_block350);
				
}

            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(isExtnJSPLoaded));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(ins_auth_flag));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(strCreditDoc_YN));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(strRepositoryYN));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(strItemsDisabled));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(str_function_id));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(billing_mode));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(strCitizenYn));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(strBlngGrpAppYN));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(strBlngGrpCatgAppYN));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(strBlngGrpStatus));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(mpolicy_type_code));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(blng_grp_values));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(referral_source_code_flag));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(referral_source_main_mand_YN));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(referral_source_sub_mand_YN));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(pr_payer_employer_id_mand_YN));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(refresh_check));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(policy_coverage_basis_gbl_ind));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(str_valid_pkg_for_pat_bg_avail_YN));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(fin_class_flag_YN));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(autoFinChk));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(siteSpec ));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(siteSpecPolApprv ));
            _bw.write(_wl_block388Bytes, _wl_block388);

queryString=queryString+"&payerGrpBySetup="+payerGrpBySetup;
	if((!(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y"))))
	{
		

            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block390Bytes, _wl_block390);

	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	if((!(remove_check.equals("remove") || add_check.equals("add") || accept_check.equals("accept") || refresh_check.equals("Y"))))
	{
					

            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block46Bytes, _wl_block46);

		if( ((!(cust_4.equals("")) || !(cash_set_type2.equals(""))) && autoFinChk.equals("N")) || autoFinChk.equals("Y") )
		{

            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block390Bytes, _wl_block390);

		}
		if(!(cash_insmt_ref1.equals("")))
		{

            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block390Bytes, _wl_block390);

		}
	}
	else
	{

            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block46Bytes, _wl_block46);

	}

            _bw.write(_wl_block394Bytes, _wl_block394);

putObjectInBean(bean_id,bean,request);

		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);


            _bw.write(_wl_block395Bytes, _wl_block395);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_START_DATE.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EXPIRY_DATE.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH_DATE.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
